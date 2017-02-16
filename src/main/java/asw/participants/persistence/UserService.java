package asw.participants.persistence;

import javax.persistence.PersistenceException;

import asw.participants.model.User;

public interface UserService {

	public void changePassword(User user, String password) throws PersistenceException;
	
	public User findByID(String DNI) throws PersistenceException;
	
}
