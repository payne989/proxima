<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>
		<font color="red">Ricerca Impiegato</font>
	</h1>

	<form action="ImpiegatoServlet" method="get">
		<font color=red>Ricerca tramite ID:</font><br> <input type="text" name="id">
		<br> <input type="hidden" name="funzione" value="cercaid">
		<input type="submit" value="Cerca"><br>
	</form>
	
	<br><form action="ImpiegatoServlet" method="get">
		<font color=red>Ricerca tramite codice fiscale:</font><br> <input type="text" name="codicefiscale">
		<br> <input type="hidden" name="funzione" value="cercacf">
		<input type="submit" value="Cerca"><br>
	</form>
	
	<br><form action="ImpiegatoServlet" method="get">
		<font color=red>Ricerca tramite nome:</font><br> <input type="text" name="nome">
		<br> <input type="hidden" name="funzione" value="cercanome">
		<input type="submit" value="Cerca">
	</form>
	
	<br><form action="ImpiegatoServlet" method="get">
		<font color=red>Ricerca tramite cognome:</font><br> <input type="text" name="cognome">
		<br> <input type="hidden" name="funzione" value="cercacognome">
		<input type="submit" value="Cerca">
	</form>
	
	
</body>
</html>