package br.edu.unoesc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.unoesc.dao.PartidoDao;
import br.edu.unoesc.dao.VereadorDao;
import br.edu.unoesc.model.Vereador;

@Controller
@RequestMapping("/vereador")
public class VereadorController {
	
	@Autowired
	private VereadorDao dao;
	
	@Autowired
	private PartidoDao partidoDao;
	
	@RequestMapping(path = "/cadastro")
	public String novo(Model model) {
		model.addAttribute("partidos", this.partidoDao.findAll());
		return "vereador/novo";
	}
	
	@RequestMapping(path = "/cadastro", method = RequestMethod.POST)
	public String lista(Vereador vereador, String dataAsso,  Model model) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = format.parse(dataAsso);
		vereador.setDataAssociacao(parsed);
		this.dao.saveAndFlush(vereador);
		model.addAttribute("vereadores", this.dao.findAll());
		return "vereador/lista";
	}
	
	@RequestMapping(path = "/listar")
	public String lista(Model model) {
		model.addAttribute("vereadores", this.dao.findAll());
		return "vereador/lista";
	}
	
	@RequestMapping(path = "/filtrarNome")
	public String lista(String filtroNome, Model model) {
		model.addAttribute("vereadores", this.dao.findByNome(filtroNome));
		return "vereador/lista";
	}
	
	@RequestMapping(path = "/filtrarPartido")
	public String listaVereadores(String filtroPartido, Model model) {
		model.addAttribute("vereadores", this.dao.vereadorPartido(filtroPartido));
		return "vereador/listaPartido";
	}

	@RequestMapping(path = "/filtrarData")
	public String lista(String dataInicio, String dataFim, Model model) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date Inicio = format.parse(dataInicio);
		Date Fim = format.parse(dataFim);
		model.addAttribute("vereadores", this.dao.vereadorData(Inicio, Fim));
		return "vereador/lista";
	}
}
