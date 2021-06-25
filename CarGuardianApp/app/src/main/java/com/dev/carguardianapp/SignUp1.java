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
    @BindView(R.id.userImage) ImageView userImage;
    @BindView(R.id.userName) EditText userName;
    @BindView(R.id.userEmail) EditText userEmail;
    @BindView(R.id.userContact) EditText userContact;
    @BindView(R.id.continueBtn) Button continueBtn;


    public SignUp1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_up1, container, false);

        ButterKnife.bind((AppCompatActivity) v.getContext());

        return v;
    }
}