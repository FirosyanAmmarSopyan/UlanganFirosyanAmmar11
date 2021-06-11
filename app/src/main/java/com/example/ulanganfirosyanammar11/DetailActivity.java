package com.example.ulanganfirosyanammar11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView DetailFoto = findViewById(R.id.DetailFoto);
        TextView tvjudul = findViewById(R.id.tv_Judul);
        TextView tvDetail = findViewById(R.id.tv_Detail);

        Makanan makanan = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (makanan != null){
            Glide.with(this)
                    .load(makanan.getPhoto())
                    .into(DetailFoto);
            tvjudul.setText(makanan.getName());
            tvDetail.setText(makanan.getDetail());
        }
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Makanan");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}