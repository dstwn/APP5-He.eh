package id.dstwn.pantiq.activity.panti;

import androidx.appcompat.app.AppCompatActivity;
import id.dstwn.pantiq.R;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import static id.dstwn.pantiq.R.*;

public class PantiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_panti);

        setTitle();

    }

    private void setTitle() {
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar)findViewById(id.tulbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        getSupportActionBar().setTitle(i.getStringExtra("judul"));
    }
}
