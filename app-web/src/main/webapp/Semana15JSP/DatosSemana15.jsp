<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import = "ar.com.educacionit.web.practicaAdicionalSemana15.Domain.Empleado" %>
<%
//Objeto implicito que tiene las jsp
Empleado empl = (Empleado) request.getAttribute("empleado");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Semana 15</title>
</head>
<body>

	<header>
		<h1>Practica adicional semana 15</h1>
	</header>
	<main>
		<h2>Datos del formulario</h2>
		
		<p><b>Documento: </b><%=empl.getDocumento()%></p>
		<p><b>Nombre: </b><%=empl.getNombre()%></p>
		<p><b>Apellido: </b><%=empl.getApellido()%></p>
		<p><b>Edad: </b><%=empl.getEdad()%></p>
		<p><b>Ocupacion: </b><%=empl.getOcupacion()%></p>
		<p><b>Fecha nacimiento: </b><%=empl.getFechaNacimiento()%></p>
		
		<h3>REGISTRADO CON EXITO</h3>
	</main>
	<form action="<%=request.getContextPath()%>/Semana15ServletListado" method = "GET">
		<button>INICIO</button>
	</form>
	<form action="<%=request.getContextPath()%>/semana15" method = "GET">
		<button>VER EMPLEADOS CREADOS</button>
	</form>
	<footer>
		<p>Solucion ejercicio practica adicional semana 15</p>
	</footer>
</body>
</html>