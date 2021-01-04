package com.blackwhite.colormesh;


import android.graphics.drawable.GradientDrawable;
import android.util.Log;

import java.util.List;


class Gradient {

    private List<Integer> colors;
    private int gradientType;
    private int alpha = 1;
    private float radius = .0F;

    Gradient() {
    }

    public Gradient(List<Integer> colors, int gradientType, int alpha, float radius) {
        this.colors = colors;
        this.gradientType = gradientType;
        this.alpha = alpha;
        this.radius = radius;
    }

    public GradientDrawable getDrawable() {
        GradientDrawable drawable = new GradientDrawable();

        if (colors.size() == 1) {
            Log.i("COLOR", "SIZE is one");
            drawable.setColor(colors.get(0));
        } else
            drawable.setColors(getPrimitivesColors());

        drawable.setGradientType(this.gradientType);
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setGradientCenter(0, 0);
        drawable.setAlpha(this.alpha);
        drawable.setCornerRadius(this.radius);

        return drawable;
    }

    private int[] getPrimitivesColors() {
        int[] primitives = new int[colors.size()];

        for (int i = 0; i < colors.size(); i++) {
            primitives[i] = colors.get(i);
        }

        return primitives;
    }

}
