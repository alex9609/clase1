<!--  Importar clases -->
<%@page import = "ar.com.educacionit.domain.Articulos" %>
<%@page import = "java.util.List" %>
<html>
	<head>
		<jsp:include page="styles.jsp"/>
	</head>
	<body>
		<jsp:include page="navbar.jsp" />
		<main>
			<%--seccion para visualizar errores en loginservlet --%>
			<jsp:include page="mensajeria.jsp" />
			<section class="container">
				<div class="row d-flex justify-content-center">
					<div class="col">
						<jsp:include page="./component/tablaArticulosPreviewResultados.jsp" />
					</div>
				</div>
			</section>
		</main>
	<jsp:include page="scripts.jsp" />
	</body>

</html>