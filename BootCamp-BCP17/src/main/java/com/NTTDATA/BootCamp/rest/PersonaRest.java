package com.NTTDATA.BootCamp.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NTTDATA.BootCamp.model.Persona;
import com.NTTDATA.BootCamp.service.SistemaAFPService;

import ch.qos.logback.classic.selector.servlet.LoggerContextFilter;



@RestController
@RequestMapping ("/api/sistemaAFP/")
public class PersonaRest {
	@Autowired
	private SistemaAFPService AFPService;
	
	
	@PostMapping
	
	private ResponseEntity<Persona> guardar (@RequestBody Persona persona){
		Persona temporal = AFPService.create(persona);
		
		try {
			return ResponseEntity.created(new URI("/api/sistemaAFP"+temporal.getDNI())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Persona>> listarTodasLasPersona (){
		return ResponseEntity.ok(AFPService.getAllPersonas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona (@RequestBody Persona persona){
		AFPService.delete(persona);
		return ResponseEntity.ok().build();
	}
		

}
