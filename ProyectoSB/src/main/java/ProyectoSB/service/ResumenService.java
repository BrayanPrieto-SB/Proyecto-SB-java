package ProyectoSB.service;
import java.util.List;

import ProyectoSB.domain.Convenio;
import ProyectoSB.domain.Resumen;


public interface ResumenService {
	List<Resumen> getResumenes(int anio, int mes);
	List<Resumen> getResumenenTotal();
}
