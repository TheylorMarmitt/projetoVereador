package br.edu.unoesc.dao;

import java.util.List;

import javax.persistence.Query;

import br.edu.unoesc.model.Projeto;

public class ProjetoJDBC extends GenericDao<Projeto> {

	public List projetosNome(String filtro) {
		conectar();
		Query query = em.createQuery("Select p from Projeto p where p.nome like : filtro");
		query.setParameter("filtro", filtro);	
		return query.getResultList();
	}
	
	public List projetosPorVereador(String filtro) {
		conectar();
		Query query = em.createQuery("Select p from Projeto p where p.vereador.nome like : filtro");
		query.setParameter("filtro", filtro);	
		return query.getResultList();
	}
	
}
