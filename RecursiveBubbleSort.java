/*
CIS 314, Spring 2020
Date: 03/8/2020
Author: Bradley Marcoux
Assignment: Week 6 Recursion
Comments: Getting this to work was a pain. At first I tried a while loop, then a do-while, but I couldn't come up with a solution for a base case. Finally I tried embedding the looping statement within a selection statement and got it to work. For a relatively simple assignment, it took a lot of brain power. I've never done anything with bubble sort or recursion, so this was a nice learning experience though.
*/
import java.util.Random;

public class RecursiveBubbleSort
{
	public static void main(String[] args) // main method
	{
		Random num = new Random(); // random object to generate random numbers
		int[] myArray = new int[10]; // build array object with length of 10 elements
		
		System.out.println("\t--- An array of 10 random integers between 1-100 ---"); // output to user
		System.out.print("\t\t");
		for(int i = 0; i < myArray.length; i++) // output initial array with random numbers
		{
			myArray[i] = num.nextInt(100) + 1; // numbers 1-100
			System.out.print(myArray[i] + ", ");
		}
		bubbleSort(myArray, myArray.length); // call bubbleSort method
		System.out.println("\n--- The same array sorted using a recursive bubble sort method ---");
		System.out.print("\t\t");
		for(int i = 0; i < myArray.length; i++) // output sorted array
		{
			System.out.print(myArray[i] + ", ");
		}
	}
	
	public static void bubbleSort(int[] array, int x) // bubbleSort method that accepts array and an int for array length
	{
		if(x == 0) // selection statement will return to main if and when the countdown of the array length equals 0
			return;
		{
			for(int j = 0; j < x - 1; j++) // for loop that will swap elements if the left element is larger than the right
			{
				if(array[j] > array[j + 1])
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		bubbleSort(array, x - 1); // recursive statement to call the same array and subtract the length by 1 to continually sort the array until the last element
	}	
}