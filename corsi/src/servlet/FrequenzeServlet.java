package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.EdizioneDTO;
import dto.FrequenzeDTO;
import ejbInterfaces.EdizioneejbRemote;
import ejbInterfaces.FrequenzeejbRemote;
import utility.Util;


@WebServlet("/FrequenzeServlet")
public class FrequenzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Resource(mappedName = "java:jboss/exported/WebApp/corsi/Frequenzeejb!ejbInterfaces.FrequenzeejbRemote")
	private FrequenzeejbRemote freqejb;
   
    public FrequenzeServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String funzione = request.getParameter("funzione");
//
//		if (funzione.equals("inserisci")) {
//
//			String idImp_str = request.getParameter("idimp");
//			String idEdiz_str = request.getParameter("idedizione");
//			
//
//			if (idImp_str != null && idEdiz_str != null )
//					 {
//				try {
//					int idImp = Integer.parseInt(idImp_str);
//					int idEdiz = Integer.parseInt(idEdiz_str);
//					
					FrequenzeDTO fr = new FrequenzeDTO();

					fr.setIdImp(1);
					fr.setIdEdiz(1);
					
					freqejb.insertFrequenze(fr);
//				} catch (NumberFormatException e) {
//
//				}
//			}
//		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
