package id.dstwn.pantiq.activity.dashboard.menu.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.auth.login.LoginActivity;

import static id.dstwn.pantiq.activity.dashboard.MainActivity.TAG_ID;
import static id.dstwn.pantiq.activity.dashboard.MainActivity.TAG_NAMEUSER;
import static id.dstwn.pantiq.activity.dashboard.MainActivity.TAG_USERNAME;

public class ProfileActivity extends AppCompatActivity {
    String id,username,nameuser;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setTitle(null);

        sharedPreferences = getSharedPreferences(LoginActivity.sharedPref, Context.MODE_PRIVATE);

        username = getIntent().getStringExtra(TAG_USERNAME);
        nameuser = getIntent().getStringExtra(TAG_NAMEUSER);
        id = getIntent().getStringExtra(TAG_ID);

        TextView usernim = (TextView) findViewById(R.id.usernim);
        TextView id_user = (TextView) findViewById(R.id.id_user);
        TextView nama_user = (TextView) findViewById(R.id.nama_user);

        usernim.setText(username);
        id_user.setText(id);
        nama_user.setText(nameuser);


    }
}
