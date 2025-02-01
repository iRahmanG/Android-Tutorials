package com.example.toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //step 1
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        //step 2
        if(getSupportActionBar()!=null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            //getSupportActionBar().setTitle("My ToolBar");
        }
        //step 3
        toolbar.setTitle("My ToolBar");
        toolbar.setSubtitle("Sub Title");

    }
    //step 4
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //step 5 after click

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id = item.getItemId();
        if(item_id==R.id.opt_new) {
            Toast.makeText(this, "Created new File", Toast.LENGTH_SHORT).show();
        }
        else if(item_id==R.id.opt_open) {
            Toast.makeText(this, "File Open", Toast.LENGTH_SHORT).show();
        } else if (item_id==R.id.opt_save) {
            Toast.makeText(this, "File Saved", Toast.LENGTH_SHORT).show();

        }
        else {//for default back button android.R.id.home
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}