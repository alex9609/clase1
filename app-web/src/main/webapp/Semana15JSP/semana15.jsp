<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%
List<String> cargos = new ArrayList<>();
cargos.add("Estudiante");
cargos.add("Tester");
cargos.add("Frontend");
cargos.add("Backend");
cargos.add("Administrador");
cargos.add("ChiefCEO");
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
		<h2>Formulario</h2>
		<form action="<%=request.getContextPath()%>/semana15" method = "POST">
			<label>Documento</label>
			<br> 
			<input type="number" name="documento">
			<br> 
			<br>
			<label>Nombre</label>
			<br> 
			<input type="text" name="nombre">
			<br> 
			<br>
			<label>Apellido</label>
			<br>
			<input type="text" name="apellido"> 
			<br> 
			<br> 
			<label>Edad</label>
			<br> 
			<input type="number" name="edad"> 
			<br> 
			<br>
			<label>Ocupacion</label>
			<br> 
			<select name="ocupacion">
				<%
				//Recorrer el listado e ir dibujando 
				for (String c : cargos) {
				%>
				<option value=<%=c%>><%=c%></option>
				<%
				}
				%>
			</select> 
			<br> 
			<br> 
			<label>Fecha de nacimiento</label> 
			<br> 
			<input type="date" name="fechaNacimiento"> 
			<br> 
			<br>
			<button>Enviar informacion</button>
		</form>
		<br>
		<br>
		<form action="<%=request.getContextPath()%>/semana15" method = "GET">
			<button>VER EMPLEADOS CREADOS</button>
		</form>
	</main>
	<footer>
		<p>Solucion ejercicio practica adicional semana 15</p>
	</footer>
</body>
</html>