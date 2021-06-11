package com.example.ulanganfirosyanammar11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.ulanganfirosyanammar11.DetailActivity.ITEM_EXTRA;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvMakanan;
    private ArrayList<Makanan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMakanan =  findViewById(R.id.recycleview);
        rvMakanan.setHasFixedSize(true);

        list.addAll(dataMakanan.getListData());
        showRecyclerList();

    }

    private void showRecyclerList(){
        rvMakanan.setLayoutManager(new LinearLayoutManager(this));
        MakananAdapter makananAdapter = new MakananAdapter(list);
        rvMakanan.setAdapter(makananAdapter);

        makananAdapter.setOnItemClickCallback(new MakananAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Makanan makanan) {
                Intent moveIntent = new Intent(MainActivity.this,DetailActivity.class);
                moveIntent.putExtra(DetailActivity.ITEM_EXTRA, makanan);
                startActivity(moveIntent);
            }
        });


    }


}