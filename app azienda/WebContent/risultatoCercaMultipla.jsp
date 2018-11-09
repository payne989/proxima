<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Array"%>
<%@page import="model.Impiegato"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ciao</title>
</head>
<body>

	<%
		ArrayList<Impiegato> impList = (ArrayList<Impiegato>) request.getAttribute("impiegato");
	%>

<table>

	<% System.out.println("la size dell'array e:"+impList.size());%>
	
	<tr><td>Id</td><td>Codice Fiscale</td><td>Nome</td><td>Cognome</td></tr>

	<%
		for (Impiegato i : impList) {
	%>	<tr>
	<!-- 		<td><input type="hidden" name="funzione" value="cancella">  -->
<!-- 		<input type="submit" value="X"> -->
		<td><%=i.getId()%></td>
		<td><%=i.getCodFisc()%></td>
		<td><%=i.getNome()%></td>
		<td><%=i.getCognome()%></td>
	</tr>


	<%
		}
	
	%>
	
	</table>



</body>
</html>