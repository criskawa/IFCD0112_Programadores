package com.ipartek.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Helper implements DAO_constantes, DAO_metodos {

	// Aqui en el DB_Helper pongo todas las funciones

	@Override
	public Connection conectar() {

		Connection con = null;
	
		

		// con el Class.forName pregunto si tengo la clase para hacer la conexion
		// luego lo rodeo con el try-catch en caso de que hayan excepciones
		try {
			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {

			System.out.println("No se encontro el driver");
		}

		// aqui utilizo el drivermanager.get connection para conectar con la base de
		// datos

		try {
			con = DriverManager.getConnection(RUTA, USUARIO, PASS);
			System.out.println("Conexion hecha");
		} catch (SQLException e) {

			System.out.println("No se puedo acceder a la base de datos");
		}

		return con;
	}

	@Override
	public int desconectar(Connection con) {

		try {
			con.close();
			System.out.println("Se ha cerrado la base de datos");
			return 0;

		} catch (SQLException e) {
			System.out.println("Error al cerrar la base de datos");
			return -1;
		}

	}

	
	
}
