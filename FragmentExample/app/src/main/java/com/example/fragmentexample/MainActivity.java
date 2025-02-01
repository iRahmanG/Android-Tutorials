package com.example.fragmentexample;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button btnFragA, btnFragB,btnFragC;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFragA = findViewById(R.id.btnFragA);
        btnFragB = findViewById(R.id.btnFragB);
        btnFragC = findViewById(R.id.btnFragC);
        //default Fragment open
        loadFragment(new BFragment(),0);

        btnFragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AFragment(),1);

            }
        });

        btnFragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new BFragment(),1);

            }
        });

        btnFragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CFragment(),1);

            }
        });

    }

       public void loadFragment(Fragment fragment,int flag){
           FragmentManager fm=getSupportFragmentManager();
           FragmentTransaction ft = fm.beginTransaction();
           Bundle bundle = new Bundle();
           bundle.putString("Arg1","Raman");
           bundle.putInt("Arg2",11);


           fragment.setArguments(bundle);
           if(flag==0) {
               ft.add(R.id.container, fragment);
           } else {
               ft.replace(R.id.container, fragment);
           }

           ft.commit();
    }


}