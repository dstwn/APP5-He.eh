package id.dstwn.pantiq.activity.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import id.dstwn.pantiq.R;
import id.dstwn.pantiq.activity.panti.PantiActivity;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.VH> {
    Context context;
    List<Data> dataList;

    public MainAdapter(Context context, List<Data> dataList){
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int a){
        View view = LayoutInflater.from(context).inflate(R.layout.item_kab,viewGroup,false);
        return new VH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull VH vh, int a ){
        vh.BindItems(dataList.get(a));
    }
    @Override
    public int getItemCount(){
        return dataList.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;
        public VH(@NonNull View itemView){
            super(itemView);
            textView =(TextView)itemView.findViewById(R.id.itemkab_title);
            imageView=(ImageView)itemView.findViewById(R.id.itemkab_image);
        }

        public void BindItems(final Data dataku) {
            textView.setText(dataku.getNamaKab());
            final int image = dataku.getGambarKab();
            imageView.setImageResource(dataku.getGambarKab());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context,PantiActivity.class);
                    i.putExtra("judul",textView.getText());
                    context.startActivity(i);
                }
            });

        }
    }
}
