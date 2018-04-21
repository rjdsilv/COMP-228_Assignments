package house_exercise_3;

import java.util.ArrayList;
import java.util.List;

import house_exercise_2.HouseComparable;

public class HouseDriver {

	public static void practiceCollectionsAndComparitor(int x, MessageHolder m) {
		m.setMessage( "Beginning");
		try {
			displayHouseWitComparitor(x);
		} catch (Exception ex) {
			System.err.println("An error occurred in 'practiceCollectionsAndComparitor' method: " + ex.getMessage());
		} finally {
			//TODO - Completed Exercise 3 - make sure the message commented out below is always set in Finally block
			m.setMessage(MessageHolder.FINALLY_MESSAGE);
		}
	}

	private static List<HouseComparable> displayHouseWitComparitor(int x) {
		List<HouseComparable> houseSet = new ArrayList<HouseComparable>();

		houseSet.add(new HouseComparable(200.00, "200"));
		houseSet.add(new HouseComparable(400.00, "400"));
		houseSet.add(new HouseComparable(100.00, "100"));
		houseSet.add(new HouseComparable(500.00, "500"));
		houseSet.add(new HouseComparable(900.00, "900"));
		houseSet.add(new HouseComparable(50.00, "50"));
		System.out.println(houseSet);
		System.out.println(houseSet.get(x));

		return houseSet;
	}

}
