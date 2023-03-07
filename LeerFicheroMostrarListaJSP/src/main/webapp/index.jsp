<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
  List<String>listaObtenida= new ArrayList<String>();
    
    if( request.getAttribute("atr_listaFichero")!=null){
    
    	listaObtenida= (List<String>)request.getAttribute("atr_listaFichero");
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<main>

<ol>
<%

//mostrar la lista
for(String elemento:listaObtenida)
{
%>	


  <li><%=elemento%></li>

<%

}


%>
</ol>


</main>





</body>
</html>