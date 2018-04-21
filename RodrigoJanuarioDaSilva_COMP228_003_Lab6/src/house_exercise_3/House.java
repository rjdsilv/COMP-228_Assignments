package house_exercise_3;

public class House{

	private double price;
	private String type;
	
	
	public House(double price, String type) {
		super();
		this.price = price;
		this.type = type;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "House [price=" + price + ", type=" + type + "]";
	}	
}
