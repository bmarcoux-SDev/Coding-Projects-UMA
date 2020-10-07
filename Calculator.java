/*
CIS 314, Spring 2020
Date: 2/7/2020
Author: Bradley Marcoux
Assignment: Week 3 Exception handling homework
Comments: This was challenging to get working right. For the most part I can't break it with normal inputs. I'm sure there are ways to break it, but inputing the wrong numbers, letters or symbols doesn't seem to break it.
*/

import java.util.InputMismatchException; // import InputMismatchException util
import java.util.Scanner;

public class Calculator
{
	public static void main(String[] args)
	{
		String a = "a"; // set String variables to accept user input for operations
		String s = "s";
		String m = "m";
		String d = "d";
		int num1; // set int for user number input
		int num2;
		
		Scanner input = new Scanner(System.in); // scanner object for user input
		boolean loop = true; // set loop
		
		do // do-while loop to test code first, then loop if exceptions are thrown
		{
			try // try input first, catch if required
			{	
				System.out.println("\t\t\t--- Choose an operation: add, subtract, multiply or divide. ---");
				System.out.print("\tUser Input: Enter an -a- for add, -s- for subtract, -m- for multiplication, or -d- for division: ");
				String operator = input.nextLine(); // prompt user for operation type
				
				System.out.print("\n--- Input your first integer: "); // prompt user for first number input
				num1 = input.nextInt();
			
				System.out.print("--- Input your second integer: "); // prompt user for second number input
				num2 = input.nextInt();
				
				if(operator.equals(a)) // if-else statement to check for initial user operation input, then outputs the mathematical result
				{
					System.out.printf("\n[ %d%s%d%s%d ]",num1," + ",num2," = ", num1 + num2);
				}
				else if(operator.equals(s))
				{
					System.out.printf("\n[ %d%s%d%s%d ]",num1," - ",num2," = ", num1 - num2);
				}
				else if(operator.equals(m))
				{
					System.out.printf("\n[ %d%s%d%s%d ]",num1," * ",num2," = ", num1 * num2);
				}
				else if(operator.equals(d))
				{
					if(num2 == 0) // embedded if statement to check for denominator input of 0 and divide by 0 exception. If true it will throw the ArithmeticException
					{
						throw new ArithmeticException(); // I did this because the compiler would still work and when running the program it would not throw an exception. It would output "infinity" because it's a float number
					}
					else // if num2 != 0, will output a double result to the console
					{
						int x = num1; // assign num1 and num2 to x and y respectively
						int y = num2;
						double z = x; // cast to double
						double w = y;
						System.out.printf("\n[ %.0f%s%.0f%s%.2f ]",z," / ",w," = ", z / w);
					}
				}
				else if(operator != a && operator != s && operator != m && operator != d) // check if operation input is not one of the requested letters
				{
					throw new Exception(); // throw exception if not
				}
				else
					return;
				
				loop = false; // end loop
			}
			catch (InputMismatchException ime) // possible exception errors to catch when testing the program. This seemed to cover the major bases.
			{
				System.err.printf("%n!!! Exception: %s !!!%n", ime);
				input.nextLine();
				System.out.printf("--- You may only use Integers, please try again --- %n\n");
			}
			catch (ArithmeticException ae)
			{
				System.err.printf("%n!!! Exception: %s !!!%n", ae);
				input.nextLine();
				System.out.printf("--- Cannot divide by zero, Please use a different denominator ---\n %n");
			}
			catch (Exception e)
			{
				System.err.printf("%n!!! Exception: Unable to Process Request %s !!!%n", e);
				input.nextLine();
				System.out.println("--- You're input was invalid. You may only choose (a, s, m, or d), please try again ---\n");
			}

		}	while(loop); // continue loop if necessary
	}
}