package servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EdizioneDTO;
import ejbInterfaces.EdizioneejbRemote;
import utiliy.Util;

@WebServlet("/EdizioneServlet")
public class EdizioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Resource(mappedName = "java:jboss/exported/corsi/Edizioneejb!ejbInterfaces.EdizioneejbRemote")
	private EdizioneejbRemote edizejb;
	
	public EdizioneServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String funzione = (request.getParameter("funzione"));
			
			if (funzione.equals("inserisci")) {
				
				int idCorso = Integer.parseInt(request.getParameter("idcorso"));
				int idSede = Integer.parseInt(request.getParameter("idsede"));
				int idDocente = Integer.parseInt(request.getParameter("iddocente"));
				Date dataIn = Util.stringToDate(request.getParameter("datain"));
				Date dataFin = Util.stringToDate(request.getParameter("datafin"));
				
				edizejb.insertEdizione(idCorso, idSede, idDocente, dataIn, dataFin);
			}
		
			else if (funzione.equals("modifica")) {
				
				int id = Integer.parseInt(request.getParameter("id"));
				int idCorso = Integer.parseInt(request.getParameter("idcorso"));
				int idSede = Integer.parseInt(request.getParameter("idsede"));
				int idDocente = Integer.parseInt(request.getParameter("iddocente"));
				Date dataIn = Util.stringToDate(request.getParameter("datain"));
				Date dataFin = Util.stringToDate(request.getParameter("datafin"));
				
				edizejb.updateEdizione(id, idCorso, idSede, idDocente, dataIn, dataFin);
				
			}
			else if (funzione.equals("cancellaid")) {

				int id = Integer.parseInt(request.getParameter("id"));

				edizejb.deleteEdizioneById(id);
				
			} else if (funzione.equals("cancellasede")) {

				int idSede = Integer.parseInt(request.getParameter("idsede"));

				edizejb.deleteEdizioneByIdSede(idSede);
			} else if (funzione.equals("cancellacorso")) {

				int idCorso = Integer.parseInt(request.getParameter("idcorso"));

				edizejb.deleteEdizioneByIdCorso(idCorso);
			}

			else if (funzione.equals("cancelladocente")) {

				int idDocente = Integer.parseInt(request.getParameter("iddocente"));

				edizejb.deleteEdizioneByIdDocente(idDocente);
			}
			
			else if (funzione.equals("cercaidedizione")) {
				
				int id = Integer.parseInt(request.getParameter("id"));
		
				EdizioneDTO ed = edizejb.selectEdizioneById(id);
				
				request.setAttribute("edizione", ed);
				
			}
		
			else if (funzione.equals("cercaedizioni")) {
				
				ArrayList<EdizioneDTO> edList = edizejb.selectAllEdizione();
				
				request.setAttribute("edizione", edList);
				
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
