package ProyectoSB.service;

import java.util.List;

import ProyectoSB.domain.EmpTelLocal;

public interface EmpTelLocalService {
	List<EmpTelLocal> getEmps(long nit);
	void crearConvenio(EmpTelLocal emp);


	
}
