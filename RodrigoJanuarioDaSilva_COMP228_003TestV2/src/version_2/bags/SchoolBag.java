package version_2.bags;

import version_2.items.Item;
import version_2.items.supplies.school.SchoolSupply;

public class SchoolBag extends ZipperBag {
	private boolean waterProof;

	public SchoolBag(int maxCapacity, String color, BagMaterial material, ZipperMaterial zipperMaterial, boolean waterProof) {
		super(maxCapacity, color, material, zipperMaterial);
		this.waterProof = waterProof;
		this.purpose = BagPurpose.SCHOOL;
	}

	public boolean isWaterProof() {
		return waterProof;
	}

	@Override
	public void putItem(Item item) {
		if (item instanceof SchoolSupply) {
			itemList.add(item);
		} else {
			System.err.println("School bags only allows you putting school supplies.");
		}
	}
}
