package asw.participants.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import asw.participants.persistence.UserService;
import asw.participants.persistence.UserServiceFakeImpl;

@Configuration
public class AppConfig {

	@Bean
	public UserService userService() {
		return new UserServiceFakeImpl();
	}
	
}
