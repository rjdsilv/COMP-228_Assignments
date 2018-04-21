package house_exercise_1;

import java.util.TreeSet;

public class HouseDriver {
	
	public static TreeSet<HouseComparable> practiceCollectionsAndComparitor(){
		//TODO - Completed Exercise 1 - PART 1 - handle exception for the below method.
		//display error in console but allow user to continue executing the program.
		//do not exit the application. list of houses from the second method should be displayed.
		try {
			displayHouseWithoutComparitor();
		} catch (Exception ex) {
			//TODO - Completed Exercise 1 - PART 2 - print error that you handled above in red color in Console
			System.err.println("An error occurred in 'displayHouseWithoutComparitor' method: " + ex.getMessage());
		}
		
		return displayHouseWitComparitor();
	}

	private static  TreeSet<HouseComparable> displayHouseWitComparitor() {
		TreeSet<HouseComparable> houseSet = new TreeSet<HouseComparable>();
		houseSet.add(new HouseComparable(200.00, "200"));
		houseSet.add(new HouseComparable(400.00, "400"));
		houseSet.add(new HouseComparable(100.00, "100"));
		houseSet.add(new HouseComparable(500.00, "500"));
		houseSet.add(new HouseComparable(900.00, "900"));
		houseSet.add(new HouseComparable(50.00, "50"));
		System.out.println(houseSet);
		return houseSet;
	}

	public static void displayHouseWithoutComparitor() throws ClassCastException{
			TreeSet<House> houseSet = new TreeSet<House>();
			houseSet.add(new House(200.00, "200"));
			houseSet.add(new House(400.00, "400"));
			houseSet.add(new House(100.00, "100"));
			houseSet.add(new House(500.00, "500"));
			houseSet.add(new House(900.00, "900"));
			houseSet.add(new House(50.00, "50"));
			System.out.println(houseSet);
	}

}
