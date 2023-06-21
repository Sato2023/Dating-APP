package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.datingapp.auth.DBConnection;

public class Register extends AppCompatActivity {

    private String sex = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SeekBar ageBar = findViewById(R.id.seekBar);
        ageBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                changeAgeTitle(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        setSex(findViewById(R.id.sexButtonMale));
    }

    public void setSex(View v) {
        int lastButtonId = sex.equals("Female") ? R.id.sexButtonFemale : (sex.equals("Male") ? R.id.sexButtonMale : R.id.sexButtonOther);
        Button lastButton = findViewById(lastButtonId);
        lastButton.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.white));
        lastButton.setTextColor(ContextCompat.getColor(this, R.color.black));

        Button b = (Button) v;
        sex = b.getText().toString();
        b.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.purple_500));
        b.setTextColor(ContextCompat.getColor(this, R.color.white));
    }

    public void registerButton(View v) {
        String email = ((TextView) findViewById(R.id.email)).getText().toString();
        String passw = ((TextView) findViewById(R.id.password)).getText().toString();
        String name = ((TextView) findViewById(R.id.name)).getText().toString();
        int agePreference = ((SeekBar) findViewById(R.id.seekBar)).getProgress();

        if (!DBConnection.register(email, passw, name, String.valueOf(agePreference), sex)) {
            Toast.makeText(this, "Oops! Something went wrong!", Toast.LENGTH_LONG).show();
            return;
        }

        Toast.makeText(this, "Sucessfully registered!", Toast.LENGTH_LONG).show();
        Intent a = new Intent(this, PersonList.class);
        startActivity(a);
    }

    public void changeAgeTitle(int num) {
        TextView ageTitle = findViewById(R.id.title_age);
        ageTitle.setText("Your age: " + num);
    }
}
