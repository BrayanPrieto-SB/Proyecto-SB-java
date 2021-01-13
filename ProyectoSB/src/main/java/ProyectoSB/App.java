package ProyectoSB;
import java.io.*;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import ProyectoSB.repository.ArchivoRepository;
import ProyectoSB.repository.EmpTelLocalRepository;
import ProyectoSB.repository.ResumenRepository;
import ProyectoSB.service.ArchivoService;
import ProyectoSB.service.EmpTelLocalService;
import ProyectoSB.service.ResumenService;
import ProyectoSB.*;
import ProyectoSB.domain.Archivo;
@SpringBootApplication
@Service
public class App {
	@Autowired
	EmpTelLocalService empTelLocalService;
	
	@Autowired
	EmpTelLocalRepository empTelLocalRepository;
	@Autowired
	static
	ArchivoService archivoService;
	
	@Autowired
	ArchivoRepository achivoRepository;
	

	public static void main(String[] args) throws IOException {
		SpringApplication.run(App.class, args);
		//System.out.println(archivoService.infoArchivos(2020,05, 9000328594L)); 


		
		//Fichero f = new Fichero();
	//	f.crearFichero("Titulo_por_input.txt");

	}
	
	

	/* CORS para IP fija */
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