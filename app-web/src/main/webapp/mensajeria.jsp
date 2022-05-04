<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%
//Si existe es porque alguien grabo un error, cualquier servlet
	String error = (String)request.getAttribute(ViewKeysEnum.ERROR_GENERAL.getParam());
	String exito = (String)request.getAttribute(ViewKeysEnum.EXITO.getParam());
%>
<section>
	<%
		if(error != null){
	%>
	<div class="alert alert-danger" role="alert">
 		<%=error%>	
	</div>
	<%
	}%>
	
	<%
		if(exito != null){
	%>
	<div class="alert alert-success" role="alert">
 		<%=exito%>	
	</div>
	<%
	}%>
</section>