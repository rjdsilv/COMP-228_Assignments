package version_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import version_2.bags.Bag;
import version_2.bags.BagMaterial;
import version_2.bags.BagPurpose;
import version_2.bags.SchoolBag;
import version_2.bags.SuiteCase;
import version_2.bags.ZipperMaterial;
import version_2.items.Item;
import version_2.items.clothes.Pants;
import version_2.items.clothes.Skirt;
import version_2.items.clothes.TShirt;
import version_2.items.supplies.office.Laptop;
import version_2.items.supplies.office.SheafferPen;
import version_2.items.supplies.school.Notebook;
import version_2.items.supplies.school.SimplePen;
import version_2.bags.SuiteCase.SuiteCaseType;
import version_2.bags.TravelBag;

public class Driver {
	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);
		final List<Bag> myBags = new ArrayList<>(6);
		myBags.add(new SchoolBag(4, "Blue", BagMaterial.FABRIC, ZipperMaterial.PLASTIC, false));
		myBags.add(new SchoolBag(10, "Black", BagMaterial.LEATHER, ZipperMaterial.METAL, true));
		myBags.add(new SuiteCase(5, "Brown", BagMaterial.FABRIC, ZipperMaterial.PLASTIC, SuiteCaseType.CASUAL));
		myBags.add(new SuiteCase(11, "Black", BagMaterial.LEATHER, ZipperMaterial.METAL, SuiteCaseType.FORMAL));
		myBags.add(new TravelBag(15, "Red", BagMaterial.FABRIC, ZipperMaterial.PLASTIC, false));
		myBags.add(new TravelBag(30, "Red", BagMaterial.PLASTIC, ZipperMaterial.METAL, true));
		
		// Selecting the number of items to carry
		System.out.println("How many items do you want to take with you?");
		int numberOfItems = scanner.nextInt();
		scanner.nextLine(); // removing the \n from the input.
		
		// Selecting the bag purpose
		System.out.println("For what purpose you want a bag: Travel, Work, or School?");
		String purpose = scanner.nextLine();
		BagPurpose bagPurpose;
		switch(purpose.toUpperCase()) {
		case "TRAVEL":
			bagPurpose = BagPurpose.TRAVEL;
			break;
		case "WORK":
			bagPurpose = BagPurpose.WORK;
			break;
		case "SCHOOL":
			bagPurpose = BagPurpose.SCHOOL;
			break;
		default:
			bagPurpose = BagPurpose.TRAVEL;
		}
		
		Bag chosenBag = findAppropriateBag(myBags, numberOfItems, bagPurpose);
		List<Item> bagItems = new ArrayList<>();
		if (null == chosenBag) {
			System.out.println("You have no bag that attend your needs!!!");
		} else {
			System.out.println(String.format("You got the bag: %s that carries %d items", chosenBag.getClass().getSimpleName(), chosenBag.getMaxCapacity()));
			switch(chosenBag.getPurpose()) {
			case SCHOOL:
				addSchoolItems(bagItems, numberOfItems);
				break;
			case WORK:
				addWorkItems(bagItems, numberOfItems);
				break;
			case TRAVEL:
				addTravelItems(bagItems, numberOfItems);
				break;
			}
			
			for (int i = 0; i < numberOfItems; i++) {
				System.out.println(String.format("Item %02d added: %s", i, bagItems.get(i).getClass().getSimpleName()));
			}
		}
		
		scanner.close();
	}
	
	private static void addTravelItems(List<Item> bagItems, int numberOfItems) {
		for (int i = 0; i < numberOfItems; i++) {
			if (i % 3 == 0) {
				bagItems.add(new Pants());
			} else if (i % 3 == 1) {
				bagItems.add(new TShirt());
			} else if (i % 3 == 2) {
				bagItems.add(new Skirt());
			}
		}
	}

	private static void addWorkItems(List<Item> bagItems, int numberOfItems) {
		for (int i = 0; i < numberOfItems; i++) {
			if (i % 2 == 0) {
				bagItems.add(new SheafferPen());
			} else if (i % 2 == 1) {
				bagItems.add(new Laptop());
			}
		}
	}

	private static void addSchoolItems(List<Item> bagItems, int numberOfItems) {
		for (int i = 0; i < numberOfItems; i++) {
			if (i % 2 == 0) {
				bagItems.add(new Notebook());
			} else if (i % 2 == 1) {
				bagItems.add(new SimplePen());
			}
		}
	}

	private static Bag findAppropriateBag(List<Bag> myBags, int numberOfItems, BagPurpose bagPurpose) {
		for (Bag bag : myBags) {
			if (bag.getPurpose() == bagPurpose && numberOfItems <= bag.getMaxCapacity()) {
				return bag;
			}
		}
		
		return null;
	}
}
