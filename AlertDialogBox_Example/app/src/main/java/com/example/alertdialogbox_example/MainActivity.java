package com.example.alertdialogbox_example;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//  one button dialog box
//        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
//        alertDialog.setTitle("Terms & Conditions");
//        alertDialog.setIcon(R.drawable.term_and_condition);
//        alertDialog.setMessage("Have you read all the Terms and Conditions?");
//        alertDialog.setButton(1,"Yes,I've read", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Okey, You can proceed now", Toast.LENGTH_LONG).show();
//            }
//        });
//        alertDialog.show();

        // two button dialog box
//        AlertDialog.Builder delDialog = new AlertDialog.Builder(MainActivity.this);
//        delDialog.setTitle("Delete");
//        delDialog.setIcon(R.drawable.delete_icon);
//        delDialog.setMessage("Are you Sure Want to Delete?");
//
//        delDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//        delDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Item not deleted", Toast.LENGTH_SHORT).show();
//            }
//        });
//        delDialog.show();
//
    }
    // three button dialog box
        @Override
        public void onBackPressed () {
//            super.onBackPressed();
            AlertDialog.Builder exitDialog = new AlertDialog.Builder(this);
            exitDialog.setTitle("Exit");
            exitDialog.setMessage("Are you sure want to exit?");
            exitDialog.setIcon(R.drawable.exit_icon);

            exitDialog.setPositiveButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Welcome Back", Toast.LENGTH_SHORT).show();
                }
            });
            exitDialog.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(MainActivity.this, "Exit Successful", Toast.LENGTH_SHORT).show();
                    MainActivity.super.onBackPressed();
                }
            });
            exitDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "Operation Canceled", Toast.LENGTH_SHORT).show();
                }
            });
            exitDialog.show();
        }
    }
