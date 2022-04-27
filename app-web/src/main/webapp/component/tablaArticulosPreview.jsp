<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.web.enums.Enumerable"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%
Enumerable _enum = (Enumerable)session.getAttribute(Enumerable.ENUMPARAM);
Collection<Articulos> articulos = (Collection<Articulos>) session.getAttribute(_enum.getParam());
if(articulos == null){
	articulos = new ArrayList<>();
}
%>
<h1>Archivos procesados</h1>
<table class="table">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Titulo</th>
			<th scope="col">Codigo</th>
			<th scope="col">Precio</th>
			<th scope="col">Stock</th>
			<th scope="col">Id Marca</th>
			<th scope="col">Id Categoria</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (Articulos arti : articulos) {
		%>
		<tr>
			<th scope="row"></th>
			<td><%=arti.getTitulo()%></td>
			<td><%=arti.getCodigo()%></td>
			<td><%=arti.getPrecio()%></td>
			<td><%=arti.getStock()%></td>
			<td><%=arti.getMarcaId()%></td>
			<td><%=arti.getCategoriaId()%></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
