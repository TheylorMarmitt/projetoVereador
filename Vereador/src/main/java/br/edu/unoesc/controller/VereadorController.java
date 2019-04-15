package br.edu.unoesc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.PartidoJDBC;
import br.edu.unoesc.dao.VereadorJDBC;
import br.edu.unoesc.model.Partido;
import br.edu.unoesc.model.Projeto;
import br.edu.unoesc.model.Vereador;

@Controller
@Path("/vereador")
public class VereadorController {
	
	private Result result;
	private VereadorJDBC jdbc;

	public VereadorController() {

	}

	@Inject
	public VereadorController(Result result, VereadorJDBC jdbc) {
		this.result = result;
		this.jdbc = jdbc;
	}
	
	@Get("/cadastro")
	public void novo() {
		PartidoJDBC jdbcPartido = new PartidoJDBC() ;
		result.include("partidos", jdbcPartido.listar(Partido.listarTodos, Partido.class));
	}
	
	@Post("/cadastro")
	public void lista(Vereador vereador, String dataAssociacao) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = format.parse(dataAssociacao);
		vereador.setDataAssociação(parsed);
		jdbc.inserir(vereador);
		result.include("vereadores", jdbc.listar(Vereador.listarTodos, Vereador.class));
	}
	
	@Get("/listar")
	public void lista() {
		result.include("vereadores", jdbc.listar(Vereador.listarTodos, Vereador.class));
	}
	
	@Get("filtrarNome")
	public void lista(String filtroNome) {
		result.include("vereadores", jdbc.vereadorNome(filtroNome));
	}
	
	@Get("/filtrarPartido")
	public void listaVereadores(String filtroPartido) {
		result.include("vereadores", jdbc.vereadorPartido(filtroPartido)).redirectTo(this).listaPartido();
	}
	
	@Get("/filtroPartido")
	public void listaPartido() {
		
	}
	
	@Get("/filtrarData")
	public void lista(String dataInicio, String dataFim) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date Inicio = format.parse(dataInicio);
		Date Fim = format.parse(dataFim);
		result.include("vereadores", jdbc.vereadorData(Inicio, Fim));
	}

}
