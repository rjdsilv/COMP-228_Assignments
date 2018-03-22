/**
 * 
 */
package stationary;

import java.util.Scanner;

import javax.swing.JOptionPane;

import stationary.Crayon.Color;
import stationary.Pen.Type;
import stationary.Pencil.Hardness;

/**
 * Class that will manage the stationaries and the desk on the application.
 * 
 * @author Rodrigo Januario da Silva
 */
public class Manager {
	/**
	 * This method will display the contents on the desk. I am using desk class instead of
	 * a list of Stationaries because the desk class has logic to deal with capacity.
	 * 
	 * @param desk The desk to be managed.
	 */
	static void whatIsOnTheDesk(Desk desk) {
		desk.getItemList().forEach(item -> System.out.println(item.describe()));
	}

	/**
	 * Gets all the items on the desk and erases all the erasable items.
	 * 
	 * @param desk The desk to be managed.
	 */
	static void eraseAllThatsRequired(Desk desk) {
		desk.getItemList().forEach(item -> {
			if (item instanceof Erasable) {
				((Erasable) item).erase();
			}
		});
	}
	
	/**
	 * Method that will ask for the user to choose the items to be on the desk.
	 * 
	 * @param desk The desk where the items will be put.
	 */
	static void askUserToChooseTheItemsToBeOnTheDesk(Desk desk) {
		// The scanner will be closed automatically after this try-with-resources.
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("First, let's choose what items will be on the desk. A numbered list for each item will be presented. Choose by the item number");
			desk.addItem(choosePen(scanner));
			desk.addItem(choosePencil(scanner));
			desk.addItem(chooseCrayon(scanner));
			desk.addItem(chooseEraser(scanner));
			System.out.println();
		}
	}
	
	/**
	 * Method that will ask for the user to choose a valid pen to be displayed on the desk.
	 * 
	 * @param scanner The scanner to read the user's input.
	 * @return The user's pen of choice.
	 */
	private static Pen choosePen(Scanner scanner) {
		// Displaying the pens to be selected.
		System.out.println("\nSelect the pen to be on the desk:");
		for (int i = 0; i < Type.values().length; i++) {
			System.out.println(String.format("\t%d) Model Number %s - %s", i + 1, Type.values()[i].getModel(), Type.values()[i].getName()));
		}

		int itemNumber;
		do {
			System.out.print("Pen Number: ");
			itemNumber = scanner.nextInt();
			scanner.nextLine(); // Removes the line feed from the input.
			
			if ((itemNumber <= 0) || (itemNumber > Type.values().length)) {
				JOptionPane.showMessageDialog(
						null,
						String.format("The pen number %d is invalid. Please, select a valid pen number.", itemNumber),
						"Invalid Pen Selected",
						JOptionPane.WARNING_MESSAGE
				);
			}
		} while ((itemNumber <= 0) || (itemNumber > Type.values().length));

		final Type selectedType = Type.values()[itemNumber - 1];
		return new Pen(selectedType.getModel(), selectedType);
	}
	
	/**
	 * Method that will ask for the user to choose a valid pencil to be displayed on the desk.
	 * 
	 * @param scanner The scanner to read the user's input.
	 * @return The user's pencil of choice.
	 */
	private static Pencil choosePencil(Scanner scanner) {
		// Displaying the pencils to be selected.
		System.out.println("\nSelect the pencil to be on the desk:");
		for (int i = 0; i < Hardness.values().length; i++) {
			System.out.println(String.format("\t%d) Model Number %s - %s", i + 1, Hardness.values()[i].getModel(), Hardness.values()[i].getName()));
		}

		int itemNumber;
		do {
			System.out.print("Pencil Number: ");
			itemNumber = scanner.nextInt();
			scanner.nextLine(); // Removes the line feed from the input.
			
			if ((itemNumber <= 0) || (itemNumber > Hardness.values().length)) {
				JOptionPane.showMessageDialog(
						null,
						String.format("The pencil number %d is invalid. Please, select a valid pencil number.", itemNumber),
						"Invalid Pencil Selected",
						JOptionPane.WARNING_MESSAGE
				);
			}
		} while ((itemNumber <= 0) || (itemNumber > Hardness.values().length));

		final Hardness selectedHardness = Hardness.values()[itemNumber - 1];
		return new Pencil(selectedHardness.getModel(), selectedHardness);
	}

	/**
	 * Method that will ask for the user to choose a valid crayon to be displayed on the desk.
	 * 
	 * @param scanner The scanner to read the user's input.
	 * @return The user's crayon of choice.
	 */
	private static Crayon chooseCrayon(Scanner scanner) {
		// Displaying the crayons to be selected.
		System.out.println("\nSelect the crayon to be on the desk:");
		for (int i = 0; i < Color.values().length; i++) {
			System.out.println(String.format("\t%d) Model Number %s - %s", i + 1, Color.values()[i].getModel(), Color.values()[i].getName()));
		}

		int itemNumber;
		do {
			System.out.print("Crayon Number: ");
			itemNumber = scanner.nextInt();
			scanner.nextLine(); // Removes the line feed from the input.
			
			if ((itemNumber <= 0) || (itemNumber > Color.values().length)) {
				JOptionPane.showMessageDialog(
						null,
						String.format("The pencil number %d is invalid. Please, select a valid pencil number.", itemNumber),
						"Invalid Pencil Selected",
						JOptionPane.WARNING_MESSAGE
				);
			}
		} while ((itemNumber <= 0) || (itemNumber > Color.values().length));

		final Color selectedColor = Color.values()[itemNumber - 1];
		return new Crayon(selectedColor.getModel(), selectedColor);
	}

	/**
	 * Method that will ask for the user to choose a valid eraser to be displayed on the desk.
	 * 
	 * @param scanner The scanner to read the user's input.
	 * @return The user's eraser of choice.
	 */
	private static Eraser chooseEraser(Scanner scanner) {
		// Displaying the erasers to be selected.
		System.out.println("\nSelect the eraser to be on the desk:");
		for (int i = 0; i < Eraser.MODELS.length; i++) {
			System.out.println(String.format("\t%d) Model Number %s", i + 1, Eraser.MODELS[i]));
		}

		int itemNumber;
		do {
			System.out.print("Eraser Number: ");
			itemNumber = scanner.nextInt();
			scanner.nextLine(); // Removes the line feed from the input.
			
			if ((itemNumber <= 0) || (itemNumber > Eraser.MODELS.length)) {
				JOptionPane.showMessageDialog(
						null,
						String.format("The pencil number %d is invalid. Please, select a valid pencil number.", itemNumber),
						"Invalid Pencil Selected",
						JOptionPane.WARNING_MESSAGE
				);
			}
		} while ((itemNumber <= 0) || (itemNumber > Eraser.MODELS.length));

		return new Eraser(Eraser.MODELS[itemNumber - 1]);
	}
}
