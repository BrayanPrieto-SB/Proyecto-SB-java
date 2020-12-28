package ProyectoSB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProyectoSB.domain.Convenio;
import ProyectoSB.repository.ConvenioRepository;
import ProyectoSB.service.ConvenioService;

@RestController
public class ConvenioController {
	
	@Autowired
	ConvenioService convenioService;
	
	@Autowired
	ConvenioRepository convenioRepository;
	
	@RequestMapping(method=RequestMethod.GET, value="/conv")
	public List<Convenio> getConvenios(){
		return convenioService.getConvenios();
		
		
	}
}
