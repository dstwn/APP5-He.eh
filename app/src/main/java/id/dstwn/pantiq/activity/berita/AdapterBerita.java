package id.dstwn.pantiq.activity.berita;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.berita.response.BeritaItem;

class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.MyViewHolder> {

    Context context;
    List<BeritaItem> berita;
    public AdapterBerita(Context context,List<BeritaItem> data_berita){
        this.context = context;
        this.berita  = data_berita;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.item_berita, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position){
        holder.judulBerita.setText(berita.get(position).getJudulBerita());
        holder.isiBerita.setText(berita.get(position).getIsiBerita());
        final String urlGambar = berita.get(position).getGambarBerita();

        Glide.with(context)
                .load(urlGambar)
                .into(holder.gambarBerita);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DetailBerita.class);
                i.putExtra("JUDUL_BERITA",berita.get(position).getJudulBerita());
                i.putExtra("ISI_BERITA",berita.get(position).getIsiBerita());
                i.putExtra("GAMBAR_BERITA",urlGambar);

                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount(){
        return berita.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView gambarBerita;
        TextView judulBerita, isiBerita;

        public MyViewHolder(View itemView){
            super(itemView);
            gambarBerita = (ImageView) itemView.findViewById(R.id.gambar_berita);
            judulBerita = (TextView) itemView.findViewById(R.id.judul_berita);
            isiBerita = (TextView) itemView.findViewById(R.id.isi_berita);
        }
    }
//    Context context;
//    List<BeritaItem> berita;
//    public AdapterBerita(Context context, List<BeritaItem> data_berita) {
//        this.context = context;
//        this.berita = data_berita;
//    }
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
//        View view = LayoutInflater.from(context).inflate(R.layout.item_berita,parent,false);
//
//        MyViewHolder holder = new MyViewHolder(view);
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, final int position){
//        holder.txtJudul.setText(berita.get(position).getJudulBerita());
//        holder.txtBerita.setText(berita.get(position).getIsiBerita());
//        final String urlgambar = berita.get(position).getGambarBerita();
//
//        Glide.with(context)
//                .load(urlgambar)
//                .into(holder.imageView);
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, DetailBerita.class);
//                intent.putExtra("JUDUL_BERITA", berita.get(position).getJudulBerita());
//                intent.putExtra("GAMBAR_BERITA",urlgambar);
//                intent.putExtra("ISI_BERITA", berita.get(position).getIsiBerita());
//                context.startActivity(intent);
//            }
//        });
//
//    }
//
//    @Override
//    public int getItemCount(){
//        return berita.size();
//    }
//
//    public class MyViewHolder extends RecyclerView.ViewHolder{
//        ImageView imageView;
//        TextView txtJudul;
//        TextView txtBerita;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            imageView = (ImageView)itemView.findViewById(R.id.gambar_berita);
//            txtJudul = (TextView)itemView.findViewById(R.id.judul_berita);
//            txtBerita = (TextView)itemView.findViewById(R.id.isi_berita);
//
//        }
//
//    }

}