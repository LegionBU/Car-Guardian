package com.dev.carguardianapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp2 extends Fragment {
    EditText carModel;
    EditText reg_No;
    Button continue_btn;
    Bundle bundle;
    View v;

    public SignUp2()
    {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        v = inflater.inflate(R.layout.fragment_sign_up2, container, false);
        ButterKnife.bind((AppCompatActivity) v.getContext(), v);

        init();

        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                bundle.putString("model",carModel.getText().toString());
                bundle.putString("reg_no",reg_No.getText().toString());
                SignUp3 su3=new SignUp3();
                su3.setArguments(bundle);
                ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame,su3).addToBackStack("SignUp2").commit();
            }
        });
        return v;
    }

    void init(){
        bundle = getArguments();
        carModel = v.findViewById(R.id.car_Model);
        reg_No = v.findViewById(R.id.reg_No);
        continue_btn = v.findViewById(R.id.continueBtn);
    }
}