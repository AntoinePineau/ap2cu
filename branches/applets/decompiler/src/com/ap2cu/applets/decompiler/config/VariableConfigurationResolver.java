package com.ap2cu.applets.decompiler.config;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.ap2cu.applets.decompiler.settings.SettingsStore;
import com.ap2cu.applets.decompiler.settings.Variable;
import com.ap2cu.applets.decompiler.settings.VariableSettings;

/*
 *  VariableConfigurationResolver.java Copyright (c) 2006,07 Swaroop Belur 
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

/**
 * Responsible for reading options(from an xml file) related to variables which
 * will be applied when class was not compiled with -g option.
 * 
 * Information to parse - Type , Name Prefix
 * 
 * Once parsed, the application code should access from VariableSettings class.
 * 
 * @author swaroop belur
 * @since 1.2.1
 */

public class VariableConfigurationResolver {

	private String xmlFileToParse;
	
	VariableSettings settings = SettingsStore.getVariablesettings();

	public VariableConfigurationResolver(String xmlFile) {
		xmlFileToParse = xmlFile;

	}

	public void read() {

		try {
			ConfigurerHandler handler = new ConfigurerHandler();
			handler.processXmlFile();
		} catch (Exception exp) {

		}

	}

	private class ConfigurerHandler extends DefaultHandler {

		private ConfigurerHandler() {
			super();
		}

		public String processXmlFile() {

			try {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				XMLReader parser = null;
				SAXParser saxParser = factory.newSAXParser();
				parser = saxParser.getXMLReader();
				parser.setContentHandler(this);
				parser.setErrorHandler(this);
				parser.parse(new InputSource(new FileInputStream(new File(xmlFileToParse))));

			} catch (Exception e) {
				e.printStackTrace();
			}

			return null;

		}

		public void startElement(String uri, String local, String raw,
				final Attributes attrs) {

			if (raw != null && raw.equals("variable")) {
				int index = attrs.getIndex("default_pkg");
				String defaultval = attrs.getValue(index);
				
				index = attrs.getIndex("pkg");
				String  pkg = attrs.getValue(index);
				
				index = attrs.getIndex("className");
				String  classname = attrs.getValue(index);
				
				index = attrs.getIndex("prefix");
				String  prefix = attrs.getValue(index);
				
				index = attrs.getIndex("primitive");
				String  prim = attrs.getValue(index);
				
				Variable var = new Variable();
				var.setClassName(classname);
				var.setPkg(pkg);
				var.setPrefix(prefix);
				var.setDefaultPackage(defaultval);
				var.setIsPrimitive(prim);
				settings.addVariable(var);
				
				
			}

		}

	}

	/*public static void main(String[] args) {
		new VariableConfigurationResolver("c:\\variables.xml").read();
	}*/
}