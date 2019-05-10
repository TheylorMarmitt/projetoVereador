package br.edu.unoesc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unoesc.dao.PartidoDao;
import br.edu.unoesc.model.Partido;

@Controller
@RequestMapping("/partido")
public class PartidoController {

	@Autowired
	private PartidoDao dao;

	
	@RequestMapping(path = "/cadastro")
	public String cadastro() {
		return "partido/novo";
	}

	@RequestMapping(path = "/enviar", method = RequestMethod.POST)
	public String lista(Partido partido, Model model) {
		dao.saveAndFlush(partido);
		model.addAttribute("partidos", this.dao.findAll());
		return "partido/lista";
	}
	
	@RequestMapping(path = "/listar")
	public String listar(Model model) {
		model.addAttribute("partidos", this.dao.findAll());
		return "partido/lista";
	}

	


}
