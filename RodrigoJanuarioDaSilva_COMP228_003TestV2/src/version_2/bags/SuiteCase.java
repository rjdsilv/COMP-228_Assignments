package version_2.bags;

import version_2.items.Item;
import version_2.items.supplies.office.OfficeSupply;

public class SuiteCase extends ZipperBag {
	private String type;
	
	public static class SuiteCaseType {
		public static final String FORMAL = "Formal";
		public static final String CASUAL = "Casual";
	}

	public SuiteCase(int maxCapacity, String color, BagMaterial material, ZipperMaterial zipperMaterial, String type) {
		super(maxCapacity, color, material, zipperMaterial);
		this.type = type;
		this.purpose = BagPurpose.WORK;
	}

	public String getType() {
		return type;
	}

	@Override
	public void putItem(Item item) {
		if (item instanceof OfficeSupply) {
			itemList.add(item);
		} else {
			System.err.println("Suite Cases only allows you putting office supplies.");
		}
	}
}
