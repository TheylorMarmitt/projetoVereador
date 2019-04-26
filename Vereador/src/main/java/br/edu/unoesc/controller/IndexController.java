package br.edu.unoesc.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;


@Controller
@ApplicationScoped
public class IndexController {
	
	@Inject
	private Result result;

	@Path("/")
	public void index() {
		result.use(Results.logic()).redirectTo(PartidoController.class).novo();;
	}
	
}