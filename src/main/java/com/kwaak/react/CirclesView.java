package com.kwaak.react;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import jp.wasabeef.blurry.Blurry;

public class CirclesView {

    private final String LOGTAG = "CirclesView";

    private int radius;
    private int sampling;
    private String color;
    private Context context;

    public static final int defaultRadius = 10;
    public static final int defaultSampling = 8;

    public CirclesView(final Context context) {
        super(context);

        this.context = context;

        Render(activity);
    }

    private void Render(Activity activity) {
        Log.i(LOGTAG, String.format("activity %s", activity));

        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);

        Log.i(LOGTAG, String.format("viewGroup %s", viewGroup));
        Log.i(LOGTAG, String.format("this %s", this));

        Blurry.Composer c = Blurry.with(activity)
                .radius(this.radius)
                .sampling(this.sampling);

        if(this.color != null)
                c = c.color(Color.parseColor(this.color));

        //c.async()
        c.capture(viewGroup)
        .into(this);
    }

    public void setRadiusAndUpdate(int radius) {
        setRadius(radius);
        Render(activity);
    }

    private void setRadius(int radius) {
        this.radius = radius;
    }

    public void setSamplingAndUpdate(int sampling) {
        setSampling(sampling);
        Render(activity);
    }

    private void setSampling(int sampling) {
        this.sampling = sampling;
    }

    public void setColorAndUpdate(String color) {
        this.color = color;
        Render(activity);
    }
}
