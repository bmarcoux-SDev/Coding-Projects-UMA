/*
CIS 214, Fall 2019
Date: 10/14/2019
Author: Bradley Marcoux
Assignment: Temperature Conversion Week 6
*/

import java.util.Scanner;

public class TemperatureConversion
{
	// Four methods to convert the input temp and return a double of the converted type that was called.
	// variable for example is named cToK = Celsius to Kelvin, etc.
	// K() will return all Kelvin types
	public static double K(double x, String y)
	{
		if(y.equals("C"))
		{
			double cToK = x + 273.15;
			return cToK;
		}
		else if(y.equals("F"))
		{
			double fToK = ((x - 32) * 5/9 + 273.15);
			return fToK;
		}
		else if(y.equals("R"))
		{
			double rToK = x * 5/9;
			return rToK;
		}
		else
			return x;
	}
	// C() will return all Celsius types
	public static double C(double x, String y)
	{
		if(y.equals("K"))
		{
			double kToC = x - 273.15;
			return kToC;
		}
		else if(y.equals("F"))
		{
			double fToC = ((x - 32) * 5/9);
			return fToC;
		}
		else if(y.equals("R"))
		{
			double rToC = ((x - 491.67) * 5/9);
			return rToC;
		}
		else
			return x;
	}
	// F() will return all Fahrenheit types
	public static double F(double x, String y)
	{
		if(y.equals("K"))
		{
			double kToF = ((x - 273.15) * 1.8 + 32);
			return kToF;
		}
		else if(y.equals("C"))
		{
			double cToF = ((x * 1.8) + 32);
			return cToF;
		}
		else if(y.equals("R"))
		{
			double rToF = (x - 459.67);
			return rToF;
		}
		else
			return x;
	}
	// R() will return all Rankine types
	public static double R(double x, String y)
	{
		if(y.equals("K"))
		{
			double kToR = x * 1.8;
			return kToR;
		}
		else if(y.equals("C"))
		{
			double cToR = x * 1.8 + 491.67;
			return cToR;
		}
		else if(y.equals("F"))
		{
			double fToR = (x + 459.67);
			return fToR;
		}
		else
			return x;
	}
	
	public static void main(String[] args)
	{
		// input object
		Scanner input = new Scanner(System.in);
	
		//Prompt user for input of a temp as a double, and a character as a String
		System.out.println("\n - Temperature Conversion:\n - You will be prompted to input a number, followed by a prompt for the temperature type.");
		System.out.print("\n - Please input a temperature you would like to Convert: ");
		double temp = input.nextDouble();
		System.out.print("\n - Input a K for Kelvin, C for Celsius, F for Fahrenheit, or R for Rankine: ");
		String myChar = input.next();

		// Call all 4 methods with the appropriate return value for each temperature type
		// returned type is cast to another double variable which is then formatted to limit to 2 decimal places when output to the user
		System.out.print("\n --- " + temp + myChar + " in Kelvin is: ");
		double convertedTemp = K(temp, myChar);
		System.out.printf("%.2f%s", convertedTemp, "K");
		
		System.out.print("\n --- " + temp + myChar + " in Celsius is: ");
		double convertedTemp2 = C(temp, myChar);
		System.out.printf("%.2f%s", convertedTemp2, "C");
		
		System.out.print("\n --- " + temp + myChar + " in Fahrenheit is: ");
		double convertedTemp3 = F(temp, myChar);
		System.out.printf("%.2f%s", convertedTemp3, "F");
		
		System.out.print("\n --- " + temp + myChar + " in Rankine is: ");
		double convertedTemp4 = R(temp, myChar);
		System.out.printf("%.2f%s", convertedTemp4, "R");
	}
}