package version_2.bags;

public enum BagMaterial {
	FABRIC("Fabric"),
	PLASTIC("Plastic"),
	LEATHER("Leather");
	
	private String material;
	
	private BagMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return material;
	}
}
