package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type=request.getParameter("identifiant");
		if(type==null) {
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
		else {
		if(type.equals("Artisan")) {
			System.out.println("1");
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuArtisan.jsp").forward(request, response);
		}
		else if(type.equals("Client")) {
			System.out.println("2");
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuClient.jsp").forward(request, response);
		}
		else {
			System.out.println("3");
			this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		}
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
