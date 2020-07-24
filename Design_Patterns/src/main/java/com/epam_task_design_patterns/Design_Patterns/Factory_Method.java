package com.epam_task_design_patterns.Design_Patterns;
import java.io.*;

	abstract class Vehicle_Cost
	{
	       protected double rate;

	       abstract void getRate();


	       public void calculate_Cost(int vehicles)

	     {
	       
	         System.out.println(vehicles*rate);
	     }

	}
	class  Two_Wheeler extends Vehicle_Cost
	{
	    public void getRate()
	   {
	        rate=250.50;            
	   }
	}
	class Three_Wheeler extends Vehicle_Cost
	{
	   
	    public void getRate()
	   {
	        rate=345.25;
	   }
	}
	class  Four_Wheeler extends Vehicle_Cost
	{
	 
	    public void getRate()
	   {
	        rate=550.50;
	   }
	}
	     
	class Buy_Vehicle
	{
	public Vehicle_Cost getVehicle_type(String vehicle_type)
	{

	       if(vehicle_type == null)
	      {
	        return null;
	      }

	   if(vehicle_type.equalsIgnoreCase("Two_Wheeler"))
	      {
	        return new Two_Wheeler();
	      }

	      else if(vehicle_type.equalsIgnoreCase("Three_Wheeler"))
	     {
	       return new Three_Wheeler();
	     }

	     else if(vehicle_type.equalsIgnoreCase("Four_Wheeler"))
	     {
	       return new Four_Wheeler();
	     }
	 

	 return null;
	}
	}
	public class Factory_Method {
	public static void main(String args[])throws IOException
	{
		Buy_Vehicle bv = new Buy_Vehicle();
	 System.out.println("Enter the type of vehicle you want to buy : ");
	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 String vehicle_name=br.readLine();
	 System.out.println("Enter number of vehicles of this type you want to buy: ");
	 int vehicles=Integer.parseInt(br.readLine());
	 Vehicle_Cost vc = bv.getVehicle_type(vehicle_name);
	 System.out.println("Total Cost of " +vehicles+ " "+vehicle_name+" "+"vehicles is:");
	      vc.getRate();
	      vc.calculate_Cost(vehicles);
	      }
	}
	
/*OUTPUT:
Enter the type of vehicle you want to buy : 
Two_Wheeler
Enter number of vehicles of this type you want to buy: 
3
Total Cost of 3 Two_Wheeler vehicles is:
751.5
*/
