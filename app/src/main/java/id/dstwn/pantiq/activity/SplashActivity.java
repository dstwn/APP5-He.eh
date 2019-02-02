package id.dstwn.pantiq.activity;

import androidx.appcompat.app.AppCompatActivity;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.auth.login.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashscreen();

    }

    private void splashscreen() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity( new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        },2000L);
    }
}
