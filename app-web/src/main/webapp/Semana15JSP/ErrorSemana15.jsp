<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%
//Objeto implicito que tiene las jsp
String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Semana 15</title>
</head>
<body>

	<header>
		<h1>Error al cargar los datos</h1>
	</header>
	<main>
		<h2>Error datos del formulario</h2>
		
		<p><%=error%></p>
	</main>
	<form action="<%=request.getContextPath()%>/Semana15ServletListado" method = "GET">
		<button>INICIO</button>
	</form>
	<footer>
		<p>Solucion ejercicio practica adicional semana 15</p>
	</footer>
</body>
</html>