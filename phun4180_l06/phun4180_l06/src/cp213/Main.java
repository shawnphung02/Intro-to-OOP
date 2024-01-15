package cp213;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    /**
     * @param args unused
     */
    public static void main(String[] args) {
	System.out.println("Test scannerTest");
	System.out.println();
	Scanner keyboard = new Scanner(System.in);
	int total = scannerTest(keyboard);
	keyboard.close();
	System.out.println("Total: " + total);
	System.out.println();

	System.out.print("Test stringPrinter");
	System.out.println();

	try {
	    String output = stringPrinter(5, "*");
	    System.out.println(output);
	    output = stringPrinter(-5, "*");
	    System.out.println(output);
	} catch (Exception e) {
	    System.out.println();
	    System.out.println("getMessage:");
	    System.out.println(e.getMessage());
	    System.out.println();
	    System.out.println("toString:");
	    System.out.println(e.toString());
	    System.out.println();
	    System.out.println("printStackTrace:");
	    e.printStackTrace();
	}
    }

    /**
     * Uses exceptions to capture bad input from a keyboard Scanner.
     *
     * @return The total of all the integers entered.
     */
    public static int scannerTest(final Scanner keyboard) {
    	// Declare variables
    	int total = 0;
    	// Get input at least once
    	do {
    		// Prompt input
   			System.out.println("Enter an integer ('Quit' to stop): ");
   			try {
    			// Try to add to total
       			int scannerIn = keyboard.nextInt();
       			total += scannerIn;
    		}
   			// Test for wrong input format
   			catch(InputMismatchException e) {
   				// Quit if 'Quit' is input
   				if(keyboard.nextLine().equals("Quit")) {
   					break;
    			}else {
    			// Wrong input format, display custom error message
    				System.out.println("This is not an integer!");
    			}
   			}	
   		}while(true);
    	
    	// Closer scanner
    	keyboard.close();
    	return total;
    }

    /**
     * Repeats a string.
     *
     * @param n   Number of times to repeat a string.
     * @param str The string to print.
     * @return The repeated string.
     * @throws Exception If n is negative.
     */
    public static String stringPrinter(int n, String str) throws Exception {
    	String strRepeat = "";
    	
    	// n is lower than 0 
    	if(n < 0) { 
    		// Throw exception
    		throw new IllegalArgumentException("Please Enter a Positive Number!");
    		}
    	// Repeat str n times
    	for(int i = 0; i < n; i++) {
    		strRepeat += str;
    	}
    	
	return strRepeat;
   }
} 


