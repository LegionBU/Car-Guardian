package com.dev.carguardianapp;

import android.content.Intent;
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

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email_id.getText().toString().contains("@"))
                {
                    email_id.setError("Please enter a valid email id.");
                }
                else
                {
                    StringRequest request = new StringRequest(Request.Method.GET, Constants.login_url, new Response.Listener<String>()
                    {
                        @Override
                        public void onResponse(String response)
                        {
                            try
                            {
                                JSONObject responseObject = new JSONObject(response);
                                if(!responseObject.getBoolean("error"))
                                {
                                    Toast.makeText(getContext(), "User logged-in successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getActivity(),Dashboard.class));
                                    getActivity().finish();
                                }
                                else
                                {
                                    Toast.makeText(getContext(), responseObject.getString("message"), Toast.LENGTH_SHORT).show();
                                }
                            }
                            catch (JSONException e)
                            {
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
                        protected Map<String, String> getParams() throws AuthFailureError
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("email",email_id.getText().toString());
                            map.put("password",password.getText().toString());
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
        ButterKnife.bind(v);
        email_id = v.findViewById(R.id.enter_email);
        password = v.findViewById(R.id.enter_password);
        createAcc = v.findViewById(R.id.createAcc);
        loginBtn = v.findViewById(R.id.loginBtn);
    }
}