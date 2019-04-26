package br.edu.unoesc.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.edu.unoesc.dao.ProjetoDao;
import br.edu.unoesc.dao.VereadorDao;
import br.edu.unoesc.model.Projeto;
import br.edu.unoesc.model.Vereador;

@Controller
@Path("/projeto")
public class ProjetoController {

	private Result result;
	private ProjetoDao dao;
	private VereadorDao daoVereador;

	public ProjetoController() {

	}

	@Inject
	public ProjetoController(Result result, ProjetoDao dao, VereadorDao daoVereador) {
		this.result = result;
		this.dao = dao;
		this.daoVereador = daoVereador;
	}
	
	@Get("/cadastro")
	public void novo() {
		result.include("vereadores", this.dao.vereadores());
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

//		VereadorJDBC jdbcVereador = new VereadorJDBC() ;
//		Vereador vereador =  jdbcVereador.buscar(Vereador.class, projeto.getVereador().getCodigo());
//		vereador.adicionaProjeto(projeto);
//		jdbcVereador.alterar(vereador);
		
		Vereador vereador = this.dao.buscaPorId(projeto.getVereador().getCodigo());
		vereador.adicionaProjeto(projeto);
		this.daoVereador.save(vereador);
		
		this.dao.save(projeto);
		result.include("projetos", this.dao.findAll());
	}
	
	@Get("/listar")
	public void lista() {
		result.include("projetos", this.dao.findAll());
	}
	
	@Get("/filtrarNome")
	public void lista(String filtro) {
		result.include("projetos", this.dao.findByName(filtro));
	}
	
	@Get("/projetoVereador")
	public void projetoVereador() {
		
	}
	
	@Get("/filtrarVereador")
	public void listaVereadores(String filtroVereador) {
		result.include("projetos", this.dao.projetosPorVereador(filtroVereador)).redirectTo(this).projetoVereador();;
	}


}
