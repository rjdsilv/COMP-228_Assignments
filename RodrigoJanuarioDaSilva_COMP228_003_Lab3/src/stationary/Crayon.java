/**
 * 
 */
package stationary;

/**
 * Class that will represent a crayon in the application.
 * 
 * @author Rodrigo Januario da Silva
 */
public final class Crayon extends AbstractWritable implements Erasable {
	private Color color;

	/**
	 * Enumeration that will contain the valid crayon colors.
	 */
	public static enum Color {
		BLUE("CYN-BL6G", "Blue"),
		GREEN("CYN-GR2D", "Green"),
		RED("CYN-RD4V", "Red"),
		BLACK("CYN-BK0I", "Black"),
		PINK("CYN-PK3B", "Pink");

		private String model;
		private String name;
		
		/**
		 * Creates a new Crayon Color.
		 * 
		 * @param name The color's model.
		 * @param name The color's name.
		 */
		private Color(String model, String name) {
			this.model = model;
			this.name = name;
		}

		/**
		 * Gets the crayon color's model.
		 * 
		 * @return The crayon color's model.
		 */
		public String getModel() {
			return model;
		}

		/**
		 * Gets the crayon color's name.
		 * 
		 * @return The crayon color's name.
		 */
		public String getName() {
			return name;
		}
	}

	/**
	 * Creates a new Crayon with the given model number and color.
	 * 
	 * @param modelNumber The model number to be used.
	 * @param color The color to be used.
	 */
	public Crayon(String modelNumber, Color color) {
		super(modelNumber);
		this.color = color;
	}

	/**
	 * Gets the crayon's color.
	 * 
	 * @return The crayon's color.
	 */
	public Color getColor() {
		return color;
	}

	/*
	 * (non-Javadoc)
	 * @see stationary.Erasable#erase()
	 */
	@Override
	public void erase() {
		text = "";
	}

	/*
	 * (non-Javadoc)
	 * @see stationary.Stationary#describe()
	 */
	@Override
	protected String describe() {
		return "This is a stationary product. " + toString();
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Crayon model %s of color %s.", modelNumber, color.getName());
	}
}
