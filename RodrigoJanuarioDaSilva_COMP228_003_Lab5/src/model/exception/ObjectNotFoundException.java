/**
 * 
 */
package model.exception;

/**
 * Exception class to be used in the application when an object cannot be found on the database.
 * 
 * @author Rodrigo Januario da Silva.
 * @version 1.0.0
 */
public final class ObjectNotFoundException extends Exception {
	private static final long serialVersionUID = -7594967234990962101L;

	/**
	 * Default Constructor. 
	 */
	public ObjectNotFoundException() {
	}

	/**
	 * Creates an instance of ObjectNotFoundException with the given message.
	 * 
	 * @param message The exception message to be shown.
	 */
	public ObjectNotFoundException(String message) {
		super(message);
	}


	/**
	 * Creates an instance of ObjectNotFoundException with the given message and the given cause.
	 * 
	 * @param message The exception message to be shown.
	 * @param cause The exception that caused this exception to be thrown.
	 */
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
