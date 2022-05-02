<%@page import="java.util.ArrayList"%>
<%@page import="ar.com.educacionit.web.enums.Enumerable"%>
<%@page import="java.util.Collection"%>
<%@page import="ar.com.educacionit.domain.Articulos"%>
<%@page import="ar.com.educacionit.web.enums.ViewKeysEnum"%>
<%
Collection<Articulos> articulosOk = (Collection<Articulos>) request.getAttribute(ViewKeysEnum.ARTICULOS_OKS.getParam());
if(articulosOk == null){
	articulosOk = new ArrayList();
}
Collection<Articulos> articulosFails = (Collection<Articulos>) session.getAttribute(ViewKeysEnum.ARTICULOS_FAIL.getParam());
if(articulosFails == null){
	articulosFails = new ArrayList();
}
%>
<h1>Listado ok</h1>
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
		for (Articulos arti : articulosOk) {
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
<h1>Listado fails</h1>
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
		for (Articulos arti : articulosFails) {
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

<div class="row">
	<div class="col-12">
		<form action="<%=request.getContextPath()%>/controllers/GenerarArchivoErrorServlet" method="POST" target="_new">
			<div class="input-group mb-3">
				<select name="formato" class="form-select" aria-label="Default select example">
				  <option value="csv" selected>CSV</option>
				  <option value="xls">XSL</option>
				  <option value="pdf">PDF</option>
				</select>
				<!-- 
				<a class="btn btn-primary" href="<%=request.getContextPath()%>/controllers/CargarProductosServlet" role="button">
					Generar Archivo de Errores
				</a>
				 -->
				<button class="btn btn-primary">
					Generar Archivo de Errores
				</button>
			</div>
		</form>
		
	</div>
</div>	

