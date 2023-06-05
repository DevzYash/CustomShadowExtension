package com.yash.shadowlayoyt.customshadow;



import android.content.Context;

import android.view.View;
import android.view.ViewGroup;

import android.widget.RelativeLayout;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.skyfishjy.library.RippleBackground;

import static android.widget.RelativeLayout.CENTER_IN_PARENT;


public class Customshadow extends AndroidNonvisibleComponent {
public  Context context;
public RippleBackground rippleBackground;
  public Customshadow(ComponentContainer container) {
    super(container.$form());
    context = container.$context();
  }

  @SimpleFunction(description = "Returns the sum of the given list of integers.")
  public void initialize(AndroidViewComponent parent ,AndroidViewComponent view,int ripple_color,float ripple_strokeWidth,float ripple_radius) {
    ViewGroup viewGroup = (ViewGroup) parent.getView();
    View myview = view.getView();

    rippleBackground = new RippleBackground(context);
    rippleBackground.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
    viewGroup.addView(rippleBackground);
    viewGroup.invalidate();

    rippleBackground.init(context,ripple_color,ripple_strokeWidth,ripple_radius);
    ViewGroup main = (ViewGroup) myview.getParent();
    main.removeView(myview);
    rippleBackground.addView(myview);


    RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) myview.getLayoutParams();
    lp.addRule(CENTER_IN_PARENT);
    rippleBackground.invalidate();

  }

  @SimpleFunction(description = "Returns the sum of the given list of integers.")
  public void start() {
    rippleBackground.startRippleAnimation();
  }
  @SimpleFunction(description = "Returns the sum of the given list of integers.")
  public void stop() {
    rippleBackground.stopRippleAnimation();
  }



}
