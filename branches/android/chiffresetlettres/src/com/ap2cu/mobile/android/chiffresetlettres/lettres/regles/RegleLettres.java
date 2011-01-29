package com.ap2cu.mobile.android.chiffresetlettres.lettres.regles;

import java.lang.reflect.Field;

import android.content.Context;

import com.ap2cu.mobile.android.chiffresetlettres.R;
import com.ap2cu.mobile.android.chiffresetlettres.common.Points;
import com.ap2cu.mobile.android.chiffresetlettres.common.Regle;
import com.ap2cu.mobile.android.chiffresetlettres.common.Solution;
import com.ap2cu.mobile.android.chiffresetlettres.common.Tirage;
import com.ap2cu.mobile.android.chiffresetlettres.exception.DictionnaireException;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.solution.SolutionLettres;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.tirage.TirageLettres;

public class RegleLettres extends Regle {

  protected final static String VOYELLE = "voyelle";
  protected final static String CONSONNE = "consonne";
  protected ListeDeLettres consonnesDisponibles;
  protected ListeDeLettres voyellesDisponibles;
  protected int nombreDeLettres;
  protected int nombreDePointsParLettres;
  protected static TirageLettres tirageLettres;
  protected static RegleLettres regleLettres;
  
  public static RegleLettres getRegles(Context context) {
    if(regleLettres==null)
      regleLettres = new RegleLettres(context);
    return regleLettres;
  }
  
  protected RegleLettres(Context context) {
    super(context);
  }
  

  public TirageLettres genererTirage() throws DictionnaireException {
    if (tirageLettres != null) {
      for (char c : tirageLettres.getLettres().toUpperCase().toCharArray())
        if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'Y') {
          voyellesDisponibles.ajouterLettre(c);
        }
        else {
          consonnesDisponibles.ajouterLettre(c);
        }
    }
    String s = "";
    for (int i = 0; i < nombreDeLettres;) {
      s += consonnesDisponibles.getLettre(Tirage.random.nextInt(consonnesDisponibles.size()));
      i++;
      if (i < nombreDeLettres) {
        s += voyellesDisponibles.getLettre(Tirage.random.nextInt(voyellesDisponibles.size()));
        i++;
      }
    }
    tirageLettres = new TirageLettres(s);
    return tirageLettres;
  }

  @Override
  public Points attribuerNombreDePoints(Solution solution, Tirage tirage) {
    try {
      if (solution == null || solution.estVide())
        return new Points(0, "Vous n'avez rien proposé");
      tirage.verifierSolutionProposee(solution);
      int nombreDeLettres = ((SolutionLettres) solution).getMot().length();
      return new Points(nombreDePointsParLettres * nombreDeLettres, "Mot de " + nombreDeLettres + " lettres");
    }
    catch (Exception e) {
      return new Points(0, e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  @Override
  protected void chargerDonneesInitiales(Context context) /*throws ConfigurationException*/ {
    this.nombreDeLettres = 9;
    this.nombreDePointsParLettres = Integer.parseInt(context.getString(R.string.nb_points_par_lettre));
    this.consonnesDisponibles = new ListeDeLettres();
    this.voyellesDisponibles = new ListeDeLettres();
    char[] letters = new char[26];
    for (int i = 0; i < letters.length; i++) {
      letters[i] = (char) (65 + i);
      Class c = R.string.class;
      try {
        Field f = c.getField("nb_" + letters[i]);
        int nombreMaximumDOccurences = Integer.parseInt(context.getString(f.getInt(null)));
        if (letters[i] == 'A' || letters[i] == 'E' || letters[i] == 'I' || letters[i] == 'O' || letters[i] == 'U' || letters[i] == 'Y') {
          for (int j = 0; j < nombreMaximumDOccurences; j++)
            voyellesDisponibles.ajouterLettre(letters[i]);
        }
        else {
          for (int j = 0; j < nombreMaximumDOccurences; j++)
            consonnesDisponibles.ajouterLettre(letters[i]);
        }
      }
      catch (Exception e) {
        e.printStackTrace();
        continue;
      }
    }
  }
}
