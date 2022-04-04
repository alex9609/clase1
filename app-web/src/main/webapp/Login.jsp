<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>

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
		
		<div class="container-fluid">
			<div class="row">
				<div class="col-6">
					<form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
						<div class="mb-3">
							<label for="exampleInputEmail1" class="form-label">Email
								address</label>
							<input type="text" name="<%=ViewKeysEnum.USERNAME.getParam()%>" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						</div>
						<div class="mb-3">
							<label for="exampleInputPassword1" class="form-label">Password</label>
							<input type="password" name="<%=ViewKeysEnum.PASSWORD.getParam()%>" class="form-control"
								id="exampleInputPassword1">
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="scripts.jsp" />
</body>
</html>