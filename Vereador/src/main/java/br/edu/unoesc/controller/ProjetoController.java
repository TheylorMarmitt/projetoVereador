package br.edu.unoesc.controller;

import javax.inject.Inject;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.ProjetoJDBC;
import br.edu.unoesc.dao.VereadorJDBC;
import br.edu.unoesc.model.Projeto;
import br.edu.unoesc.model.Vereador;

@Controller
@Path("/projeto")
@NamedQueries({ @NamedQuery(name = Projeto.listarTodos, query = "select pro from Projeto pro") })
public class ProjetoController {

	private Result result;
	private ProjetoJDBC jdbc;
	

	public ProjetoController() {

	}

	@Inject
	public ProjetoController(Result result, ProjetoJDBC jdbc) {
		this.result = result;
		this.jdbc = jdbc;
	}
	
	@Get("/cadastro")
	public void novo() {
		VereadorJDBC jdbcVereador = new VereadorJDBC() ;
		result.include("vereadores", jdbcVereador.listar(Vereador.listarTodos, Vereador.class));
	}
	
	@Post("/enviar")
	public void lista(Projeto projeto, String aprovado, String apresentado) {
		if(aprovado.contentEquals("true")) {
			projeto.setAprovado(true);
		}else {
			projeto.setAprovado(false);
		}
		if(apresentado.contentEquals("true")) {
			projeto.setApresentado(true);
		}else {
			projeto.setApresentado(false);
		}

		VereadorJDBC jdbcVereador = new VereadorJDBC() ;
		Vereador vereador =  jdbcVereador.buscar(Vereador.class, (long)projeto.getVereador().getCodigo());
		vereador.adicionaProjeto(projeto);
		jdbcVereador.alterar(vereador);
		
		jdbc.inserir(projeto);
		result.include("projetos", jdbc.listar(Projeto.listarTodos, Projeto.class));
	}
	
	@Get("/listar")
	public void lista() {
		result.include("projetos", jdbc.listar(Projeto.listarTodos, Projeto.class));
	}
	
	@Get("/filtrarNome")
	public void lista(String filtro) {
		result.include("projetos", jdbc.projetosNome(filtro));
	}
	
	@Get("/projetoVereador")
	public void projetoVereador() {
		
	}
	
	@Get("/filtrarVereador")
	public void listaVereadores(String filtroVereador) {
		result.include("projetos", jdbc.projetosPorVereador(filtroVereador)).redirectTo(this).projetoVereador();;
	}


}
