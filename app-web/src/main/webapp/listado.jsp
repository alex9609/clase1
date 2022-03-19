<!--  Importar clases -->
<%@page import = "ar.com.educacionit.domain.Articulos" %>
<%@page import = "java.util.List" %>
<html>
	<head>
	
	</head>
	<body>
		<!-- Quiero capturar el listado que envio el servlet bajo el nombre
		listado
		 -->
		 
		 <!--  El scriplet me permite escribiir condigo JAVA
		 dentro de la jsp tengo un "objeto implicito" llamado request
		 
		 no hay que instanciarlo, solo llamarlo-->
		 <%
		 
		 //Primero -> Caputro la informacion
		 Object listadoObject = request.getAttribute("Listado");
		 
		 //Puedo castear
		 List<Articulos> listado = (List<Articulos>)listadoObject;
		 %>
		 
		 <%
		 //Recorrer el listado e ir dibujando 
		 for(Articulos art : listado){
		 %>
		 <!-- Puedo poder el html puto y usar el objeto art -->
		 
		 	<!-- Esto es como hacer un print -->
		 	<p><%=art.getTitulo()%> 
		 	   <%=art.getCodigo()%> 
		 	   <%=art.getPrecio()%> 
		 	   <%=art.getFechaCreacion()%></p>
		 <%
		 }
		 %>
	</body>

</html>