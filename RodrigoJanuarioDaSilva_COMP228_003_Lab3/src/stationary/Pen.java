/**
 * 
 */
package stationary;

/**
 * Class that will represent a pen in the application.
 * 
 * @author Rodrigo Januario da Silva
 */
public final class Pen extends AbstractWritable implements Writable {
	private Type type;

	/**
	 * Enumeration that will contain the valid pen types.
	 */
	public static enum Type {
		QUILL("PEN-QL8Y", "Quill"),
		BALLPOINT("PEN-BP9K", "Ball Point"),
		MARKER("PEN-MK5S", "Marker"),
		GEL_PEN("PEN-GP0H", "Gel Pen"),
		SPACE_PEN("PEN-SP8N", "Space Pen");

		private String model;
		private String name;

		/**
		 * Creates a new Pen Type.
		 * 
		 * @param name The type's name.
		 */
		private Type(String model, String name) {
			this.model = model;
			this.name = name;
		}

		/**
		 * Gets the pen type's model.
		 * 
		 * @return The pen type's model.
		 */
		public String getModel() {
			return model;
		}

		/**
		 * Gets the pen type's name.
		 * 
		 * @return The pen type's name.
		 */
		public String getName() {
			return name;
		}
	}

	/**
	 * Creates a new Pen with the given model number and type.
	 * 
	 * @param modelNumber The model number to be used.
	 * @param type The type to be used.
	 */
	public Pen(String modelNumber, Type type) {
		super(modelNumber);
		this.type = type;
	}

	/**
	 * Gets the pen defined type.
	 * 
	 * @return The pen defined type.
	 */
	public Type getType() {
		return type;
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
		return String.format("Pen model %s of type %s.", modelNumber, type.getName());
	}
}
