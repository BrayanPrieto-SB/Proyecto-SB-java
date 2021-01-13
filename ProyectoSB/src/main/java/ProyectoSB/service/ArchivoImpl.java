package ProyectoSB.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoSB.repository.ArchivoRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoSB.domain.Archivo;
import ProyectoSB.domain.Convenio;
import ProyectoSB.repository.ConvenioRepository;


@Service
public class ArchivoImpl implements ArchivoService {
	@Autowired ArchivoRepository archivoRepository;
	
	@Override
	public List<Archivo> infoArchivos(int anio, int mes, long nit){
		return archivoRepository.infoArchivos(anio,mes, nit);
	}
}
