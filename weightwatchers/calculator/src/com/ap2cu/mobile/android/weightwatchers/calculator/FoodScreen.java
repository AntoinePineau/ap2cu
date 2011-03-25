package com.ap2cu.mobile.android.weightwatchers.calculator;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class FoodScreen extends AbstractScreen {

  private static final String TAG = "Activity";
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.food);
    Log.v(TAG, "Creating Food activity");

    final EditText pField = (EditText) findViewById(R.id.pField);
    final EditText lField = (EditText) findViewById(R.id.lField);
    final EditText fField = (EditText) findViewById(R.id.fField);
    final EditText gField = (EditText) findViewById(R.id.gField);
    final EditText bField = (EditText) findViewById(R.id.bField);
    final EditText qField = (EditText) findViewById(R.id.qField);
    final CheckBox intField = (CheckBox) findViewById(R.id.intField);
    
    pField.setOnFocusChangeListener(this);
    lField.setOnFocusChangeListener(this);
    fField.setOnFocusChangeListener(this);
    gField.setOnFocusChangeListener(this);
    bField.setOnFocusChangeListener(this);
    qField.setOnFocusChangeListener(this);
    intField.setOnCheckedChangeListener(this);
  }

  private double calculateTakenPoints(double p, double l, double f, double g, double b, double q, boolean integerValue) {
    double points = (p / 10.9375 + l / 3.888883 + f / 35.00049 + g / 9.2105535) * q / b;
    return round(points, integerValue);
  }
  
  public void calculate() {
    Log.d(TAG, "Calculating");
    final EditText pField = (EditText) findViewById(R.id.pField);
    final EditText lField = (EditText) findViewById(R.id.lField);
    final EditText fField = (EditText) findViewById(R.id.fField);
    final EditText gField = (EditText) findViewById(R.id.gField);
    final EditText bField = (EditText) findViewById(R.id.bField);
    final EditText qField = (EditText) findViewById(R.id.qField);
    final CheckBox intField = (CheckBox) findViewById(R.id.intField);
    final TextView result = (TextView) findViewById(R.id.result);

    double p = getDouble(pField);
    double l = getDouble(lField);
    double f = getDouble(fField);
    double g = getDouble(gField);
    double b = getDouble(bField);
    double q = getDouble(qField);

    result.setText("" + calculateTakenPoints(p, l, f, g, b, q, intField.isChecked()));
  }
  

}
