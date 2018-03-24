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

	/**
	 * Changing the doSomething method for getStopWritingChoiceText method to be called in the driver class.
	 *  
	 * @return The text You chose to stop writing!
	 */
	public static String getStopWritingChoiceText() {
		return "You chose to stop writing!";
	}

	/**
	 * Method that will describe what the actual Stationary is.
	 * 
	 * @return The stationary's description.
	 */
	protected abstract String describe();
}
