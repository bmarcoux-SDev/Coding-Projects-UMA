/*
CIS 215, Summer 2019
Date: 06/19/2019
Author: Bradley Marcoux
Assignment: fstream customer list wk5
*/

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main()
{
	// Set variables to string to read all characters
	// Set do-while looping control variable 'Y' to continue
	string line, lastName, firstName;
	char addName = 'Y';
	
	// do-while function to run statements first before testing loop control condition
	do
	{
	cout << '\n' << "--Current customer list on file--" << endl;
	ifstream myList ("customers.txt");

	// Set loop to pull entire list from .txt file using getline function with correct cout format
	// Added \t to console output for ease of reading
	while (getline(myList, line))
		cout << "\t" << line << endl;
	// Close list once loop condition becomes false to save
	myList.close();

		// if function to check if input is the Y or N variable to proceed with function
		cout << '\n' << "To enter another name, press 'Y' to continue, otherwise 'N' to close the program" << endl;
		cin >> addName;
		if (addName == 'Y')
		{
			// Input last name
			cout << "Enter last name:" << endl;
			cin >> lastName;
			// Input first name
			cout << "Enter first name:" << endl;
			cin >> firstName;
			
			// Concatenate strings together and input into text file with lastName, firstName format
			fstream myList;
			myList.open ("customers.txt", ios::app); // note input/output stream appended otherwise the program would keep overwriting the current .txt data
			
			if (myList.is_open())
			{
				myList << '\n' + lastName + ", " + firstName;
				// Close list as this is best practice to save data
				myList.close();
			}
		}	
	}	while (addName == 'Y'); // Check continuation-condition for loop
	

	return 0;

}