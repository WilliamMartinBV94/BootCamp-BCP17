package com.NTTDATA.BootCamp.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.NTTDATA.BootCamp.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	

}
