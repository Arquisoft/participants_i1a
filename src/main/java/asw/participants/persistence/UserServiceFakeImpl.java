package asw.participants.persistence;

import java.util.Date;

import asw.participants.model.User;

public class UserServiceFakeImpl implements UserService {

	@Override
	public void changePassword(User user, String password) {
		System.out.println("Cambiando contraseña");
	}

	@Override
	public User findByID(String DNI) {
		User user = new User("DNI");
		user.setPassword("123");
		user.setFirstName("Sergio");
    	user.setLastName("Mosquera");
    	user.setAddress("Avenida Principal");
    	user.setDateOfBirth(new Date());
    	user.setNationality("Spain");
		return user;
	}

}
