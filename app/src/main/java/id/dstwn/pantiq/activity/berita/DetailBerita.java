package id.dstwn.pantiq.activity.berita;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import id.dstwn.pantiq.R;

public class DetailBerita extends AppCompatActivity {

    ImageView imageView;
    TextView judulBerita, isiBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_berita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        imageView = (ImageView) findViewById(R.id.gambar_detail_berita);
        judulBerita = (TextView) findViewById(R.id.judul_detail_berita);
        isiBerita = (TextView) findViewById(R.id.isi_detail_berita);

        showDataBerita();
    }

    private void showDataBerita() {
        String judul_berita = getIntent().getStringExtra("JUDUL_BERITA");
        String gambar_berita = getIntent().getStringExtra("GAMBAR_BERITA");
        String isi_berita  = getIntent().getStringExtra("ISI_BERITA");

        judulBerita.setText(judul_berita);
        isiBerita.setText(isi_berita);
        Glide.with(this)
                .load(gambar_berita)
                .into(imageView);

    }



}
