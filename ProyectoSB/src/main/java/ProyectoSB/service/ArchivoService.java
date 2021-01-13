package ProyectoSB.service;

import java.util.List;

import ProyectoSB.domain.Archivo;

public interface ArchivoService {
	List<Archivo> infoArchivos(int anio,int mes, long nit);
}
