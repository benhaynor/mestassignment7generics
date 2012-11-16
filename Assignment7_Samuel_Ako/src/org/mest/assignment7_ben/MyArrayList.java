package org.mest.assignment7_ben;

import java.util.Iterator;


public class MyArrayList<AnyType> implements Iterable<AnyType>{
	
	//Global Vars
	private AnyType[] elements;

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.elements = (AnyType[]) (new Object[0]);
	}//--end constructor

	
	
/**
 * @name		 add
 * @about		 adds an object to the list
 * @param		 e - the object to be added to the list
 * @return		 returns true if add is successfull and false otherwise
 */
	@SuppressWarnings("unchecked")
	public boolean add(AnyType e) {// Appends e to the elements array

		AnyType[] newArray = (AnyType[]) (new Object[elements.length + 1]);
		for (int i = 0; i < elements.length; i++) {
			newArray[i] = elements[i];
		}
		newArray[elements.length] = e;
		elements = newArray;
		return true;
	}//--end method add
	
	
	
/**
 * @name		 addAll
 * @about		 adds all the elements in a list to this list
 * @param		 MyArrayList otherList - the list to be added
 * @return		 true if successful and false otherwise
 */
	@SuppressWarnings("unchecked")
	public boolean addAll(MyArrayList<AnyType> otherList) {// Appends e to the elements array

		if (otherList.size() < 1) {
			System.out.println("Caution! : attempting to add empty list");
			return false;
		}
		
		int index = 0;
		AnyType[] newArray = (AnyType[]) (new Object[elements.length + otherList.size()]);
		for (int i = 0; i < elements.length; i++)
			newArray[index++] = elements[i];
		
		for (int i = 0; i < otherList.size(); i++)
			newArray[index++] = otherList.get(i);
		
		elements = newArray;
		return true;
	}//--end method add
	

/**
 * @name		 get
 * @about		 returns the object at the specified location
 * @param		 index - the index containing the desired object
 * @return		 returns the object if found and null if not found
 */
	public AnyType get(int index) {
		if (index>=0 & index<elements.length)
			return elements[index];
		else
			System.out.println("Element "+ index+ " does not exist");
		return null;
	}//--end method get
	

	
/**
 * @name		 size
 * @about		 returns the size of the list structure
 * @param		 none
 * @return		 int - the size
 */
	public int size() {
		return elements.length;
	}//--end method size
	
	
/**
 * @name		 remove
 * @about		 removes an object at the specified index
 * @param		 index - the index containing the object to be removed
 * @return		 true if successfull and false otherwise
 */
	public boolean remove (int index) {
		if (index<0 | index>elements.length)
			return false;
		
		int count = 0;
		@SuppressWarnings("unchecked")
		AnyType[] newArray = (AnyType[]) (new Object[elements.length-1]);
		
		for (int i=0; i<elements.length; i++) {
			if (i != index)
				newArray[count++] = elements[i];
		}//end for
		elements = newArray;
		return true;
	}//--end method remove
	
	
	
/**
 * @name		 remove
 * @about		 searches for and deletes the specified object
 * @param		 e - the object to be removed
 * @return		 int count - the number of occurances of the object found and removed
 */
	public int remove (AnyType e) {
		int count = 0;
		
		for (int i=0; i<elements.length; i++) {
			if (e.equals(elements[i]))
				count++;
		}//-end for
		remove_sub (count, e);
		return count;
	}//--end method remove
	
	
/**
 * @name		 remove_sub
 * @about		 called by remove (AnyType e) to assist in removing objects
 * @param		 ??
 * @return		 ??
 */
	@SuppressWarnings("unchecked")
	private void remove_sub (int count, AnyType e) {
		int index = 0;
		AnyType[] newArray = (AnyType[]) (new Object[elements.length-count]);
		
		for (int i=0; i<elements.length; i++) {
			if (!e.equals(elements[i]))
				newArray[index++] = elements[i];
		}//end for
		elements = newArray;
	}//--end method remove_sub
	
	
/**
 * @name		 toString
 * @about		 prints the string representation of this object
 * @param		 none
 * @return		 string - the string representation
 */
	public String toString () {
		StringBuilder strBuild = new StringBuilder("[");
		for (int i=0; i<elements.length; i++) {
			strBuild.append(elements[i]);
			if (!(i+1 == elements.length))
				strBuild.append(",");
		}
		strBuild.append("]");
		return strBuild.toString();
		
	}//--end method toString
	

/**
 * @name		 Iterator - overrides Iterator in interface Iterable
 * @about		 returns an iterator which is used in iterating through the list structure
 * @param		 none
 * @return		 returns an iterator
 */
	@Override
	public Iterator<AnyType> iterator() {
		return new MyIterator<AnyType>(this);
	}

}
