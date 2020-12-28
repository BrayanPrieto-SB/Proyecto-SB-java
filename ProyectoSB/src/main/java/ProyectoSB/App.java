package ProyectoSB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ProyectoSB.repository.EmpTelLocalRepository;
import ProyectoSB.service.EmpTelLocalService;
import ProyectoSB.*;
@SpringBootApplication
public class App {
	@Autowired
	EmpTelLocalService empTelLocalService;
	
	@Autowired
	EmpTelLocalRepository empTelLocalRepository;
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	
	 @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4207")
	                .allowedMethods("*")
	                .allowedHeaders("*");
	            }
	        };
	        
	 }

}