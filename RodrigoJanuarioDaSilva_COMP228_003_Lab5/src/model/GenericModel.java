package model;

/**
 * Generic model class to be used by all the application tables.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public abstract class GenericModel {
	protected int id;

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
}
