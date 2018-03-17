package application;

/**
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public enum Sex {
	MALE("Male"),
	FEMALE("Female");
	
	// The sex stored.
	private String sex;
	
	/**
	 * Private constructor for the enumeration.
	 * @param sex The sex to be set.
	 */
	private Sex(String sex) {
		this.sex = sex;
	}
	
	/**
	 * Returns the sex as string
	 * @return The sex as string
	 */
	@Override
	public String toString() {
		return sex;
	}
}
