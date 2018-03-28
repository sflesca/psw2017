package org.ProvaWebDB.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "ciccio")
public class ciccio extends HttpServlet {
	
	@Resource(mappedName="java:/PostgresDS")
	DataSource dx;
	
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		response.setContentType("text/html");
		response.getWriter().println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<title>Elenco Prodotti</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>Prodotti</h1>");
		try {
			con = dx.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from prodotto");
			response.getWriter().println("<ul>");
			while(rs.next()) {
				response.getWriter().println("<li>id:"+rs.getInt(1)+" nome:"+rs.getString(2)+"</li>");
			}
			response.getWriter().println("</ul>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			response.getWriter().println(
					"</body>\n" + 
					"</html>");
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}