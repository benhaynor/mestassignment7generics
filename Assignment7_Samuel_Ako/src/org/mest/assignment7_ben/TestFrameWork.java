package org.mest.assignment7_ben;

public class TestFrameWork {

	public static void main (String args[]) {
		
	//--TESTING MyArrayList CLASS
		System.out.println("TESTING MyArrayList CLASS");
		MyArrayList<String> lullaby = new MyArrayList<>();
		lullaby.add("twinkle");
		lullaby.add("twinkle");
		lullaby.add("little");
		lullaby.add("star");
		System.out.println("Full song");
		System.out.println(lullaby);
		lullaby.remove("twinkle");
		System.out.println("\nMinus twinkle");
		System.out.println(lullaby);
		lullaby.remove("shazam");
		System.out.println("\nMinus shazam");
		System.out.println(lullaby);
		
		
		
		//--TESTING MySet CLASS
		System.out.println("\n\n TESTING MySet CLASS");
		MySet<Integer> holder = new MySet<>  (); //I defined the MySet class to return unions and intersections instead of changing
												 //the original sets, so this object will be used to collect the results
		
		MySet<Integer> ints = new MySet<Integer>();
		ints.add(new Integer(1));
		ints.add(new Integer(1));
		ints.add(new Integer(1));
		ints.add(new Integer(2));
		ints.add(new Integer(3));
		System.out.println("Original");
		System.out.println(ints);
		ints.remove(new Integer(3));
		System.out.println("\nMinus three");
		System.out.println(ints);
		MySet<Integer> ints2 = new MySet<Integer>();
		ints2.add(new Integer(2));
		ints2.add(new Integer(4));
		System.out.println("\nAfter union");
		holder = ints.union(ints2);
		System.out.println(holder);
		MySet<Integer> ints3 = new MySet<Integer>();
		ints3.add(new Integer(2));
		ints3.add(new Integer(4));
		ints3.add(new Integer(5));
		
		ints = holder;					//this modification is made to compensate for structural differences in my code
		holder = ints.intersect(ints3);
		System.out.println("\nAfter intersection");
		System.out.println(holder);
		
		
		
		//--TESTING MySet CLASS
		System.out.println("\n\n TESTING MySet CLASS");
		Pair<String, String> hw = new Pair<String,String>("Hello","World");
		System.out.println(hw);
		Pair<Integer, String> company = new Pair<Integer,String>(new Integer(2),"is company.");
		System.out.println(company);

		
		
		//--TESTING LookupTable CLASS
		System.out.println("\n\n TESTING LookupTable CLASS");
		LookupTable<String,String> animals = new LookupTable<>();
		animals.add(new Pair<String,String>("anteater","ant eating mammal"));
		animals.add(new Pair<String,String>("aardvark","not an anteater"));
		System.out.println("Animals");
		System.out.println(animals.lookUp("anteater"));
		System.out.println(animals.lookUp("aardvark"));
		System.out.println("\nMonths");
		LookupTable<Integer,String> months = new LookupTable<Integer,String>();
		months.add(new Pair<Integer,String>(new Integer(1),"January"));
		months.add(new Pair<Integer,String>(new Integer(2),"February"));
		System.out.println(months.lookUp(new Integer(1)));
		System.out.println(months.lookUp(new Integer(2)));
		
		//--TESTING Iterator implementation
		System.out.println("\n\n TESTING Iterator implementation");
		MySet<String> strings = new MySet<String>();
		strings.add("Hello");
		strings.add("world!");
		for (String s: strings){
		System.out.println(s);
		}

	}//--end main
	
}//--end class
