/**
 * 
 */
package exercise2;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Driver class for creating new dishes
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class DishWithRecipeDriver {
	private static final String NO = "no";
	private static final String YES = "yes";

	/**
	 * Main method called by the JVM.
	 * @param args The arguments from the command line.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String userResponse = "";
		
		// Gets the information from the user.
		while (!NO.equalsIgnoreCase(userResponse)) {
			// Gets the user response whether he / she want to create a new dish or not.
			System.out.println("Do you want to create a new dish? (Type 'yes' or 'no' and press Enter)");
			userResponse = scanner.nextLine();
			
			if (YES.equalsIgnoreCase(userResponse)) {
				Dish dish = new Dish();

				// Getting the dish's name.
				System.out.println("Please, provide the dish's name:");
				dish.setName(scanner.nextLine());
	
				// Getting the dish's description.
				System.out.println("Please, provide the dish's description:");
				dish.setDescription(scanner.nextLine());
	
				// Getting the dish's number of servings.
				System.out.println("Please, provide the dish's number of servings:");
				dish.setServings(scanner.nextInt());
				
				// Gets information about the Dish's recipe.
				String ingredients = JOptionPane.showInputDialog(null, "Please provide the list of ingredients:", "List of Ingredients", JOptionPane.QUESTION_MESSAGE);
				String preparation = JOptionPane.showInputDialog(null, "Please provide the the steps on how to prepare the dish:", "Preparation", JOptionPane.QUESTION_MESSAGE);
				dish.setRecipe(new Recipe(ingredients, preparation));
				
				// Getting the remaining line break if it's there
				if (scanner.hasNextLine()) {
					scanner.nextLine();
				}
				
				System.out.print(dish.getDishInformation());
			}
		}
		
		System.out.println("As you decided you no longer want to create dishes, the program is exiting!");
		scanner.close();
	}
}
