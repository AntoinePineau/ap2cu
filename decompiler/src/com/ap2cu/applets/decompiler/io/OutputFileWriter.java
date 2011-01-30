/*
 *  OutputFileWriter.java Copyright (c) 2006,07 Swaroop Belur
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


public class OutputFileWriter extends FileWriter {
    
    private static File file;
  
    private OutputFileWriter(java.io.Writer writer) {
        super(writer);
    }
    
    public static OutputFileWriter getOutputFileWriter(String path) throws IOException {
        if(osw==null) {
            fos= new FileOutputStream(file = new java.io.File(path));
            //opwriter = new PrintWriter(new BufferedWriter(new java.io.OutputStreamWriter(new java.io.BufferedOutputStream(fout),"UTF-8")));
            bos = new java.io.BufferedOutputStream(fos);
            osw = new java.io.OutputStreamWriter(bos,"UTF8");
            ofw=new OutputFileWriter(osw);
        }
        return ofw;
        
    }
    
    public File getFile() {
      return file;
    }
    
    public void writeOutput(String data) throws java.io.IOException {
        osw.write(data);
    }
    
    /**
     * Need to call This after calling writeOutput method of this class
     */
    public void flush() {
        try {
            osw.flush();
        } catch(IOException ioe) {
            
        }
    }
    
    /***
     * Dummy Method...Added for overriding purpose From Writer Class....
     * DO NOT USE
     *
     *
     */
    
    public final void writeLog(String data) throws IOException {
    	 throw new UnsupportedOperationException();
    }
    
    
    /**
     * NOTE:
     * This method Nullifies the Reference to the
     * encapsualating writer object...
     * Calling any write method using this Object reference will
     * throw a @see java.lang.NullPointerException ; even
     * though The reference to the OutputFileWriter Or the
     * FileWriter Object may not be null at that time.
     *
     */
    
    public void close() {
        try {
            if(osw!=null) {
                osw.flush();
                osw.close();
            }
            osw=null;
            if(fos!=null) {
              fos.flush();
              fos.close();
          }
            fos=null;
          if(bos!=null) {
            bos.flush();
            bos.close();
        }
          bos=null;
        } catch(IOException ioe) {
          ioe.printStackTrace();
        }
    }
    
    public void writeLog(String data,java.lang.String level) throws java.io.IOException {
        //java.lang.String logLevel=Configuration.getLogLevel();
        if(level.equals("2"))  // 2 is for more/extra output to log
        {					  // 1 is default
            logwriter.write(data);
        }
    }
    
}
