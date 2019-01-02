package id.dstwn.pantiq.activity.auth.login;

import androidx.appcompat.app.AppCompatActivity;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.auth.register.RegisterActivity;
import id.dstwn.pantiq.activity.controller.AppController;
import id.dstwn.pantiq.activity.dashboard.MainActivity;
import id.dstwn.pantiq.api.ServerAuth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    MaterialButton btn_login;
    EditText txt_uname, txt_upass;
    Intent i;

    int success;

    ConnectivityManager connectivityManager;

    private static final String TAG = LoginActivity.class.getSimpleName();
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
    private static final String TAG_USERNAME = "username";
    private static final String TAG_ID = "id";
    private static final String TAG_NAMEUSER = "nameuser";

    String tag_json_obj = "json_obj_req";

    SharedPreferences sharedPreferences;
    Boolean session = false;
    String id,username , nameuser ;

    public static final String sharedPref = "SharedPref";
    public static final String session_status  = "session_status";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cekKoneksi();
        toRegis();
        prosesLogin();

    }

    void prosesLogin() {
        btn_login = (MaterialButton) findViewById(R.id.btn_login);
        txt_uname = (EditText) findViewById(R.id.txt_uname);
        txt_upass = (EditText) findViewById(R.id.txt_upass);

        checkSession();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username  = txt_uname.getText().toString();
                String password = txt_upass.getText().toString();

                if (username.trim().length() > 0 & password.trim().length()>0){
                    if (connectivityManager.getActiveNetworkInfo()!=null
                        && connectivityManager.getActiveNetworkInfo().isAvailable()
                        && connectivityManager.getActiveNetworkInfo().isConnected()){
                        checkLogin(username, password);
                    }else {
                        Toast.makeText(getApplicationContext() ,"No Internet Connection", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext() ,"Kolom tidak boleh kosong", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void checkLogin(final String username, final String password) {

        loginDialog();
        String url = ServerAuth.URL + "login.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e(TAG, "Login respon : " + response.toString());
                hideDialog();
                try{
                    JSONObject jsonObject = new JSONObject(response);
                    success = jsonObject.getInt(TAG_SUCCESS);

                    if (success == 1){
                        String username = jsonObject.getString(TAG_USERNAME);
                        String id = jsonObject.getString(TAG_ID);
                        String nameuser = jsonObject.getString(TAG_NAMEUSER);

                        Log.e("login sukses", jsonObject.toString());
                        Toast.makeText(getApplicationContext(), jsonObject.getString(TAG_MESSAGE), Toast.LENGTH_LONG).show();
                        editSharedPref(username, id, nameuser);
                        loginSuccess(username, id, nameuser, getApplicationContext());
                    }
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Login Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_LONG).show();

                hideDialog();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", username);
                params.put("password", password);

                return params;
            }

        };
        AppController.getInstance().addToRequestQueue(stringRequest, tag_json_obj);
    }

    private void editSharedPref(String username, String id, String nameuser) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(session_status, true);
        editor.putString(TAG_ID,id);
        editor.putString(TAG_USERNAME, username);
        editor.putString(TAG_NAMEUSER, nameuser);
        editor.commit();
    }

    private void loginDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Logging in...");
        showDialog();
    }

    public void checkSession() {
        sharedPreferences = getSharedPreferences(sharedPref,Context.MODE_PRIVATE);
        session = sharedPreferences.getBoolean(session_status,false);
        id = sharedPreferences.getString(TAG_ID,null);
        username = sharedPreferences.getString(TAG_USERNAME,null);
        nameuser = sharedPreferences.getString(TAG_NAMEUSER,null);

        if (session){
            loginSuccess(username, id, nameuser, LoginActivity.this);
        }
    }
    public void loginSuccess(String username, String id, String nameuser, Context applicationContext) {
        Intent i = new Intent(applicationContext, MainActivity.class);
        i.putExtra(TAG_ID, id);
        i.putExtra(TAG_USERNAME, username);
        i.putExtra(TAG_NAMEUSER, nameuser);
        startActivity(i);
        finish();
    }

    public void cekKoneksi() {
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        {
            if (connectivityManager.getActiveNetworkInfo() != null
                    && connectivityManager.getActiveNetworkInfo().isAvailable()
                    && connectivityManager.getActiveNetworkInfo().isConnected()){
            } else {
                Toast.makeText(getApplicationContext(),"Koneksi tidak ada",Toast.LENGTH_LONG).show();
            }
        }
    }

    private void toRegis() {
        TextView kd = (TextView) findViewById(R.id.kedaftar);
        kd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
                finish();
            }
        });
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
