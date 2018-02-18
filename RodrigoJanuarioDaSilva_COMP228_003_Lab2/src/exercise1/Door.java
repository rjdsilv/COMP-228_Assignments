/**
 * 
 */
package exercise1;

/**
 * Class designed to represent house's door0.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public class Door {
	// The door color.
	private String color;

	// The door material.
	private String material;

	// The door number of locks.
	private int numOfLocks;
	
	/**
	 * Inner class containing the possible materials to be used on the doors.
	 */
	public static final class Material {
		public final static String METAL = "metal";
		public final static String WOOD = "wood";
		public final static String PLASTIC = "plastic";
	}

	/**
	 * Door constructor receiving all the fields.
	 * 
	 * @param color The color to be set.
	 * @param material The material to be set.
	 * @param numOfLocks The number of locks to be set.
	 */
	public Door(String color, String material, int numOfLocks) {
		super();
		this.color = color;
		this.material = material;
		this.numOfLocks = numOfLocks;
	}

	/**
	 * Gets the door's color
	 * @return the door'scolor
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Gets the door's material
	 * @return the door's material
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Gets the door's number of locks.
	 * @return the door's number of locks
	 */
	public int getNumOfLocks() {
		return numOfLocks;
	}
}
