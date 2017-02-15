package hello;


import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model.User;
import persistence.PersistenceFactory;

@Controller
public class MainController {
	
    @RequestMapping("/")
    public String landing(Model model) {
    	model.addAttribute("nombre", "Amigo");
        return "saludo";
    }
    
    
    @RequestMapping("/login.jsp")
    public String hola(Model model) {
    	model.addAttribute("nombre", "Luis");
        return "saludo";
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
	    			PersistenceFactory.getPersistenceService().changePassword(user, newPassword);
	    			request.setAttribute("user", user);
	    			messageForTheUser = "The password has been updated succesfully";
	    		}catch(PersistenceException p) {
	    			messageForTheUser = "There has been a persistency problem when changing the password";
	    		}
	    	}
    	}
    	
    	request.setAttribute("messageForTheUser",  messageForTheUser);
        return "change_password";
    }

}