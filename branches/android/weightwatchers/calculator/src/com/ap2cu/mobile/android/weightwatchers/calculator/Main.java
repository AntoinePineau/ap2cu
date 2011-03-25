package com.ap2cu.mobile.android.weightwatchers.calculator;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends ListActivity implements OnItemClickListener {

  private static final String TAG = "Main";
  
  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.v(TAG, "Creating main activity");
    String[] menu = getResources().getStringArray(R.array.menu_array);
    setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, menu));
    ListView lv = getListView();
    lv.setItemsCanFocus(true);
    lv.setTextFilterEnabled(true);
    lv.setOnItemClickListener(this);
  }

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    try {
      Log.d(TAG, "Item click (position:"+position+")");
      if (position == 0) {
        Intent intent = new Intent(view.getContext(), FoodScreen.class);
        startActivity(intent);
        // finish();
      }
      else if (position == 1) {
        Intent intent = new Intent(view.getContext(), ActivityScreen.class);
        startActivity(intent);
        // finish();
      }
    }
    catch (Exception e) {
      Log.e(TAG, "An error occurred while clicking on Item", e);
      Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
    }
  }

}
