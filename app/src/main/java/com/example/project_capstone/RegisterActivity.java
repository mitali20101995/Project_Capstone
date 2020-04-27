package com.example.project_capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEmail, mPassword, mConfirmPassword;
    private Button register;
    private static final String TAG = "RegisterActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = (EditText) findViewById(R.id.editEnterTextUsername);
        mPassword = (EditText) findViewById(R.id.editEnterTextPassword);
        mConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);
        register = (Button)  findViewById(R.id.btnSignUp);
    }

    public void moveToLogInForm(View view)
    {
        //check for null valued EditText fields
        if(!isEmpty(mEmail.getText().toString())
                && !isEmpty(mPassword.getText().toString())
                && !isEmpty(mConfirmPassword.getText().toString())){

                if(doStringsMatch(mPassword.getText().toString(),
                        mConfirmPassword.getText().toString())){
                    User user = new User();
                    user.setUsername(mEmail.getText().toString());
                    user.setPassword(mPassword.getText().toString());

                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    Log.d(TAG,"JSON:" + json);
                    Toast.makeText(RegisterActivity.this, "JSON:" + json,Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Passwords do not Match", Toast.LENGTH_SHORT).show();
                    }
        }
        else
            {
            Toast.makeText(RegisterActivity.this, "You must fill out all the fields", Toast.LENGTH_SHORT).show();
            }

        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
        startActivity(intent);
    }
    private boolean doStringsMatch(String s1, String s2){
        return s1.equals(s2);
    }


    private boolean isEmpty(String string){
        return string.equals("");
    }

}
