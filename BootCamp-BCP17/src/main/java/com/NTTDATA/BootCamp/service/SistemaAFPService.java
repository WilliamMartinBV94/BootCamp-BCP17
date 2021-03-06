package com.NTTDATA.BootCamp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NTTDATA.BootCamp.model.Persona;
import com.NTTDATA.BootCamp.model.RegistrarSolicitudRequest;
import com.NTTDATA.BootCamp.model.RegistrarSolicitudResponse;
import com.NTTDATA.BootCamp.repository.PersonaRepository;
import com.NTTDATA.BootCamp.model.RegistarSolicitudAFP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
public class SistemaAFPService {
	private final Logger logger = LoggerFactory.getLogger(SistemaAFPService.class);
	@Autowired
	private PersonaRepository personaRepository;

	
	// vincular AFP
	
	public Persona create (Persona persona) {
		return personaRepository.save(persona);
	}
	
	public List<Persona> getAllPersonas (){
		return personaRepository.findAll();
	}
	
	public void delete (Persona persona) {
		
		personaRepository.delete(persona);
	}
	
	//registrar solicitud AFP
	public RegistrarSolicitudResponse registrarSolicitud(RegistarSolicitudAFP solicituAFP,
			RegistrarSolicitudRequest registrarSolicitudRequest) {
	RegistrarSolicitudResponse responseData = new RegistrarSolicitudResponse();
	RegistrarSolicitudRequest dataRequest = new RegistrarSolicitudRequest();
	dataRequest.setDNI(registrarSolicitudRequest.getDNI());
	dataRequest.setMontoRetiro(registrarSolicitudRequest.getMontoRetiro());
	dataRequest.setAFP(registrarSolicitudRequest.getAFP());
	
	logger.info("VALIDAR AFP");
	if (registrarSolicitudRequest.getAFP().contains("AFP")) {
		dataRequest.setAFP(registrarSolicitudRequest.getAFP());		
	}else {
		logger.info("error");
	}
	
	logger.info("VALIDAR MONTO RETIRO : MontoRetiro > MontoDisponible ");
	
	if(Double.parseDouble(registrarSolicitudRequest.getMontoRetiro()) < Double.parseDouble(solicituAFP.getMontoDisponible()) ) {
		responseData.setDNI(registrarSolicitudRequest.getDNI());
		responseData.setMontoRetiro(registrarSolicitudRequest.getMontoRetiro());
		responseData.setAFP(registrarSolicitudRequest.getAFP());		
	}else {
		logger.info("No se puede registrar la solicitud. Monto mayor que el permitido");
	}
	
	logger.info("VALIDAR MONTO RETIRO: MontoRetiro > 50%MontoDisponible");
	
	if(Double.parseDouble(registrarSolicitudRequest.getMontoRetiro()) > (50/100 * Double.parseDouble(solicituAFP.getMontoDisponible()))) {
		responseData.setDNI(registrarSolicitudRequest.getDNI());
		responseData.setMontoRetiro(registrarSolicitudRequest.getMontoRetiro());
		responseData.setAFP(registrarSolicitudRequest.getAFP());		
	}else {
		logger.info("Monto m??nimo no cubierto por favor revise el monto m??nimo a retirar");
	}
	return responseData;
	
	}

}
