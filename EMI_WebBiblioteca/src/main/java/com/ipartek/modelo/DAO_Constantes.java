package com.ipartek.modelo;

public interface DAO_Constantes 
{
	//por defecto los atributos son public static final
	String NOMBRE_BD = "BD_Biblioteca.db";
	String RUTA = "jdbc:sqlite:C:\\Users\\Java\\Desktop\\BD\\" + NOMBRE_BD;
	String DRIVER = "org.sqlite.JDBC";
	String USUARIO = "";
	String PASS = "";
	

	String TABLA_LIBROS = "Libros";
	String LIBROS_ID = "id";
	String LIBROS_TITULO = "titulo";
	String LIBROS_AUTOR = "FK_autor";
	String LIBROS_PRECIO = "precio";
	
	String TABLA_AUTORES = "Autores";
	String AUTORES_ID = "id";
	String AUTORES_AUTOR = "autor";
	String AUTORES_FALLECIDO = "fallecido";
	
	String VISTA_LIBROS_COMPLETOS = "LibrosCompleto";
	String LIBROSCOMPLETO_ID = "id";
	String LIBROSCOMPLETO_TITULO = "titulo";
	String LIBROSCOMPLETO_FKAUTOR = "FK_autor";
	String LIBROSCOMPLETO_PRECIO = "precio";
	String LIBROSCOMPLETO_AUTOR = "autor";
	String LIBROSCOMPLETO_FALLECIDO = "fallecido";
	
	
	//constantes de las vistas jsp
	String JSP_AGREGAR = "index.jsp";
	String JSP_BUSCAR = "buscar.jsp";
	String JSP_ACERCA = "acerca.jsp";
	String JSP_FORM_MODIF = "form_modificar.jsp";
}
