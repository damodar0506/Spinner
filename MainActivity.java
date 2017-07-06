package com.example.jithu.spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity implements AsyncResponse  , OnItemSelectedListener, View.OnClickListener    {

    Spinner s1,s2;
    RadioButton rb;

  EditText editTextId  , et1;
    private Button buttonGet ;
    Button bt1, bt2;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        editTextId = (EditText) findViewById(R.id.editTextId);
        et1 = (EditText) findViewById(R.id.teachername);
        bt1 = (Button) findViewById(R.id.Submit);
        bt2 = (Button) findViewById(R.id.Reset);
        s1.setOnItemSelectedListener(this);
        rg = (RadioGroup) findViewById(R.id.rgroup);
        buttonGet = (Button) findViewById(R.id.buttonGet);



        buttonGet.setOnClickListener(this);


        bt1.setOnClickListener(this);
       bt2.setOnClickListener(this);

    }

    private void getData2() {
        String id = editTextId.getText().toString().trim();
        if (id.equals("")) {
            Toast.makeText(this, "Please enter an id", Toast.LENGTH_LONG).show();
            return;
        }
       // loading = ProgressDialog.show(this,"Please wait...","Fetching...",false,false);

        String url = Config.DATA_URL+editTextId.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.getMessage().toString(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void showJSON(String response){
        String name="";

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(Config.JSON_ARRAY);
            JSONObject collegeData = result.getJSONObject(0);
            name = collegeData.getString(Config.KEY_NAME);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        et1.setText(name);

    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                               long arg3) {
        // TODO Auto-generated method stub
        String sp1= String.valueOf(s1.getSelectedItem());
        Toast.makeText(this, sp1, Toast.LENGTH_SHORT).show();
        if(sp1.contentEquals("Draughtsman (Civil)2014-16")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Subject");
            list.add("Computer Organization & Architecture");
            list.add("Java Programming");
            list.add("Web Programming Using PHP");
            list.add("Principals of S/W Engineering");
            list.add("Open Course 1 - Computer Fundamentals & Office Automation");
            list.add("Mini Project-CS");
            list.add("Malayala Bhashayum Sahithyavum 1");
            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter.notifyDataSetChanged();
            s2.setAdapter(dataAdapter);
        }
        if(sp1.contentEquals("Mechanic Motor Vehicle 2014-16")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Subject");
            list.add("Properties of Matter & Thermodynamics");
            list.add("Malayala Bhashayum Sahithyavum 1");
            list.add("Open Course 1 - Computer Fundamentals & Office Automation");
            list.add("Communication Skills in Hindi");
            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

        if(sp1.contentEquals("Electronics Mechanic 2014-16")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Subject");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }


        if(sp1.contentEquals("Mechanic Computer Hardware 2014-16")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Subject");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

        if(sp1.contentEquals("Draughtsman (Civil) 2015-17")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Subject");
            list.add("Malayala Bhashayum Sahithyavum 1");
            list.add("Numerical Skills");
            list.add("Communicative Skills in Arabic");

            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

        if(sp1.contentEquals("Mechanic Motor Vehicle 2015-17")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Subject");
            list.add(" ");


            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

        if(sp1.contentEquals("Electronic Mechanic 2015-17")) {
            List<String> list = new ArrayList<String>();
            list.add("Select Subject");
            list.add(" ");


            ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_item, list);
            dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dataAdapter2.notifyDataSetChanged();
            s2.setAdapter(dataAdapter2);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }


    public void rdclick(View v) {

        int radiobuttonid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radiobuttonid);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.buttonGet){

            getData2();
        }

         else if(v.getId()==R.id.Submit){

            if (s1== null && s2==null && et1==null && rb==null ){

                Toast.makeText(MainActivity.this, "Please Enter all Fields", Toast.LENGTH_SHORT).show();

            }


                HashMap postData = new HashMap();
                postData.put("mobile", "android");
                postData.put("txtUsername", s1.getSelectedItem().toString());
                postData.put("txtPassword", s2.getSelectedItem().toString());
                postData.put("name", et1.getText().toString());
                postData.put("id" ,editTextId.getText().toString());
              //  postData.put("class" , rg.getCheckedRadioButtonId());



                PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
                task.execute("http://192.168.1.12/webservice/insertStudent.php");

        }
        else if(v.getId()==R.id.Reset){




            et1.setText(null);
            editTextId.setText(null);
            rg.clearCheck();



        }
        }


    @Override
    public void processFinish(String s) {



    }
}
