package com.dev.carguardianapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp1 extends Fragment {
    //@BindView(R.id.userImage) ImageView userImage;
    EditText userName;
    EditText userEmail;
    EditText userContact;
    Button continueBtn;
    View v;
    //Button continueBtn;

    Bundle bundle;


    public SignUp1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sign_up1, container, false);

        init();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(userContact.getText().length() != 10 ){

                    userContact.setError("Invalid length");

                }else if (!userEmail.getText().toString().contains("@")){

                    userEmail.setError("Please enter a valid email id");

                }else {

                    SignUp2 signUp2 = new SignUp2();
                    bundle.putString("name", userName.getText().toString());
                    bundle.putString("email_id", userEmail.getText().toString());
                    bundle.putString("phone", userContact.getText().toString());
                    signUp2.setArguments(bundle);

                    ((AppCompatActivity) v.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.frame, signUp2).addToBackStack("signup_1").commit();

                }
            }
        });

        return v;
    }

    void init(){
        bundle = new Bundle();
        userName = v.findViewById(R.id.userName);
        userEmail = v.findViewById(R.id.userEmail);
        userContact = v.findViewById(R.id.userContact);
        continueBtn = v.findViewById(R.id.continueBtn);

    }
}