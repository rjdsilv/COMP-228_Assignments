/**
 * 
 */
package exercise1;

/**
 * Class representing a house room.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class Room {
	// The room type.
	private RoomType type;

	// The room size.
	private int size;

	/**
	 * Room Constructor.
	 * 
	 * @param type The type to be set.
	 * @param size The size to be set.
	 */
	public Room(RoomType type, int size) {
		this.type = type;
		this.size = size;
	}

	/**
	 * Gets the room's type.
	 * @return the room's type.
	 */
	public RoomType getType() {
		return type;
	}

	/**
	 * Gets the room's size.
	 * @return the room's size.
	 */
	public int getSize() {
		return size;
	}
}
