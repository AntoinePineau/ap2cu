package com.ap2cu.mobile.android.weightwatchers.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityScreen extends AbstractScreen implements OnItemSelectedListener {

  private static final String TAG = "Activity";
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity);
    Log.v(TAG, "Creating Activity activity");
    
    final EditText wField = (EditText) findViewById(R.id.wField);
    final EditText dField = (EditText) findViewById(R.id.dField);
    final Spinner iSpinner = (Spinner) findViewById(R.id.iSpinner);
    final CheckBox intField = (CheckBox) findViewById(R.id.intField);
    
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.intensity, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    
    wField.setOnFocusChangeListener(this);
    dField.setOnFocusChangeListener(this);
    iSpinner.setOnItemSelectedListener(this);
    iSpinner.setAdapter(adapter);
    intField.setOnCheckedChangeListener(this);
  }
  
  private double calculateLostPoints(double weight, int minutes, int intensity, boolean integerValue) {
    double coeff = intensity == 0 ? 0.0007286 : (intensity == 1 ? 0.00101527 : 0.00254749);
    double points = weight * minutes * coeff;
    return round(points, integerValue);
  }
    
  public void calculate() {
    Log.v(TAG, "calculate");
    final EditText wField = (EditText) findViewById(R.id.wField);
    final EditText dField = (EditText) findViewById(R.id.dField);
    final Spinner iSpinner = (Spinner) findViewById(R.id.iSpinner);
    final CheckBox intField = (CheckBox) findViewById(R.id.intField);
    final TextView result = (TextView) findViewById(R.id.result);

    double w = getDouble(wField);
    int d = getInt(dField);
    int i = iSpinner.getSelectedItemPosition();

    result.setText("" + calculateLostPoints(w, d, i, intField.isChecked()));
  }

  @Override
  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    calculate();
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {
  }
  
}
