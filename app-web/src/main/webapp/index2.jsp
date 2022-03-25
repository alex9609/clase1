<html>
<head>
	<title>Clase 36 - Inicio java web</title>
</head>
	<h1>Clase 36</h1>
	<h2>Subtitulo</h2>
	<ul>
		<li>1</li>
		<li>2</li>
		<li>3</li>
		<li>4</li>
	</ul>
	<p>
	JSP es codigo java que se compila y se muestra como html
	</p>
	<%
	for(int i = 0; i <5;i++){
		out.print("i = " + i +"<br>");
	}
		
	%>
	<form action="<%=request.getContextPath()%>/listado" method = "post">
		<input type="submit" value="Pedir listado post" ></input>
	</form>
	
	<form action="<%=request.getContextPath()%>/listado" method = "get">
		<input type="submit" value="Pedir listado get" ></input>
	</form>
	
	<img src="<%=request.getContextPath()%>/img/bartsimpson.jpg" alt="bart">
</html>