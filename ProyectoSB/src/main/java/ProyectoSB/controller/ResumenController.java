package ProyectoSB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProyectoSB.domain.Convenio;
import ProyectoSB.domain.Resumen;
import ProyectoSB.repository.ResumenRepository;
import ProyectoSB.service.ResumenService;

@RestController
public class ResumenController {
	@Autowired ResumenService resumenService;
	@Autowired ResumenRepository resumenRepository;
	

	
	@RequestMapping(method=RequestMethod.GET, value="/resumen/{anio}/{mes}")
	public List<Resumen> getResumenes(@PathVariable int anio, @PathVariable int mes){
		return resumenService.getResumenes( anio, mes);
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/resumen")
	public List<Resumen> getResumenenTotal(){
		return resumenService.getResumenenTotal();
		
		
	}
}
