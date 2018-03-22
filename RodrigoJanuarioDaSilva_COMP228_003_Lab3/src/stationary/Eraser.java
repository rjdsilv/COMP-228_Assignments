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
	public static final String MODELS[] = {
			"ERS-8Y9K",
			"ERS-5W1F",
			"ERS-4R4K",
			"ERS-9G3R",
			"ERS-0L7T",
			"ERS-2K0P",
			"ERS-3V1J",
	};

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
