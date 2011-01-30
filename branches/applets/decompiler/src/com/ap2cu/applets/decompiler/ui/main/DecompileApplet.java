package com.ap2cu.applets.decompiler.ui.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;

import com.ap2cu.applets.decompiler.config.Configuration;
import com.ap2cu.applets.decompiler.main.ConsoleLauncher;
import com.ap2cu.applets.decompiler.util.FileUtils;


public class DecompileApplet extends JApplet implements WindowListener, FileDrop.Listener {

  private static final long serialVersionUID = 5411840194196757472L;

  static {
    try {
      javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
    }
    catch (Exception e) {
    }
  }

  private JPanel rootPanel = null;
  private BorderLayout rootLayout = null;

  private static JEditorPane logArea = new JEditorPane();

  final JTextField jarFileField = new JTextField(60);

  public static final int PREFERRED_WIN_WIDTH = 600;
  public static final int PREFERRED_WIN_HEIGHT = 250;

  public DecompileApplet() {
    Dimension size = new Dimension(PREFERRED_WIN_WIDTH, PREFERRED_WIN_HEIGHT);
    setSize(size);
    setMinimumSize(size);
    new FileDrop(this, this);
    render();
  }

  @Override
  public void paint(Graphics g) {
    // TODO Auto-generated method stub
    super.paint(g);
  }

  private void buildInterface() {
    buildRootPanel();
    buildCenterWidgets();
    getContentPane().add(rootPanel);
  }

  private void buildRootPanel() {
    rootPanel = new JPanel();
    rootLayout = new BorderLayout();
    rootPanel.setLayout(rootLayout);
  }

  private static JLabel buildLabel(String text, int n) {
    return new JLabel("<html><h" + n + ">" + text + "</h" + n + "></html>");
  }

  private ScrollPane buildLogPanel() {
    ScrollPane logPanel = new ScrollPane();
    logArea.setEditable(false);
    new FileDrop(logArea, this);
    logPanel.add(logArea);
    return logPanel;
  }

  private void buildCenterWidgets() {
    JPanel centerWidgetPanel = new JPanel();
    BorderLayout centerLayout = new BorderLayout();
    centerWidgetPanel.setLayout(centerLayout);

    centerWidgetPanel.add(buildBrowseBoxPanel(), BorderLayout.NORTH);
    centerWidgetPanel.add(buildLauncherPanel(), BorderLayout.CENTER);

    rootPanel.add(centerWidgetPanel, BorderLayout.CENTER);
  }

  public void action(String path, int index) {
    appendToLog("Unjaring " + path);
    File zip = decompileJar(path, index);
    if (zip != null) {
      appendToLog("Opening " + path);
      DesktopUtils.openFile(zip);
    }
  }

  public void filesDropped(final File[] files) {
    for (int i = 0; i < files.length; i++) {
      final File f = files[i];
      final int index = i;
      Thread t = new Thread(new Runnable() {
        public void run() {
          String path = f.getAbsolutePath();
          action(path, index);
        }
      });
      t.start();
    }
  }

  public static File sourceZipFile;

  public static File decompileJar(final String jarFile, int i) {
    String id = System.currentTimeMillis() + "" + i;
    File sourceZipFile = new File(jarFile.replaceAll("^(.*)\\.jar$", "$1_src.zip"));
    String bin = "bin" + id;
    String src = "src" + id;

    File binFolder = new File(bin);
    File srcFolder = new File(src);

    if (!binFolder.exists())
      binFolder.mkdirs();
    if (!srcFolder.exists())
      srcFolder.mkdirs();

    Configuration.setFileExtension("java");
    Configuration.setSkipClassVersionCheck("true");
    Configuration.setTempDir(bin);
    Configuration.setBkpoppath(src);
    Configuration.setLogMode("log");
    ConsoleLauncher.decompileJarAndZip(jarFile, sourceZipFile.getAbsolutePath());
    FileUtils.deleteFile(binFolder);
    FileUtils.deleteFile(srcFolder);
    return sourceZipFile;
  }

  private JPanel buildLauncherPanel() {
    JPanel launchPanel = new JPanel(new BorderLayout());
    launchPanel.add(buildLogPanel(), BorderLayout.CENTER);
    return launchPanel;
  }

  private JPanel buildBrowseBoxPanel() {
    JPanel browsePanel = new JPanel();
    browsePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    jarFileField.getDocument().addDocumentListener(new DocumentListener() {
      private void updated(DocumentEvent e) {
        try {
          final String file = e.getDocument().getText(0, e.getDocument().getLength()).toString();
          if (file == null || !file.matches("^.*\\.jar$"))
            appendToLog("ERROR: file is not a .jar");
          else
            new Thread(new Runnable() {
              public void run() {
                action(file, 0);
              }
            }).start();
        }
        catch (Exception ex) {
          ex.printStackTrace();
        }
      }

      public void removeUpdate(DocumentEvent e) {
        updated(e);
      }

      public void insertUpdate(DocumentEvent e) {
        updated(e);
      }

      public void changedUpdate(DocumentEvent e) {
        updated(e);
      }
    });
    JButton browseButton = new JButton("Browse");
    new FileDrop(jarFileField, this);
    browseButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        final File f = new File(jarFileField.getText());
        fc.setCurrentDirectory(f);
        JarFilter sf = new JarFilter("Java Archive (.jar)", "jar");
        fc.addChoosableFileFilter(sf);
        int returnVal = fc.showOpenDialog(DecompileApplet.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
          String selectedFileName = fc.getSelectedFile().getAbsolutePath();
          jarFileField.setText(selectedFileName);
          // decompileJar(selectedFileName, 0);
        }
      }
    });

    browsePanel.add(jarFileField);
    browsePanel.add(browseButton);

    return browsePanel;
  }

  public void render() {
    this.buildInterface();
    this.setVisible(true);
  }

  public static void appendToLog(String toDisplay) {
    if (logArea != null) {
      String text = toDisplay + "\n" + logArea.getText();
      logArea.setText(text);
    }
  }

  public void windowClosed(WindowEvent e) {
  }

  public void windowActivated(WindowEvent e) {
  }

  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }

  public void windowDeactivated(WindowEvent e) {
  }

  public void windowDeiconified(WindowEvent e) {
  }

  public void windowIconified(WindowEvent e) {
  }

  public void windowOpened(WindowEvent e) {
  }

  class JarFilter extends FileFilter {

    private String description;
    private String extension;

    public JarFilter(String description, String extension) {
      this.description = description;
      this.extension = extension;
    }

    public boolean accept(File file) {
      if (file.isDirectory()) {
        return false;
      }
      String fileName = file.getName().toLowerCase();

      return fileName.endsWith(extension);
    }

    public String getDescription() {
      return description;
    }
  }
}
