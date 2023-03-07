package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

public interface DAO_metodos {

	// las funciones correspondientes a la clase Persona se crean aqui.
	// todas las funciones por convencion dentro de la interfaz tendran "public
	// abstract"
	Connection conectar();

	// la defino como un int porque pueden haber varias alternativas de desconexion
	// se pone asi para poder comprobar mas homogeneos los errores

	int desconectar(Connection con);

	
}
