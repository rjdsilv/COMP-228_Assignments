package house_exercise_2;

import java.util.ArrayList;
import java.util.List;

public class HouseDriver {
	
	public static List<HouseComparable> practiceCollectionsAndComparitor(int x, Object o){
		//TODO - Completed Exercise 2 - surround this  method call with try statement
		//provide multicatch block where you will handle both exceptions in the same way
		//types of exceptions to handle:
		//IndexOutOfBound and ClassCastException
		try {
			displayHouseWitComparitor(x, o);
		} catch (IndexOutOfBoundsException | ClassCastException ex) {
			//TODO - Completed Exercise 2 - display error in console ( add to the message - "I will rethrow this exception now."
			//then rethrow the exception.
			//do not allow user to continue the program
			System.err.println("An error occurred in 'practiceCollectionsAndComparitor' method: " +
					ex.getMessage() + ". I will rethrow this exception now.");
			throw ex;
		}
		
		return null;
	}

	private static  List<HouseComparable> displayHouseWitComparitor(int x, Object o) {
		List<HouseComparable> houseSet = new ArrayList<HouseComparable>();

		houseSet.add(new HouseComparable(200.00, "200"));
		houseSet.add(new HouseComparable(400.00, "400"));
		houseSet.add(new HouseComparable(100.00, "100"));
		houseSet.add(new HouseComparable(500.00, "500"));
		houseSet.add(new HouseComparable(900.00, "900"));
		houseSet.add(new HouseComparable(50.00, "50"));
		System.out.println(houseSet);
		System.out.println(houseSet.get(x));

		System.out.println(((House) o).getPrice());
		
		return houseSet;
	}

}
