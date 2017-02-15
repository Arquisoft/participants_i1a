package persistence;

import model.User;

public class PersistenceServiceFakeImpl implements PersistenceService {

	@Override
	public void changePassword(User user, String password) {
		System.out.println("Cambiando contraseña");
	}

	@Override
	public User findByID(Long id) {
		return new User("DNI del usuario");
	}

}
