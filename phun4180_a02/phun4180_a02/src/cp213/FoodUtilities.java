package cp213;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Utilities for working with Food objects.
 *
 * @author Shawn Phung, 200814180, phun4180@mylaurier.ca
 * @version 2022-10-04
 */
public class FoodUtilities {

    /**
     * Determines the average calories in a list of foods. No rounding necessary.
     * Foods list parameter may be empty.
     *
     * @param foods a list of Food
     * @return average calories in all Food objects
     */
    public static int averageCalories(final ArrayList<Food> foods) {
    
    int average, total = 0;
    // Iterate and increase total calories
	for(int i = 0; i < foods.size(); i++) {
		total += foods.get(i).getCalories();
	}
	// Calculate average calories
	average = total / foods.size();

	return average;
    }

    /**
     * Determines the average calories in a list of foods for a particular origin.
     * No rounding necessary. Foods list parameter may be empty.
     *
     * @param foods  a list of Food
     * @param origin the origin of the Food
     * @return average calories for all Foods of the specified origin
     */
    public static int averageCaloriesByOrigin(final ArrayList<Food> foods, final int origin) {
    
    int total = 0, average;	
    // Get list of Food by origin
    ArrayList<Food> foodsByOrigin = FoodUtilities.getByOrigin(foods, origin);
	// Iterate through list
    for(int i = 0; i < foodsByOrigin.size(); i++) {
    	total += foodsByOrigin.get(i).getCalories();
    }
    // Calculate average
    average = total / foodsByOrigin.size();
    
    return average;
    }

    /**
     * Creates a list of foods by origin.
     *
     * @param foods  a list of Food
     * @param origin a food origin
     * @return a list of Food from origin
     */
    public static ArrayList<Food> getByOrigin(final ArrayList<Food> foods, final int origin) {
    ArrayList<Food> foodsByOrigin = new ArrayList<Food>();
    
	// Iterate through Foods
    for(int i = 0; i < foods.size(); i++) {
    	// Matching origins
    	if(foods.get(i).getOrigin() == origin) {
    		// Get data on food item
    		String newName = foods.get(i).getName();
    		int newOrigin = foods.get(i).getOrigin();
    		boolean newVeg = foods.get(i).isVegetarian();
    		int newCals = foods.get(i).getCalories();
    		// Create new food item
    		Food newFood = new Food(newName, newOrigin, newVeg, newCals);
    		// Add to foodsByOrigin list
    		foodsByOrigin.add(newFood);
    	}
    }
	return foodsByOrigin;
    }

    /**
     * Creates a Food object by requesting data from a user. Uses the format:
     *
     * <pre>
    Name: name
    Origins
     0 Canadian
     1 Chinese
    ...
    11 English
    Origin: origin number
    Vegetarian (Y/N): Y/N
    Calories: calories
     * </pre>
     *
     * @param keyboard a keyboard Scanner
     * @return a Food object
     */
    public static Food getFood(final Scanner keyboard) {
    boolean isVegetarian;
    // Get name
	System.out.print("Name: ");
	String name = keyboard.next();
	// Get origin
	System.out.print(Food.originsMenu());
	System.out.print("Origin: ");
	int origin = Integer.parseInt(keyboard.next());
	// Get vegetarian
	System.out.print("Vegetarian (Y/N): ");
	String tempVege = keyboard.next();
	if(tempVege.compareToIgnoreCase("y") == 0) {
		isVegetarian = true;
	}else {
		isVegetarian = false;
	}
	// Get calories
	System.out.print("Calories: ");
	int calories = Integer.parseInt(keyboard.next());
	
	// Create new Food object
	Food newFood = new Food(name, origin, isVegetarian, calories);
	
	return newFood;
    }

    /**
     * Creates a list of vegetarian foods.
     *
     * @param foods a list of Food
     * @return a list of vegetarian Food
     */
    public static ArrayList<Food> getVegetarian(final ArrayList<Food> foods) {
    ArrayList<Food> vegFood = new ArrayList<Food>();
    
	// Iterate through list
    for(int i = 0; i < foods.size(); i++) {
    	// Vegetarian option
    	if(foods.get(i).isVegetarian() == true) {
    		// Get data from list
    		String name = foods.get(i).getName();
    		int origin = foods.get(i).getOrigin();
    		boolean isVeg = foods.get(i).isVegetarian();
    		int calories = foods.get(i).getCalories();
    		// Create new food item
    		Food newFood = new Food(name, origin, isVeg, calories);
    		// Add new food to list
    		vegFood.add(newFood);
    	}
    }

	return vegFood;
    }

    /**
     * Creates and returns a Food object from a line of string data.
     *
     * @param line a vertical bar-delimited line of food data in the format
     *             name|origin|isVegetarian|calories
     * @return the data from line as a Food object
     */
    public static Food readFood(final String line) {
    // Split String
    String[] list = line.split("\\|+");
	// Get variables
	String name = list[0];
	int origins = Integer.parseInt(list[1]);
	boolean isVegetarian = Boolean.parseBoolean(list[2]);
	int calories = Integer.parseInt(list[3]);
	// Create new Food object
	Food newFood = new Food(name, origins, isVegetarian, calories);

	return newFood;
    }

    /**
     * Reads a file of food strings into a list of Food objects.
     *
     * @param fileIn a Scanner of a Food data file in the format
     *               name|origin|isVegetarian|calories
     * @return a list of Food
     */
    public static ArrayList<Food> readFoods(final Scanner fileIn) {
    // Declare variables
    ArrayList<Food> foods = new ArrayList<Food>();
    String line;
    // Iterate through file
	while(fileIn.hasNextLine()) {
		line = fileIn.nextLine();
		// Add to Food array
		foods.add(readFood(line));
	}

	return foods;
    }

    /**
     * Searches for foods that fit certain conditions.
     *
     * @param foods        a list of Food
     * @param origin       the origin of the food; if -1, accept any origin
     * @param maxCalories  the maximum calories for the food; if 0, accept any
     * @param isVegetarian whether the food is vegetarian or not; if false accept
     *                     any
     * @return a list of foods that fit the conditions specified
     */
    public static ArrayList<Food> foodSearch(final ArrayList<Food> foods, final int origin, final int maxCalories,
	    final boolean isVegetarian) {
    ArrayList<Food> result = new ArrayList<Food>();
	// Iterate through list
    for(int i = 0; i < foods.size(); i++) {
    	// Matching origin or origin = -1
    	if(origin == -1 || foods.get(i).getOrigin() == origin) {
    		// Matches calorie count or maxCalories = 0
    		if(maxCalories == 0 || foods.get(i).getCalories() <= maxCalories) {
    			// isVegetarian or no preference
    			if(isVegetarian == false || foods.get(i).isVegetarian() == isVegetarian) {
    				// Everything matches, get data
    				String name = foods.get(i).getName();
    				boolean isVeg = foods.get(i).isVegetarian();
    				int cals = foods.get(i).getCalories();
    				// Create food object and add to list
    				Food newFood = new Food(name, origin, isVeg, cals);
    				result.add(newFood);
    			}
    		}
    	}
    	
    }
	return result;
    }

    /**
     * Writes the contents of a list of Food to a PrintStream.
     *
     * @param foods a list of Food
     * @param ps    the PrintStream to write to
     */
    public static void writeFoods(final ArrayList<Food> foods, PrintStream ps) {

	// your code here

    }
}
