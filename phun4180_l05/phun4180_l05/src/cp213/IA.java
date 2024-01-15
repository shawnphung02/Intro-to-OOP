package cp213;

/**
 * Inherited class from the Student Class.
 *
 * @author Shawn Phung
 * @version 2022-11-03
 */
public class IA extends Student {
	private String course = null;
	
	public IA(final String lastName, final String firstName, final String id, final String course) {
		super(lastName, firstName, id);
		this.course = course;
	}
	
	//Return course
    public String getCourse() {
    	return this.course;
    }
    
	/**
	* Creates formatted string version of CAS.
	*/
	@Override
	public String toString() {
		return(super.toString() + "\nCourse: " + course);
	}

}
