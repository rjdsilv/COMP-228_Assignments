package stationary;

/**
 * Interface containing methods that allows implementors to write text and
 * retrieve already written text.
 * 
 * @author Rodrigo Januario da Silva
 */
public interface Writable {
	/**
	 * Method that will write the give text with a stationary.
	 * 
	 * @param text The text to be written.
	 */
	void write(String text);

	/**
	 * Gets all the written text by a stationary.
	 * 
	 * @return All the written text by a stationary.
	 */
	String getText();
}
