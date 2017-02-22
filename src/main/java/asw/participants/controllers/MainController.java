package asw.participants.controllers;


import java.util.Date;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import asw.participants.model.User;
import asw.participants.model.UserCredentials;
import asw.participants.persistence.Services;
import asw.participants.persistence.UserService;


@Controller
public class MainController {
	
	@Autowired
	UserService us;
    
    @GetMapping("/")
    public String login(Model model) {
    	model.addAttribute("credentials", new UserCredentials());
        return "login";
    }
    
//    @GetMapping("/user_info")
//    public String login(Model model) {
//    	model.addAttribute("credentials", new UserCredentials());
//        return "login";
//    }
    
    @PostMapping(value = "/login", produces = "application/html")
    public String hola(@ModelAttribute UserCredentials credentials, Model model) {
    	String username = credentials.getUsername();
    	String pass = credentials.getPassword();
    	User user = Services.getUserService().findByID(username);
    	
    	if(user.getPassword().equals(pass)){
    		model.addAttribute("user", user);
    		return "user_info";
    	}
    	else
    		return "error";
    }
    
    
    @RequestMapping("/change_password")
    public String changePassword(Model model) {
    	model.addAttribute("nombre", "Luis");
        return "change_password";
    }
    
    @RequestMapping("/changing_password")
    public String changingPassword(HttpServletRequest request) {
    	String oldPassword = request.getParameter("oldpass");
    	String newPassword = request.getParameter("newpass");
    	String newRepeatedPassword = request.getParameter("repeatnewpass");
    	
    	User user = (User) request.getAttribute("user");
    	
    	String messageForTheUser = "";
    	if(newPassword.equals(newRepeatedPassword)) {
	    	if(user.getPassword().equals(oldPassword)){
	    		try {
	    			Services.getUserService().changePassword(user, newPassword);
	    			request.setAttribute("user", user);
	    			messageForTheUser = "The password has been updated succesfully";
	    		}catch(PersistenceException p) {
	    			messageForTheUser = "There has been a persistency problem when changing the password";
	    		}
	    	}
    	}
    	
    	request.setAttribute("messageForTheUser",  messageForTheUser);
        return "login";
    }

}