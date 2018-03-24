package version_2.bags;

import version_2.items.Item;
import version_2.items.clothes.Clothes;

public class TravelBag extends ZipperBag {
	private boolean hasWheels;

	public TravelBag(int maxCapacity, String color, BagMaterial material, ZipperMaterial zipperMaterial, boolean hasWheels) {
		super(maxCapacity, color, material, zipperMaterial);
		this.hasWheels = hasWheels;
		this.purpose = BagPurpose.TRAVEL;
	}

	public boolean isHasWheels() {
		return hasWheels;
	}

	@Override
	public void putItem(Item item) {
		if (item instanceof Clothes) {
			itemList.add(item);
		} else {
			System.err.println("Travel bags only allows you putting office supplies.");
		}
	}
}
