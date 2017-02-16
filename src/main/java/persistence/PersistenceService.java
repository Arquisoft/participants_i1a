package persistence;

import javax.persistence.PersistenceException;

import model.User;

public interface PersistenceService {

	public void changePassword(User user, String password) throws PersistenceException;
	
	public User findByID(String DNI) throws PersistenceException;
	
}
