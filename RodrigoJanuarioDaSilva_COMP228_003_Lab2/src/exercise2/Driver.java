/**
 * 
 */
package exercise2;

import java.security.SecureRandom;
import java.util.List;

import exercise1.Door;
import exercise1.House;
import exercise1.Room;
import exercise1.RoomType;

/**
 * Application's driver class containing the necessary logic.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public final class Driver {
	private static final int ROOM_TYPE_BOUND = 6;
	/**
	 * Main method called on the application starts.
	 * 
	 * @param args The arguments from the command line.
	 */
	public static void main(String[] args) {
		try {
			final House house = new House();
	
			// Setting the house's front door.
			house.setDoor("White", Door.Material.WOOD, 2);
	
			// Setting all the house's rooms.
			house.addRoom(createRoom(50));
			house.addRoom(createRoom(25));
			house.addRoom(createRoom(40));
			house.addRoom(createRoom(55));
			house.addRoom(createRoom(15));

			// Prints the information about the house's rooms.
			printHouseInfo(house.getAllRooms(), false);
			
			// Prints the information about the house's front door.
			printHouseInfo(house.getFrontDoor());
			
			// Removes one room from the house and print the information again.
			house.removeRoom(RoomType.KITCHEN);
			printHouseInfo(house.getAllRooms(), true);
		} catch (Throwable t) {
			System.err.println("########## ERROR: An unexpected error occured on the application!!!");
			t.printStackTrace();
		}
	}

	/**
	 * Creates a room with the given size with its type generated randomly.
	 * 
	 * @param size The room's size.
	 * @return The room created with the given size and the type randomly generated.
	 */
	private static Room createRoom(int size) {
		final SecureRandom random = new SecureRandom();
		return new Room(RoomType.fromNumber(random.nextInt(ROOM_TYPE_BOUND)), size);
	}

	/**
	 * Prints the information about the house's door.
	 * 
	 * @param door The door to have the information printed.
	 */
	private static void printHouseInfo(Door door) {
		printHeaderSeparator();
		System.out.println("#####             D O O R   I N F O R M A T I O N             #####");
		printHeaderSeparator();
		System.out.printf("## Color: %s, Material: %s, Number of Locks: %d%n%n",
				door.getColor(), door.getMaterial(), door.getNumOfLocks());
	}

	/**
	 * Prints the information about all the house's rooms.
	 * 
	 * @param rooms The rooms to have the information printed.
	 */
	private static void printHouseInfo(List<Room> rooms) {
		for (Room r : rooms) {
			System.out.printf("## Type: %11s, Size: %4d%n", r.getType().getName(), r.getSize());
		}
		System.out.println();
	}

	/**
	 * Prints the information about all the house's rooms.
	 * 
	 * @param rooms The rooms to have the information printed.
	 * @param deletedRoom Indicates if any room was deleted to have a different header.
	 */
	private static void printHouseInfo(List<Room> rooms, boolean deletedRoom) {
		// Prints the header.
		printHeaderSeparator();
		System.out.println("#####             R O O M   I N F O R M A T I O N             #####");
		if (deletedRoom) {
			System.out.println("#####               A F T E R   D E L E T I O N               #####");
		}

		printHeaderSeparator();
		printHouseInfo(rooms);
	}

	/**
	 * Prints the header separator.
	 */
	private static void printHeaderSeparator() {
		System.out.println("###################################################################");
	}
}
