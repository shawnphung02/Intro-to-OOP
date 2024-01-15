package cp213;

import java.util.Scanner;

/**
 * Class to demonstrate the use of Scanner with a keyboard and File objects.
 *
 * @author your name here
 * @version 2022-01-08
 */
public class ScannerTest {

    /**
     * Count lines in the scanned file.
     *
     * @param source Scanner to process
     * @return number of lines in scanned file
     */
    public static int countLines(final Scanner source) {
	int count = 0;

	while(source.hasNextLine()) {
		count ++;
		source.nextLine();	
	}

	return count;
    }

    /**
     * Count tokens in the scanned object.
     *
     * @param source Scanner to process
     * @return number of tokens in scanned object
     */
    public static int countTokens(final Scanner source) {
	int tokens = 0;

	while(source.hasNext()) {
		tokens ++;
		source.next();
	}

	return tokens;
    }

    /**
     * Ask for and total integers from the keyboard.
     *
     * @param source Scanner to process
     * @return total of positive integers entered from keyboard
     */
    public static int readNumbers(final Scanner keyboard) {
    	
    // Declare variables
	int total = 0;
	String userInput; 
	int num;
	// Determine when to stop
	boolean stop = false;
	
	while(stop != true) {
		// User inputs an integer
		if(keyboard.hasNextInt() == true) {
			// Grab user input and increase total
			num = keyboard.nextInt();
			total += num;
			// Move cursor to next line
			keyboard.nextLine();
		}
		// Not integer
		else {
			// Grab user input
			userInput = keyboard.nextLine();
			// End if input is q
			if(userInput.equals("q")) {
				stop = true;
			}
			// User input is not an integer or q
			// Output error
			else{
				System.out.printf("'%s' is not an integer or 'q'.\n", userInput);
			}
		}
    }
	return total;
    }
}




