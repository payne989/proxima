package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CorsoDTO;
import ejbInterfaces.CorsoejbRemote;


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
			
			String nome = request.getParameter("nome");
			
		if (nome!= null) corsiejb.insertCorso(nome);
		}
		else if (funzione.equals("modifica")) {
			
			CorsoDTO cor = new CorsoDTO();
			cor.setId(Integer.parseInt(request.getParameter("id")));
			cor.setNome(request.getParameter("nome"));
		corsiejb.updateCorso(cor);
			
		}	
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
