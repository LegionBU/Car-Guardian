package com.dev.carguardianapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginFragment extends Fragment {

    TextView createAcc;
    View v;
    EditText email_id, password;
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
                ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, new SignUp1()).addToBackStack("login").commit();
            }
        });


        return v;
    }

    void init(){
        ButterKnife.bind(v);
        email_id = v.findViewById(R.id.enter_email);
        password = v.findViewById(R.id.enter_password);
        createAcc = v.findViewById(R.id.createAcc);
        loginBtn = v.findViewById(R.id.loginBtn);
    }
}