package com.blackwhite.colormesh;

import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;
import java.util.List;


public class ColorMesh {
    public static final int ANGLE_90 = 1;
    public static final int ANGLE_45 = 2;

    public static final int LINEAR = 0;
    public static final int RADIAL = 1;

    private List<Integer> colors;
    private int gradientType = LINEAR;
    private int alpha = 1;
    private float radius = .0F;

    public ColorMesh() {
        this.colors = new ArrayList<>();
    }

    public ColorMesh setColor(String hex) {
        this.colors.add(Color.parseColor(hex));
        return this;
    }

    public ColorMesh setColors(String[] hexCodes) {
        for (String hex : hexCodes) {
            this.colors.add(Color.parseColor(hex));
        }
        return this;
    }

    public ColorMesh setType(int gradientType) {
        this.gradientType = gradientType;
        return this;
    }

    public ColorMesh setTransparency(int percent) {
        return this.setAlpha(255 - ((255 * percent) / 100));
    }

    public ColorMesh setAlpha(int alpha) {
        this.alpha = alpha;
        return this;
    }

    public ColorMesh setCornerRadius(float radius) {
        this.radius = radius;
        return this;
    }

    public void attach(View view) {
        Gradient gradient = new Gradient(colors, gradientType, alpha, radius);
        view.setBackground(gradient.getDrawable());
    }
}
