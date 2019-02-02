package id.dstwn.pantiq.activity.panti;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.dstwn.pantiq.R;

import id.dstwn.pantiq.activity.panti.response.PantiItem;

class AdapterPanti extends RecyclerView.Adapter<AdapterPanti.MyViewHolder> {
    Context context;
    List<PantiItem> panti;
    public AdapterPanti(Context context, List<PantiItem> data_panti){
        this.context = context;
        this.panti = data_panti;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_panti,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){


        holder.txtJudul.setText(panti.get(position).getNamaPanti());
        holder.txtAlamat.setText(panti.get(position).getAlamatPanti());
        holder.txtDeskripsi.setText(panti.get(position).getDeskripsi());
        holder.txtPemilik.setText(panti.get(position).getNamaPemilik());
        holder.txtKontak.setText(panti.get(position).getKontakPemilik());
        holder.txtLat.setText(panti.get(position).getLat());
        holder.txtLong.setText(panti.get(position).getJsonMemberLong());

        final String urlPanti = panti.get(position).getGambarPanti();

        Glide.with(context)
                .load(urlPanti)
                .into(holder.gmbr);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, DetailActivity.class);
                i.putExtra("GAMBAR_PANTI",panti.get(position).getGambarPanti());
                i.putExtra("JUDUL_PANTI",panti.get(position).getNamaPanti());
                i.putExtra("ALAMAT_PANTI",panti.get(position).getAlamatPanti());
                i.putExtra("DESKRIPSI_PANTI",panti.get(position).getDeskripsi());
                i.putExtra("PEMILIK_PANTI",panti.get(position).getNamaPemilik());
                i.putExtra("KONTAK_PANTI",panti.get(position).getKontakPemilik());
                i.putExtra("LAT_PANTI",panti.get(position).getLat());
                i.putExtra("LONG_PANTI",panti.get(position).getJsonMemberLong());
                context.startActivity(i);
            }
        });


    }
    @Override
    public int getItemCount(){
        return panti.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView gmbr;
        TextView txtJudul, txtAlamat, txtPemilik, txtKontak, txtLat, txtLong, txtDeskripsi;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            gmbr = (ImageView)itemView.findViewById(R.id.gambar_panti_list);
            txtAlamat = (TextView)itemView.findViewById(R.id.alamat_list);
            txtJudul = (TextView)itemView.findViewById(R.id.nama_panti_list);
            txtPemilik = (TextView) itemView.findViewById(R.id.nama_pemilik_list);
            txtKontak = (TextView)itemView.findViewById(R.id.kontak_pemilik_list);
            txtLat = (TextView)itemView.findViewById(R.id.lat_list);
            txtLong = (TextView)itemView.findViewById(R.id.long_list);
            txtDeskripsi = (TextView)itemView.findViewById(R.id.deskripsi_list);

        }
    }

}
