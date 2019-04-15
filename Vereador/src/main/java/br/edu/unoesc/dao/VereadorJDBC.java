package br.edu.unoesc.dao;


import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import br.edu.unoesc.model.Partido;
import br.edu.unoesc.model.Vereador;

public class VereadorJDBC extends GenericDao<Vereador>{
	
	public List vereadorNome(String filtro) {
		conectar();
		Query query = em.createQuery("Select v from Vereador v where v.nome like : filtro");
		query.setParameter("filtro", filtro);	
		return query.getResultList();
	}
	
	public List vereadorPartido(String filtro) {
		conectar();
		Query query = em.createQuery("Select v from Vereador v where v.partido.nome like :filtro");
		query.setParameter("filtro", filtro);	
		return query.getResultList();
	}	
	
	public List vereadorData(Date dataInicio, Date dataFim) {
		conectar();
		Query query = em.createQuery("Select v from Vereador v where v.dataAssociacao >= :dataInicio and dataAssociacao <= :dataFim");
		query.setParameter("dataInicio", dataInicio);
		query.setParameter("dataFim", dataFim);
		return query.getResultList();
	}	
	
	public List vereadores() {
		conectar();
		Query query = em.createQuery("select v from Vereador v");
		return query.getResultList();
		
	}
}
