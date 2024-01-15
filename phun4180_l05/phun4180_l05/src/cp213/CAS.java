package cp213;

/**
 * Inherited class from the Professor Class.
 *
 * @author Shawn Phung
 * @version 2022-11-03
 */
public class CAS extends Professor {
	String term = null;
	
	public CAS(final String lastName, final String firstName, final String department, final String term) {
		super(lastName, firstName, department);
		this.term = term;	
	}
	
	// Return term
	public String getTerm() {
		return this.term;
	}

	/**
	* Creates formatted string version of CAS.
	*/
	@Override
	public String toString() {
		return(super.toString() + "\nTerm: " + this.term);
	}
}
