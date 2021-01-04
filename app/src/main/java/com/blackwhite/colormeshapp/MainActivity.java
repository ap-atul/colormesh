package com.blackwhite.colormeshapp;

import android.os.Bundle;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.blackwhite.colormesh.ColorMesh;

public class MainActivity extends AppCompatActivity {

    private ColorMesh colorMesh;

    private RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.blackwhite.colormeshapp.R.layout.activity_main);

        colorMesh = new ColorMesh();
        mainLayout = findViewById(com.blackwhite.colormeshapp.R.id.main_layout);

        colorMesh
                .setColor("#FFAEBC")
                .setColor("#FBE7C6")
                .setTransparency(20)
                .setType(ColorMesh.LINEAR)
                .setCornerRadius(15)
                .attach(mainLayout);
    }
}
