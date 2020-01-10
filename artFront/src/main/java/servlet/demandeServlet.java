package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAODemande;
import dao.FactoryDemande;
import model.Demande;

/**
 * Servlet implementation class demandeServlet
 */
@WebServlet("/demande")
public class demandeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		DAODemande daoD= FactoryDemande.getDAODemande();
		String id=request.getParameter("id_demande");
		Demande D=daoD.selectById(Integer.parseInt("3"));
		request.setAttribute("demande", D);
		
		//daoD.selectAll();
		
		//List<Demande> maListe= daoD.selectAll();
		//request.setAttribute("listeSec", id);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/demande.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
