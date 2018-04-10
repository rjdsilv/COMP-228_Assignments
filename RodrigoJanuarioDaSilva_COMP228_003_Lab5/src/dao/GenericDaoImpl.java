/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import model.GenericModel;
import model.exception.ObjectNotFoundException;

/**
 * Class that will implement all the generic methods necessary to be used in the application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public abstract class GenericDaoImpl<M extends GenericModel> implements GenericDao<M> {
	// Constant declarations.
	protected static final String CNN_STR = "jdbc:derby:database/hospitals";
	protected static final String CNN_USER = "liliya";
	protected static final String CNN_PWD = "liliya";

	// Properties declaration.
	protected String tableName;

	/**
	 * Default Constructor.
	 * 
	 * @throws Exception If any error occurs when loading the Derby driver.
	 */
	protected GenericDaoImpl() throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	}

	/**
	 * Fills the model from the given result set. NEVER open or close the result set in this method.
	 * 
	 * @param rs The result set to be used.
	 * @throws SQLException if any error occur during the model creation.
	 */
	protected abstract M createModelFromResultSet(ResultSet rs) throws SQLException;

	/**
	 * Gets the correct ID Column name from the table.
	 * 
	 * @return The correct ID Column name from the table.
	 */
	protected abstract String getIdColumnName();

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDao#findAll()
	 */
	@Override
	public List<M> findAll() {
		final List<M> objectList = new ArrayList<>();

		try (Connection cnn = getConnection()) {
			final String sql = "SELECT * FROM " + tableName;

			try (PreparedStatement stmt = cnn.prepareStatement(sql)) {
				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						objectList.add(createModelFromResultSet(rs));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An error occurred in findAll method.");
		}

		return Collections.unmodifiableList(objectList);
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDao#findById(int)
	 */
	@Override
	public M findById(int id) throws ObjectNotFoundException {
		try (Connection cnn = getConnection()) {
			final String sql = "SELECT * FROM " + tableName + " WHERE " + getIdColumnName() + " = ?";

			try (PreparedStatement stmt = cnn.prepareStatement(sql)) {
				stmt.setInt(1, id);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						return createModelFromResultSet(rs);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An error occurred in findById method.");
		}
		
		throw new ObjectNotFoundException("No object could be found on the table " + tableName + " with the ID = " + id);
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDao#delete(model.GenericModel)
	 */
	@Override
	public boolean delete(M model) {
		try (Connection cnn = getConnection()) {
			final String sql = "DELETE FROM " + tableName + " WHERE " + getIdColumnName() + " = ?";

			try (PreparedStatement stmt = cnn.prepareStatement(sql)) {
				stmt.setInt(1, model.getId());
				return stmt.executeUpdate() > 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An error occurred in findById method.");
		}

		return false;
	}

	/**
	 * Gets the connection to the database using the established class parameters.
	 * 
	 * @return The connection to the database.
	 * @throws SQLException If an error occurs when establishing the connection.
	 */
	protected Connection getConnection() throws SQLException {
		return DriverManager.getConnection(CNN_STR, CNN_USER, CNN_PWD);
	}
}
