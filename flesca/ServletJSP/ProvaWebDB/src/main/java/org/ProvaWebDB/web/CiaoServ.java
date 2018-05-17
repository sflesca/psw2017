package org.ProvaWebDB.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "ciaoServ")
public class CiaoServ extends HttpServlet {
	@Inject
	ServletContext cntx;
	
	private int count =0;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		 count=0;
	}


//	@Override
//	protected void doGet(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		
//		gotoPage("/primajsp.jsp",request,response);
//	}
	
	

	@Override
	protected void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().println("Method doPost invoked");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		gotoPage("/primajsp.jsp",request,response);
	}


	private void gotoPage(String address, HttpServletRequest request,
			HttpServletResponse response) throws ServletException,IOException{
		RequestDispatcher dispatcher =
			cntx.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}
}