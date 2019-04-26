package br.edu.unoesc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.model.Partido;

public interface PartidoDao  extends JpaRepository<Partido, Long> {
	
	

}
