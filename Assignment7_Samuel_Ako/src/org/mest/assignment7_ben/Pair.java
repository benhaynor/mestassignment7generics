package org.mest.assignment7_ben;

public class Pair<T1, T2> {

	T1 key;
	T2 value;
	
	//constructor 1
	public Pair (T1 key, T2 value) {
		this.key = key;
		this.value = value;
	}//--end constructor
	
	//constructor 2 - mainly a wrapper for key when trying to retrieve a value
	//wrapping a key is done so that equals method can be used
	public Pair (T1 key) {
		this.key = key;
		this.value = null;
	}//--end constructor
	
	
	/**
	 * @name		 equals
	 * @about		 compares two Pair objects
	 * @param		 Object obj - the object to be compared to this object
	 * @return		 booelan - true if objects are equal and false otherwise
	 */
	@Override
	public boolean equals (Object obj) {
		@SuppressWarnings("unchecked")
		Pair<T1, T2> pair = (Pair<T1, T2>) obj;
		if (key instanceof String) {
			if (((String) key).equalsIgnoreCase((String) pair.key))
				return true;
		}
		
		if (key.equals(pair.key))
			return true;
		else
			return false;
	}//--end method equals
	
	
/**
 * @name		 getValue
 * @about		 returns the value field in this object
 * @param		 none
 * @return		 T2 - the value
 */
	public T2 getValue () {
		return value;
	}//--end method getValue
	
	
/**
 * @name		 toString
 * @about		 prints the string representation of this object
 * @param		 none
 * @return		 string - the string representation
 */
	public String toString () {
		StringBuilder strBuild = new StringBuilder();
		strBuild.append(key);
		strBuild.append(", "+ value);
		
		return strBuild.toString();
	}//--end method toString
}
