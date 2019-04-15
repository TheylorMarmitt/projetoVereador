package br.edu.unoesc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Projeto")
@NamedQueries({ @NamedQuery(name = Projeto.listarTodos, query = "select p from Projeto p") })
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String nome;
	private boolean aprovado;
	private boolean apresentado;

	public static final String listarTodos = "buscarTodosProjetos";
	
	@ManyToOne
	@JoinColumn(name = "vereador_id")
	private Vereador vereador;

	public Projeto(int codigo, String nome, boolean aprovado, boolean apresentado, Vereador vereador) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.aprovado = aprovado;
		this.apresentado = apresentado;
		this.vereador = vereador;
	}

	public Projeto() {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAprovado() {
		return aprovado;
	}

	public void setAprovado(boolean aprovado) {
		this.aprovado = aprovado;
	}

	public boolean isApresentado() {
		return apresentado;
	}

	public void setApresentado(boolean apresentado) {
		this.apresentado = apresentado;
	}

	public Vereador getVereador() {
		return vereador;
	}

	public void setVereador(Vereador vereador) {
		this.vereador = vereador;
	}

	@Override
	public String toString() {
		return "Projeto [codigo=" + codigo + ", nome=" + nome + ", aprovado=" + aprovado + ", apresentado="
				+ apresentado + ", vereador=" + vereador + "]";
	}

}
