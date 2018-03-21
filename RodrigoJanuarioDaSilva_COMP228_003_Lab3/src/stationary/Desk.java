/**
 * 
 */
package stationary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class that will represent a desk in the application.
 * 
 * @author Rodrigo Januario da Silva
 */
public final class Desk {
	// The desk's maximum item capacity.
	private static final int MAX_CAPACITY = 4;

	// The list of items on the desk.
	private List<Stationary> itemList = new ArrayList<>();

	/**
	 * Add a new item on the desk as long as the maximum capacity is not reached.
	 * 
	 * @param item The item to be added.
	 * @return <b>true</b> if the item can be added. <b>false</b> otherwise.
	 */
	public boolean addItem(Stationary item) {
		if (itemList.size() < MAX_CAPACITY) {
			itemList.add(item);
			return true;
		}

		return false;
	}

	/**
	 * Gets the list of items on the desk. This list cannot be modified outside this class.
	 * 
	 * @return The list of items on the desk.
	 */
	public List<Stationary> getItemList() {
		return Collections.unmodifiableList(itemList);
	}
}
