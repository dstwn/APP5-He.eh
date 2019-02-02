package id.dstwn.pantiq.activity.panti;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.berita.network.ApiServices;
import id.dstwn.pantiq.activity.berita.network.InitRetrofit;
import id.dstwn.pantiq.activity.panti.response.PantiItem;
import id.dstwn.pantiq.activity.panti.response.ResponsePanti;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.List;

import static id.dstwn.pantiq.R.*;

public class PantiActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_panti);
        setToolbar();

        CardView cardView = (CardView) findViewById(id.card_panti);

//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(getApplicationContext(), DetailActivity.class);
//                startActivity(i);
//            }
//        });
        recyclerView = (RecyclerView) findViewById(id.list_panti);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tampilPanti();

        TextView textView = (TextView) findViewById(id.kategori);

        String kgt = getIntent().getStringExtra("judul");

        textView.setText("Daftar Panti Asuhan di "+kgt);

    }

    private void tampilPanti() {
        ApiServices pnt = InitRetrofit.getInstance();
        Call<ResponsePanti> pantiCall = pnt.request_show_panti();
        pantiCall.enqueue(new Callback<ResponsePanti>() {
            @Override
            public void onResponse(Call<ResponsePanti> call, Response<ResponsePanti> response) {
                if (response.isSuccessful()){
                    List<PantiItem> data_panti = response.body().getPanti();
                    boolean status = response.body().isStatus();
                    if (status){
                        AdapterPanti adapterPanti = new AdapterPanti(PantiActivity.this, data_panti);
                        recyclerView.setAdapter(adapterPanti);
                    }else {
                        Toast.makeText(PantiActivity.this, "Tidak ada berita untuk saat ini", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponsePanti> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

    private void setToolbar() {
        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar)findViewById(id.tulbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(drawable.ic_back);
    }
}
