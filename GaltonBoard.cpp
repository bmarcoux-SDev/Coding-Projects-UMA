/*
CIS 215, Summer 2019
Date: 07/21/2019
Author: Bradley Marcoux
Assignment: Galton Board Week 9
*/

#include <iostream>
#include <ctime>
#include <cstdlib>
using namespace std;

// Function to determine L or R. R = True
bool dropMarble()
{	
	if (rand() % 2)
	{
		return true;
	}
	else
	{
		return false;
	}
}

int main()
{
	// Declare srand for random number for the function and program to run correctly
	// Declare number of marbles, array and array size as a const
	srand(time(NULL));
	int numberOfMarbles;
	const int colSize = 8;
	int columns[colSize];
	
	// Initialize the array
	for(int i = 0; i <= colSize; ++i)
    {
		columns[i] = 0;
    }
	
	// Prompt user for number of marbles
	cout << "Input the number of marbles you wish to use for the Galton Board: ";
	cin >> numberOfMarbles;
	
	// Outer loop that will run inner loop n number of times until the input number has been reached, thus ending the outer loop
	for (int i = 0; i < numberOfMarbles; i++)
	{
		// declare the correct marble as true
		// initialize count to increment slot in the array as the inner loop runs
		bool marbleRight = true;
		int count = 0;
		
		// inner loop will run 7 times (amount of rows and pegs the marbles will hit) counting how many "right" moves the marble will make
		// for each true output the counter will add + 1 to a max of 8 as the initial slot in the array is '0'
		for (int rowOfPegs = 0; rowOfPegs < 7; rowOfPegs++)
		{
			// run function
			marbleRight = dropMarble();
			if (marbleRight)
				count = count + 1;
		}
		// this will output how many times a slot in the array was selected by the inner loop
		++columns[count];
	}
	
	// output column number and how many marbles landed in each slot
	for (int j = 0; j < colSize; ++j)
	{
		cout << '\n' << "Column " << j + 1 << " --- " << columns[j] << " " << endl;
	}
	
	return 0;
}