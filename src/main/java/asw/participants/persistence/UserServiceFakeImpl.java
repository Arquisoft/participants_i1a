package asw.participants.persistence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import asw.participants.model.User;

public class UserServiceFakeImpl implements UserService {

    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    @Override
    public void changePassword(User user, String password) {
	System.out.println("Cambiando contraseña");
    }

    @Override
    public User findByID(String DNI) {
	User user = new User("DNI");
	user.setPassword("123");
	user.setFirstName("Jose");
	user.setLastName("Hidalgo");
	user.setAddress("Calle Uria");
	try {
	    user.setDateOfBirth(df.parse("14/11/1994"));
	} catch (ParseException e) {
	    e.printStackTrace();
	}
	user.setNationality("Spain");
	user.setEmail("hidalgo@uniovi.es");
	return user;
    }

}
