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
import ejbInterfaces.CorsoejbRemote;

@WebServlet("/CorsiServlet")
public class CorsiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/exported/corsi/Corsoejb!ejbInterfaces.CorsoejbRemote")
	private CorsoejbRemote corsiejb;

	public CorsiServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funzione = request.getParameter("funzione");

		if (funzione.equals("inserisci")) {

			String nome = request.getParameter("nome");

			corsiejb.insertCorso(nome);
		} else if (funzione.equals("cercaid")) {

			int id = Integer.parseInt(request.getParameter("id"));
			CorsoDTO cor = corsiejb.selectCorsoById(id);

			request.setAttribute("corso", cor);
		}

		else if (funzione.equals("cercanome")) {

			String nome = request.getParameter("nome");
			ArrayList<CorsoDTO> corList = corsiejb.selectCorsoByNome(nome);

			request.setAttribute("corso", corList);
		}

		else if (funzione.equals("cancella")) {

			int id = Integer.parseInt(request.getParameter("id"));
			corsiejb.deleteCorso(id);
		}

		else if (funzione.equals("modifica")) {

			String nome = request.getParameter("nome");

			corsiejb.updateCorso(nome);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}