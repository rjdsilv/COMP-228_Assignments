package stationary;

import javax.swing.JOptionPane;

public class Driver {
	public static void main(String[] args) {
		final Desk desk = new Desk();
		Manager.askUserToChooseTheItemsToBeOnTheDesk(desk);
		Manager.whatIsOnTheDesk(desk);
		
		int continueWriting;
		do {
			Manager.askUserForMessages(desk);
			Manager.displayMessages(desk);

			int eraseText = JOptionPane.showConfirmDialog(
					null, 
					"Do you want to erase everything that can be erased?", 
					"Erase Text",
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE
			);

			if (JOptionPane.YES_OPTION == eraseText) {
				Manager.eraseAllThatsRequired(desk);
				System.out.println("Text remaining after erasing:");
				Manager.displayMessages(desk);
			}
			
			continueWriting = JOptionPane.showConfirmDialog(
					null, 
					"Do you want to continue writing?", 
					"User Decision",
					JOptionPane.YES_NO_OPTION, 
					JOptionPane.QUESTION_MESSAGE
			);
		} while (JOptionPane.YES_OPTION == continueWriting);
		
		System.out.println("You chose to stop writing.");
		Manager.displayMessages(desk);
	}
}
