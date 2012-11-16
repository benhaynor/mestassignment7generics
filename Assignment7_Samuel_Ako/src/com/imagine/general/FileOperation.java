package com.imagine.general;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileOperation {
	
	
/**
 * @name		selectFileDialog
 * @params		folderPath - the full path to the folder containing the files
 * @return		a FileWrap object containing the read file and it's state
 * @about		lists all the files in a given folder and lets the user select
 */
	public static FileWrap selectFileDialog (String folderPath) {
		int index = 1;
		File folder = new File (folderPath);
		String[] files = folder.list();
		
		try {
			if (files.length < 1) {
				return new FileWrap (null, 0);
			}
		} catch (Exception e) {
			System.out.println("Folder is empty");
			shutdown();
		}
		
		for (String file : files) {
			System.out.printf ("%d. %s %n", index++, file);
		}
		
		System.out.println();
		int choice = (Integer) Interact.getInput("Please Select File", "int");
		
		if (choice>=1 & choice<=files.length) {
			System.out.println("Selected : "+ files[choice-1]);
			return new FileWrap (new File (files[choice-1]), 1);
		}
		else {
			System.out.println("Invalid choice, Please try again");
			return new FileWrap(null, -1);
		}
	}//--end method listFileMenu

	
/**
 * @name		read
 * @params		file - the file to be read
 * @return		a string array with each index containing a line from file
 * @about		reads data from a given file into memory
 */
	public static String[] read(String file) {
		String line = "";
		ArrayList<String> array = new ArrayList<>();
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(new File(file));
		} catch (IOException ioe) {
			System.out.println("File Not Found! "+ ioe.toString());
		}

		while (fileScan.hasNextLine()) {
			line = fileScan.nextLine();
			array.add(line);
		}
		fileScan.close();
		String[] returnArray = new String[array.size()];
		for (int i=0; i<returnArray.length; i++) {
			returnArray[i] = array.get(i);
		}
		return returnArray;
	}// end method read

	
/**
 * @name		write
 * @params		array - string values to be written to file
 * @return		method is void
 * @about		writes the contents of an array to a given file
 */
	public static void write(String[] array, String file) {

		PrintWriter writeToFile = null;

		try {
			writeToFile = new PrintWriter(new FileWriter(new File(file)));
		} catch (IOException ioe) {
			System.out.println("Error Accesing File " + ioe.toString());
		}

		for (String str : array) {
			writeToFile.println(str);
		}

		writeToFile.close();
	}// end method write
	
	
/**
 * @name    : shutdown
 * @params  : None
 * @return  : Method is void
 * @about   : This method displays a fun animation
 */
	    public static void shutdown() {
	    	String s1 = "Shutting Down";
	    	String s2 = "Bye";
	        System.out.print(s1);
	        for (int i = 0; i < 7; i++) {
	            for (long j = 0; j < 99; j++) {
	                for (long k = 0; k < 9999999; k++) {
	                }
	            }
	            System.out.print(".");
	        }
	        System.out.println(s2+ "\n");
	        System.exit(0);
	    }//--end method shutdown
}
