<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Home</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">

  
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="home.jsp">App Aziendale Proxima Centauri</a>


  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>	
    <form action="ImpiegatoServlet" method="get">

		<h1>App Aziendale Proxima Academy</h1>
		<br> <br><a
			href="http://localhost:8080/appazienda/ruoloInsert.jsp">
			Inserisci Nuovo Ruolo</a> <br> <a
			href="http://localhost:8080/appazienda/impiegatoSearch.jsp">
			Cerca Impiegato</a> <br> <a
			href="http://localhost:8080/appazienda/cancellaImpiegato.jsp">
			Cancella Impiegato</a> <br> 

			<a class="btn btn-dark"	href="impiegatoInsert.jsp">Inserisci Impiegato</a>

	</form>

    
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>