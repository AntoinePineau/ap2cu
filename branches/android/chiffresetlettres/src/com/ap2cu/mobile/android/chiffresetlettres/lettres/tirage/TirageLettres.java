package com.ap2cu.mobile.android.chiffresetlettres.lettres.tirage;

import com.ap2cu.mobile.android.chiffresetlettres.common.Solution;
import com.ap2cu.mobile.android.chiffresetlettres.common.Tirage;
import com.ap2cu.mobile.android.chiffresetlettres.exception.DictionnaireException;
import com.ap2cu.mobile.android.chiffresetlettres.exception.SolutionIncorrecteException;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.dico.CalculDuMotLePlusLong;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.dico.Dictionnaire;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.regles.ListeDeMots;
import com.ap2cu.mobile.android.chiffresetlettres.lettres.solution.SolutionLettres;

public class TirageLettres extends Tirage {

  // ==================================================
  // A T T R I B U T S
  // ==================================================

  private String lettres;

  private Dictionnaire dico;
  
  // ==================================================
  // C O N S T R U C T E U R
  // ==================================================

  public TirageLettres(String s) throws DictionnaireException {
    lettres = s;
    dico = Dictionnaire.getDictionnaire();
  }

  // ==================================================
  // M E T H O D E S
  // ==================================================

  public String getLettres() {
    return lettres;
  }

  public ListeDeMots trouverTousLesMots() {
    CalculDuMotLePlusLong motLePlusLong = new CalculDuMotLePlusLong(lettres, dico);
    return motLePlusLong.trouverMots();
  }

  @Override
  public Solution donnerSolution() {
    if(dico == null)
      return null;
    CalculDuMotLePlusLong motLePlusLong = new CalculDuMotLePlusLong(lettres, dico);
    return motLePlusLong.trouverSolutions().get(0);
  }

  @Override
  public void verifierSolutionProposee(Solution solution) throws SolutionIncorrecteException {
    String mot = ((SolutionLettres) solution).getMot().toUpperCase();

    // v�rifier qu'on a pris les lettres autoris�es
    for (char c : mot.toCharArray()) {
      if (!lettres.contains(c + ""))
        throw new SolutionIncorrecteException("La lettre " + c + " ne fait pas partie du tirage");
    }

    // v�rifier que le mot existe bien dans le dictionnaire
    if(!dico.existe(mot))
      throw new SolutionIncorrecteException("Le mot "+mot+" n'existe pas dans le dictionnaire");
  }

  public void ajouterLettre(char lettre) {
    lettres = lettres + lettre;
  }

  public String toString() {
    return lettres;
  }
}
