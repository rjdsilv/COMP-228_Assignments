/**
 * 
 */
package stationary;

/**
 * Abstract class that will contain the common attributes and methods for
 * all the objects that can write.
 * 
 * @author Rodrigo Januario da Silva
 */
public abstract class AbstractWritable extends Stationary implements Writable {
	protected String text = "";

	/**
	 * Create an AbstractWritable with the given model.
	 * 
	 * @param modelNumber The Writable model.
	 */
	AbstractWritable(String modelNumber) {
		super(modelNumber);
	}

	/*
	 * (non-Javadoc)
	 * @see stationary.Writable#write(java.lang.String)
	 */
	@Override
	public void write(String text) {
		this.text += text + "\r\n";
	}

	/*
	 * (non-Javadoc)
	 * @see stationary.Writable#getText()
	 */
	@Override
	public String getText() {
		return text;
	}
}
