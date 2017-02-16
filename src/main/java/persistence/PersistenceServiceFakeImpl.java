package persistence;

import model.User;

public class PersistenceServiceFakeImpl implements PersistenceService {

	@Override
	public void changePassword(User user, String password) {
		System.out.println("Cambiando contraseña");
	}

	@Override
	public User findByID(String DNI) {
		User user = new User("DNI");
		user.setPassword("123");
		return user;
	}

}
