/**
 * 
 */
package exercise1;

/**
 * Class containing the necessary functionality for handling different dishes.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class Dish {
	// The dish name.
	private String name;
	
	// The dish description.
	private String description;
	
	// The number people this dish can serve.
	private int servings;
	
	// The country related to the dish.
	private String country;
	
	// The dish sale price.
	private float price;
	
	/**
	 * Dish default constructor.
	 */
	public Dish() {
	}

	/**
	 * Gets the dish's name
	 * @return the dish's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the dish's name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the dish's description
	 * @return the dish's description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the dish's description
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the dish's number of servings.
	 * @return the dish's number of servings.
	 */
	public int getServings() {
		return servings;
	}

	/**
	 * Sets the number of servings for the dish.
	 * @param servings the servings to set
	 */
	public void setServings(int servings) {
		this.servings = servings;
	}

	/**
	 * Gets the dish's related country.
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the related country for the dish.
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the dish's sale price.
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * Sets the sale price for the dish.
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * This method provides the dish information in the following format.
	 *      Name       : The name of the dish.
	 *      Serves     : The number of servings.
	 *      Country    : The related country.
	 *      Price      : The sale price. 
	 *      Description: The dish's description.
	 * @return The dish information as described.
	 */
	public String getDishInformation() {
		return String.format("%nHere is the dish you just created!%n"
				+ "Name       : %s%n"
				+ "Serves     : %d%n"
				+ "Country    : %s%n"
				+ "Price      : $%.2f%n"
				+ "Description: %s%n%n", name, servings, country, price, description);
	}
}
