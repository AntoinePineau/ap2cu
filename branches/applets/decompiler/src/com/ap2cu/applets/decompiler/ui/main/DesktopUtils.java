package com.ap2cu.applets.decompiler.ui.main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class DesktopUtils {

  public static boolean openFile(final File file) {
    if (!Desktop.isDesktopSupported()) {
      System.err.println("Desktop not supported");
      return false;
    }

    Desktop desktop = Desktop.getDesktop();
    if (!desktop.isSupported(Desktop.Action.OPEN)) {
      System.err.println("open not supported");
      return false;
    }

    try {
      desktop.open(file);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }
  
  
}
