<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="ar.com.educacionit.web.practicaAdicionalSemana15.Domain.Empleado"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%
//Objeto implicito que tiene las jsp
Map<Long, Empleado> mapa = (HashMap) request.getAttribute("mapa");
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
		<h2>Listado de datos creados</h2>
		<table>
  			<tr>
    			<th>Documento</th>
    			<th>Nombre</th>
   				<th>Apellido</th>
   				<th>Edad</th>
   				<th>Ocupacion</th>
   				<th>Fecha Nacimiento</th>
  			</tr>
				<%//Recorrer el listado e ir dibujando 
				for (Map.Entry<Long,Empleado> entry : mapa.entrySet()) {
				%>
				<tr>
					<td> <%=entry.getKey()%></td>
					<td> <%=entry.getValue().getNombre()%></td>
					<td> <%=entry.getValue().getApellido()%></td>
					<td> <%=entry.getValue().getEdad()%></td>
					<td> <%=entry.getValue().getOcupacion()%></td>
					<td> <%=entry.getValue().getFechaNacimiento()%></td>
				</tr>
				<%
				}
				%>
		</table>
		<form action="<%=request.getContextPath()%>/Semana15ServletListado" method="GET">
			<button>INICIO</button>
		</form>
	</main>
	<footer>
		<p>Solucion ejercicio practica adicional semana 15</p>
	</footer>
</body>
</html>