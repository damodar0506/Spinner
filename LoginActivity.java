package com.example.jithu.spinner;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.*;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements AsyncResponse  , View.OnClickListener{

    EditText etUsername , etPassword ;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void processFinish(String result) {
        if (result.equals("Success")) {
            Intent i = new Intent(LoginActivity.this , MainActivity.class);
            startActivity(i);
            Toast.makeText(this, "Login Successfully", Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {

        HashMap postData = new HashMap();
        postData.put("mobile" , "android");
        postData.put("txtUsername",etUsername.getText().toString());
        postData.put("txtPassword",etPassword.getText().toString());


        PostResponseAsyncTask task = new PostResponseAsyncTask(this ,postData );
        task.execute("http://192.168.1.12/webservice/login.php");

    }
}
