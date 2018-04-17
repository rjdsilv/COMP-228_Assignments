/**
 * 
 */
package dao;

import java.util.List;

import model.Hospital;
import model.exception.ObjectNotFoundException;

/**
 * Interface that will contain all the methods that are specific for dealing with hospitals.
 * 
 * @author Rodrigo Januario da Silva.
 * @version 1.0.0
 */
public interface HospitalDao extends GenericDao<Hospital> {
	/**
	 * Finds a hospital using partial name search as per the where clause "WHERE Name LIKE '%lastName'";
	 * 
	 * @param lastName The partial last name to be found.
	 * @return The list of hospitals matching the given partial last name string.
	 * @throws ObjectNotFoundException if no hospital is found with the given last name.
	 */
	public List<Hospital> findByLastName(String lastName) throws ObjectNotFoundException;
}
