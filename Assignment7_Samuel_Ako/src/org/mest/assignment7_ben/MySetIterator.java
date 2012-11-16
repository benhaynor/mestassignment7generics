package org.mest.assignment7_ben;

import java.util.Iterator;

public class MySetIterator<AnyType> implements Iterator<AnyType> {

	int position;					 		//-this is used to mark the current position during iteration
	private MySet<AnyType> myList;	//-this holds the list to be iterated through	

	
	//constructor
	public MySetIterator (MySet<AnyType> set) {
		myList = set;
	}//--end constructor

	
/**
 * @name		 hasNext
 * @about		 determines in there are anymore objects left during iteration
 * @param		 none
 * @return		 true if yes and false otherwise
 */
	@Override
	public boolean hasNext() {
		if (position < myList.getSize())
			return true;
		else
			return false;
	}//--end method hasNext

	
/**
 * @name		 next
 * @about		 returns the next object during iteration
 * @param		 none
 * @return		 AnyType - the next object
 */
	@Override
	public AnyType next() {
		return myList.getMember(position++);
	}//--end method next

	
/**
 * @name		 remove
 * @about		 removes an object at the specified position
 * @param		 none
 * @return		 method is void
 */
	@Override
	public void remove() {
		myList.remove(myList.getMember(position));
	}

}
