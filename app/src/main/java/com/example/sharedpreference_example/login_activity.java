package com.example.sharedpreference_example;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class login_activity extends AppCompatActivity {

    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // code for verification

                SharedPreferences preferences  = getSharedPreferences("login",MODE_PRIVATE);
                SharedPreferences.Editor editor =preferences.edit();

                editor.putBoolean("flag",true);
                editor.apply();

                Intent iHome = new Intent(login_activity.this, Home_activity.class);
                startActivity(iHome);
            }
        });

    }
}