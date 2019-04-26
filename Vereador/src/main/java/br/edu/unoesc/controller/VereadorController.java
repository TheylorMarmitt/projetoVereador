package br.edu.unoesc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.VereadorDao;
import br.edu.unoesc.model.Vereador;

@Controller
@Path("/vereador")
public class VereadorController {
	
	private Result result;
	private VereadorDao dao;

	public VereadorController() {

	}

	@Inject
	public VereadorController(Result result, VereadorDao dao ) {
		this.result = result;
		this.dao = dao;
	}
	
	@Get("/cadastro")
	public void novo() {
//		result.include("partidos", jdbcPartido.listar(Partido.listarTodos, Partido.class));
		result.include("partidos", this.dao.partidos());
	}
	
	@Post("/cadastro")
	public void lista(Vereador vereador, String dataAssociacao) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = format.parse(dataAssociacao);
		vereador.setData(parsed);
//		jdbc.inserir(vereador);
//		result.include("vereadores", jdbc.listar(Vereador.listarTodos, Vereador.class));
		this.dao.save(vereador);
		result.include("vereadores", this.dao.findAll());
	}
	
	@Get("/listar")
	public void lista() {
//		result.include("vereadores", jdbc.listar(Vereador.listarTodos, Vereador.class));
		result.include("vereadores", this.dao.findAll());
	}
	
	@Get("filtrarNome")
	public void lista(String filtroNome) {
//		result.include("vereadores", jdbc.vereadorNome(filtroNome));
		result.include("vereadores", this.dao.findByName(filtroNome));
	}
	
	@Get("/filtrarPartido")
	public void listaVereadores(String filtroPartido) {
//		result.include("vereadores", jdbc.vereadorPartido(filtroPartido)).redirectTo(this).listaPartido();
		result.include("vereadores", this.dao.vereadorPartido(filtroPartido)).redirectTo(this).listaPartido();
	}
	
	@Get("/filtroPartido")
	public void listaPartido() {
		
	}
	
	@Get("/filtrarData")
	public void lista(String dataInicio, String dataFim) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date Inicio = format.parse(dataInicio);
		Date Fim = format.parse(dataFim);
		result.include("vereadores", this.dao.vereadorData(Inicio, Fim));
	}

}
