/**
 * 
 */
package exercise1;

/**
 * Enumeration containing all the available types of rooms for the application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public enum RoomType {
	UNKNOWN("Unknown"),
	STUDY("Study Room"),
	BEDROOM("Bedroom"),
	BATHROOM("Bathroom"),
	KITCHEN("Kitchen"),
	DINNERROOM("Dinner Room"),
	LIVINGROOM("Living Room");

	// The room name
	private String name;

	/**
	 * Creates the RoomType using the specific name.
	 * 
	 * @param name The name to be set.
	 */
	private RoomType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public static RoomType fromNumber(int number) {
		switch(number) {
			case 0: return RoomType.STUDY;
			case 1: return RoomType.BEDROOM;
			case 2: return RoomType.BATHROOM;
			case 3: return RoomType.KITCHEN;
			case 4: return RoomType.DINNERROOM;
			case 5: return RoomType.LIVINGROOM;
		}
		return RoomType.UNKNOWN;
	}
}
