package version_2.bags;

public abstract class ZipperBag extends Bag {
	protected ZipperMaterial zipperMaterial;

	protected ZipperBag(int maxCapacity, String color, BagMaterial material, ZipperMaterial zipperMaterial) {
		super(maxCapacity, color, material);
		this.zipperMaterial = zipperMaterial;
	}

	public ZipperMaterial getZipperMaterial() {
		return zipperMaterial;
	}
}
