package com.example.datingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.datingapp.auth.DBConnection;
import com.example.datingapp.auth.User;
import com.example.datingapp.auth.Utils;

public class PersonList extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_list);

        LinearLayout contentContainer = findViewById(R.id.container);
        LayoutInflater inflater = getLayoutInflater();
        boolean first = true;

        for (int x = 1; x <= 20; x++) {
            ConstraintLayout person = (ConstraintLayout) inflater.inflate(R.layout.person, null);
            ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            if (first){
                System.out.println("Set margins...");
                lp.setMargins(0, 100, 0, 30);
                first = false;
            } else {
                System.out.println("Set second margins...");
                lp.setMargins(0, 0, 0, 30);
            }

            person.setLayoutParams(lp);

            TextView name = person.findViewById(R.id.name);
            TextView age = person.findViewById(R.id.age);
            ImageView img = person.findViewById(R.id.image);
            ImageButton likeButton = person.findViewById(R.id.like);

            name.setText("Bruker nr " + x);
            age.setText("20 år");
            img.setBackgroundResource(R.drawable.user_img);
            likeButton.setOnClickListener(view -> {
                DBConnection.like(Utils.getCurrentUser(), new User(0)); // Endre til ekte person
            });

            contentContainer.addView(person);
        }
    }

    @Override
    public void onBackPressed() { }
}
