package com.ipartek.modelo;

public interface DAO_constantes {

	   String NOMBRE_BD="BD_Musica.db";
	   String RUTA="jdbc:sqlite:/C:\\Users\\Java\\Desktop\\BD\\"+NOMBRE_BD;
	   String DRIVER="org.sqlite.JDBC";
	   String USUARIO="";
	   String PASS="";
	   
	   String TABLA_CANCIONES="Canciones";
	   String CANCIONES_ID="id";
	   String CANCIONES_GRUPO="grupo";
	   String CANCIONES_CANCION="cancion";
	   String CANCIONES_ENLACE="enlace";
	   String CANCIONES_ESTILO="estilo";

}
