<%@page import="com.ipartek.modelo.dto.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.modelo.dto.Autor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- aqui recibimos el objeto desde pantallaModificar -->

<%
Libro libro = new Libro();
if(request.getAttribute("atr_libro")!=null){
	libro = (Libro)request.getAttribute("atr_libro");
}
List<Autor> listaAutores = new ArrayList<Autor>();
if(request.getAttribute("atr_listaAutores") != null)
{
	listaAutores = (List<Autor>) request.getAttribute("atr_listaAutores");
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="styles/style.css">
<link rel="stylesheet" href="styles/style_form_modificar.css">
</head>
<body>

	<%@ include file="includes/cabecera.jsp"%>

	<main>
		<section>
			<form method ="get">
				<div class="form_modificar">
					<div class="lbl_id">Id</div>
					<div class="lbl_titulo">Titulo</div>
					<div class="lbl_autor">Autor</div>
					<div class="lbl_precio">Precio</div>
					<div class="txt_id">
						<!-- para que envie los datos del libro seleccionado a la  siguiente 
						pantalla usamos libro.get...-->
						<input type="text" id="id" name="id" value="<%=libro.getId() %>" readonly>
					</div>
					<div class="txt_titulo">
						<input type="text" id="titulo" name="titulo" value="<%=libro.getTitulo()%>">
					</div>
					<div class="cmb_autor">
<!-- 					montar un select para que escoja los autores de la base de datos -->

						<select name="autor" id="autor">
							<option value="-1" disabled selected >Escoja un autor</option>
							<% for(Autor elemento:listaAutores)
							{
							%>	
							<option value="<%=elemento.getId()%>"  
							<% if(elemento.getId()==libro.getFk_autor()){
								
								out.write(" selected ");
							}%> >
								<%=elemento.getAutor()%>
							</option>
							<%
							}
							%>
						</select>
					</div>
					<div class="txt_precio">
						<input type="text" id="precio" name="precio" value="64.98">
					</div>
					<div class="botonera"></div>
						<input type="submit" value="Modificar" formaction= "EditarLibro"> 
						<input type="submit" value="Cancelar" formaction= "MenuBuscar">
				</div>
			</form>
		</section>

	</main>


</body>
</html>