package br.com.qwertcardo.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.qwertcardo.model.Filme;
import br.com.qwertcardo.util.UtilJPA;

@WebServlet("/listar-filmes")
public class ServletListarFilme extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		EntityManager em = UtilJPA.getEntityManager();
		em.getTransaction().begin();

		TypedQuery<Filme> query = em.createQuery("SELECT f FROM Filme f", Filme.class);
		List<Filme> filmes = query.getResultList();
		
		em.close();

		ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
		listaDeFilmes.addAll(filmes);

		req.setAttribute("listaDeFilmes", listaDeFilmes);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/listar-filmes.jsp");
		dispatcher.forward(req, res);
	}

}
