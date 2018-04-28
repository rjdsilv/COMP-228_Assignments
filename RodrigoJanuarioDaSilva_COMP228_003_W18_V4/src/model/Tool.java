/**
 * 
 */
package model;

/**
 * Class that is going to represent a Tool in the application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public final class Tool extends GenericModel {
	// Constant declarations.
	public static final String ID_COL = "TOOLID";
	public static final String PRICE_COL = "PRICE";
	public static final String CATEGORY_COL = "CATEGORY";
	public static final String TYPE_COL = "TOOLTYPE";
	public static final String BRAND_COL = "BRAND";

	// Properties declaration.
	private int price;
	private String category;
	private String type;
	private String brand;

	/**
	 * Default Constructor.
	 */
	public Tool() {
		super();
	}

	/**
	 * Constructor for the Hospital class.
	 * 
	 * @param id The id to be set.
	 */
	public Tool(int id) {
		super(id);
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tool other = (Tool) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tool [price=" + price + ", category=" + category + ", type=" + type + ", brand=" + brand + "]";
	}
}
