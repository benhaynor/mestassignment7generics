//package org.mest.assignment7_ben;
//
//import javaInterfaces.EIT;
//
//public class SetTest {
//
//	public static void main (String args[]) {
//		MySet<EIT> set1 = new MySet<>();
//		MySet<EIT> set2 = new MySet<>();
//		
//		
//		//Removing member from empty set
//		EIT e4 = new EIT("Sam", "Johnson", 342);
//		System.out.println(set1.remove(e4));
//		
//		
//		//Taking the union of empty sets
//		set1.union(set2);
//		//displaying result
//		set1.displaySet();
//		System.out.println("\n\n");
//		
//		//Taking the intersection of empty sets
//		set1.intersect(set2);
//		//displaying result
//		set1.displaySet();
//		System.out.println("\n\n");
//		
//		
//		EIT e1 = new EIT("Davey", "Jones", 34);
//		EIT e2 = new EIT("Ben", "Gunn", 342);
//		EIT e3 = new EIT("Ben", "Gunn", 342);
//		
//		
//		set1.add(e1);
//		set1.add(e2);
//		set1.add(e3);
//		set1.add(e3);
//		
//		set2.add(e1);
//		set2.add(e2);
//		
//		//Removing Non-existing set member
//		System.out.println(set1.remove(e4));
//		
//		//Adding duplicate set members
//		set2.add(e3);
//		set2.add(e3);
//		
//		System.out.println("Set 1");
//		set1.displaySet();
//		System.out.println("\n\nSet 2");
//		set2.displaySet();
//		
//		System.out.println("\n\nAfter Set 1 union Set 2");
//		set1.intersect(set2);
//		set1.displaySet();
//	}
//}
