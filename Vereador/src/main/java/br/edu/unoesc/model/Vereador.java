package br.edu.unoesc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Vereador")
@PrimaryKeyJoinColumn(name = "codigo")
public class Vereador extends Pessoa {

	private Date dataAssociacao;

	@ManyToOne
	@JoinColumn(name = "partido_codigo")
	private Partido partido;

	@OneToMany(mappedBy = "vereador", targetEntity = Projeto.class, fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Set<Projeto> projetos = new HashSet<Projeto>();

	public Integer qtdeProjetosApresentados() {
		Integer contador = 0;
		for (Projeto projeto : projetos) {
			if (projeto.isApresentado()) {
				contador++;
			}
		}
		return contador;
	}

	public Integer qtdeProjetosAprovados() {
		Integer contador = 0;
		for (Projeto projeto : projetos) {
			if (projeto.isAprovado()) {
				contador++;
			}
		}
		return contador;
	}

	public void adicionaProjeto(Projeto projeto) {
		projetos.add(projeto);
	}

	public Double desempenho() {
		Integer ap = 0;
		for (Projeto projeto : projetos) {
			if (projeto.isAprovado()) {
				ap++;
			}
		}
		if (projetos.isEmpty()) {
			return (double) 0;
		}
		return (double) ((ap * 100.0) / projetos.size());
	}

	public Vereador(Date data, Partido partido, Set<Projeto> projetos) {
		super();
		this.dataAssociacao = data;
		this.partido = partido;
		this.projetos = projetos;
	}

	public Vereador() {

	}

	public Date getData() {
		return dataAssociacao;
	}

	public void setData(Date data) {
		this.dataAssociacao = data;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Set<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Set<Projeto> projetos) {
		this.projetos = projetos;
	}

	@Override
	public String toString() {
		return "Vereador [dataAssociacao=" + dataAssociacao + ", partido=" + partido + ", projetos=" + projetos + "]";
	}

}
