package ProyectoSB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoSB.domain.Convenio;
import ProyectoSB.domain.Resumen;
import ProyectoSB.repository.ResumenRepository;

@Service
public class ResumenImpl implements ResumenService{
	@Autowired ResumenRepository resumenRepository;
	
	
	@Override
	public List<Resumen> getResumenes() {
		return resumenRepository.getResumenes();
	}
}
