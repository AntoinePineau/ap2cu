package com.ap2cu.applets.decompiler.commonutil;

import com.ap2cu.applets.decompiler.config.VariableConfigurationResolver;


/***
 * 
 * @author sbelur
 *
 */

/***
 * This class should be used to init all the basic tasks
 * for jdec to work properly. 
 * 
 * TODO: Move all launch tasks like config calls
 * validation calls over here.
 */
public class StartupHelper {

	
	public StartupHelper(){
		
	}
	
	public  void start(){
		
		new VariableConfigurationResolver("variables.xml").read();
	}
	
	
}

