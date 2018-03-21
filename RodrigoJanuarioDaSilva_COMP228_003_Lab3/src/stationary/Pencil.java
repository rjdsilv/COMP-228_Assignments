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
		_6HB("6HB"),
		_4HB("4HB"),
		_2HB("2HB"),
		_2B("2B"),
		_4B("4B"),
		_6B("6B");
		
		private String name;

		/**
		 * Creates a new Crayon Color.
		 * 
		 * @param name The color's name.
		 */
		private Hardness(String name) {
			this.name = name;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
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
		return String.format("Pencil model %s of hardness %s.", modelNumber, hardness);
	}
}
