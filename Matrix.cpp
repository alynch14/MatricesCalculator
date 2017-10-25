#include "stdafx.h"
#include "Matrix.h"
#include <iostream>
#include <random>
using namespace std;


Matrix::Matrix()
{
	size = 20;
}

Matrix::Matrix(int s) {
	size = s;
	table[s][s];
}

int Matrix::getSize() {
	return size;
}

int Matrix::getElement(int r, int c) {
	return table[r][c];
}

void Matrix::setElement(int r, int c, int e) {
	table[r][c] = e;
}

void Matrix::print() {
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			if (table[r][c] >= 10) {
				cout << "   " << table[r][c];
			}
			else {
				cout << "    " << table[r][c];
			}
		}
		cout << endl;
	}
}

void Matrix::initialize(int low, int high) {
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			table[r][c] = rand() % high + low;
		}
	}

}

Matrix Matrix::addition(Matrix m) {
	Matrix t(size);
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			t.table[r][c] = (table[r][c] + m.table[r][c]);
		}
	}
	return  t;
}

Matrix Matrix::subtraction(Matrix m) {
	Matrix t(size);
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			t.table[r][c] = (table[r][c] - m.table[r][c]);
		}
	}
	return t;
}

Matrix Matrix::multiplication(Matrix m) {
	Matrix t(size);
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			for (int i = 0; i < size; i++) {
				t.table[r][c] += (table[r][i] * m.table[i][c]);
			}
		}
	}
	return t;
}

Matrix Matrix::multiplyConst(int x) {
	Matrix m(size);
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			m.table[r][c] = (table[r][c] * x);
		}
	}
	return m;
}

Matrix Matrix::transpose() {
	Matrix m(size);
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			m.table[r][c] = table[c][r];
		}
	}
	return m;
}

int Matrix::trace() {
	int sum = 0;
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			sum += table[r][c];
		}
	}
	return sum;
}

bool Matrix::equals(Matrix m) {
	if (m.size == size) {
		return true;
	}

	return false;
}

void Matrix::copy(Matrix m) {
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			table[r][c] = m.table[r][c];
		}
	}
}

Matrix Matrix::getCopy() {
	Matrix m(size);
	for (int r = 0; r < size; r++) {
		for (int c = 0; c < size; c++) {
			m.table[r][c] = table[r][c];
		}
	}
	return m;
}

//Matrix::~Matrix()
//{
//}
