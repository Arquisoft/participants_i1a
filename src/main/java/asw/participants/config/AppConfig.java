package asw.participants.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import asw.participants.persistence.UserService;
import asw.participants.persistence.UserServiceFakeImpl;

@Configuration
//@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public UserService userService() {
		return new UserServiceFakeImpl();
	}
	
	
	@Override	
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	configurer.favorPathExtension(false).
	        favorParameter(true).
	        defaultContentType(MediaType.APPLICATION_JSON).
	        mediaType("html", MediaType.APPLICATION_XHTML_XML);
	  }
	  
}
