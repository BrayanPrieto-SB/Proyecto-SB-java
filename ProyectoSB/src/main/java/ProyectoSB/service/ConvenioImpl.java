package ProyectoSB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ProyectoSB.domain.Convenio;
import ProyectoSB.repository.ConvenioRepository;

@Service
public class ConvenioImpl implements ConvenioService {
	@Autowired ConvenioRepository convenioRepository;
	
	@Override
	public List <Convenio> getConvenios() {
		return convenioRepository.getConvenios();
	}

}
