package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbInterfaces.SedeejbRemote;


@WebServlet("/SedeServlet")
public class SedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(mappedName = "java:jboss/exported/corsi/Corsoejb!ejbInterfaces.CorsoejbRemote")
	private SedeejbRemote sedeejb;
    
    public SedeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String funzione = request.getParameter("funzione");
		
		if (funzione.equals("inserisci")) {
			
			String nomesede = request.getParameter("nomesede");
			String indirizzo = request.getParameter("indirizzo");
			String citta = request.getParameter("citta");
			
			
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
