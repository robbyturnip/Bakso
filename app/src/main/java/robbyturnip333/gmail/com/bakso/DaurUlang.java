package robbyturnip333.gmail.com.bakso;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by robby on 23/04/18.
 */

public class DaurUlang extends RecyclerView.Adapter<DaurUlang.ViewHolder>{
    Context konteks;
    List<Menu> daftar;
    public DaurUlang(Context konteks,List<Menu> daftar){
        this.konteks=konteks;
        this.daftar=daftar;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DaurUlang.ViewHolder(LayoutInflater.from(konteks).inflate(R.layout.daftar_makanan,parent,false));
    }

    @Override
    public void onBindViewHolder(DaurUlang.ViewHolder holder, int position) {
    Menu menu=daftar.get(position);
    holder.judul.setText(menu.getJudul());
    holder.harga.setText(menu.getHarga());
    }

    @Override
    public int getItemCount() {
        return daftar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView gambar;
        TextView judul,harga;
        public ViewHolder(View itemView) {
            super(itemView);
            gambar=itemView.findViewById(R.id.gambar);
            judul=itemView.findViewById(R.id.judul);
            harga=itemView.findViewById(R.id.harga);
        }
    }
}
