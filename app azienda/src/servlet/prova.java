package servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejb.ProvaEJBRemote;


@WebServlet("/prova")
public class prova extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource (mappedName = "java:jboss/exported/provaejb/ProvaEJB!ejb.ProvaEJBRemote")
    private ProvaEJBRemote interfaccia;
	
    public prova() {
        super();
        }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		interfaccia.prova();
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
