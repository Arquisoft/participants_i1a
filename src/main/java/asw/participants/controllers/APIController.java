package asw.participants.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asw.participants.examples.UserInfo;
import asw.participants.model.User;
import asw.participants.model.UserCredentials;
import asw.participants.persistence.Services;
import asw.participants.persistence.UserService;

@RestController
public class APIController {

	@Autowired
	UserService us;
	
    @RequestMapping("/user_info")
    public UserInfo user() {
        return new UserInfo("pepe",0);
    }
    
    @PostMapping(value = "/login", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public User hola(@ModelAttribute UserCredentials credentials, Model model) {
    	String username = credentials.getUsername();
    	String pass = credentials.getPassword();
    	User user = Services.getUserService().findByID(username);
    	
    	if(user.getPassword().equals(pass)){
    		model.addAttribute("user", user);
    		return user;
    	}
    	else
    		return null;
    }    

}