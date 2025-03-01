package com.example.sharedpreference_example;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences preferences = getSharedPreferences("login",MODE_PRIVATE);
                Boolean check = preferences.getBoolean("flag",false);

                Intent iNext;
                if(check){
                    //for true
                    iNext = new Intent(MainActivity.this,Home_activity.class);

                }
                else {
                    //for false
                    iNext = new Intent(MainActivity.this, login_activity.class);
                }
                startActivity(iNext);

            }
        },4000);
    }
}