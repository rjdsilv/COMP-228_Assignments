/**
 * 
 */
package exercise1;

import java.util.Scanner;

/**
 * Driver class for creating new dishes
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class DishDriver {
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
