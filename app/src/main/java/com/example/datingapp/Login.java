package com.example.datingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.datingapp.auth.DBConnection;

public class Login extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginButton(View v) {
        String email = ((TextView) findViewById(R.id.email)).getText().toString();
        String passw = ((TextView) findViewById(R.id.password)).getText().toString();

        if (DBConnection.verifyUser(email, passw)) {
            setContentView(null);
        }
    }

    public void goToRegisterPage(View v) {
        Intent a = new Intent(this, Register.class);
        startActivity(a);
    }
}
