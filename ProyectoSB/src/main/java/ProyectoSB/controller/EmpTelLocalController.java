package ProyectoSB.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ProyectoSB.domain.EmpTelLocal;
import ProyectoSB.repository.EmpTelLocalRepository;
import ProyectoSB.service.EmpTelLocalService;

@RestController 
public class EmpTelLocalController {
	@Autowired
	EmpTelLocalService empTelLocalService;
	
	@Autowired
	EmpTelLocalRepository empTelLocalRepository;

	@RequestMapping(method=RequestMethod.GET, value="/home/{nit}")
	public List <EmpTelLocal> getEmps(@PathVariable Long nit){
		return empTelLocalService.getEmps(nit);				
	}	


	
    @RequestMapping(path = "/conv", method = RequestMethod.POST)
    public void crearConvenio(@RequestBody EmpTelLocal emp){
    	empTelLocalService.crearConvenio(emp);

    }
	
	
	
}
