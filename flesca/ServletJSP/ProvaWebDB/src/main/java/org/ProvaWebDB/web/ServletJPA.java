package org.ProvaWebDB.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.inject.Inject;
import javax.persistence.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import org.ProvaWebDB.model.*;

@WebServlet(urlPatterns = "servletJPA")
public class ServletJPA extends HttpServlet {
	
	@PersistenceContext
	EntityManager em;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Elenco Prodotti</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>Prodotti</h1>");
		Query q = em.createNamedQuery("findAll");
		List<Prodotto> l =q.getResultList();
		response.getWriter().println("<ul>");
		for( Prodotto p: l) {
			response.getWriter().println("<li>id:"+p.getId()+" nome:"+p.getNome()+"</li>");
		}
		response.getWriter().println("</ul>");
		response.getWriter().println(
				"</body>\n" + 
				"</html>");
	}
	
	private void gotoPage(String address, HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher =
			getServletContext().getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

}