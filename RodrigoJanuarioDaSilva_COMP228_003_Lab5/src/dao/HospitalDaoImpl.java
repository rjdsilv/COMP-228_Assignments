/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.Hospital;
import model.exception.ObjectNotFoundException;

/**
 * DAO class that will handle database operations for the Hospitals table.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public final class HospitalDaoImpl extends GenericDaoImpl<Hospital> implements HospitalDao {
	/**
	 * Default constructor.
	 * 
	 * @throws Exception If any error occur during the object creation.
	 */
	protected HospitalDaoImpl() throws Exception {
		super();
		tableName = "Hospitals";
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDaoImpl#createModelFromResultSet(java.sql.ResultSet)
	 */
	@Override
	protected Hospital createModelFromResultSet(ResultSet rs) throws SQLException {
		Hospital hospital = new Hospital(rs.getInt(Hospital.ID_COL));
		hospital.setName(rs.getString(Hospital.NAME_COL));
		hospital.setRating(rs.getInt(Hospital.RATING_COL));
		hospital.setAddress(rs.getString(Hospital.ADDR_COL));
		hospital.setFaxNumber(rs.getString(Hospital.FAX_COL));
		hospital.setPhoneNumber(rs.getString(Hospital.PHONE_COL));
		hospital.setEmail(rs.getString(Hospital.EMAIL_COL));
		return hospital;
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDao#insert(model.GenericModel)
	 */
	@Override
	public Hospital insert(Hospital model) {
		try (Connection cnn = getConnection()) {
			final String sql = "INSERT INTO " + tableName + " (Name, Address, FaxNumber, PhoneNumber, Email, Rating) values (?, ?, ?, ?, ?, ?)";

			try (PreparedStatement stmt = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
				stmt.setString(1, model.getName());
				stmt.setString(2, model.getAddress());
				stmt.setString(3, model.getFaxNumber());
				stmt.setString(4, model.getPhoneNumber());
				stmt.setString(5, model.getEmail());
				stmt.setInt(6, model.getRating());

				// Makes sure the insert was successfully performed.
				if (stmt.executeUpdate() == 1) {
					try (ResultSet rs = stmt.getGeneratedKeys()) {
						if (rs.next()) {
							model.setId(rs.getInt(1));
						}
					}
				}

				return model;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An error occurred in findById method.");
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDao#update(model.GenericModel)
	 */
	@Override
	public Hospital update(Hospital model) {
		if (model.getId() <= 0) { // If the ID is not set, the Hospital still does not exists, so we insert it.
			return insert(model);
		} else {                  // Updates the existing hospital.
			final String sql = "UPDATE " + tableName + " SET Name = ?, Address = ?, FaxNumber = ?, PhoneNumber = ?, Email = ?, Rating = ? "
					+ "WHERE " + getIdColumnName() + " = ?";

			try (Connection cnn = getConnection()) {
				try (PreparedStatement stmt = cnn.prepareStatement(sql)) {
					stmt.setString(1, model.getName());
					stmt.setString(2, model.getAddress());
					stmt.setString(3, model.getFaxNumber());
					stmt.setString(4, model.getPhoneNumber());
					stmt.setString(5, model.getEmail());
					stmt.setInt(6, model.getRating());
					stmt.setInt(7, model.getId());
	
					// Makes sure the update was successfully performed.
					if (stmt.executeUpdate() == 1) {
						return model;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("An error occurred in findById method.");
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see dao.HospitalDao#findByLastName(java.lang.String)
	 */
	@Override
	public List<Hospital> findByLastName(String lastName) throws ObjectNotFoundException {
		final List<Hospital> hospitalList = new ArrayList<>();

		try (Connection cnn = getConnection()) {
			final String sql = "SELECT * FROM " + tableName + " WHERE Name LIKE ?";

			try (PreparedStatement stmt = cnn.prepareStatement(sql)) {
				stmt.setString(1, "%" + lastName);

				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						hospitalList.add(createModelFromResultSet(rs));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An error occurred in findByLastName method.");
		}

		if (hospitalList.isEmpty()) {
			throw new ObjectNotFoundException("No hospitals found with the given Last Name: " + lastName);
		}

		return Collections.unmodifiableList(hospitalList);
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDaoImpl#getIdColumnName()
	 */
	@Override
	protected String getIdColumnName() {
		return Hospital.ID_COL;
	}

}
