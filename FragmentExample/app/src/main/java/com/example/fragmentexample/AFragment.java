 package com.example.fragmentexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

 public class AFragment extends Fragment {


    public AFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(getArguments()!=null){
          String name=  getArguments().getString("Arg1");
          int rollno = Integer.parseInt(getArguments().getString("Arg2"));

          Log.d("Value from Act","Name is "+name+", RollNo is: "+rollno);
        }
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        TextView textView = view.findViewById(R.id.txtFrag);
        return view;
    }
}