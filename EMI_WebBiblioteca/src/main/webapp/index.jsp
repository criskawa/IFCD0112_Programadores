<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.ipartek.modelo.dto.Autor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
    
<% 
List<Autor> listaAutores = new ArrayList<Autor>();
if(request.getAttribute("atr_listaAutores") != null)
{
	listaAutores = (List<Autor>) request.getAttribute("atr_listaAutores");
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
    <link rel="stylesheet" href="styles/style_agregar.css">
</head>
<body>
    <%@ include file="includes/cabecera.jsp" %>

    <main>
    	<section>
			<form action="AgregarLibro" method="get">
				<div class="formulario_insertar">
 					<div class="titulo">
 						Formulario para añadir un nuevo libro
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
					<div class="boton">
						<input type="submit" value="Agregar">
					</div>
				</div>
			</form>
			
			<%
			if(!mensaje.isEmpty())
			{
			%>
				<h3><%= mensaje %></h3>
			<%
			}
			%>		
		</section>
    </main>
</body>
</html>