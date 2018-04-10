package model;

/**
 * Generic model class to be used by all the application tables.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public abstract class GenericModel {
	// Properties declaration.
	protected int id;

	/**
	 * Default Constructor.
	 */
	protected GenericModel() {
	}

	/**
	 * Constructor for the Model.
	 * 
	 * @param id The id to be set.
	 */
	protected GenericModel(int id) {
		this.id = id;
	}

	/**
	 * Getter for the id property.
	 * 
	 * @return The Model's id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter for the id property.
	 * 
	 * @param id The id to be set.
	 */
	public void setId(int id) {
		this.id = id;
	}
}
