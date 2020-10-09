<%@page import="java.util.ArrayList"%>
<%@page import="br.com.qwertcardo.model.Filme"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de filmes - DB</title>
</head>
<body>
	<h2>Lista de Filmes</h2>
	<ol>
		<%
			ArrayList<Filme> filmes = new ArrayList<Filme>();
		filmes = (ArrayList<Filme>) request.getAttribute("listaDeFilmes");

		for (Filme filme : filmes) {
		%>
		<li>
			<%
				out.println("Nome: " + filme.getNome());
				out.println(" // Genero: " + filme.getGenero());
				out.println(" // Ano: " + filme.getAno());
			%>
		</li>
		<%
			}
		%>

	</ol>
</body>
</html>