package br.edu.unoesc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unoesc.model.Partido;
import br.edu.unoesc.model.Vereador;

public interface VereadorDao extends JpaRepository<Vereador, Long> {
	
	List<Vereador> findByName(String nome);
	
	@Query("select v from Vereador v where v.partido.nome like :filtro")
	List<Vereador> vereadorPartido(String filtro);
	
	@Query("select v from Vereador v where v.dataAssociacao >= :dataInicio and dataAssociacao <= :dataFim")
	List<Vereador> vereadorData(Date dataInicio, Date dataFim);
	
	@Query("select p from Partido p")
	List<Partido> partidos();
}
