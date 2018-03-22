/**
 * 
 */
package stationary;

/**
 * Class that will represent a pencil in the application.
 * 
 * @author Rodrigo Januario da Silva
 */
public final class Pencil extends AbstractWritable implements Erasable {
	private Hardness hardness;

	/**
	 * Enumeration that will contain the valid pencil hardnesses.
	 */
	public static enum Hardness {
		_6HB("PCL-6H9P", "6HB"),
		_4HB("PCL-4H7X", "4HB"),
		_2HB("PCL-2H0T", "2HB"),
		_2B("PCL-2B5W", "2B"),
		_4B("PCL-4B2Z", "4B"),
		_6B("PCL-6B8M", "6B");
		
		private String model;
		private String name;

		/**
		 * Creates a new Pencil Hardness.
		 * 
		 * @param name The hardness' model.
		 * @param name The hardness' name.
		 */
		private Hardness(String model, String name) {
			this.model = model;
			this.name = name;
		}

		/**
		 * Gets the pencil hardness' model.
		 * 
		 * @return The pencil hardness' model.
		 */
		public String getModel() {
			return model;
		}

		/**
		 * Gets the pencil hardness' name.
		 * 
		 * @return pencil hardness' name.
		 */
		public String getName() {
			return name;
		}
	}

	/**
	 * Creates a new Pencil with the given model number and hardness.
	 * 
	 * @param modelNumber The model number to be used.
	 * @param color The color to be used.
	 */
	public Pencil(String modelNumber, Hardness hardness) {
		super(modelNumber);
		this.hardness = hardness;
	}

	/**
	 * Gets the pencil's hardness.
	 * 
	 * @return The pencil's hardness.
	 */
	public Hardness getHardness() {
		return hardness;
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
		return String.format("Pencil model %s of hardness %s.", modelNumber, hardness.getName());
	}
}
