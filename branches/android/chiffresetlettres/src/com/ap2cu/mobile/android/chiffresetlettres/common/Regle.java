package com.ap2cu.mobile.android.chiffresetlettres.common;

import android.content.Context;

import com.ap2cu.mobile.android.chiffresetlettres.exception.SolutionIncorrecteException;

public abstract class Regle {

//  protected Element configuration;
  
  protected Regle(Context context) /*throws ConfigurationException*/ {
//    try {
//      configuration = new SAXReader().read(url).getRootElement();
      
      chargerDonneesInitiales(context); 
//    }
//    catch(Exception e) {
//      System.out.println(e.getMessage());
//      throw new ConfigurationException("Erreur pendant le chargement des regles "+url, e);
//    }
  }
  
  protected abstract void chargerDonneesInitiales(Context context) /*throws ConfigurationException*/;
  
  public abstract Points attribuerNombreDePoints(Solution solution, Tirage tirage) throws SolutionIncorrecteException;
  
}
