package com.example.myfirsttoast;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnToast = findViewById(R.id.btn);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Custom Toast
                Toast toast = new Toast(getApplicationContext());
                View view = getLayoutInflater().inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.toastContent));
                toast.setView(view);
      //        toast.setText("");
                TextView txtMsg = view.findViewById(R.id.txtMsg);
                txtMsg.setText("Message sent succesfully");
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();

            }
        });


    }
}