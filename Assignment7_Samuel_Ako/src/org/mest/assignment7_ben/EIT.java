package org.mest.assignment7_ben;


public class EIT implements Numeric, MyComparable<EIT>{

	//Global Variables
	String firstName;
	String lastName;
	double age;
	
	
	//constructor
	public EIT (String fName, String lName, double age) {
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
	}//--end constructor
	
	//disregard
	public double getValue () {
		return this.age;
	}
	
	/**
	 * @name		 equals - overrides the default equals method defined in class Object
	 * @about		 compares two objects fo this class
	 * @param		 Object obj - the object to be compared with this object
	 * @return		 true if the two are equal and false otherwise
	 */
	@Override
	public boolean equals (Object obj) {
		if (!(obj instanceof EIT) & (obj == null)) {
			return false;
		}
		else {
			EIT eit = (EIT) obj;
			if (eit.firstName.equalsIgnoreCase(this.firstName) & eit.lastName.equalsIgnoreCase(this.lastName)) {
				return true;
			}
			else
				return false;
		}
	}//--end method equals
	

	
/**
 * @name		 toString
 * @about		 prints the string representation of this object
 * @param		 none
 * @return		 string - the string representation
 */
	@Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();

        strBuild.append("Firstname : ").append(this.firstName).append("\n");
        strBuild.append("Surname   : ").append(this.lastName).append("\n");
        strBuild.append("Age       : ").append(this.age).append("\n");

        return strBuild.toString();
    }//--end method toString

	
//disregard
	@Override
	public int myCompareTo(MyComparable<EIT> other) {
		if (this.age < ((EIT) other).age)
			return -1;
		else if (this.age == ((EIT) other).age)
			return 0;
		else
			return 1;
	}//--end method myCompareTo

}//---end class
