package com.example.database_example;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MyDBHelper dbHelper =new MyDBHelper(this);

//        dbHelper.addContact("Raman","9876543210");
//        dbHelper.addContact("Saman","9876543212");
//        dbHelper.addContact("Gaman","9876543213");
//        dbHelper.addContact("Jaman","9876543214");
//        dbHelper.addContact("Daman","9876543215");

        ArrayList<ContactModel> arrContacts = dbHelper.getContacts();

        for(int i=0;i<arrContacts.size();i++)
            Log.d("CONTACT INFO","Name: "+arrContacts.get(i).name + ", Phone Number: "+ arrContacts.get(i).phone_no);
    }
}