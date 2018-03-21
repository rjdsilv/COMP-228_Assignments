/**
 * 
 */
package stationary;

/**
 * Abstract class to be used as base for all kinds of Stationary in the application.
 * 
 * @author Rodrigo Januario da Silva
 */
public abstract class Stationary {
	protected String modelNumber;

	/**
	 * Creates a new Stationary with the given model number.
	 * 
	 * @param modelNumber
	 */
	Stationary(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	/**
	 * Gets the stationary model number.
	 * 
	 * @return The stationary model number.
	 */
	public String getModelNumber() {
		return modelNumber;
	}

	// TODO Check with the teacher if this method is really necessary!!!
	public static String doSomething() {
		return "Doing something now";
	}

	/**
	 * Method that will describe what the actual Stationary is.
	 * 
	 * @return The stationary's description.
	 */
	protected abstract String describe();
}
