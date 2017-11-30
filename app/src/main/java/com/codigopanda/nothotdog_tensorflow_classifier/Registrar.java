package com.codigopanda.nothotdog_tensorflow_classifier;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;



import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Registrar extends Activity implements OnClickListener {
    private EditText user, pass,sexo,correo,telefono;
    private RadioGroup radioGroup;
    private Button mRegister;
    private RadioButton radiosexo;
    // Progress Dialog
    String sexotxt, correotxt, telefonotxt,username,password;
    // Progress Dialog
    private ProgressDialog pDialog;

    // JSON parser class
    JSONParser jsonParser = new JSONParser();

    //si lo trabajan de manera local en xxx.xxx.x.x va su ip local
    // private static final String REGISTER_URL = "http://xxx.xxx.x.x:1234/cas/register.php";

    //testing on Emulator:
    private static final String REGISTER_URL = "https://edisolizc.000webhostapp.com/register.php";

    //ids
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);

        correo=(EditText)findViewById(R.id.editcorreo);
        telefono=(EditText)findViewById(R.id.edittelefono);
///fb


        mRegister = (Button)findViewById(R.id.register);
        String username = user.getText().toString();
        String password = pass.getText().toString();



        mRegister.setOnClickListener(this);

    }
    private void pantallaprincipar() {
        Intent i=new Intent(this,Login.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        int pos=radioGroup.getCheckedRadioButtonId();
        radiosexo=(RadioButton)findViewById(pos);
        //sexotxt =radiosexo.getText().toString();
        sexotxt="hombre";
        correotxt=correo.getText().toString();
        telefonotxt=telefono.getText().toString();
         username = user.getText().toString();
         password = pass.getText().toString();
        new CreateUser().execute();

    }

    class CreateUser extends AsyncTask<String, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(Registrar.this);
            pDialog.setMessage("Creating User...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected String doInBackground(String... args) {
            // TODO Auto-generated method stub
            // Check for success tag
            int success;


            try {
                // Building Parameters
                List params = new ArrayList();
                params.add(new BasicNameValuePair("username", username));
                params.add(new BasicNameValuePair("password", password));
                params.add(new BasicNameValuePair("sexo", sexotxt));
                params.add(new BasicNameValuePair("correo", correotxt));
                params.add(new BasicNameValuePair("telefono", telefonotxt));
                Log.d("request!", "starting");

                //Posting user data to script
                JSONObject json = jsonParser.makeHttpRequest(
                        REGISTER_URL, "POST", params);

                // full json response
                Log.d("Registering attempt", json.toString());

                // json success element
                success = json.getInt(TAG_SUCCESS);
                if (success == 1) {
                    Log.d("User Created!", json.toString());
                    finish();
                    return json.getString(TAG_MESSAGE);
                }else{
                    Log.d("Registering Failure!", json.getString(TAG_MESSAGE));
                    return json.getString(TAG_MESSAGE);

                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(Registrar.this, "salio mal pues", Toast.LENGTH_SHORT).show();
            }

            return null;

        }

        protected void onPostExecute(String file_url) {
            // dismiss the dialog once product deleted
            pDialog.dismiss();
            if (file_url != null){
                Toast.makeText(Registrar.this, file_url, Toast.LENGTH_LONG).show();
            }
        }
    }

 protected  void onActivityResult(int requestCode,int resultCode,Intent data){

     super.onActivityResult(requestCode,resultCode,data);


 }

}