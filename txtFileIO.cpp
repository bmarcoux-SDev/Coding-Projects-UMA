/*
CIS 215, Summer 2019
Date: 08/03/2019
Author: Bradley Marcoux
Assignment: Test Score txt file I/O week 11 assignment
*/

#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>
using namespace std;

int main()
{
	// declare variables
	string line;
	int x;
	int count = 0;
	int sum = 0;
	double average = 0;
	
	// initialize class.
	ofstream fileOutput;
	
	// open new file if it doesn't exist.
	fileOutput.open("TestScores.txt");
	
	// prompt user for input.
	cout << "-- Please enter a test score --" << endl;
    cout << "-- Enter Q to exit -- \n" << endl;
	
	// while loop to add test scores. "Q" entry will end the loop and the file output will close.
	while (fileOutput)
	{
		cout << "Enter Test Score: ";
		getline(cin, line);
		// add sentinel control to end loop.
		if (line == "Q" || line == "q")
			break;
		// add scores to TestScores.txt file.
		fileOutput << line << endl;
	}
	// close file.
	fileOutput.close();
	
	// initialize class.
	ifstream readFile;
	// open file to read contents.
	readFile.open("TestScores.txt");
	
	// declare variables for min/max. I made max 0 and min 100 to output properly. If grades can be higher than 100, I can change the variable here.
	int max = 0;
	int min = 100;

	// while loop to read the file and produce the contents to the console.
	// the if statements will determine as the loop passes through each iteration to find the max and min values.
	while (readFile >> x)
	{
		if (x > max)
		{
			max = x;
		}
		if ( x < min)
		{
			min = x;
		}
		// find sum of all lines from the txt file. Increase count each iteration of the loop.
		sum = sum + x;
		count++;
	}
	// close file once all data has been read.
	readFile.close();

	// calculate average of the data.
	average = sum / count;
	
	// console out the sum of all scores, the average score, how many scores were counted, the max score evaluated, and the min score evaluated.
	cout << '\n' << "Sum of scores is: " << sum << endl <<
	"The average of the scores is: " << average << endl <<	
	"This is based off " << count << " scores" << endl <<
	"With a max score of: " << max << endl << "The min score is: " << min << endl;

	return 0;
}