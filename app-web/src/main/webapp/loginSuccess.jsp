<%@page import="ar.com.educacionit.domain.Users"%>
<%
//Objeto implicito que tiene las jsp
Users user = (Users) session.getAttribute("usuario");
%>

<html>
	<head>
	<body>
		<main>
		
			<h1>Username: <%=user.getUsername()%></h1>
			<h2>Nombre: <%=user.getSocio().getNombre()%></h1>
			<h2>Apellido: <%=user.getSocio().getApellido() %></h2>
			
			<a href="<%=request.getContextPath()%>/BuscarProductosServlet">Ver listado</a>
		</main>
	</body>
	</head>
</html>