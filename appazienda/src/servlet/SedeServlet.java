package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CorsoDTO;
import dto.SedeDTO;
import ejbInterfaces.SedeejbRemote;


@WebServlet("/SedeServlet")
public class SedeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(mappedName = "java:jboss/exported/corsi/Sedeejb!ejbInterfaces.SedeejbRemote")
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
			
			sedeejb.insertSede(nomesede, indirizzo, citta);
			}
		else if (funzione.equals("modifica")) {
			
			String nomesede = request.getParameter("nomesede");
			String indirizzo = request.getParameter("indirizzo");
			String citta = request.getParameter("citta");
			int id = Integer.parseInt(request.getParameter("id"));
			
			sedeejb.updateSede(nomesede, indirizzo, citta, id);		
		}
		else if (funzione.equals("cancella")) {
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			sedeejb.deleteSede(id);
		}
		else if (funzione.equals("cercanome")) {
			
			String nome = request.getParameter("nome");
			ArrayList<SedeDTO> sedList = sedeejb.selectSedeByNome(nome);

			request.setAttribute("sede", sedList);
		}
		else if (funzione.equals("cercaid")) {

			int id = Integer.parseInt(request.getParameter("id"));
			SedeDTO sed = sedeejb.selectSedeById(id);

			request.setAttribute("sede", sed);
		}
		else if (funzione.equals("cercasedi")) {

			ArrayList<SedeDTO> sedList = sedeejb.selectAllSede();

			request.setAttribute("corso", sedList);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
