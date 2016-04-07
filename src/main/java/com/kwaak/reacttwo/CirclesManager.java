package com.kwaak.reacttwo;

import android.graphics.Color;
import android.support.annotation.Nullable;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.Map;

import at.grabner.circleprogress.TextMode;
import at.grabner.circleprogress.CircleProgressView;

public class CirclesManager extends SimpleViewManager<CircleProgressView> {

    public static final int COMMAND_SPIN = 1;
    public static final int COMMAND_STOPSPINNING = 2;
    private boolean _animated;

    public CirclesManager() {
    }

    public static final String REACT_CLASS = "RCTCircles";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public CircleProgressView createViewInstance(ThemedReactContext context) {
        return new CircleProgressView(context, null);
    }

    @ReactProp(name = "barColors")
    public void setBarColors(CircleProgressView view, ReadableArray val) {
        int[] vals = new int[val.size()];
        for(int i = 0; i < val.size(); i++) {
            vals[i] = Color.parseColor(val.getString(i));
        }
        view.setBarColor(vals);
    }

    @ReactProp(name = "barWidth", defaultInt = 0)
    public void setBarWidth(CircleProgressView view, int val) {
        view.setBarWidth(val);
    }
    @ReactProp(name = "blockCount", defaultInt = 0)
    public void setBlockCount(CircleProgressView view, int val) {
        view.setBlockCount(val);
    }
    @ReactProp(name = "blockScale", defaultFloat = 0)
    public void setBlockScale(CircleProgressView view, float val) {
        view.setBlockScale(val);
    }

    @ReactProp(name = "contourColor")
    public void setContourColor(CircleProgressView view, @Nullable String val) {
        view.setContourColor(Color.parseColor(val));
    }

    @ReactProp(name = "textColor")
    public void setTextColor(CircleProgressView view, @Nullable String val) {
        view.setTextColor(Color.parseColor(val));
    }
    @ReactProp(name = "contourSize", defaultFloat = 0)
    public void setContourSize(CircleProgressView view, float val) {
        view.setContourSize(val);
    }

    @ReactProp(name = "delayMillis", defaultInt = 0)
    public void setDelayMillis(CircleProgressView view, int val) {
        view.setDelayMillis(val);
    }

    @ReactProp(name = "fillColor")
    public void setFillColor(CircleProgressView view, @Nullable String val) {
        view.setFillCircleColor(Color.parseColor(val));
    }

    @ReactProp(name = "maxValue", defaultFloat = 0)
    public void setMaxValue(CircleProgressView view, float val) {
        view.setMaxValue(val);
    }

    @ReactProp(name = "value", defaultFloat = 0)
    public void setValue(CircleProgressView view, float val) {
        if(_animated)
            view.setValueAnimated(val) ;
        else
            view.setValue(val);
    }

    @ReactProp(name = "rimColor")
    public void setRimColor(CircleProgressView view, @Nullable String val) {
        view.setRimColor(Color.parseColor(val));
    }

    @ReactProp(name = "rimWidth", defaultInt = 0)
    public void setRimWidth(CircleProgressView view, int val) {
        view.setRimWidth(val);
    }

    @ReactProp(name = "startAngle", defaultInt = 0)
    public void setStartAngle(CircleProgressView view, int val) {
        view.setStartAngle(val);
    }

    @ReactProp(name = "unit")
    public void setUnit(CircleProgressView view, @Nullable String val) {
        view.setUnit(val);
    }

    @ReactProp(name = "unitScale", defaultFloat = 0)
    public void setUnitScale(CircleProgressView view, float val) {
        view.setUnitScale(val);
    }

    @ReactProp(name = "unitVisible", defaultBoolean = false)
    public void setUnitVisible(CircleProgressView view, boolean val) {
        view.setUnitVisible(val);
    }

    @ReactProp(name = "unitColor")
    public void setUnitColor(CircleProgressView view, @Nullable String val) {
        view.setUnitColor(Color.parseColor(val));
    }

    @ReactProp(name = "unitSize", defaultInt = 0)
    public void setUnitSize(CircleProgressView view, int val) {
        view.setUnitSize(val);
    }

    @ReactProp(name = "textScale", defaultFloat = 0)
    public void setTextScale(CircleProgressView view, float val) {
        view.setTextScale(val);
    }

    @ReactProp(name = "textSize", defaultInt = 0)
    public void setTextSize(CircleProgressView view, int val) {
        view.setTextSize(val);
    }

    @ReactProp(name = "text")
    public void setText(CircleProgressView view, @Nullable String val) {
        view.setText(val);
    }

    @ReactProp(name = "textMode")
    public void setTextMode(CircleProgressView view, @Nullable String val) {
        if(val.equalsIgnoreCase("text"))
            view.setTextMode(TextMode.TEXT);
        if(val.equalsIgnoreCase("value"))
            view.setTextMode(TextMode.VALUE);
        if(val.equalsIgnoreCase("percent"))
            view.setTextMode(TextMode.PERCENT);
    }

    @ReactProp(name = "animated", defaultBoolean = false)
    public void setAnimated(CircleProgressView view, boolean val) {
        _animated = val;
    }

    @ReactProp(name = "spinColor")
    public void setSpinColor(CircleProgressView view, @Nullable String val) {
        view.setSpinBarColor(Color.parseColor(val));
    }

    @ReactProp(name = "spinSpeed", defaultFloat = 10)
    public void setSpinSpeed(CircleProgressView view, float val) {
        view.setSpinSpeed(val);
    }

    @ReactProp(name = "spinBarLength", defaultFloat = 10)
    public void setSpinBarLength(CircleProgressView view, float val) {
        view.setSpinningBarLength(val);
    }

    @Override
    public Map<String,Integer> getCommandsMap() {
        return MapBuilder.of(
                "spin",
                COMMAND_SPIN,
                "stopSpinning",
                COMMAND_STOPSPINNING);
    }

    @Override
    public void receiveCommand(
            CircleProgressView viewPager,
            int commandType,
            @Nullable ReadableArray args) {
        Assertions.assertNotNull(viewPager);
        Assertions.assertNotNull(args);
        switch (commandType) {
            case COMMAND_SPIN: {
                viewPager.spin();
                return;
            }
            case COMMAND_STOPSPINNING: {
                viewPager.stopSpinning();
                return;
            }
            default:
                throw new IllegalArgumentException(String.format(
                        "Unsupported command %d received by %s.",
                        commandType,
                        getClass().getSimpleName()));
        }
    }
}

