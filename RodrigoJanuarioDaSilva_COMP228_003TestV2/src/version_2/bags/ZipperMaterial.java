package version_2.bags;

public enum ZipperMaterial {
	PLASTIC("Plastic"),
	METAL("Wood");
	
	private String material;
	
	private ZipperMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return material;
	}
}
