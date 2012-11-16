/*
 * 
 */
package com.imagine.general;

import java.io.File;

/**
 * The Class FileWrap.
 */
public class FileWrap {
	
//Global Vars
	/** state =  0  --> file is as yet unset - do not access file
	 *  state =  1  --> file is set and can be used
	 *  state = -1  --> error occured, do not access file field.
	 */
	private int state = 0;
	private File file = null;
	

	//constructor
	public FileWrap (File f, int state) {
		this.state = state;
		this.file = f;
	}//--end constructor
	
	
	/**
	 * @name		 getFile
	 * @about		 returns the file object
	 * @param 		 none
	 * @return		 file - the file object 
	 */
	public File getFile () {
		return this.file;
	}//--end method getFile
	
	/**
	 * @name		 getFilename
	 * @about		 returns the filename of the file object
	 * @param 		 none
	 * @return		 String filename - the name of the fileobject
	 */
	public String getFilename () {
		return this.file.getName();
	}//--end method getFilename
	
	/**
	 * @name		 getState
	 * @about		 returns the state of the file object
	 * @param 		 none
	 * @return		 int state - the state of the file
	 */
	public int getState () {
		return this.state;
	}//--end method getState
}
