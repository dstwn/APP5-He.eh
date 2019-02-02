package id.dstwn.pantiq.activity.panti;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import id.dstwn.pantiq.R;

public class DetailActivity extends AppCompatActivity {
    ImageView gambar;
    TextView detailJudul,detailAlamat,detailPemilik,detailKontak,detailDeskripsi;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setTitle(null);

        ImageView keMap = (ImageView) findViewById(R.id.tombol_map);
        keMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:"));
                startActivity(i);

            }
        });


        gambar = (ImageView) findViewById(R.id.gambar_panti_detail);
        detailJudul = (TextView) findViewById(R.id.judul_panti_detail);
        detailAlamat = (TextView) findViewById(R.id.alamat_panti_detail);
        detailPemilik = (TextView) findViewById(R.id.pemilik_panti_detail);
        detailKontak = (TextView) findViewById(R.id.kontak_panti_detail);
        detailDeskripsi = (TextView) findViewById(R.id.deskripsi_panti_detail);
        ambilData();
        

    }

    private void ambilData() {
        String gambarPanti =  getIntent().getStringExtra("GAMBAR_PANTI");
        String judulPanti = getIntent().getStringExtra("JUDUL_PANTI");
        String alamatPanti = getIntent().getStringExtra("ALAMAT_PANTI");
        String deskripsiPanti = getIntent().getStringExtra("DESKRIPSI_PANTI");
        String pemilikPanti = getIntent().getStringExtra("PEMILIK_PANTI");
        String kontakPanti = getIntent().getStringExtra("KONTAK_PANTI");
        String latPanti = getIntent().getStringExtra("LAT_PANTI");
        String longPanti = getIntent().getStringExtra("LONG_PANTI");


        detailJudul.setText(judulPanti);
        detailAlamat.setText(alamatPanti);
        detailPemilik.setText(pemilikPanti);
        detailKontak.setText(kontakPanti);
        detailDeskripsi.setText(deskripsiPanti);


        Glide.with(this)
                .load(gambarPanti)
                .into(gambar);


    }
}
