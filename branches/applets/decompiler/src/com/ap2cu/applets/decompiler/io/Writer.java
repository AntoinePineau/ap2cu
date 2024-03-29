
/*
 *  Writer.java Copyright (c) 2006,07 Swaroop Belur
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */

package com.ap2cu.applets.decompiler.io;

import java.io.*;

import com.ap2cu.applets.decompiler.config.Configuration;
import com.ap2cu.applets.decompiler.exceptions.ApplicationException;
import com.ap2cu.applets.decompiler.main.ConsoleLauncher;
import com.ap2cu.applets.decompiler.ui.main.UILauncher;
import com.ap2cu.applets.decompiler.util.AllExceptionHandler;


public abstract class Writer extends java.io.PrintWriter{
    
     public Writer() {
        super(new PrintWriter(new BufferedOutputStream(System.out)));
    }
    
    /**
     * @param arg0
     */
    public Writer(java.io.Writer writer) {
        super(writer);
        
    }

    protected static OutputStreamWriter osw=null;
    protected static FileOutputStream fos=null;
    protected static BufferedOutputStream bos = null;
    protected static OutputFileWriter ofw = null;
    
    protected static java.io.Writer logwriter=null;
    
    
    
    public static java.io.Writer getUIConsoleWriter() throws IOException {
        
        return UIConsoleWriter.getInstance();
        
        
    }
    
    public static  com.ap2cu.applets.decompiler.io.Writer getWriter(java.lang.String type) throws IOException {
        if(type.equalsIgnoreCase("log")) {
            return getLogWriter();
        } else if(type.equalsIgnoreCase("output")) {
            return getOutputWriter();
        } else
            throw new ApplicationException("Invalid type passed to getWriter Method of getWriter in Writer Class...");
        
    }
    
    
    private static  com.ap2cu.applets.decompiler.io.Writer getOutputWriter() throws IOException {
        if(Configuration.getOutputMode().equalsIgnoreCase("file")) {
            if(Configuration.getDecompileroption().equals("dc") || Configuration.getDecompileroption().equals("jar")) {
                String classpath= Configuration.getClassPath();
                String className="";
                int dot=classpath.lastIndexOf(".");
                int start=dot-1;
                if(dot!=-1) {
                    boolean ok=false;
                    while(start >= 0) {
                        char ch=classpath.charAt(start);
                        if(ch=='\\' || ch=='/') {
                            ok=true;
                            break;
                        }
                        start--;
                        
                    }
                    if(ok) {
                        
                        className=classpath.substring(start+1);
                        dot=className.lastIndexOf(".");
                        if(dot!=-1)className=className.substring(0,dot).concat("."+ Configuration.getFileExtension());
                    }
                    
                }
                
                
                //ConsoleLauncher.setResultFilePath(Configuration.getOutputFolderPath()+File.separator+className);
                return com.ap2cu.applets.decompiler.io.FileWriter.getFileWriter(Configuration.getOutputFolderPath()+File.separator+className,"output");
            } else if(Configuration.getDecompileroption().equals("vcp")) {
                String classpath= Configuration.getClassPath();
                String className="";
                
                int dot=classpath.lastIndexOf(".");
                int start=dot-1;
                if(dot!=-1) {
                    boolean ok=false;
                    while(start >= 0) {
                        char ch=classpath.charAt(start);
                        if(ch=='\\' || ch=='/') {
                            ok=true;
                            break;
                        }
                        start--;
                        
                    }
                    if(ok) {
                        
                        className=classpath.substring(start+1);
                        dot=className.lastIndexOf(".");
                        if(dot!=-1)className=className.substring(0,dot).concat("."+ Configuration.getFileExtension());
                    }
                    
                }
                
                
                
                String s= Configuration.getOutputFolderPath()+File.separator+className;//File.createTempFile("cpool",".txt").getAbsolutePath();
                
                if(UILauncher.getUIutil()!=null)
                    UILauncher.getUIutil().setConstantPoolResultFile(s);
                ConsoleLauncher.setResultFilePath(Configuration.getOutputFolderPath()+File.separator+className);
                return com.ap2cu.applets.decompiler.io.FileWriter.getFileWriter(s,"output");
            } else if(Configuration.getDecompileroption().equals("dis")) {
                String classpath= Configuration.getClassPath();
                String disClass="";
                int dot=classpath.lastIndexOf(".");
                int start=dot-1;
                if(dot!=-1) {
                    boolean ok=false;
                    while(start >= 0) {
                        char ch=classpath.charAt(start);
                        if(ch=='\\' || ch=='/') {
                            ok=true;
                            break;
                        }
                        start--;
                        
                    }
                    if(ok) {
                        
                        disClass=classpath.substring(start+1);
                        dot=disClass.lastIndexOf(".");
                        if(dot!=-1)disClass=disClass.substring(0,dot).concat("."+ Configuration.getFileExtension());
                    }
                    
                }
                
                
                ConsoleLauncher.setResultFilePath(Configuration.getOutputFolderPath()+File.separator+disClass);
                return com.ap2cu.applets.decompiler.io.FileWriter.getFileWriter(Configuration.getOutputFolderPath()+File.separator+disClass,"output");
            } else if(Configuration.getDecompileroption().equals("nocode")) {
                String classpath= Configuration.getClassPath();
                String className="";
                int dot=classpath.lastIndexOf(".");
                int start=dot-1;
                if(dot!=-1) {
                    boolean ok=false;
                    while(start >= 0) {
                        char ch=classpath.charAt(start);
                        if(ch=='\\' || ch=='/') {
                            ok=true;
                            break;
                        }
                        start--;
                        
                    }
                    if(ok) {
                        
                        className=classpath.substring(start+1);
                        dot=className.lastIndexOf(".");
                        if(dot!=-1)className=className.substring(0,dot).concat("."+ Configuration.getFileExtension());
                    }
                    
                }
                
                ConsoleLauncher.setResultFilePath(Configuration.getOutputFolderPath()+File.separator+className);
                return com.ap2cu.applets.decompiler.io.FileWriter.getFileWriter(Configuration.getOutputFolderPath()+File.separator+className,"output");
            } else if(Configuration.getDecompileroption().equals("llv")) {
                String classpath= Configuration.getClassPath();
                String className="";
                int dot=classpath.lastIndexOf(".");
                int start=dot-1;
                if(dot!=-1) {
                    boolean ok=false;
                    while(start >= 0) {
                        char ch=classpath.charAt(start);
                        if(ch=='\\' || ch=='/') {
                            ok=true;
                            break;
                        }
                        start--;
                        
                    }
                    if(ok) {
                        
                        className=classpath.substring(start+1);
                        dot=className.lastIndexOf(".");
                        if(dot!=-1)className=className.substring(0,dot).concat("."+ Configuration.getFileExtension());
                    }
                    
                }
                
                
                return com.ap2cu.applets.decompiler.io.FileWriter.getFileWriter(Configuration.getOutputFolderPath()+File.separator+className,"output");
            } else {
                java.lang.String error="Invalid Option provided during run....Please check The usage of this jdec....";
                error+="\nFor usage type help after option to the jdec....";
                throw new ApplicationException(error);
            }
            
        }
        //TODO HANDLE ZIP SIMILARLY AS FILEWRITER
        else if(Configuration.getOutputMode().equalsIgnoreCase("zip")) {
            return com.ap2cu.applets.decompiler.io.ZipWriter.getZipWriter(Configuration.getOutputFolderPath());
        }
          else if(Configuration.getOutputMode().equalsIgnoreCase("memory")) {
            return com.ap2cu.applets.decompiler.io.ZipWriter.getZipWriter(Configuration.getOutputFolderPath());
        }
        else {
            return com.ap2cu.applets.decompiler.io.ConsoleWriter.getConsoleWriter("output");
        }
        
    }
    
    private static com.ap2cu.applets.decompiler.io.Writer getLogWriter() throws IOException {
        
        if(Configuration.getLogMode().equalsIgnoreCase("file")) {
            return FileWriter.getFileWriter(Configuration.getLogFilePath(),"log");
        }
        //TODO
        else {
            return com.ap2cu.applets.decompiler.io.ConsoleWriter.getConsoleWriter("log");
        }
        
    }
    
    
    public abstract void writeOutput(String data) throws IOException;
    
    public abstract void writeLog(String data) throws IOException;
    
    public abstract void writeLog(String data,String level) throws IOException;
    
    
    /***
     *
     * @param mode Can either be log or output
     * NOTE: In case some error is made in passing parameter no writer object is closed.
     * @return
     */
    
    
    public boolean close(java.lang.String mode) {
        try {
            if(mode.equalsIgnoreCase("log")) {
                this.logwriter.flush();
                this.logwriter=null;
            } else if(mode.equalsIgnoreCase("output")) {
              if(osw!=null) {
              this.osw.flush();
              this.osw.close();
              this.osw=null;
              }
              if(bos!=null) {
                this.bos.flush();
                this.bos.close();
                this.bos=null;
                }
                if(fos!=null) {
                this.fos.flush();
                this.fos.close();
                this.fos=null;
                }
              if(ofw!=null) {
              //this.ofw.flush();
              this.ofw.close();
              this.ofw=null;
              }
            } else {
                // Left Blank
            }
            return true;
            
        } catch(IOException ioe) {
            java.lang.String error="Error while Closing writer Object.\nThe writer was a "+mode+"writer Object";
            AllExceptionHandler handler=new AllExceptionHandler(new IOException(error));
            handler.reportException();
            return false;
            
        }
        
    }
}
