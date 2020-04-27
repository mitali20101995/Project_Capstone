package com.example.project_capstone;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    private EditText mEmail, mPassword;
    private Button logIn;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEmail = (EditText) findViewById(R.id.editTextUsername);
        mPassword = (EditText) findViewById(R.id.editTextPassword);
        logIn = (Button)  findViewById(R.id.btnLogin);




    // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://www.google.com";

    // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       //textView.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {


            @Override
            public void onErrorResponse(VolleyError error) {
                //textView.setText("That didn't work!");
            }
        });

    // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
    public void moveToRegisterForm(View view)
    {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void moveToHome(View view)
    {
        if(!isEmpty(mEmail.getText().toString())
                && !isEmpty(mPassword.getText().toString()))
        {
            User user = new User();
            user.setUsername(mEmail.getText().toString());
            user.setPassword(mPassword.getText().toString());

            Gson gson = new Gson();
            String json = gson.toJson(user);
            Log.d(TAG,"JSON:" + json);
            Toast.makeText(MainActivity.this, "JSON:" + json,Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(MainActivity.this, CreateNewBatchActivity.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(MainActivity.this, "You must fill out all the fields", Toast.LENGTH_SHORT).show();
        }
    }

}
