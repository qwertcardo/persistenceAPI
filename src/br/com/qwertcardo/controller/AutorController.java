package br.com.qwertcardo.controller;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.qwertcardo.model.Autor;
import br.com.qwertcardo.util.UtilJPA;

@Controller
public class AutorController {

	@RequestMapping(value = "/consultar-autor", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Autor consultarAutor(@RequestParam Integer id) {
		EntityManager em = UtilJPA.getEntityManager();
		
		Autor autor = em.find(Autor.class, id);
		em.close();
		
		return autor;
	}
	
}
