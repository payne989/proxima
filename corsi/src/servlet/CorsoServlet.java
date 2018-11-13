package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CorsoDTO;
import ejb.Corsoejb;
import ejbInterfaces.CorsoejbRemote;

/**
 * Servlet implementation class CorsoServlet
 */
@WebServlet("/CorsoServlet")
public class CorsoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	@Resource(mappedName = "java:jboss/exported/WebApp/corsi/Corsoejb!ejbInterfaces.CorsoejbRemote")
	private CorsoejbRemote corsiejb;
	
   
    public CorsoServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String funzione = request.getParameter("funzione");
		
		if (funzione.equals("inserisci")) {
		corsiejb.insertCorso(request.getParameter("nome"));
		}
		else if (funzione.equals("modifica")) {
			
			CorsoDTO cor = new CorsoDTO();
			cor.setId(3);
			cor.setNome("Hibernate");
		corsiejb.updateCorso(cor);
			
		}	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
