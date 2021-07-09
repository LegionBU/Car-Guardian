package com.dev.carguardianapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUp4 extends Fragment {
    View v;
    TextView enterPass, confirmPass;
    Button continueBtn;
    Bundle bundle;

    public SignUp4() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_sign_up4, container, false);

        init();

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!enterPass.getText().toString().equals(confirmPass.getText().toString())){

                    confirmPass.setText("");
                    confirmPass.setError("Passwords Dont Match");

                }else {

                    StringRequest request = new StringRequest(Request.Method.POST, Constants.register_url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject responseObject = new JSONObject(response);
                                if(!responseObject.getBoolean("error")){
                                    Toast.makeText(getContext(), "User registered sucessfully", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(getContext(), responseObject.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> map = new HashMap<>();
                            map.put("name", bundle.getString("name"));
                            map.put("email", bundle.getString("email_id"));
                            map.put("mobile", bundle.getString("phone"));
                            map.put("password", confirmPass.getText().toString());
                            map.put("car_model", bundle.getString("model"));
                            map.put("reg_no",bundle.getString("reg_no") );
                            return map;
                        }
                    };

                    RequestHandler.getInstance(getContext()).addToRequestQueue(request);
                }
            }
        });

        return v;
    }

    void init(){
        bundle = getArguments();
        enterPass = v.findViewById(R.id.enterPassword);
        confirmPass = v.findViewById(R.id.confirmPassword);
        continueBtn = v.findViewById(R.id.continueBtn);
    }
}