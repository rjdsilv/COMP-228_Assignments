/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Tool;

/**
 * DAO class that will handle database operations for the Tools table.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public final class ToolDaoImpl extends GenericDaoImpl<Tool> implements ToolDao {
	// Singleton instance for the class.
	private static final ToolDao INSTANCE = new ToolDaoImpl();

	/**
	 * Gets the singleton instance for the class.
	 * 
	 * @return The singleton instance for the class.
	 */
	public static ToolDao instance() {
		return INSTANCE;
	}

	/**
	 * Default constructor.
	 * 
	 * @throws Exception If any error occur during the object creation.
	 */
	private ToolDaoImpl() {
		super();
		tableName = "Tools";
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDaoImpl#createModelFromResultSet(java.sql.ResultSet)
	 */
	@Override
	protected Tool createModelFromResultSet(ResultSet rs) throws SQLException {
		Tool tool = new Tool(rs.getInt(Tool.ID_COL));
		tool.setBrand(rs.getString(Tool.BRAND_COL));
		tool.setCategory(rs.getString(Tool.CATEGORY_COL));
		tool.setPrice(rs.getInt(Tool.PRICE_COL));
		tool.setType(rs.getString(Tool.TYPE_COL));
		return tool;
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDao#insert(model.GenericModel)
	 */
	@Override
	public Tool insert(Tool model) {
		try (Connection cnn = getConnection()) {
			if (null == findById(model.getId())) {
				final String insertSql = "INSERT INTO " + tableName + " (Price, Category, ToolType, Brand) values (?, ?, ?, ?)";

				try (PreparedStatement stmt = cnn.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
					stmt.setInt(1, model.getPrice());
					stmt.setString(2, model.getCategory());
					stmt.setString(3, model.getType());
					stmt.setString(4, model.getBrand());
	
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
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("An error occurred in insert method.");
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDao#update(model.GenericModel)
	 */
	@Override
	public Tool update(Tool model) {
		if (model.getId() <= 0) { // If the ID is not set, the Hospital still does not exists, so we insert it.
			return insert(model);
		} else {                  // Updates the existing hospital.
			final String sql = "UPDATE " + tableName + " SET Price = ?, Category = ?, ToolType = ?, Brand = ? WHERE " + getIdColumnName() + " = ?";

			try (Connection cnn = getConnection()) {
				try (PreparedStatement stmt = cnn.prepareStatement(sql)) {
					stmt.setInt(1, model.getPrice());
					stmt.setString(2, model.getCategory());
					stmt.setString(3, model.getType());
					stmt.setString(4, model.getBrand());
					stmt.setInt(5, model.getId());
	
					// Makes sure the update was successfully performed.
					if (stmt.executeUpdate() == 1) {
						return model;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("An error occurred in update method.");
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see dao.GenericDaoImpl#getIdColumnName()
	 */
	@Override
	protected String getIdColumnName() {
		return Tool.ID_COL;
	}
}
