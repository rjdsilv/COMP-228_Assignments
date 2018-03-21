/**
 * 
 */
package stationary;

/**
 * Class that will represent an eraser in the application.
 * 
 * @author Rodrigo Januario da Silva
 */
public class Eraser extends Stationary {
	/**
	 * @param modelNumber
	 */
	public Eraser(String modelNumber) {
		super(modelNumber);
	}

	/*
	 * (non-Javadoc)
	 * @see stationary.Stationary#describe()
	 */
	@Override
	protected String describe() {
		return "This is a stationary product. " + toString();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Eraser model %s.", modelNumber);
	}
}
