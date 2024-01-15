package cp213;

/**
 * Sample string methods.
 *
 * @author your name, ID, and email here
 * @version 2022-05-06
 */
public class StringMethods {
    // Constants
    /**
     * String of vowels.
     */
    public static final String VOWELS = "aeiouAEIOU";

    /**
     * Counts the number of vowels in a string. Does not include 'y'.
     *
     * @param string A string.
     * @return Number of vowels in string.
     */
    public static int vowelCount(final String string) {
	int count = 0;
	
	// Iterate through each index of given string
	for(int i = 0; i < string.length(); i++) {
		// Check if the character at index i is a vowel
		if(VOWELS.contains(String.valueOf(string.charAt(i)))) {
			count ++;
		}
	}
	/*
	// Iterate through each index of given string
	for(int i = 0; i < string.length(); i++) {
		// Get char value for index i
		char letter = string.charAt(i);
		// Iterate through each index of vowel string
		for(int j = 0; j < VOWELS.length(); j++) {
			// Get char value for index j
			char vowel = VOWELS.charAt(j);
			// Compare both char values, if true then count++
			if(letter == vowel) {
				count ++;
				break;
			}
		}
	}
	*/
	return count;
    }

    /**
     * Counts the number of digits in a string.
     *
     * @param string A string.
     * @return Number of digits in string.
     */
    public static int digitCount(final String string) {
	int count = 0;
	
	// Iterate through each index of given string
	for(int i = 0; i < string.length(); i++) {
		// Take char value at index and checks if it is a digit
		if(Character.isDigit(string.charAt(i))) {
			count++;
		}
	}
	return count;
    }
    

    /**
     * Totals the individual digits in a string.
     *
     * @param string A string.
     * @return The integer total of all individuals digits in string.
     */
    public static int totalDigits(final String string) {
	int total = 0;

	// Iterate through each index of given string
	for(int i = 0; i < string.length(); i++) {
		if(Character.isDigit(string.charAt(i))) {
			// Get character value of digit
			char temp = string.charAt(i);
			
			// Create an integer of the digit by converting temp to a String
			int num = Integer.parseInt(String.valueOf(temp));
			total += num;
		}
	}

	return total;
    }

    /**
     * Compares string1 and string2 and returns a comma-delimited concatenated
     * string consisting of the string that is first lexically followed by the
     * string that is second lexically. If the strings are equal, then only string1
     * is returned.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return A concatenation of string1 and string2 in order.
     */
    public static String pairs(String string1, String string2) {
	String line = null;

	// Test if strings are identical
	if(string1.compareTo(string2) == 0) {
		line = string1;
	}else 
	// Strings are NOT identical
	{
		for(int i = 0; i < string1.length(); i++) {
			// Get ASCII value for string1 at index i
			char char1 = string1.charAt(i);
			int num1 = (int)char1;
			// Get ASCII value for string2 at index i
			char char2 = string2.charAt(i);
			int num2 = (int)char2;
			
			// Compare index of the characters
			if(num1 < num2) {
				line = string1 + "," + string2;
				break;
			}else if(num2 < num1) {
				line = string2 + "," + string1;
				break;
			}
			// Keep iterating if characters are equivalent
		}
	}
	return line;
    }

    /**
     * Finds the distance between the s1 and s2. The distance between two strings of
     * the same length is the number of positions in the strings at which their
     * characters are different. If two strings are not the same length, the
     * distance is unknown (-1). If the distance is zero, then two strings are
     * equal.
     *
     * @param string1 String to compare against string2.
     * @param string2 String to compare against string1.
     * @return The distance between string1 and string2.
     */
    public static int stringDistance(String string1, String string2) {
	int distance = 0;
	
	// Determine if string lengths are the equal
	if(string1.length() == string2.length()) {
		// Iterate through both strings' index
		for(int i = 0; i< string1.length(); i++) {
			// Get char value from each string
			char char1 = string1.charAt(i);
			char char2 = string2.charAt(i);
			// Compare char values
			if(char1 != char2) {
				distance++;
			}
		}
	// Strings are different lengths
	}else{
		distance = -1;
	}

	return distance;
    }
}
