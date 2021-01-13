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
	public List<Resumen> getResumenes(int anio, int mes) {
		return resumenRepository.getResumenes(anio,mes);
	}
	@Override
	public List<Resumen> getResumenenTotal() {
		return resumenRepository.getResumenenTotal();
	}
}
