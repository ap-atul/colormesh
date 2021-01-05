package com.blackwhite.colormeshapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blackwhite.colormesh.ColorMesh;

import static com.blackwhite.colormesh.Palette.FRUITY;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mainLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.blackwhite.colormeshapp.R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CardAdapter());

    }


    class CardAdapter extends RecyclerView.Adapter<CardAdapter.MyViewHolder> {

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
            return new MyViewHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            ColorMesh colorMesh = new ColorMesh();
            colorMesh
                    .setRandomColors(FRUITY, 3)
                    .setTransparency(70)
                    .setOrientation(ColorMesh.TL_BR)
                    .setType(ColorMesh.LINEAR)
                    .setShape(ColorMesh.OVAL)
                    .setCornerRadius(15)
                    .attach(holder.layout);
        }


        @Override
        public int getItemCount() {
            return 10;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            public RelativeLayout layout;

            MyViewHolder(@NonNull View itemView) {
                super(itemView);

                layout = itemView.findViewById(R.id.main_layout);
            }
        }
    }
}
