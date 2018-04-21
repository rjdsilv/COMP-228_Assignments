package house_exercise_3;

public class HouseComparable implements Comparable<HouseComparable>{

		private double price;
		private String type;
		
		
		public HouseComparable(double price, String type) {
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

		@Override
		public int compareTo(HouseComparable o) {
			if(this.getPrice() > o.getPrice()) {
				return 1;
			}else if(this.getPrice() == o.getPrice()) {
				return 0;
			}else {
				return -1;
			}
		}	
	}
