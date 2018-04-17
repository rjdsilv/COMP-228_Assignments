package dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import model.Hospital;
import model.exception.ObjectNotFoundException;

/**
 * Test class implemented just to make sure connectivity with database is OK.
 * 
 * @author Rodrigo Januario da Silva
 * @version 1.0.0 *
 */
class HospitalDaoImplTest {
	private HospitalDaoImpl hospitalDao;
	
	HospitalDaoImplTest() throws Exception {
		hospitalDao = new HospitalDaoImpl();
	}

	@Test
	void testFindAll() {
		final List<Hospital> hospitals = hospitalDao.findAll();
		assertFalse(hospitals.isEmpty());
		System.out.println("Hospitals Found:");
		hospitals.forEach(h -> System.out.println(h));
	}

	@Test
	void testFindByIdExistingHospital() throws Exception {
		final List<Hospital> hospitals = hospitalDao.findAll();
		assertFalse(hospitals.isEmpty());
		final Hospital found = hospitalDao.findById(hospitals.get(0).getId());
		assertEquals(hospitals.get(0).getId(), found.getId());
	}

	@Test
	void testFindByIdInexistingHospital() {
		final Executable codeToExecute = () -> hospitalDao.findById(0);
		assertThrows(ObjectNotFoundException.class, codeToExecute);
	}

	@Test
	void testInsert() {
		Hospital hospital = new Hospital();
		hospital.setName("St. Louis Hospital");
		hospital.setAddress("154 Danforth Avenue");
		hospital.setFaxNumber("444-4444");
		hospital.setPhoneNumber("444-1234");
		hospital.setEmail("louis@hospital.com");
		hospital.setRating(9);
		hospital = hospitalDao.insert(hospital);
		assertNotNull(hospital.getId());
	}

	@Test
	void testUpdateExistingHospital() throws Exception {
		final List<Hospital> hospitals = hospitalDao.findAll();
		assertFalse(hospitals.isEmpty());
		final Hospital updated = hospitals.get(hospitals.size() - 1);
		updated.setEmail("newemail@hospital.com");
		hospitalDao.update(updated);
		final Hospital found = hospitalDao.findById(updated.getId());
		assertEquals(updated.getEmail(), found.getEmail());
	}

	@Test
	void testUpdateInexistingHospital() {
		Hospital hospital = new Hospital();
		hospital.setName("St. Inexisting Hospital");
		hospital.setAddress("365 Weleslley Street");
		hospital.setFaxNumber("777-7777");
		hospital.setPhoneNumber("777-1234");
		hospital.setEmail("inexisting@hospital.com");
		hospital.setRating(5);
		hospital = hospitalDao.update(hospital);
		assertNotNull(hospital.getId());
	}

	@Test
	void testDelete() {
		final List<Hospital> hospitals = hospitalDao.findAll();
		assertFalse(hospitals.isEmpty());
		final Hospital deleted = hospitals.get(hospitals.size() - 1);
		assertTrue(hospitalDao.delete(deleted));
		final Executable findHospital = () -> hospitalDao.findById(deleted.getId());
		assertThrows(ObjectNotFoundException.class, findHospital);
	}

	@Test
	void testFindByLastName() {
		assertTrue(hospitalDao.findByLastName("Hospital").size() >= 2);
		assertTrue(hospitalDao.findByLastName("Mikes Hospital").size() == 1);
	}
}
