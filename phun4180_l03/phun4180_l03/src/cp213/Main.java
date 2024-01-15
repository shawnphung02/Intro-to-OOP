package cp213;

import java.time.LocalDate;

/**
 * Tests the Student class.
 *
 * @author Shawn Phung
 * @version 2022-10-03
 */
public class Main {

    public static void main(String[] args) {
	final String line = "-".repeat(40);
	int id = 123456;
	String surname = "Brown";
	String forename = "David";
	LocalDate birthDate =  LocalDate.parse("1962-10-25");
	Student student = new Student(id, surname, forename, birthDate);
	System.out.println("New Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test Getters");

	// call getters here
	String studentSurname = student.getSurname();
	String studentForename = student.getForename();
	LocalDate studentBirthDate = student.getBirthDate();
	int studentId = student.getId();
	String string = ("Name:      " + studentSurname + ", " + studentForename + "\nID:        " + studentId + "\nBirthdate: " + studentBirthDate);
	System.out.println(string);

	System.out.println(line);
	System.out.println("Test Setters");

	// call setters here
	student.setSurname("Phung");
	student.setForename("Caine");
	student.setId(162534);
	student.setBirthDate(LocalDate.parse("1994-12-25"));
	
	System.out.println("Updated Student:");
	System.out.println(student);
	System.out.println(line);
	System.out.println("Test compareTo");

	// create new Students - call comparisons here
	String newSurname = "Phung";
	String newForename = "Shawn";
	LocalDate newBirthDate = LocalDate.parse("2002-06-03");
	int newId = 567890;
	Student student2 = new Student(newId, newSurname, newForename, newBirthDate);
	// compare students
	int compare = student.compareTo(student2);
	// output
	System.out.println("\nNew Student:");
	System.out.println(student2);
	System.out.println("\nCompare: " + compare);
    }

}
