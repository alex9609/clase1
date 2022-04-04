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
				<h1>Cargar archivo</h1>
				<div class="col-6">
				<!-- Cuando se envien archivos binarios se envia con el tag enctype -->
					<form action="${pageContext.request.contextPath}/UploadFileServlet" method="post" enctype="multipart/formdata">
						<div class="mb-3">
						  <label for="formFile" class="form-label">Cargar archivo</label>
						  <input class="form-control" name="<%=ViewKeysEnum.UPLOAD_FILE.getParam()%>" type="file" id="formFile">
						</div>
						<button type="submit" class="btn btn-primary">Cargar archivo</button>
					</form>
				</div>
			</div>
		</section>

	</main>
	<jsp:include page="scripts.jsp" />
</body>
</html>