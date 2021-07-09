package com.dev.carguardianapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;


public class SignUp3 extends Fragment {
    EditText otpText1;
    EditText otpText2;
    EditText otpText3;
    EditText otpText4;
    EditText otpText5;
    EditText otpText6;

    Bundle bundle;
    View v;
    String phnNumber;
    String mVerificationId;

    Button continueBtn;

    private void sendVerificationCode() {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                "+91" + phnNumber,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();

            if (code != null) {
                otpText1.setText(code.charAt(0)+"");
                otpText2.setText(code.charAt(1)+"");
                otpText3.setText(code.charAt(2)+"");
                otpText4.setText(code.charAt(3)+"");
                otpText5.setText(code.charAt(4)+"");
                otpText6.setText(code.charAt(5)+"");
                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;
        }
    };

    private void verifyVerificationCode(String code) {
        //creating the credential
        try {
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);
            signInWithPhoneAuthCredential(credential);
        }catch (Exception e){
            Toast toast = Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        Toast.makeText(getContext(), "Phone Number Verified Successfully", Toast.LENGTH_SHORT).show();

    }



    public SignUp3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_sign_up3, container, false);
        init();



        return v;
    }

    void init(){
        bundle = getArguments();
        phnNumber = bundle.getString("phone");

        otpText1 = v.findViewById(R.id.otptext3);
        otpText2 = v.findViewById(R.id.otptext6);
        otpText3 = v.findViewById(R.id.otptext1);
        otpText4 = v.findViewById(R.id.otptext5);
        otpText5 = v.findViewById(R.id.otptext2);
        otpText6 = v.findViewById(R.id.otptext4);
        continueBtn = v.findViewById(R.id.continueBtn);

        EditText[] edit = {otpText1, otpText2, otpText3, otpText4, otpText5, otpText6};

        otpText1.addTextChangedListener((TextWatcher) new GenericTextWatcher(otpText1, edit));
        otpText2.addTextChangedListener((TextWatcher) new GenericTextWatcher(otpText2, edit));
        otpText3.addTextChangedListener((TextWatcher) new GenericTextWatcher(otpText3, edit));
        otpText4.addTextChangedListener((TextWatcher) new GenericTextWatcher(otpText4, edit));
        otpText5.addTextChangedListener((TextWatcher) new GenericTextWatcher(otpText5, edit));
        otpText6.addTextChangedListener((TextWatcher) new GenericTextWatcher(otpText6, edit));
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyVerificationCode(otpText1.getText().toString()+otpText2.getText().toString()+otpText3.getText().toString()+
                        otpText4.getText().toString()+otpText5.getText().toString()+otpText6.getText().toString());
            }
        });

        sendVerificationCode();
    }
}