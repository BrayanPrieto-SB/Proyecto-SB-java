package ProyectoSB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoSB.domain.EmpTelLocal;
import ProyectoSB.repository.EmpTelLocalRepository;
@Service
public class EmpTelLocalImpl implements EmpTelLocalService {

	@Autowired
	EmpTelLocalRepository empTelLocalRepository;
	



	@Override
	public void crearConvenio(EmpTelLocal emp) {
		empTelLocalRepository.crearConvenio(emp);				
	}



	@Override
	public List<EmpTelLocal> getEmps(long nit) {
		
		return empTelLocalRepository.getEmps(nit);
	}


}
