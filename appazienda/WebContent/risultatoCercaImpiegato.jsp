<%@page import="model.Impiegato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ImpiegatoServlet" method="get">
	<%
		Impiegato imp = (Impiegato) request.getAttribute("impiegato");
	%>
	<b>Id:</b><input type="text" name="id" value="<%=imp.getId()%>" readonly>
	<br>
	<b>Codice Fiscale:</b><input type="text" name="codfisc" value="<%=imp.getCodFisc()%>">
	<br>
	<b>Nome:</b><input type="text" name="nome" value="<%=imp.getNome()%>">
	<br>
	<b>Cognome:</b><input type="text" name="cognome" value="<%=imp.getCognome()%>">
	<br>
	<input type="hidden" name="funzione" value="aggiorna">
		<input type="submit" value="Aggiorna"><br>
		
	</form>

</body>
</html>