package br.edu.unoesc.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.PartidoDao;
import br.edu.unoesc.model.Partido;

@Controller
@Path("/partido")
public class PartidoController {

	private Result result;
	private PartidoDao dao;

	public PartidoController() {

	}

	@Inject
	public PartidoController(Result result, PartidoDao dao) {
		this.result = result;
		this.dao = dao;
	}
	
	@Get("/cadastro")
	public void novo() {
	
	}
	
	@Post("/enviar")
	public void lista(Partido partido) {
		this.dao.save(partido);
		result.include("partidos", this.dao.findAll());
	}
	
	@Get("/listar")
	public void lista() {
		result.include("partidos", this.dao.findAll());
	}


}
