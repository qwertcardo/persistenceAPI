package br.com.qwertcardo.controller;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.qwertcardo.model.Filme;
import br.com.qwertcardo.util.UtilJPA;

@Controller
public class FilmeController {

	@Autowired
	AutorController autorController;

	@RequestMapping(value = "/persistir-filme", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public ResponseEntity<Filme> persistirFilme(@RequestBody Filme filme) {
		EntityManager em = UtilJPA.getEntityManager();
			em.getTransaction().begin();
		
		try {
			autorController.consultarAutor(filme.getAutor().getId());
			em.persist(filme);
		} catch (Exception error) {
			em.persist(filme.getAutor());
			em.persist(filme);
		} finally {
			em.getTransaction().commit();
			em.close();
		}
		return ResponseEntity.ok().body(filme);
	}

	@RequestMapping(value = "/consultar-filme", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Filme consultarFilme(@RequestParam Integer id) {
		EntityManager em = UtilJPA.getEntityManager();

		Filme filme = em.find(Filme.class, id);
		em.close();

		return filme;
	}
}
