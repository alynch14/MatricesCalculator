#pragma once
class Matrix
{
	int size;
	int table[20][20];
public:
	Matrix();
	Matrix(int);
	int getSize();
	int getElement(int, int);
	void setElement(int, int, int);
	void initialize(int, int);
	void print();
	Matrix addition(Matrix);
	Matrix subtraction(Matrix);
	Matrix multiplication(Matrix);
	Matrix multiplyConst(int);
	Matrix transpose();
	int trace();
	bool equals(Matrix);
	void copy(Matrix);
	Matrix getCopy();
	//~Matrix();
};

