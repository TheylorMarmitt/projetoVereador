package br.edu.unoesc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Partido")
@NamedQueries({ @NamedQuery(name = Partido.listarTodos, query = "select p from Partido p") })
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;
	private String numero;
	private String nome;
	
	public static final String listarTodos = "buscarTodosPartidos";

	public Partido(long codigo, String numero, String nome) {
		super();
		this.codigo = codigo;
		this.setNumero(numero);
		this.nome = nome;
	}

	public Partido() {

	}

	public long getCodigo() {
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

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Partido [codigo=" + codigo + ", nome=" + nome + "]";
	}


}
