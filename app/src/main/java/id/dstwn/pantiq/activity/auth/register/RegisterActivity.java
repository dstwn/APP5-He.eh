package id.dstwn.pantiq.activity.auth.register;

import androidx.appcompat.app.AppCompatActivity;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.auth.login.LoginActivity;
import id.dstwn.pantiq.activity.controller.AppController;
import id.dstwn.pantiq.api.ServerAuth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    MaterialButton btn_reg;
    TextInputEditText reg_name,reg_username,reg_password,reg_repassword;
    Intent i;

    int success;
    ConnectivityManager connectivityManager;

    private String url = ServerAuth.URL + "register.php";

    private static final String TAG = RegisterActivity.class.getSimpleName();

    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";

    String tag_json_obj = "json_obj_req";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView kl = (TextView) findViewById(R.id.kelogin);

        kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                finish();
            }
        });



        cekKoneksi();

        btn_reg = (MaterialButton) findViewById(R.id.btn_daftar);
        reg_name = (TextInputEditText) findViewById(R.id.reg_name);
        reg_username = (TextInputEditText) findViewById(R.id.reg_username);
        reg_repassword =(TextInputEditText) findViewById(R.id.reg_repassword);
        reg_password = (TextInputEditText) findViewById(R.id.reg_password);

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameuser = reg_name.getText().toString();
                String username = reg_username.getText().toString();
                String password = reg_password.getText().toString();
                String repassword = reg_repassword.getText().toString();
                if (connectivityManager.getActiveNetworkInfo() !=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){
                    checkRegister(nameuser,username,password,repassword);
                }else {
                    Toast.makeText(getApplicationContext(), "No Internet Connection",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    private void checkRegister(final String nameuser,final String username,final String password, final String repassword) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Registering ..");
        showDialog();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Register Response: " + response.toString());
                hideDialog();


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    success = jsonObject.getInt(TAG_SUCCESS);

                    if (success == 1) {
                        reg_name.setText("");
                        reg_username.setText("");
                        reg_password.setText("");
                        reg_repassword.setText("");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                hideDialog();
            }
        }){
            @Override
            protected Map<String,String> getParams(){
                Map<String, String> params =new HashMap<String, String>();
                params.put("nameuser",nameuser);
                params.put("username", username);
                params.put("password", password);
                params.put("confirm_password", repassword);

                return params;
            }
            };
        AppController.getInstance().addToRequestQueue(stringRequest,tag_json_obj);
        }


    private void cekKoneksi() {
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (connectivityManager.getActiveNetworkInfo() !=null && connectivityManager.getActiveNetworkInfo().isAvailable() && connectivityManager.getActiveNetworkInfo().isConnected()){

            }else {
                Toast.makeText(getApplicationContext(), "No Internet Connection",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
    private void showDialog() {
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    private void hideDialog() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }

}
