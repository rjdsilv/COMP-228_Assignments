package version_2.bags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import version_2.Closable;
import version_2.OpenCloseState;
import version_2.Openable;
import version_2.items.Item;

public abstract class Bag implements Openable, Closable {
	protected int maxCapacity;
	protected String color;
	protected BagMaterial bagMaterial;
	protected List<Item> itemList;
	protected OpenCloseState state;
	protected BagPurpose purpose;
	
	protected Bag(int maxCapacity, String color, BagMaterial bagMaterial) {
		this.maxCapacity = maxCapacity;
		this.color = color;
		this.bagMaterial = bagMaterial;
		this.itemList = new ArrayList<>(maxCapacity);
		this.state = OpenCloseState.CLOSED;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public String getColor() {
		return color;
	}

	public BagMaterial getBagMaterial() {
		return bagMaterial;
	}

	public OpenCloseState getState() {
		return state;
	}

	public List<Item> getItemList() {
		return Collections.unmodifiableList(itemList);
	}

	public BagPurpose getPurpose() {
		return purpose;
	}

	public void removeItem(Item item) {
		if (itemList.contains(item)) {
			itemList.remove(item);
		}
	}

	@Override
	public void open() {
		state = OpenCloseState.OPENED;
	}

	@Override
	public void close() {
		state = OpenCloseState.CLOSED;
	}

	public abstract void putItem(Item item);
}
