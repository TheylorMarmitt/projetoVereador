package br.edu.unoesc.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Vereador")
@PrimaryKeyJoinColumn(name="codigo")
@NamedQueries({ @NamedQuery(name = Vereador.listarTodos, query = "select v from Vereador v") })
public class Vereador extends Pessoa {

	private Date dataAssociacao;

	@ManyToOne
	@JoinColumn(name = "partido_codigo")
	private Partido partido;
	
	@OneToMany(mappedBy = "vereador", targetEntity = Projeto.class, 
	fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private Set<Projeto> projetos = new HashSet<Projeto>();
	
	public static final String listarTodos = "buscarTodosVereadores";
	
	public Integer qtdeProjetosApresentados(){
		return null;
	}
	
	public Integer qtdeProjetosAprovados(){
		return null;
	}
	
	public Integer adicionaProjeto(Projeto projeto){
		return null;
	}
	
	public Float desempenho(){
		return null;
	}

	public Vereador(Date dataAssociacao, Partido partido, Set<Projeto> projetos) {
		super();
		this.dataAssociacao = dataAssociacao;
		this.partido = partido;
		this.projetos = projetos;
	}

	public Vereador() {

	}

	public Date getDataAssociacao() {
		return dataAssociacao;
	}

	public void setDataAssociação(Date dataAssociacao) {
		this.dataAssociacao = dataAssociacao;
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
		return "Vereador : dataAssociação=" + dataAssociacao + ", partido=" + partido
				+ ", projetos=" + projetos + "]";
	}
	
}
