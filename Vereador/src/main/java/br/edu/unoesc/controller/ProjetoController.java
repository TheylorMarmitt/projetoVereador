package br.edu.unoesc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unoesc.dao.ProjetoDao;
import br.edu.unoesc.dao.VereadorDao;
import br.edu.unoesc.model.Projeto;
import br.edu.unoesc.model.Vereador;

@Controller
@RequestMapping("/projeto")
public class ProjetoController {

	@Autowired
	private ProjetoDao dao;
	
	@Autowired
	private VereadorDao daoVereador;
	
	@RequestMapping(path = "/cadastro")
	public String cadastro(Model model) {
		model.addAttribute("vereadores", this.daoVereador.findAll());
		return "projeto/novo";
	}
	
	@RequestMapping(path = "/enviar", method = RequestMethod.POST)
	public String lista(Projeto projeto, String aprovado, String apresentado, Model model) {
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
		Vereador vereador = this.daoVereador.findById(projeto.getVereador().getCodigo());
		
		projeto.setVereador(vereador);
		vereador.adicionaProjeto(projeto);
		
		this.daoVereador.saveAndFlush(vereador);
		this.dao.saveAndFlush(projeto);

		model.addAttribute("projetos", this.dao.findAll());
		return "projeto/lista";
	}
	
	@RequestMapping(path = "/listar")
	public String lista(Model model) {
		model.addAttribute("projetos", this.dao.findAll());
		return "projeto/lista";
	}
	
	@RequestMapping(path = "/filtrarNome")
	public String lista(String filtro, Model model) {
		model.addAttribute("projetos", this.dao.findByNome(filtro));
		return "projeto/lista";
	}

	@RequestMapping(path = "/filtrarVereador")
	public String cadastro(String filtroVereador, Model model) {
		model.addAttribute("projetos", this.dao.projetosPorVereador(filtroVereador));
		return "projeto/projetoVereador";
	}

}
