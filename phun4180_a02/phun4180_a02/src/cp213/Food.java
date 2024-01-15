package cp213;

import java.io.PrintStream;

/**
 * Food class definition.
 *
 * @author Shawn Phung, 200814180, phun4180@mylaurier.ca
 * @version 2022-10-15
 */
public class Food implements Comparable<Food> {

    // Constants
    public static final String ORIGINS[] = { "Canadian", "Chinese", "Indian", "Ethiopian", "Mexican", "Greek",
	    "Japanese", "Italian", "Moroccan", "Scottish", "Columbian", "English" };

    /**
     * Creates a string of food origins in the format:
     *
     * <pre>
    Origins
    0 Canadian
    1 Chinese
    ...
    11 English
     * </pre>
     *
     * @return A formatted numbered string of valid food origins.
     */
    public static String originsMenu() {
    // Create String
	String origins = "";
	
	// Iterate through array and add origin to String
	for (int i = 0; i < ORIGINS.length; i++) {
		origins +=  String.format("%2d %s%n",i, ORIGINS[i]);
	}

	return origins;
    }

    // Attributes
    private String name = null;
    private int origin = 0;
    private boolean isVegetarian = false;
    private int calories = 0;

    /**
     * Food constructor.
     *
     * @param name         food name
     * @param origin       food origin code
     * @param isVegetarian whether food is vegetarian
     * @param calories     caloric content of food
     */
    public Food(final String name, final int origin, final boolean isVegetarian, final int calories) {

	this.name = name;
	this.origin = origin;
	this.isVegetarian = isVegetarian;
	this.calories = calories;

	return;
    }

    /*
     * (non-Javadoc) Compares this food against another food.
     *
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    /**
     * Foods are compared by name, then by origin if the names match. Must ignore
     * case.
     */
    @Override
    public int compareTo(final Food target) {

	int result = 0;
	// Equal names, compare origins
	if(this.getName().compareToIgnoreCase(target.getName()) == 0) {
		// Equal origins and names, result = 0
		if(this.getOrigin() == (target.getOrigin())) {
			result = 0;
		}else {
		// Not equal origins but same name
			if(this.getOrigin() < target.getOrigin()) {
			// Target origin is higher
				result = -1;
			}else{
			// Target origin is lower
				result = 1;
			}
		}
	}else {
		// Different names
		result = this.getName().compareToIgnoreCase(target.getName());
		}
	
	return result;
    }

    /**
     * Getter for calories attribute.
     *
     * @return calories
     */
    public int getCalories() {
    return this.calories;
    }

    /**
     * Getter for name attribute.
     *
     * @return name
     */
    public String getName() {
    return this.name;
    }

    /**
     * Getter for origin attribute.
     *
     * @return origin
     */
    public int getOrigin() {
	return this.origin;
    }

    /**
     * Getter for string version of origin attribute.
     *
     * @return string version of origin
     */
    public String getOriginString() {
    	String origin = ORIGINS[this.origin];
    return origin;
    }

    /**
     * Getter for isVegetarian attribute.
     *
     * @return isVegetarian
     */
    public boolean isVegetarian() {
    return this.isVegetarian;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object//toString() Creates a formatted string of food data.
     */
    /**
     * Returns a string version of a Food object in the form:
     *
     * <pre>
    Name:       name
    Origin:     origin string
    Vegetarian: true/false
    Calories:   calories
     * </pre>
     */
    @Override
    public String toString() {

	//String food = String.format("Name: %13s%nOrigin: %11s%nVegetarian: %b%nCalories: %5d%n", this.getName(), this.getOriginString(), this.isVegetarian(), this.getCalories());
    String food;
    food = String.format("%-11s %s %n%-11s %s %n%-11s %s %n%-11s %d\n", "Name:", getName(), 
    		"Origin:", getOriginString(), "Vegetarian:", isVegetarian, "Calories", getCalories());
	return food;
    }
    
    /**
     * Writes a single line of food data to an open PrintStream. The contents of
     * food are written as a string in the format name|origin|isVegetarian|calories
     * to ps.
     *
     * @param ps The PrintStream to write to.
     */
    public void write(final PrintStream ps) {

	ps.println(String.format("%s|%d|%b|%d", name, origin, isVegetarian, calories));

	return;
    }

}