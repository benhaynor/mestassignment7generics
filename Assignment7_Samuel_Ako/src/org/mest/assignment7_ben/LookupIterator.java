package org.mest.assignment7_ben;

import java.util.Iterator;

public class LookupIterator<T1, T2> implements Iterator<Pair<T1, T2>> {

	int position;					 		//-this is used to mark the current position during iteration
	private LookupTable<T1, T2> myList;	//-this holds the list to be iterated through	

	
	//constructor
	public LookupIterator (LookupTable<T1, T2> lookTable) {
		myList = lookTable;
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
	public Pair<T1, T2> next() {
		return myList.getPair(position++);
	}//--end method next

	
/**
 * @name		 remove
 * @about		 removes an object at the specified position
 * @param		 none
 * @return		 method is void
 */
	@Override
	public void remove() {
		myList.remove(position);
	}

}
