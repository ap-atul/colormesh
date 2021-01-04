package com.blackwhite.colormesh;

import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ColorMesh {
    public static final int ANGLE_90 = 1;
    public static final int ANGLE_45 = 2;

    public static final int LINEAR = 0;
    public static final int RADIAL = 1;

    public static final Object TOP_BOTTOM = Orientation.TOP_BOTTOM;
    public static final Object BOTTOM_TOP = Orientation.BOTTOM_TOP;
    public static final Object LEFT_RIGHT = Orientation.LEFT_RIGHT;
    public static final Object RIGHT_LEFT = Orientation.RIGHT_LEFT;
    public static final Object BL_TR = Orientation.BL_TR;
    public static final Object TR_BL = Orientation.TR_BL;
    public static final Object BR_TL = Orientation.BR_TL;
    public static final Object TL_BR = Orientation.TL_BR;


    private List<Integer> colors;
    private int gradientType = LINEAR;
    private int alpha = 1;
    private float radius = .0F;
    private Object orientation = TOP_BOTTOM;

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

    public ColorMesh setRandomColors(String[] palette, int count) {
        Random r = new Random();

        for (int i = 0; i < count; i++)
            this.colors.add(Color.parseColor(palette[r.nextInt(palette.length)]));

        return this;
    }

    public ColorMesh setType(int gradientType) {
        this.gradientType = gradientType;
        return this;
    }

    public ColorMesh setOrientation(Object orientation) {
        this.orientation = orientation;
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
        Gradient gradient = new Gradient(colors, gradientType, alpha, radius, orientation);
        view.setBackground(gradient.getDrawable());
    }
}
