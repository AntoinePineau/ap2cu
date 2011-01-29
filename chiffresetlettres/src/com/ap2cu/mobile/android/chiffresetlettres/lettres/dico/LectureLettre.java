package com.ap2cu.mobile.android.chiffresetlettres.lettres.dico;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author PINEAU Antoine
 * @version 1.0
 */
public class LectureLettre {
    char dernierChar;
    boolean fin;
    InputStream inputStream;

  public LectureLettre(InputStream inputStream) throws IOException{
    this.inputStream = inputStream;
    dernierChar=(char)inputStream.read();
    fin=false;
  }


  public boolean getFin(){
    return fin;
  }

  public boolean lireCaractereCorrect()throws IOException{
    lireCaractere();

    if (dernierChar=='�' || dernierChar=='�' || dernierChar=='�') dernierChar='e';
    if (dernierChar=='�') dernierChar='a';
    if (dernierChar=='�') dernierChar='c';
    if (dernierChar=='�' || dernierChar=='�') dernierChar='u';
    if (dernierChar=='�' || dernierChar=='�') dernierChar='i';

    return ( ((dernierChar>='a') && (dernierChar<='z') ) ||((dernierChar>='A')&& (dernierChar<='Z'))
             || (dernierChar=='-'));
  }


  public char lireCaractere()throws IOException{
    char c=dernierChar;
    int i=inputStream.read();
    if ((i==-1)) fin=true;
    dernierChar=(char)i;
    return c;
  }

  public char voirCaractere()throws IOException{
    return dernierChar;
  }
}




