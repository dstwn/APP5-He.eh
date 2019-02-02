package id.dstwn.pantiq.activity.berita;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.berita.network.ApiServices;
import id.dstwn.pantiq.activity.berita.network.InitRetrofit;
import id.dstwn.pantiq.activity.berita.response.BeritaItem;
import id.dstwn.pantiq.activity.berita.response.ResponseBerita;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeritaActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_berita);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.list_berita);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tampilBerita();
    }

    private void tampilBerita() {

        ApiServices apiServices = InitRetrofit.getInstance();
        Call<ResponseBerita> beritaCall = apiServices.request_show_all_berita();

        beritaCall.enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response.isSuccessful()){
                    List<BeritaItem> data_berita = response.body().getBerita();
                    boolean status = response.body().isStatus();
                    if (status) {
                        AdapterBerita adapter = new AdapterBerita(BeritaActivity.this, data_berita);
                        recyclerView.setAdapter(adapter);
                    } else {
                        Toast.makeText(BeritaActivity.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
