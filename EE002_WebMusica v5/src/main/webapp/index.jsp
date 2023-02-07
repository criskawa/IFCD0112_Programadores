<%@page import="com.ipartek.modelo.dto.Cancion"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--     aqui recibimos la lista desde menuVerTodas  con codigo de programacion java entre esas etiquetas-->
<%--     <%List<Cancion> listaObtenida = (List<Cancion>)request.getAttribute("atributo_listaCanciones");%> --%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="styles/styles.css">
</head>
<body>
	<!--La cabecera de la pagina-->
	<%@include file="includes/cabecera.jsp" %>
	<%@include file="includes/nav_no_login.jsp" %>

	<!--El cuerpo de la pagina-->
	<main>
<!-- 	hacer tabla estatica -->
<!-- 	en servlet, hacer 7 pasos para cargar una lista de canciones -->
	
<!-- 	modificar tabla para que pueda mostrar datos -->
<!-- 	recoger la lista para mostrar -->
	</main>

	<!--El pie de la pagina-->
	<%@include file="includes/pie.jsp" %>
</body>
</html>


