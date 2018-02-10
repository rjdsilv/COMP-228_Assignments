/**
 * 
 */
package exercise2;

/**
 * Class responsible for storing the ingredients and the preparation of a Dish.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class Recipe {
	// The recipe ingredients.
	private String ingredients;
	
	// The recipe preparation.
	private String preparation;
	
	/**
	 * Creates a new instance of a Recipe receiving the necessary ingredients and how to prepare it.
	 * 
	 * @param ingredients The Recipe's ingredients.
	 * @param preparation The Recipe's preparation.
	 */
	public Recipe(String ingredients, String preparation) {
		this.ingredients = ingredients;
		this.preparation = preparation;
	}

	/**
	 * Gets the Recipe's ingredients.
	 * @return the Recipe's ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}

	/** Gets the Recipe's preparation.
	 * @return the Recipe's preparation
	 */
	public String getPreparation() {
		return preparation;
	}
	
	
}
