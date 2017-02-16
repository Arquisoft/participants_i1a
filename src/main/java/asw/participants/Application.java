package asw.participants;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import asw.participants.config.AppConfig;

@SpringBootApplication
public class Application {

	ApplicationContext ctx = 
			   new AnnotationConfigApplicationContext(AppConfig.class);
	
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    }
}