package com.example.jithu.spinner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kosalgeek.android.json.JsonConverter;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

public class SecondActivity extends Activity  implements View.OnClickListener, AsyncResponse {

    TextView TV1, TV2, TV3, TV4 ;
    ListView data;
    Button insert, b2 ,get ;

    private static final String REGISTER_URL = "http://192.168.1.12/webservice/insert1.php";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);

        PostResponseAsyncTask task = new PostResponseAsyncTask(this);
        task.execute("http://192.168.1.12/web/check.php?Course_Name=Draughtsman%20(Civil)2014-16");

        TV1 = (TextView) findViewById(R.id.tv1);
        TV2 = (TextView) findViewById(R.id.tv2);
        TV3 = (TextView) findViewById(R.id.tv3);
        TV4 = (TextView) findViewById(R.id.tv4);
        data = (ListView) findViewById(R.id.std);
        insert = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        get = (Button) findViewById(R.id.get);


        get.setOnClickListener(this);
        insert.setOnClickListener(this);
        b2.setOnClickListener(this);

        Intent intent2 = getIntent();
        Bundle bundle = intent2.getExtras();
        final String Name = bundle.getString("Teacher Name");
        final String Course = bundle.getString("Course Name");

        final String Subject = bundle.getString("Subject Name");
        final String Class = bundle.getString("id");

        TV1.setText(Name);
        TV2.setText(Course);
        TV3.setText(Subject);
        TV4.setText(Class);



    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1) {
            registerUser();
        }

        else if ((v.getId() == R.id.button2)){

            Intent iti = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(iti);

        }

        else if(v.getId() == R.id.get){








        }




    }


    private void registerUser() {
        String name = TV1.getText().toString().trim().toLowerCase();
        String username = TV2.getText().toString().trim().toLowerCase();
        String password = TV3.getText().toString().trim().toLowerCase();
      String email = TV4.getText().toString().trim().toLowerCase();

        register(name,username,password,email);
    }

    private void register(String name, String username, String password, String email) {
        class RegisterUser extends AsyncTask<String, Void, String> {
            ProgressDialog loading;
            RegisterUserClass ruc = new RegisterUserClass();


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SecondActivity.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {

                HashMap<String, String> data = new HashMap<String,String>();
                data.put("name",params[0]);
                data.put("username",params[1]);
                data.put("password",params[2]);
                data.put("email",params[3]);

                String result = ruc.sendPostRequest(REGISTER_URL,data);

                return  result;
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(name,username,password,email);
    }




    @Override
    public void processFinish(String result) {

        ArrayList<Post>postList = new JsonConverter<Post>().toArrayList(result , Post.class);

        ArrayList<String> titles = new ArrayList<String>();
        for (Post value:postList) {
            titles.add(value.Member_Name);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1, titles);

            data.setAdapter(adapter);


        }




    }

}









