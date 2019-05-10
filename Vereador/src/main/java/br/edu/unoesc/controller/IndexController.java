package br.edu.unoesc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class IndexController {
	
	
	@RequestMapping(path = { "", "/" })
	public String cadastro() {
		return "partido/novo";
	}
	
}