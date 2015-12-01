package com.kwaak.react;

import android.app.Activity;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import at.grabner.circleprogress.CircleProgressView;

public class CirclesManager extends SimpleViewManager<CirclesView> {


    public CirclesManager() {
    }

    public static final String REACT_CLASS = "RCTCircle";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public CirclesView createViewInstance(ThemedReactContext context) {
        //CirclesView c = new CirclesView(context);
        return new CircleProgressView(context, null);

        return c;
    }

    /*@ReactProp(name = "radius", defaultInt = 0)
    public void setRadius(CirclesView view, int radius) {
        view.setRadiusAndUpdate(radius);
    }

    @ReactProp(name = "sampling", defaultInt = 0)
    public void setSampling(CirclesView view, int sampling) {
        view.setSamplingAndUpdate(sampling);
    }

    @ReactProp(name = "color")
    public void setColor(CirclesView view, String color) {
        view.setColorAndUpdate(color);
    }*/
}

