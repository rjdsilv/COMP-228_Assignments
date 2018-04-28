/**
 * 
 */
package dao;

import java.util.List;

import model.GenericModel;
import model.exception.ObjectNotFoundException;

/**
 * Generic DAO interface containing all the commom DAO methods to be implemented in the application.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0
 */
public interface GenericDao<M extends GenericModel> {
	/**
	 * Finds all the given model in the database.
	 * 
	 * @return The list of objects found. 
	 */
	public List<M> findAll();

	/**
	 * Find a given model object by its id.
	 * 
	 * @param id The id to be searched.
	 * @return The found, populated model if found.
	 * @throws ObjectNotFoundException if no object with the given id could be found.
	 */
	public M findById(int id) throws ObjectNotFoundException;

	/**
	 * Inserts the given model object into the database.
	 * 
	 * @param model The model to be inserted.
	 * @return The inserted model with its generated ID or null if the insert fails.
	 */
	public M insert(M model);

	/**
	 * Updates the given object into the database. In case the object does not exists yet, inserts it.
	 * 
	 * @param model The model object to be updated.
	 * @return The updated object model.
	 */
	public M update(M model);

	/**
	 * Deletes the given object from the database.
	 * 
	 * @param model The model object to be deleted.
	 * @return <b>true</b> if an object to delete was found. <b>false</b> otherwise.
	 */
	public boolean delete(M model);
}
