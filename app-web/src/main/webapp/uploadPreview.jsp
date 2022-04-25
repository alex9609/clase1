<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>

<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%@page isELIgnored="false"%>

<!-- con el doctype le decimos que es un hmtl 5 -->
<!DOCTYPE html>
<html lang=es>

<!-- Para reempazar elrequest.getContextPath()th()%> -->

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Insert title here</title>
<jsp:include page="styles.jsp" />
</head>
<body>
	<%--Incluyo la seccion del navbar con f3 corroboramos que este bien la dirección --%>
	<jsp:include page="navbar.jsp" />
	<main>
		<%--seccion para visualizar errores en loginservlet --%>
		<jsp:include page="mensajeria.jsp" />
		<section class="container">
			<div class="row d-flex justify-content-center">
				<h1>Preview de archivos a procesar</h1>
				<%
					Collection<Articulos> articulos = (Collection<Articulos>)request.getAttribute(ViewKeysEnum.UPLOAD_PREVIEW_KEY.getParam());
					out.print(articulos);
				%>
				
			</div>
		</section>

	</main>
	<jsp:include page="scripts.jsp" />
</body>
</html>