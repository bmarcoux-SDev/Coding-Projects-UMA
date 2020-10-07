/*
CIS 314, Spring 2020
Date: 03/19/2020
Author: Bradley Marcoux
Assignment: Week 8 Measure Time Project
Comments: Fun assignment. Took awhile to figure out the logistics behind it, but it was fun to play with and modify. I tested the array lengths a bit and stuck with the 15000. Other numbers seemed to work fine until it got too big. I ran into some exception handling issues when the arrays got too big, specifically for the recursive bubble sort method.
*/

import java.util.concurrent.TimeUnit;
import java.util.Random;

public class MeasureTime
{
	public static void bubbleSort(int[] array, int x) // bubbleSort method that accepts array and an int for array length
	{
		if(x == 0)
			return;
		{
			for(int j = 0; j < x - 1; j++)
			{
				if(array[j] > array[j + 1])
				{
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		bubbleSort(array, x - 1);
	}
	
	public static void insertionSort(int[] array) // insertion sort method
	{
		int i = 0;
		while(i < array.length - 1)
		{
			if(array[i] > array[i +1])
			{
				int temp = array[i + 1];
				int k = i;
				while(k >= 0 && array[k] > temp)
				{
					array[k + 1] = array[k];
					k = k - 1;
					
					array[k + 1] = temp;
				}
			}
			i = i + 1;
		}
	}
	
	public static void selectionSort(int[] array) // selection sort method
	{
		for(int i = 0; i < array.length; i++)
		{
			int min_element = i;
			for(int j = i+1; j < array.length; j++)
			{
				if(array[j] < array[min_element])
					min_element = j;
			}
			int temp = array[min_element];
			array[min_element] = array[i];
			array[i] = temp;
		}
	}
	
	public static void main(String[] args) // begin main method
	{
		System.out.print("Here's a list of 3 arrays all with random numbers generated not in any specific order. \nThe program will now sort each array using different methods, output the time it takes to sort \neach array and tell us which is the fastest and the slowest sorting method of the 3.\n\n");
		Random n = new Random(); // new random obj
		
		int[] myArray = new int[15000]; // first array set to 15000 elements
		for(int i = 0; i < myArray.length; i++)
		{
			myArray[i] = n.nextInt(10000) + 1; // array with number range of 1 - 10000
		}
		long startTime = System.nanoTime(); // start time
		selectionSort(myArray); // run selection sort method
		long endTime = System.nanoTime(); // end time

		long durationInNano1 = (endTime - startTime); //Total execution time in nanoseconds
		long durationInMillis1 = TimeUnit.NANOSECONDS.toMillis(durationInNano1); //Same duration in milliseconds

		System.out.println("- Sorted array using [selection sort] method with a length of: " + myArray.length);
		System.out.println("\tDuration in nanoseconds " + durationInNano1);
		System.out.println("\tDuration in milliseconds " + durationInMillis1);
		
		
		int[] myArray2 = new int[15000]; // second array set to 15000 elements
		for(int i = 0; i < myArray2.length; i++) // output initial array with random numbers
		{
			myArray2[i] = n.nextInt(10000) + 1; // array with number range of 1 - 10000
		}
		startTime = System.nanoTime(); // start time
		bubbleSort(myArray2, myArray2.length); // run bubble sort method
		endTime = System.nanoTime(); // end time

		long durationInNano2 = (endTime - startTime); //Total execution time in nanoseconds
		long durationInMillis2 = TimeUnit.NANOSECONDS.toMillis(durationInNano2); //Same duration in milliseconds
		
		System.out.println("- Sorted array using [recursive bubble sort] method with a length of: " + myArray2.length);
		System.out.println("\tDuration in nanoseconds " + durationInNano2);
		System.out.println("\tDuration in milliseconds " + durationInMillis2);
		
		
		int[] myArray3 = new int[15000]; // third array set to 15000 elements
		for(int i = 0; i < myArray3.length; i++)
		{
			myArray3[i] = n.nextInt(10000) + 1; // array with number range of 1 - 10000
		}
		startTime = System.nanoTime(); // start time
		insertionSort(myArray3); // run insertion sort method
		endTime = System.nanoTime(); // end time

		long durationInNano3 = (endTime - startTime); //Total execution time in nanoseconds
		long durationInMillis3 = TimeUnit.NANOSECONDS.toMillis(durationInNano3); //Same duration in milliseconds
		
		System.out.println("- Sorted array using [insertion sort] method with a length of: " + myArray3.length);
		System.out.println("\tDuration in nanoseconds " + durationInNano3);
		System.out.println("\tDuration in milliseconds " + durationInMillis3);
		
		
		long[] sortedTime = {durationInMillis1,durationInMillis2,durationInMillis3}; // add sort times to new array
		for(int i = 0; i < sortedTime.length; i++) // sort the times from fastest to slowest
		{
			int min_element = i;
			for(int j = i+1; j < sortedTime.length; j++)
			{
				if(sortedTime[j] < sortedTime[min_element])
					min_element = j;
			}
			long temp = sortedTime[min_element];
			sortedTime[min_element] = sortedTime[i];
			sortedTime[i] = temp;
		}
		System.out.println();
		if(durationInMillis1 == sortedTime[0] || durationInMillis2 == sortedTime[0] || durationInMillis3 == sortedTime[0]) // select from the sortedTime array and output which sort method is fastest, etc.
		{
			if(durationInMillis1 == sortedTime[0])
				System.out.println("- Fastest sort method: Selection Sort");
			else if(durationInMillis2 == sortedTime[0])
				System.out.println("- Fastest sort method: Recursive Bubble Sort");
			else
				System.out.println("- Fastest sort method: Insertion Sort");
		}
		if(durationInMillis1 == sortedTime[1] || durationInMillis2 == sortedTime[1] || durationInMillis3 == sortedTime[1]) // select from the sortedTime array and output which sort method is in the middle.
		{
			if(durationInMillis1 == sortedTime[1])
				System.out.println("- Middle sort method: Selection Sort");
			else if(durationInMillis2 == sortedTime[1])
				System.out.println("- Middle sort method: Recursive Bubble Sort");
			else
				System.out.println("- Middle sort method: Insertion Sort");
		}
		if(durationInMillis1 == sortedTime[2] || durationInMillis2 == sortedTime[2] || durationInMillis3 == sortedTime[2]) // select from the sortedTime array and output which sort method is slowest.
		{
			if(durationInMillis1 == sortedTime[2])
				System.out.println("- Slowest sort method: Selection Sort");
			else if(durationInMillis2 == sortedTime[2])
				System.out.println("- Slowest sort method: Recursive Bubble Sort");
			else
				System.out.println("- Slowest sort method: Insertion Sort");
		}
	} // end of the main method
} // end of MeasureTime class