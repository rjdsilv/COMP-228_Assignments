/**
 * 
 */
package exercise2;

/**
 * Class containing the necessary functionality for handling different dishes and its preparations.
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
	
	// The Dish recipe.
	private Recipe recipe;
	
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
	
	/** Gets the dish's recipe.
	 * @return the dish's recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * Sets the dish's recipe.
	 * @param recipe the recipe to set
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * This method provides the dish information in the following format.
	 *      Name       : The name of the dish.
	 *      Serves     : The number of servings.
	 *      Description: The dish's description.
	 *      Ingredients: The dish's ingredients.
	 *      Preparation: The dish's preparation.
	 * @return The dish information as described.
	 */
	public String getDishInformation() {
		return String.format("%nHere is the dish you just created!%n"
				+ "Name       : %s%n"
				+ "Serves     : %d%n"
				+ "Description: %s%n"
				+ "Ingredients: %s%n"
				+ "Preparation: %s%n%n", name, servings, description, recipe.getIngredients(), recipe.getPreparation());
	}
}
