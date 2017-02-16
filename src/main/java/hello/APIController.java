package hello;


import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.User;
import model.UserCredentials;
import persistence.PersistenceFactory;

@RestController
public class APIController {

    @RequestMapping("/user")
    public UserInfo user() {
        return new UserInfo("pepe",0);
    }
    
    @PostMapping("/login")
    public User hola(@ModelAttribute UserCredentials credentials, Model model) {
    	String username = credentials.getUsername();
    	String pass = credentials.getPassword();
    	User user = PersistenceFactory.getPersistenceService().findByID(username);
    	user.setFirstName("Sergio");
    	user.setLastName("Mosquera");
    	user.setAddress("Avenida Principal");
    	user.setDateOfBirth(new Date());
    	user.setNationality("Spain");
    	
    	if(user.getPassword().equals(pass)){
    		model.addAttribute("user", user);
    		return user;
    	}
    	else
    		return null;
    }

}