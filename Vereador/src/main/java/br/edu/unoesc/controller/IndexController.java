package br.edu.unoesc.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.unoesc.model.Partido;


@Controller
public class IndexController {
	
	@Inject
	private Result result;

	@Path("/")
	public void index() {
		result.use(Results.logic()).redirectTo(PartidoController.class).novo();;
	}
	
}