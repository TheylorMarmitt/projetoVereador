package br.edu.unoesc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unoesc.model.Projeto;
import br.edu.unoesc.model.Vereador;

public interface ProjetoDao extends JpaRepository<Projeto, Long> {

	List<Projeto> findByName(String nome);
	
	@Query("select p from Projeto p where p.vereador.nome like : filtro")
	List<Projeto> projetosPorVereador(String filtro);
	
	@Query("select v from Vereador v where v.codigo = filtro")
	List<Vereador> vereadorPorCodigo(Long filtro);
	
	@Query("select v from Vereador v")
	List<Vereador> vereadores();
	
	@Query("select v from Vereador v where v.codigo = filtro")
	Vereador buscaPorId(long filtro);
}
