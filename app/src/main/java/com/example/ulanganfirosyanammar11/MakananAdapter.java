package com.example.ulanganfirosyanammar11;

import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class MakananAdapter extends RecyclerView.Adapter<MakananAdapter.MakananViewHolder> {
    private ArrayList<Makanan> listMakanan;
    private OnItemClickCallback onItemClickCallback;
    int posku;
    View viewku;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }



    public MakananAdapter(ArrayList<Makanan> list){
        this.listMakanan = list;
    }

    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_makanan, parent, false);
        return new MakananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, int position) {
        Makanan makanan = listMakanan.get(position);
        Glide.with(holder.itemView.getContext())
                .load(makanan.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvNama.setText(makanan.getName());
        holder.tvDesk.setText(makanan.getDetail());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listMakanan.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMakanan.size();
    }

    class MakananViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        ImageView imgPhoto;
        TextView tvNama, tvDesk;
        MakananViewHolder(View itemview) {
            super(itemview);
            viewku = itemView;
            itemView.setOnCreateContextMenuListener(this);
            imgPhoto = itemview.findViewById(R.id.gambarMakanan);
            tvNama = itemview.findViewById(R.id.tvNama);
            tvDesk = itemview.findViewById(R.id.tvDesk);
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            MenuItem Delete = menu.add(Menu.NONE, 1, 1, "Delete");
            posku = getAdapterPosition();
            Delete.setOnMenuItemClickListener(onlickcontextmenu);
        }
    }
    private final MenuItem.OnMenuItemClickListener onlickcontextmenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {

            switch ( (item.getItemId())) {

                case 1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(viewku.getContext());
                    builder.setMessage("Are you sure to delete data")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    listMakanan.remove(posku);
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            })
                            //set your icon at here
                            .setTitle("Delete data")
                            .setIcon(R.mipmap.ic_launcher);
                    AlertDialog alert = builder.create();
                    alert.show(); //showing the dialog

                    break;
            }
            return false;
        }
    };

    public interface  OnItemClickCallback{
        void onItemClicked(Makanan data);
    }
}
