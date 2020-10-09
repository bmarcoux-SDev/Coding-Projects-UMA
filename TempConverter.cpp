/*
CIS 215, Summer 2019
Date: 07/06/2019
Author: Bradley Marcoux
Assignment: Temperature Conversion assignment week 7
*/

// Include libraries. Using iomanip to get the appropriate decimal output on my temperatures
#include <iostream>
#include <iomanip>
using namespace std;

// Prototype Function
double tempConverter(double, char);

// declare my variables
double fahrenheit, celsius, temp;
char tempType;

int main()
{
	// input for both temperature and whether it's celsius or fahrenheit
	cout << "Input a value indicating a temperature: ";
	cin >> temp;
	
	cout << "input a single letter (F or C) indicating the temperature scale of the value you entered: ";
	cin >> tempType;
	
	// if else statements to determine whether the user input is in fahrenheit or celsius with appropriate output after calling my tempConverter function
	// fixed and setprecision utilized for correct 0.0 decimal output
	if (tempType == 'F')
	{
		cout << "The temperature you entered was: " << fixed << setprecision(1) << temp << ' ' << tempType << endl <<
		"The Converted temperature is: " << tempConverter(temp, tempType) << " C" << endl;
	}
	else
	{
		cout << "The temperature you entered was: " << fixed << setprecision(1) << temp << ' ' << tempType << endl <<
		"The Converted temperature is: " << tempConverter(temp, tempType) << " F" << endl;
	}
	
	return 0;
}

// built function that the main function calls after user input. Parameters are declared as a double and char
double tempConverter(double temp, char tempType)
{
	// "if" statement used to determine if temp is in fahrenheit, "else", celsius formula is run and output to main function where called
	if (tempType == 'F')
	{
		// fahrenheit to celsius conversion formula
		celsius = ((temp - 32) * 5) / 9;
		return celsius;
	}
	
	else
		// celsius to fahrenheit conversion formula
		fahrenheit = (temp * 1.8) + 32;
		return fahrenheit;
}