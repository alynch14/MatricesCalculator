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
import java.util.Scanner;
import java.util.Random;

public class MatricesCalculator {

    /**
     * @param args the command line arguments
     */
    public static final int MAX = 20; 
    public static final int LOW = 1; 
    public static final int UP = 10;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        int choice; //operation to be executed from menu 
        int numCommands = 0; //display counter 
        int size; //for subarray processing 
        int value; //multiply matrix by this constant 
        int tr; //return from trace() 
        
        size = getInt(input,"Please enter a positive integer value less than or equal to 20 for the size: ");
        while(size <=0 || size >20)
            size = getInt(input,"Error! enter a value greater than 0 or less than or equal to 20!");
        
        Matrix first = new Matrix(size); 
        Matrix second = new Matrix(size); 
        Matrix result = new Matrix(size); 
        choice = menu(input); //priming read; 
        while (choice != 0){
            switch(choice){
                case 1: numCommands++;
                    first.initialize(LOW, UP);
                    second.initialize(LOW, UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    System.out.println("The second matrix is: ");
                    second.print();
                    System.out.println("The result is: ");
                    result = first.addition(second);
                    result.print();
                    System.out.println("Command number " + numCommands + " completed.");
                    break;
                    
                case 2: numCommands++;
                    first.initialize(LOW, UP);
                    second.initialize(LOW, UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    System.out.println("The second matrix is: ");
                    second.print();
                    System.out.println("The result is: ");
                    result = first.subtraction(second);
                    result.print();
                    System.out.println("Command number " + numCommands + " completed.");
                    break;
                    
                case 3: numCommands++;
                    first.initialize(LOW, UP);
                    second.initialize(LOW, UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    System.out.println("The second matrix is: ");
                    second.print();
                    System.out.println("The result is: ");
                    result = first.multiplication(second);
                    result.print();
                    System.out.println("Command number " + numCommands + " completed.");
                    break;
                    
                case 4: numCommands++;
                    value = getInt(input, "Please enter a value to multiply the matrix by: ");
                    first.initialize(LOW, UP);
                    second.initialize(LOW, UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    System.out.println("The second matrix is: ");
                    second.print();
                    System.out.println("The result is: ");
                    result = first.multiplyConst(value);
                    result.print();
                    System.out.println("Command number " + numCommands + " completed.");
                    break;
                    
                case 5: numCommands++;
                    first.initialize(LOW, UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    result = first.transpose();
                    System.out.println("The resulting matrix is: ");
                    result.print();
                    System.out.println("  Command number " + numCommands + " completed.");
                    break;
                    
                case 6: numCommands++;
                    first.initialize(LOW, UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    tr = first.trace();
                    System.out.println("The result is: " + tr);
                    System.out.println("Command number " +numCommands + " completed.");
                    break;
                    
                case 7: numCommands++;
                    first.initialize(LOW, UP);
                    System.out.println("Original matrix is: ");
                    first.print();
                    result = first.getCopy();
                    System.out.println("The copied matrix is: ");
                    result.print();
                    System.out.println("Testing for equality, the matrices should be equal.");
                    if(first.equals(result))
                        System.out.println("The matrices are equal!!");
                    else
                        System.out.println("The matrices are NOT equal!!");
                    System.out.println("Command number " + " completed.");
                    break;
                    
                case 8: numCommands++;
                    first.initialize(LOW,UP);
                    second.initialize(LOW, UP);
                    System.out.println("The first matrix is: ");
                    first.print();
                    System.out.println("The second matrix is ");
                    second.print();
                    if(first.equals(result))
                        System.out.println("The matrices are equal!!");
                    else
                        System.out.println("The matrices are NOT equal!!");
                    System.out.println("Command number " + " completed.");
                    break;
                    
                default: System.out.println("Error! Number entered does not match any of the options. Please try again: ");
            }
            choice = menu(input);
        }
    }
    
    public static int getInt(Scanner in, String prompt){
        System.out.println(prompt);
        
        while(!in.hasNextInt()){
            in.next();
            System.out.println("Not an integer value! Try again: ");
        }
        return in.nextInt();
    }
    
    public static int menu(Scanner keyboard){
        return getInt(keyboard, "Your options for matrix operations are:\n" +
                            "----------------------------------------\n" + 
                            "1) Add 2 matrices\n"+ 
                            "2) Subtract 2 matrices\n" + 
                            "3) Multiply 2 matrices\n" + 
                            "4) Multiply matrix by a constant\n" +
                            "5) Transpose matrix\n" + 
                            "6) Matrix trace\n" + 
                            "7) Make a copy\n" +
                            "8) Test for equality\n" + 
                            "0) EXIT\n" +
                            "Please enter your option:");
    }
}
