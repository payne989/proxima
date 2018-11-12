package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FrequenzeDTO;
import ejbInterfaces.FrequenzeejbRemote;

@WebServlet("/FrequenzeServlet")
public class FrequenzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(mappedName = "java:jboss/exported/corsi/Corsoejb!ejbInterfaces.CorsoejbRemote")
	private FrequenzeejbRemote freqejb;

	public FrequenzeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funzione = request.getParameter("funzione");

		if (funzione.equals("inserisci")) {

			int idImp = Integer.parseInt(request.getParameter("idimp"));
			int idEdiz = Integer.parseInt(request.getParameter("idediz"));

			freqejb.insertFrequenze(idImp, idEdiz);

		} else if (funzione.equals("cancellaid")) {

			int id = Integer.parseInt(request.getParameter("id"));

			freqejb.deleteFrequenzeById(id);
		} else if (funzione.equals("cancellasede")) {

			int idSede = Integer.parseInt(request.getParameter("idsede"));

			freqejb.deleteFrequenzeByIdSede(idSede);
		} else if (funzione.equals("cancellacorso")) {

			int idCorso = Integer.parseInt(request.getParameter("idcorso"));

			freqejb.deleteFrequenzeByIdCorso(idCorso);
		}

		else if (funzione.equals("cancelladocente")) {

			int idDocente = Integer.parseInt(request.getParameter("iddocente"));

			freqejb.deleteFrequenzeByIdDocente(idDocente);

		}

		else if (funzione.equals("cercaidfrequenze")) {

			int id = Integer.parseInt(request.getParameter("id"));

			FrequenzeDTO freq = freqejb.selectFrequenzeById(id);

			request.setAttribute("frequenze", freq);
		}

		else if (funzione.equals("cercafrequenze")) {

			ArrayList<FrequenzeDTO> freqList = freqejb.selectAllFrequenze();

			request.setAttribute("frequenze", freqList);
		}

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
