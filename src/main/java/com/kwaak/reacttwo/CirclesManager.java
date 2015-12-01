package com.kwaak.reacttwo;

import android.support.annotation.Nullable;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.Map;

public class CirclesManager extends SimpleViewManager<CirclesView> {

    public static final int COMMAND_SPIN = 1;
    public static final int COMMAND_STOPSPINNING = 2;

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
        return new CirclesView(context);
    }

    @ReactProp(name = "BarColors", defaultInt = 0)
    public void setBarColors(CirclesView view, ReadableArray val) {
        int[] vals = new int[val.size()];
        for(int i = 0; i < val.size(); i++) {
            vals[i] = val.getInt(i);
        }
        view.setBarColor(vals);
    }
    @ReactProp(name = "BarWidth", defaultInt = 0)
    public void setBarWidth(CirclesView view, int val) {
        view.setBarWidth(val);
    }
    @ReactProp(name = "BlockCount", defaultInt = 0)
    public void setBlockCount(CirclesView view, int val) {
        view.setBlockCount(val);
    }
    @ReactProp(name = "BlockScale", defaultFloat = 0)
    public void setBlockScale(CirclesView view, float val) {
        view.setBlockScale(val);
    }
    @ReactProp(name = "ContourColor", defaultInt = 0)
    public void setContourColor(CirclesView view, int val) {
        view.setContourColor(val);
    }
    @ReactProp(name = "ContourSize", defaultFloat = 0)
    public void setContourSize(CirclesView view, float val) {
        view.setContourSize(val);
    }
    @ReactProp(name = "DelayMillis", defaultInt = 0)
    public void setDelayMillis(CirclesView view, int val) {
        view.setDelayMillis(val);
    }
    @ReactProp(name = "FillColor", defaultInt = 0)
    public void setFillColor(CirclesView view, int val) {
        view.setFillCircleColor(val);
    }
    @ReactProp(name = "MaxValue", defaultFloat = 0)
    public void setMaxValue(CirclesView view, float val) {
        view.setMaxValue(val);
    }
    @ReactProp(name = "RimColor", defaultInt = 0)
    public void setRimColor(CirclesView view, int val) {
        view.setRimColor(val);
    }
    @ReactProp(name = "RimWidth", defaultInt = 0)
    public void setRimWidth(CirclesView view, int val) {
        view.setRimWidth(val);
    }
    @ReactProp(name = "SpinSpeed", defaultFloat = 0)
    public void setSpinSpeed(CirclesView view, float val) {
        view.setSpinSpeed(val);
    }
    @ReactProp(name = "StartAngle", defaultInt = 0)
    public void setStartAngle(CirclesView view, int val) {
        view.setStartAngle(val);
    }
    @ReactProp(name = "TextScale", defaultFloat = 0)
    public void setTextScale(CirclesView view, float val) {
        view.setTextScale(val);
    }
    @ReactProp(name = "TextSize", defaultInt = 0)
    public void setTextSize(CirclesView view, int val) {
        view.setTextSize(val);
    }
    @ReactProp(name = "Unit")
    public void setUnit(CirclesView view, String val) {
        view.setUnit(val);
    }
    @ReactProp(name = "UnitScale", defaultFloat = 0)
    public void setUnitScale(CirclesView view, float val) {
        view.setUnitScale(val);
    }
    @ReactProp(name = "UnitSize", defaultInt = 0)
    public void setUnitSize(CirclesView view, int val) {
        view.setUnitSize(val);
    }

/*android.graphics.Paint.Cap                              public void setBarStrokeCap(CirclesView view, )
android.graphics.Shader                             public void setRimShader(CirclesView view, )
android.graphics.Paint.Cap                              public void setSpinnerStrokeCap(CirclesView view, )*/

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
            CirclesView viewPager,
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

