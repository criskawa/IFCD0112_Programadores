<%@page import="com.ipartek.modelo.dto.LibroCompleto"%>
<%@page import="com.ipartek.modelo.dto.Autor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Libro"%>
<%@page import="java.util.List"%>    
    
<%
List<Autor> listaAutores = new ArrayList<Autor>();
if(request.getAttribute("atr_listaAutores") != null)
{
	listaAutores = (List<Autor>) request.getAttribute("atr_listaAutores");
}

List<LibroCompleto> listaLibrosCompletos = new ArrayList<LibroCompleto>();

if(request.getAttribute("atr_listaLibrosCompletos") != null)
{
	listaLibrosCompletos = (List<LibroCompleto>) request.getAttribute("atr_listaLibrosCompletos");
}

String mensaje = "";
if(request.getAttribute("atr_mensaje") != null)
{
	mensaje = (String) request.getAttribute("atr_mensaje");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/style_buscar.css">
</head>
<body>
    <%@ include file="includes/cabecera.jsp" %>

    <main>
		<section>
			<form action="BuscarLibro" method="get">
				<div class="formulario_buscar">
 					<div class="titulo">
 						Filtro de busqueda
 					</div>
					<div class="lbl1">
						<label for="titulo">Titulo</label>
					</div>
					<div class="lbl2">
						<label for="autor">Autor</label>
					</div>
 					<div class="lbl3">
 						<label for="precio">Precio</label>
 					</div>
	 				<div class="txt1">
	 					<input type="text" name="titulo" id="titulo">
	 				</div>
 					<div class="txt2">
 						<select name= "autor" id="autor">
 							<option value="-1" selected disabled>
 								Escoja un autor
 							</option>
 							<%
 							for(Autor elemento:listaAutores)
 							{
 							%>
 							<option value=<%=elemento.getId() %>>
 								<%=elemento.getAutor() %>
 							</option>
 							<%
 							}
 							%>		
 						</select>
 					</div>
					<div class="txt3">
						<input type="text" name="precio" id="precio">
					</div>
					<div class="select">
						<select name="select_filtro_precio" id="select_filtro_precio">
							<option value="1">Mayor que</option>
							<option value="2">Menor que</option>
							<option value="3">Igual a</option>
						</select>
					</div>
					<div class="boton">
						<input type="image" src="imagenes/lupa.png" name="imagen_lupa" id="imagen_lupa">
					</div>
				</div>
			</form>
			
			<h3>
				<%
				if(!mensaje.isEmpty())
				{
				%>
					<h3><%= mensaje %></h3>
				<%
				}
				%>
			</h3>
		</section>
	
		<%
		if(!listaLibrosCompletos.isEmpty())
		{
		%>
		<section>
			<table>
				<thead>
					<tr>
						<th>ID</th>
						<th>TITULO</th>
						<th>AUTOR</th>
						<th>PRECIO</th>
						<th>OPCIONES</th>
					</tr>
				</thead>
				<tbody>
					<%for(LibroCompleto elemento:listaLibrosCompletos)
					{%>
						<tr>
							<td><%= elemento.getId() %></td>
							<td><%= elemento.getTitulo() %></td>
							<td><%= elemento.getAutor() %></td>
							<td><%= elemento.getPrecio() %></td>
							<td> 
								<a href="BorrarLibro?id=<%= elemento.getId() %>">
									<img alt="" src="imagenes/borrar.png">
								</a>
								<a href="PantallaModificar?id=<%= elemento.getId() %>">
									<img alt="" src="imagenes/editar.png">
								</a>
							</td>
						</tr>
				 <% } %>
				</tbody>
			</table>
		</section>
		<% } %>

    </main>
</body>
</html>