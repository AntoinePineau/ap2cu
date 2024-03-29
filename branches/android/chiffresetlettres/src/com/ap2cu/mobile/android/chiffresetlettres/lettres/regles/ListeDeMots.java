package com.ap2cu.mobile.android.chiffresetlettres.lettres.regles;

import java.util.Collections;
import java.util.Vector;

import com.ap2cu.mobile.android.chiffresetlettres.lettres.dico.ComparateurDeMots;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.dico.Ordre;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.solution.ListeDeSolutionsLettres;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.solution.SolutionLettres;

public class ListeDeMots extends Vector<String> {

  private static final long serialVersionUID = 1L;

  public void trier() {
    ComparateurDeMots comparateur = new ComparateurDeMots(Ordre.DESCENDANT);
    Collections.sort(this, comparateur);
  }

  public ListeDeMots recupererMotsAvecLeMaximumDeLettres() {
    ListeDeMots liste = new ListeDeMots();
    trier();
    if (size() == 0)
      return liste;
    int n = get(0).length();
    for (String s : this)
      if (s.length() < n)
        break;
      else
        liste.add(s);
    return liste;
  }

  public ListeDeMots recupererMotsDe_X_Lettres(int x) {
    ListeDeMots liste = new ListeDeMots();
    for (String s : this)
      if (s.length() == x)
        liste.add(s);
    return liste;
  }
  
  public ListeDeSolutionsLettres toListeDeSolutionLettres() {
    ListeDeSolutionsLettres l = new ListeDeSolutionsLettres();
    for (String s : this)
      l.add(new SolutionLettres(s));
    return l;
  }
}
