package com.ap2cu.mobile.android.weightwatchers.calculator;

import android.app.Activity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;

public abstract class AbstractScreen extends Activity implements View.OnClickListener, View.OnFocusChangeListener, CompoundButton.OnCheckedChangeListener {

  protected double getDouble(EditText editText) {
    try {
      return Double.parseDouble(editText.getText().toString());
    }
    catch (Exception e) {
      return 0;
    }
  }
  
  protected int getInt(EditText editText) {
    try {
      return Integer.parseInt(editText.getText().toString());
    }
    catch (Exception e) {
      return 0;
    }
  }
    
  protected double round(double points, boolean integerValue) {
    return (integerValue ? (int)Math.round(points) : (double)Math.round(100 * points) / 100);
  }
  
  protected abstract void calculate();
  
  @Override
  public void onClick(View v) {
    calculate();
  }

  @Override
  public void onFocusChange(View v, boolean hasFocus) {
    if(!hasFocus)
      calculate();    
  }

  @Override
  public void onCheckedChanged(CompoundButton b, boolean checked) {
    calculate();    
  }
}
