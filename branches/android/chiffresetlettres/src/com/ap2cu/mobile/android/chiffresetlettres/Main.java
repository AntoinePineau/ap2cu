package com.ap2cu.mobile.android.chiffresetlettres;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TableRow;
import android.widget.TextView;

import com.ap2cu.mobile.android.chiffresetlettres.exception.DictionnaireException;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.regles.RegleLettres;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.tirage.TirageLettres;

public class Main extends Activity {

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    Button chiffresButton = (Button) findViewById(R.id.chiffres);
    chiffresButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.exit(0);
        // TODO
      }
    });

    final Button lettresButton = (Button) findViewById(R.id.lettres);
    lettresButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        try {
          final TableRow row1 = (TableRow) findViewById(R.id.TableRow01);
          final TableRow row2 = (TableRow) findViewById(R.id.TableRow02);
          final Context context = row1.getContext();
          RegleLettres regles = RegleLettres.getRegles(context); 
          final TirageLettres tirage = regles.genererTirage();
          String lettres = tirage.getLettres();
          for(int i=0;i<lettres.length();i++) {
            String c = lettres.substring(i, i+1);
            Button b = new Button(context);
            b.setText(c);
            b.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                TextView t = new TextView(context);
                t.setText(tirage.donnerSolution().toString());
                row2.addView(t, LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
              }
            });
            row1.addView(b, v.getWidth()/lettres.length(), LayoutParams.WRAP_CONTENT);
            setContentView(R.layout.lettres);
          }
        }
        catch(DictionnaireException e) {
          Log.e("LCELL", "An error occurred while trying to get the dictionary"+e.getMessage());
        }
      }
    });
  }
}
