package com.example.bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);
        bnView.setLabelVisibilityMode(NavigationBarView.LABEL_VISIBILITY_LABELED);

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                int id = item.getItemId();
                if(id==R.id.nav_home){
                   loadFrag(new AFragment(),0);
                    
                } else if(id==R.id.nav_Search) {
                    loadFrag(new BFragment(),1);
                    
                } else if (id==R.id.nav_Utilities) {
                    loadFrag(new CFragment(),1);
                } else if (id==R.id.nav_Contact) {
                    loadFrag(new DFragment(),1);
                } else  { //profile
                    loadFrag(new EFragment(),1);
                }

            return true;
            }
        });
        bnView.setSelectedItemId(R.id.nav_home);

    }

    public void loadFrag(Fragment fragment,int n) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        if(n==0){
            ft.add(R.id.container,fragment);
        } else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}