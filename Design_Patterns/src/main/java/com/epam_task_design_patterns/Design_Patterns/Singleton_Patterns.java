package com.epam_task_design_patterns.Design_Patterns;

class Singleton_Pattern {

	private static Singleton_Pattern single_instance = null;
	public String str;
	private Singleton_Pattern()
	{
	str = "Consider a string belonging to Singleton Class";
	}
	
	public static Singleton_Pattern getInstance() //creating instance of singleton class
	{
	if (single_instance == null)
	single_instance = new Singleton_Pattern();

	return single_instance;
	}
	}

	class Singleton_Patterns
	{
	public static void main(String args[])
	{
	Singleton_Pattern sub1 = Singleton_Pattern.getInstance();
	Singleton_Pattern sub2 = Singleton_Pattern.getInstance();
	Singleton_Pattern sub3 = Singleton_Pattern.getInstance();
	sub1.str = (sub1.str).toUpperCase();

	System.out.println("String from sub1 is " + sub1.str);
	System.out.println("String from sub2 is " + sub2.str);
	System.out.println("String from sub3 is " + sub3.str);
	System.out.println("\n");

	sub3.str = (sub3.str).toLowerCase();

	System.out.println("String from sub1 is " + sub1.str);
	System.out.println("String from sub2 is " + sub2.str);
	System.out.println("String from sub3 is " + sub3.str);
	}
	} 
	
	
/*OUTPUT:
String from sub1 is CONSIDER A STRING BELONGING TO SINGLETON CLASS
String from sub2 is CONSIDER A STRING BELONGING TO SINGLETON CLASS
String from sub3 is CONSIDER A STRING BELONGING TO SINGLETON CLASS


String from sub1 is consider a string belonging to singleton class
String from sub2 is consider a string belonging to singleton class
String from sub3 is consider a string belonging to singleton class

 */

