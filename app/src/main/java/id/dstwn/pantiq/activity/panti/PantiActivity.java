package id.dstwn.pantiq.activity.panti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import id.dstwn.pantiq.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import static id.dstwn.pantiq.R.*;

public class PantiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_panti);
        setToolbar();

        CardView cardView = (CardView) findViewById(id.card_panti);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
                startActivity(i);
            }
        });
    }

    private void setToolbar() {
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar)findViewById(id.tulbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
