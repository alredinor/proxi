package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAODemande;
import dao.DAOService;
import dao.FactoryDemande;
import dao.FactoryService;
import model.Demande;
import model.Service;

/**
 * Servlet implementation class serviceServlet
 */
@WebServlet("/service")
public class serviceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		DAOService daoS= FactoryService.getDAOService();
		//String id=request.getParameter("id");
		
		List<Service> S=daoS.selectAll();
		request.setAttribute("service", S);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/service.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
