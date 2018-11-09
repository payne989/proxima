package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.RuoloDao;
import model.Ruolo;

/**
 * Servlet implementation class ImpiegatoServlet
 */
@WebServlet("/RuoloServlet")
public class RuoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public RuoloServlet() {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Ruolo inserito con successo nel database!");

		String funzione = request.getParameter("funzione");
		try {
		if (funzione.equals("inserisci")) {

			String nomeruolo = request.getParameter("nomeruolo");
			int stipendio = Integer.parseInt(request.getParameter("stipendio"));

			Ruolo ruo = new Ruolo(0, nomeruolo, stipendio);

			
				RuoloDao.insert(ruo);
			} 

		

		else if (funzione.equals("cerca")) {

			int id = Integer.parseInt(request.getParameter("id"));
			RuoloDao.researchById(id);
		}

		else if (funzione.equals("cancella")) {

			int id = Integer.parseInt(request.getParameter("id"));
			try {
				RuoloDao.delete(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (funzione.equals("aggiorna"))

		{

			String ruolo = request.getParameter("nomeruolo");
			Integer stipendio = Integer.parseInt(request.getParameter("stipendio"));
			int id = Integer.parseInt(request.getParameter("id"));

			try {
				RuoloDao.update(ruolo, stipendio, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	}