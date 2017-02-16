package asw.participants.examples;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asw.participants.model.User;
import asw.participants.model.UserCredentials;
import asw.participants.persistence.UserService;

@RestController
public class APIController {

	@Autowired
	UserService us;
	
    @RequestMapping("/user")
    public UserInfo user() {
        return new UserInfo("pepe",0);
    }
    
//    @PostMapping("/login")
//    public User hola(@ModelAttribute UserCredentials credentials, Model model) {
//    	String username = credentials.getUsername();
//    	String pass = credentials.getPassword();
//    	User user = us.findByID(username);
//    	user.setFirstName("Sergio");
//    	user.setLastName("Mosquera");
//    	user.setAddress("Avenida Principal");
//    	user.setDateOfBirth(new Date());
//    	user.setNationality("Spain");
//    	
//    	if(user.getPassword().equals(pass)){
//    		model.addAttribute("user", user);
//    		return user;
//    	}
//    	else
//    		return null;
//    }

}