package br.edu.unoesc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unoesc.model.Projeto;

public interface ProjetoDao extends JpaRepository<Projeto, Long> {

	List<Projeto> findByNome(String nome);
	
	
	
	@Query("select p from Projeto p where p.vereador.nome like ?1%")
	List<Projeto> projetosPorVereador(String filtro);
	
	
	
}
//@Query("select v from Vereador v where v.codigo like : filtro")
