/**
 * 
 */
package model;

/**
 * Class that is going to represent a Hospital in the application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public final class Hospital extends GenericModel {
	// Constant declarations.
	public static final String ID_COL = "HOSPITALID";
	public static final String NAME_COL = "NAME";
	public static final String RATING_COL = "RATING";
	public static final String ADDR_COL = "ADDRESS";
	public static final String FAX_COL = "FAXNUMBER";
	public static final String PHONE_COL = "PHONENUMBER";
	public static final String EMAIL_COL = "EMAIL";

	// Properties declaration.
	private String name;
	private int rating;
	private String address;
	private String faxNumber;
	private String phoneNumber;
	private String email;

	/**
	 * Default Constructor.
	 */
	public Hospital() {
		super();
	}

	/**
	 * Constructor for the Hospital class.
	 * 
	 * @param id The id to be set.
	 */
	public Hospital(int id) {
		super(id);
	}

	/**
	 * Getter for the name property.
	 * 
	 * @return The Hospital's name.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter for the name property.
	 * 
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for the rating property.
	 * 
	 * @return the Hospital's rating.
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Setter for the rating property.
	 * 
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Getter for the address property.
	 * 
	 * @return the Hospital's address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Setter for the address property.
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Getter for the faxNumber property.
	 * 
	 * @return the Hospital's faxNumber.
	 */
	public String getFaxNumber() {
		return faxNumber;
	}

	/**
	 * Setter for the faxNumber property.
	 * 
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	/**
	 * Getter for the phoneNumber property.
	 * 
	 * @return the Hospital's phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter for the phoneNumber property.
	 * 
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getter for the email property.
	 * 
	 * @return the Hospital's email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter for the email property.
	 * 
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
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
		GenericModel other = (GenericModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "{Hospital: {id='" + id + "', name='" + name + "', rating='" + rating + "', address='" + address + "', faxNumber='" + faxNumber
				+ "', phoneNumber='" + phoneNumber + "', email='" + email + "'}}";
	}
}
