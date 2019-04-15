package br.edu.unoesc.controller;

import javax.inject.Inject;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.PartidoJDBC;
import br.edu.unoesc.model.Partido;

@Controller
@Path("/partido")
@NamedQueries({ @NamedQuery(name = Partido.listarTodos, query = "select p from Partido p") })
public class PartidoController {

	private Result result;
	private PartidoJDBC jdbc;

	public PartidoController() {

	}

	@Inject
	public PartidoController(Result result, PartidoJDBC jdbc) {
		this.result = result;
		this.jdbc = jdbc;
	}
	
	@Get("/cadastro")
	public void novo() {
	
	}
	
	@Post("/enviar")
	public void lista(Partido partido) {
		jdbc.inserir(partido);
		result.include("partidos", jdbc.listar(Partido.listarTodos, Partido.class));
	}
	
	@Get("/listar")
	public void lista() {
		result.include("partidos", jdbc.listar(Partido.listarTodos, Partido.class));
	}


}
