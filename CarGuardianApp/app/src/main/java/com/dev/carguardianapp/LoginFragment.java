package com.dev.carguardianapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginFragment extends Fragment {

    View v;
    EditText email_id, password;
    TextView createAcc;
    Button loginBtn;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_login, container, false);

        init();

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Hello. Create Account Pressed", Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    void init(){
        email_id = v.findViewById(R.id.enter_email);
        password = v.findViewById(R.id.enter_password);
        createAcc = v.findViewById(R.id.createAcc);
        loginBtn = v.findViewById(R.id.loginBtn);
    }
}