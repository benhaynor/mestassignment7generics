package com.imagine.general;

import java.util.Scanner;

public abstract class Interact {

	
/**
 * @name		 getInput
 * @about		 takes user inputs of all types	
 * @param 		 prompt - the question to display to user
 * @param 		 type - the data type of the input 
 * @return		 returns type Object, which should be cast to the appropriate type
 */
	public static Object getInput (String prompt, String type) {
        Scanner scan = new Scanner (System.in);
        System.out.print (prompt+ " : ");
        try {
            switch (type) {
                case "int":
                    if (scan.hasNextInt()) return scan.nextInt();
                    else                   return getInput ("Please Enter an integer","int");
                    
                case "double":
                case "float":
                    if (scan.hasNextDouble() | scan.hasNextFloat()) return scan.nextDouble();
                    else                                            return getInput ("Please Enter a double","double");
                    
                case "boolean":
                    if (scan.hasNextBoolean()) return scan.nextBoolean ();
                    else                       return getInput ("Please enter a boolean","boolean");
                    
                case "string":
                    if (scan.hasNextLine()) return scan.next ();
                    else                    return getInput ("Please enter a string", "string");
                    
                default:
                    System.out.println ("UNHANDLED EXCEPTION. YOU WILL NEVER SEE THIS OUTPUT - I HOPE");
                    return null;
            }
   
        } catch (Exception e) {System.err.println (e.getMessage());}
        return null;
    }//--end method getInput
	
	
/**
 * @name		 getRandomNum
 * @about		 creates a random number from 1 to limit
 * @param 		 limit - the max random number in the range
 * @return		 the generated random number
 */
	public static int getRandomNum (int limit) {
		return (1 + (int) (Math.random() * limit));
	}
	

/**
 * @name		 getRandomNum
 * @about		 creates a random number of length numDigits, each digit in the range 1 to limit
 * @param 		 limit     - the max random number in the range
 * 				 numDigits - the number of digits to be in the random number
 * @return		 the generated random number
 */
	public static int getRandomNum (int limit, int numDigits) {
		if (numDigits  <1) {
			System.out.println("ERROR : A number less than 1 has been passed to getRandomNum");
			return 0;
		}
		
		if (numDigits > 9) {
			System.out.println("CAUTION : getRandomNum output is approaching int limit, Enter a number < 9");
			return 0;
		}
		
		StringBuilder random = new StringBuilder();
		for (int i=0; i<numDigits; i++) {
			random.append(getRandomNum(limit));
		}
		
		return Integer.parseInt(random.toString());
	}//--end method getRandomNum
	
	
/**
 * @name		 print
 * @about		 prints strings using print
 * @param 		 str - the string to be printed
 * @return		 method is void
 */
	public static void print (String str) {
		System.out.print (str);
	}
	
	
/**
 * @name		 printl
 * @about		 prints strings using println
 * @param 		 str - the string to be printed
 * @return		 method is void
 */
	public static void printl (String str) {
		System.out.println(str);
	}
	
	
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

}//--end class
