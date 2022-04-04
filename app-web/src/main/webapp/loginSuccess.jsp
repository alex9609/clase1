<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%@page import="ar.com.educacionit.domain.Users"%>
<%@page isELIgnored="false" %>
<%
//Objeto implicito que tiene las jsp
Users user = (Users) session.getAttribute(ViewKeysEnum.USER.getParam());
%>

<html lang="es">

	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Insert title here</title>
		<jsp:include page="styles.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="navbar.jsp"></jsp:include>
		<main>
		<jsp:include page="mensajeria.jsp" />
			<h1>Username: <%=user.getUsername()%></h1>
			<h2>Nombre: <%=user.getSocio().getNombre()%></h1>
			<h2>Apellido: <%=user.getSocio().getApellido() %></h2>
			
			<a href="<%=request.getContextPath()%>/BuscarProductosServlet">Ver listado</a>
		</main>
		<jsp:include page="scripts.jsp" />
	</body>
</html>