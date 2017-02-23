package asw.participants.controllers;

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import asw.participants.model.User;
import asw.participants.model.UserCredentials;
import asw.participants.persistence.UserService;

@SessionAttributes("user")
@Scope("session")
@Controller
public class MainController {

    @Autowired
    UserService us;

    @GetMapping("/")
    public String login(Model model) {
	model.addAttribute("credentials", new UserCredentials());
	return "login";
    }

    // @GetMapping("/user_info")
    // public String login(Model model) {
    // model.addAttribute("credentials", new UserCredentials());
    // return "login";
    // }

    @PostMapping(value = "/login", produces = MediaType.TEXT_HTML_VALUE)
    public String hola(@ModelAttribute UserCredentials credentials, Model model, HttpServletRequest request) {
    String username = credentials.getUsername();
    String pass = credentials.getPassword();
	User user = us.findByID(username);

	if (user.getPassword().equals(pass)) {
		model.addAttribute("user", user);
	    request.getSession().setAttribute("user", user);
	    return "user_info";
	} else
	    return "error";
    }

    @RequestMapping("/change_password")
    public String changePassword(Model model) {
	model.addAttribute("nombre", "Luis");
	return "change_password";
    }

    @RequestMapping("/changing_password")
    public String changingPassword(HttpServletRequest request, @ModelAttribute("user") User user, Model model) {
	String oldPassword = request.getParameter("oldpass");
	String newPassword = request.getParameter("newpass");
	String newRepeatedPassword = request.getParameter("repeatnewpass");

	String messageForTheUser = "The new password introduced is different in both fields";
	if (newPassword.equals(newRepeatedPassword)) {
	    if (user.getPassword().equals(oldPassword)) {
			try {
			    us.changePassword(user, newPassword);
			    request.setAttribute("user", user);
			    messageForTheUser = "The password has been updated succesfully";
			    return "user_info";
			} catch (PersistenceException p) {
			    messageForTheUser = "There has been a persistency problem while changing the password";
			}	
	    }
	    messageForTheUser = "The old password introduced is wrong.";
	}

	model.addAttribute("messageForTheUser", messageForTheUser);
	return "change_password";
    }

}