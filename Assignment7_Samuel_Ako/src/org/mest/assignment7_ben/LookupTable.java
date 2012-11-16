package org.mest.assignment7_ben;

import java.util.Iterator;

public class LookupTable<T1, T2> implements Iterable<Pair<T1, T2>> {

	private MyArrayList<Pair<T1, T2>> keyValues;


	//constructor
	public LookupTable() {
		keyValues = new MyArrayList<Pair<T1, T2>>();
	}//--end constructor

	/**
	 * @name		 add
	 * @about		 adds a Pair object to the lookup table
	 * @param		 Pair pair - the Pair object to be addes
	 * @return		 boolean - true if added successfuly and false otherwise
	 */
	public boolean add(Pair<T1, T2> pair) {
		if (isUnique(pair)) {
			keyValues.add(pair);
			return true;
		}//end if
		else
			return false;
	}//--end method add
	
	
/**
 * @name		 isUnique - helper method
 * @about		 checks if a given element exitst in the set
 * @param		 pair - the object to be added
 * @return		 returns true if no match is found and false otherwise
 */
	public boolean isUnique (Pair<T1, T2> pair) {
		for (Pair<T1, T2> p : keyValues) {
			if (pair.equals(p))
				return false;
		}
		return true;
	}//--end method isUnique

	
	
/**
 * @name		 lookup
 * @about		 takes a key and finds its value
 * @param		 T1 key - the key whose value is sought
 * @return		 returns the value if found
 */
	public T2 lookUp(T1 key) {

		for (Pair<T1, T2> p : keyValues) {
			if (p.equals(new Pair<T1, T2>(key)))
				return p.getValue();
		}//-end for
		System.out.println("nothing found");
		return null;
	}//--end method lookup
	
	
/**
 * @name		 getSize
 * @about		 returns the number of elements in this table
 * @param		 none
 * @return		 returns the size
 */
	public int getSize () {
		return keyValues.size();
	}//--end method getSize
	
	
/**
 * @name		 getPair
 * @about		 returns the Pair object at location index
 * @param		 int index - the location of the Pair object
 * @return		 the pair if found
 */
	public Pair<T1, T2> getPair (int index) {
		if (index <0 & index>keyValues.size())
			return null;
		return keyValues.get(index);
	}//--end method getPair
	
	
/**
 * @name		 remove
 * @about		 removes a pair object at location index
 * @param		 index - the location of the object to remove
 * @return		 true if successful and false otherwise
 */
	public boolean remove (int index) {
		if (index <0 & index>keyValues.size())
			return false;
		else {
			keyValues.remove(index);
			return true;
		}
	}//--end method remove

@Override
public Iterator<Pair<T1, T2>> iterator() {
	return new LookupIterator<>(this);
}

}
