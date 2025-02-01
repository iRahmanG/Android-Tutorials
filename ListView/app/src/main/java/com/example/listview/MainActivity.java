package com.example.listview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;
    AutoCompleteTextView actxView;
    ArrayList<String> arrNames = new ArrayList<>();
    ArrayList<String> arrIds = new ArrayList<>();
    ArrayList<String> arrLanguage = new ArrayList<>();


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

        listView =findViewById(R.id.listView);
        spinner = findViewById(R.id.spinner);
        actxView =findViewById(R.id.actxView);

        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");
        arrNames.add("Maksud");
        arrNames.add("Rahman");

        ArrayAdapter<String> adaptor = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrNames);
        listView.setAdapter(adaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0) {
                    Toast.makeText(MainActivity.this, "Clicked First Item", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //spinner

        arrIds.add("Adhar card");
        arrIds.add("PAN card");
        arrIds.add("Voter Id");
        arrIds.add("Ration Card");
        arrIds.add("Driving Licence");
        arrIds.add("College/School I card");

        ArrayAdapter<String> spinnerAdaptor =new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,arrIds);
        spinner.setAdapter(spinnerAdaptor);

        //auto complete text view

        arrLanguage.add("Java");
        arrLanguage.add("C");
        arrLanguage.add("C++");
        arrLanguage.add("Python");
        arrLanguage.add("Kotlin");
        arrLanguage.add("JavaScript");
        arrLanguage.add("HTML/CSS");

        ArrayAdapter<String> actxViewAdaptor = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrLanguage);
        actxView.setAdapter(actxViewAdaptor);
        actxView.setThreshold(1);
    }
}