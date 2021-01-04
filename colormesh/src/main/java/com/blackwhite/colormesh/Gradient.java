package com.blackwhite.colormesh;


import android.graphics.drawable.GradientDrawable;
import android.util.Log;

import java.util.List;


class Orientation {
    static final GradientDrawable.Orientation TOP_BOTTOM = GradientDrawable.Orientation.TOP_BOTTOM;
    static final GradientDrawable.Orientation BOTTOM_TOP = GradientDrawable.Orientation.BOTTOM_TOP;
    static final GradientDrawable.Orientation RIGHT_LEFT = GradientDrawable.Orientation.RIGHT_LEFT;
    static final GradientDrawable.Orientation BL_TR = GradientDrawable.Orientation.BL_TR;
    static final GradientDrawable.Orientation TR_BL = GradientDrawable.Orientation.TR_BL;
    static final GradientDrawable.Orientation BR_TL = GradientDrawable.Orientation.BR_TL;
    static final GradientDrawable.Orientation TL_BR = GradientDrawable.Orientation.TL_BR;
    static final GradientDrawable.Orientation LEFT_RIGHT = GradientDrawable.Orientation.LEFT_RIGHT;

}


class Gradient {

    private List<Integer> colors;
    private int gradientType;
    private int alpha = 1;
    private float radius = .0F;
    private Object orientation = null;

    Gradient() {
    }

    public Gradient(List<Integer> colors, int gradientType, int alpha, float radius, Object orientation) {
        this.colors = colors;
        this.gradientType = gradientType;
        this.alpha = alpha;
        this.radius = radius;
        this.orientation = orientation;
    }

    GradientDrawable getDrawable() {
        GradientDrawable drawable = new GradientDrawable();

        if (colors.size() == 1) {
            Log.i("COLOR", "SIZE is one");
            drawable.setColor(colors.get(0));
        } else
            drawable.setColors(getPrimitivesColors());

        drawable.setGradientType(this.gradientType);
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setOrientation(GradientDrawable.Orientation.BR_TL);
        drawable.setGradientCenter(0, 0);
        drawable.setAlpha(this.alpha);
        drawable.setCornerRadius(this.radius);
        drawable.setOrientation((GradientDrawable.Orientation) orientation);

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
