/**
 * 
 */
package exercise1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class representing a house in the application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class House {
	// The rooms contained in the house.
	private List<Room> rooms;
	
	// The house's front door.
	private Door frontDoor;
	
	/**
	 * Default constructor.
	 */
	public House() {
		rooms = new ArrayList<>();
	}

	/**
	 * Adds a new room to the house.
	 * 
	 * @param room The room to be added.
	 */
	public void addRoom(Room room) {
		if (null != room) {
			if (!RoomType.UNKNOWN.equals(room.getType()) ) {
				rooms.add(room);
			} else {
				System.err.println("########## ERROR: The room to be added must have a known type!!!");
			}
		} else {
			System.err.println("########## ERROR: The room to add cannot be null!!!");
		}
	}
	
	/**
	 * Remove all the rooms that have the type passed as parameter.
	 * 
	 * @param type The room type to be removed.
	 */
	public void removeRoom(RoomType type) {
		if (null != type) {
			rooms.removeIf(filter -> type.equals(filter.getType()));
		} else {
			System.err.println("########## ERROR: The type to be removed cannot be null!!!");
		}
	}
	
	/**
	 * Sets the front door with the color, material, and number of locks given.
	 * 
	 * @param color The door's color.
	 * @param material The door's material.
	 * @param numOfLocks The door's number of locks.
	 */
	public void setDoor(String color, String material, int numOfLocks) {
		frontDoor = new Door(color, material, numOfLocks);
	}
	
	/**
	 * Gets the house's front door.
	 * 
	 * @return The house's front door.
	 */
	public Door getFrontDoor() {
		return frontDoor;
	}
	
	/**
	 * Returns all the house's rooms in a way that it cannot be modified by the caller.
	 * 
	 * @return All house's rooms.
	 */
	public List<Room> getAllRooms() {
		return Collections.unmodifiableList(rooms);
	}
}
