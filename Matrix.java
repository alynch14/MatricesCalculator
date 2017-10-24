/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricescalculator;

/**
 *
 * @author user
 */
import java.util.Random;

public class Matrix {
    private final int MAX = 20;
    private int[][] table = new int[20][20];
    private int size;
        
    public Matrix(){
        size = 20;
    }
    
    public Matrix(int x){
        size = x;
        table = new int[size][size];
    }
    
    public int getSize(){
        return size;
    }
    
    public int getElement(int r, int c){
        return table[r][c];
    }
    
    public void setElement(int r, int c, int v){
        table[r][c] = v;
    }
    
    public void initialize(int low, int up){
        Random rand = new Random();
        
        for(int r = 0; r<size; r++){
            for(int c = 0; c<size; c++)
                table[r][c] = rand.nextInt(up - low +1)+low;
        }
    }
    
    public void print(){
        for(int r = 0; r<size; r++){
            for(int c = 0; c<size; c++)
                System.out.print("\t" + table[r][c]);
        System.out.print("\n");
        }
    }
    
    public Matrix addition(Matrix m){
        Matrix arr = new Matrix(size);
        
        for(int row = 0; row<size ; row++){
            for(int col = 0; col<size ; col++)
                arr.table[row][col] = table[row][col] + m.table[row][col];
        }
        return arr;
    }
    
    public Matrix subtraction(Matrix m){
        Matrix arr = new Matrix(size);
        
        for(int row = 0; row<size ; row++){
            for(int col = 0; col<size ; col++)
                arr.table[row][col] = table[row][col] - m.table[row][col];
        }
        return arr;
    }
    
    public Matrix multiplication(Matrix m){
        Matrix arr = new Matrix(size);
        
        for(int r = 0; r < size; r++)
        {
            for(int c = 0; c < size; c++)
            {
                for(int i = 0; i < size; i++)
                    arr.table[r][c] += table[r][i] * m.table[i][c];
            }
        }
        return arr;
    }
    
    public Matrix multiplyConst(int whatConst){
        Matrix arr = new Matrix(size);
        
        for(int row = 0; row<size; row++){
            for(int col = 0; col< size;col++)
                arr.table[row][col] = table[row][col] * whatConst;
        }
        return arr;
    }
    
    public Matrix transpose(){
        Matrix m = new Matrix(size);
        
        for(int r = 0; r<size; r++){
            for(int c = 0; c<size; c++)
                m.table[r][c] = table[c][r];
        }
        return m;
    }
    
    public int trace(){
        int sum = 0;
        
        for(int r = 0; r<size; r++)
            sum+= table[r][r];
        
        return sum;
    }
    
    public boolean equals(Matrix m){
        for(int r = 0; r<size; r++){
            for(int c = 0; c<size; c++)
                if(table[r][c] != m.table[r][c])
                    return false;
        }
        return true;
    }
    
    public void copy(Matrix m){
        for(int r = 0; r<size; r++){
            for(int c = 0; c<size; c++)
                table[r][c] = m.table[r][c];
        }
    }
    
    public Matrix getCopy(){
        Matrix m = new Matrix(size);
        
        for(int r = 0; r<size; r++){
            for(int c = 0; c<size; c++)
                m.table[r][c] = table[r][c];
        }
        return m;
    }
    
}
