package org.mest.assignment7_ben;

import java.util.Iterator;

public class MySet<E> implements Iterable<E> {
	
	private MyArrayList<E> elements = new MyArrayList<E>();

	
/**
 * @name		 add
 * @about		 adds an object to this set
 * @param		 e - the object to be added to the list
 * @return		 returns true if add is successfull and false otherwise
 */
	public boolean add (E e) {
		if (isUnique(e)) {
			elements.add(e);
			return true;
		}//end if
		else
			return false;
	}//--end method add
	
	
/**
 * @name		 addAll
 * @about		 adds all the elements in a list to this list
 * @param		 MySet otherSet - the set to be added
 * @return		 true if successful and false otherwise
 */
	public void addAll (MySet<E> set) {
		for (E item : set.elements) {
			if (isUnique(item)) {
				elements.add(item);
			}
		}
	}//--end method add
	
	
/**
 * @name		 isUnique - helper method
 * @about		 checks if a given element exitst in the set
 * @param		 e - the object to be matched
 * @return		 returns true if no match is found and false otherwise
 */
	public boolean isUnique (E e) {
		for (E element : elements) {
			if (e.equals(element))
				return false;
		}//end for
		return true;
	}//-- end method isUnique
	
	
/**
 * @name		 remove
 * @about		 searches for and deletes the specified object
 * @param		 e - the object to be removed
 * @return		 int count - the number of occurances of the object found and removed
 */
	public boolean remove(E e) {
		if (!isUnique(e)) {
			elements.remove(e);
			return true;
		}//end if
		else
			return false;
	}//--end method remove

	
/**
 * @name		 union
 * @about		 takes the union of this set and others
 * @param		 MySet other - the set to be used in creating the union with this set
 * @return		 the union of the two sets
 */
	public MySet<E> union(MySet<E> otherSet) {
		MySet<E> newSet = new MySet<>();
		newSet.addAll(otherSet);
		newSet.addAll(this);
		
		return newSet;
	}//--end method union

	
/**
 * @name		 intersect
 * @about		 takes the intersection of this set and other
 * @param		 MySet other - the set to be used in creating the intersection with this set
 * @return		 the intersection of the two sets
 */
	public MySet<E> intersect(MySet<E> other) {
		MySet<E> newSet = new MySet<E>();
		
		for (int i=0; i<this.getSize(); i++) {
			E thisElement = this.getMember(i);
			for (int j=0; j<other.getSize(); j++) {
				if (thisElement.equals(other.getMember(j))) {
					newSet.add(thisElement);
				}//-end if
			}//-end inner for
			
		}//-end outer for loop
		
		return newSet;
	}//-- end method intersect
	
	
/**
 * @name		 getSize
 * @about		 returns the number of elements in this set
 * @param		 none
 * @return		 the size of the set
 */
	public int getSize () {
		return this.elements.size();
	}//--end method getSize
	
	
/**
 * @name		 getMember
 * @about		 returns the setMember at the given index
 * @param		 int index - the index holding the desired element
 * @return		 the element if found and null otherwise
 */
	public E getMember (int index) {
		if (index>=0 & index<elements.size())
			return this.elements.get(index);
		else {
			System.out.println("Element "+ index+ " does not exist");
			return null;
		}
	}//--end method getMember
	
/**
 * @name		 getData
 * @about		 returns the list structure of this object
 * @param		 none
 * @return		 MyArrayList
 */
	public MyArrayList<E> getData() {
		return elements;
	}//--end method getData
	
		
/**
 * @name		 displaySet
 * @about		 displays the contents of this set
 * @param		 none
 * @return 		 method is void
 */
	public void displaySet () {
		if (this.elements.size()==0)
			System.out.println("Set Is Empty\n");
		else
			for (int i=0; i<this.getSize(); i++) {
				System.out.println(elements.get(i).toString());
			}
	}//--end method displaySet
	
	
	
/**
 * @name		 toString
 * @about		 prints the string representation of this object
 * @param		 none
 * @return		 string - the string representation
 */
	public String toString () {
		StringBuilder strBuild = new StringBuilder("[");
		for (E element : elements) {
			strBuild.append(element+ ",");
		}
		strBuild = new StringBuilder(strBuild.substring(0, strBuild.length()-1));
		strBuild.append("]");
		return strBuild.toString();
		
	}//--end method toString


@Override
public Iterator<E> iterator() {
	return new MySetIterator<>(this);
}
	
}//---end class
