// MatricesCalculator.cpp : Defines the entry point for the console application.
//

#include "stdafx.h"
#include <iostream>
#include "Matrix.h"
#include <string>
#include <sstream>
using namespace std;

const int LOW = 1;
const int HIGH = 20;
int getInt(string s);
int printMenu();

int main()
{
	int multiplicationConstant, size;
	int choice = 1;
	string instructions = "Please enter a size for your matrices.";
	

	while (choice != 0) {
		size = getInt(instructions);
		Matrix matrixOne(size);
		Matrix matrixTwo(size);
		Matrix resultingMatrix(size);
		choice = printMenu();
		switch(choice){
		case 1:
			matrixOne.initialize(LOW, HIGH);
			matrixTwo.initialize(LOW, HIGH);
			cout << "Here is the first matrix: " << endl;
			matrixOne.print();
			cout << "Here is the second matrix: " << endl;
			matrixTwo.print();
			resultingMatrix = matrixOne.addition(matrixTwo);
			cout << "Here is the resulting matrix: " << endl;
			resultingMatrix.print();
			break;

		case 2:
			matrixOne.initialize(LOW, HIGH);
			matrixTwo.initialize(LOW, HIGH);
			cout << "Here is the first matrix: " << endl;
			matrixOne.print();
			cout << "Here is the second matrix: " << endl;
			matrixTwo.print();
			cout << "And the resulting matrix is: " << endl;
			resultingMatrix = matrixOne.subtraction(matrixTwo);
			resultingMatrix.print();
			break;

		case 3:
			matrixOne.initialize(LOW, HIGH);
			matrixTwo.initialize(LOW, HIGH);
			cout << "Here is the first matrix: " << endl;
			matrixOne.print();
			cout << "The second matrix: " << endl;
			matrixTwo.print();
			cout << "And the final matrix: " << endl;
			resultingMatrix = matrixOne.multiplication(matrixTwo);
			resultingMatrix.print();
			break;

		case 4:
			matrixOne.initialize(LOW, HIGH);
			cout << "The matrix is: " << endl;
			matrixOne.print();
			multiplicationConstant = getInt("Please enter the constant you wish to multiply the matrix by: ");
			resultingMatrix = matrixOne.multiplyConst(multiplicationConstant);
			cout << "Resulting Matrix: " << endl;
			resultingMatrix.print();
			break;

		case 5: 
			matrixOne.initialize(LOW, HIGH);
			cout << "The matrix is: " << endl;
			matrixOne.print();
			cout << "After transposition, the matrix is: " << endl;
			resultingMatrix = matrixOne.transpose();
			resultingMatrix.print();
			break;

		case 6:
			matrixOne.initialize(LOW, HIGH);
			cout << "The matrix is: " << endl;
			matrixOne.print();
			cout << "The sum of all its values is: " << matrixOne.trace() << endl;
			break;

		case 7:
			matrixOne.initialize(LOW, HIGH);
			cout << "The matrix is: " << endl;
			matrixOne.print();
			cout << "After call the copy, the resulting matrix is: " << endl;
			resultingMatrix.copy(matrixOne);
			resultingMatrix.print();
			break;

		case 8:
			matrixOne.initialize(LOW, HIGH);
			matrixTwo.initialize(LOW, HIGH);
			cout << "Matrix One: " << endl;
			matrixOne.print();
			cout << "Matrix two: " << endl;
			matrixTwo.print();
			if (matrixOne.equals(matrixTwo)) {
				cout << "The matrices are equal." << endl;
			}

			else {
				cout << "The matrices are not equal" << endl;
			}
			
			break;
			
		case 9:
			cerr << "Error: please enter a value between 0-8!" << endl;
			break;
		}
	}
	
    return 0;
}

int getInt(string s) {
	string input;
	int num = 0;

	cout << s << endl;
	cin >> input;
	stringstream convert (input);

	while (!(convert >> num)) {
		cerr << "Error: Please enter an integer value:" << endl;
		cin >> input;
	}
	return num;
}

int printMenu() {
	cout << "Your options for matrix operations are:" << endl;
	cout << "----------------------------------------" << endl;
	cout << "1) Add 2 matrices" << endl;
	cout << "2) Subtract 2 matrices" << endl;
	cout << "3) Multiply 2 matrices" << endl;
	cout << "4) Multiply matrix by a constant" << endl;
	cout << "5) Transpose matrix" << endl;
	cout << "6) Matrix trace" << endl;
	cout << "7) Make a copy" << endl;
	cout << "8) Test for equality" << endl;
	cout << "0) EXIT" << endl;
	return getInt("Please enter your option:");
}

