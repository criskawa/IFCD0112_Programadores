package com.ipartek.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Helper implements DAO_constantes, DAO_metodos {

	@Override
	public Connection conectar() {

		Connection con= null;
		
		try {
			Class.forName(DRIVER);
			con= DriverManager.getConnection(RUTA);
			System.out.println("CONEXION OK");
		} catch (ClassNotFoundException e) {
			System.out.println("NO HAY DRIVER");
		} catch (SQLException e) {
			System.out.println("NO SE PUDO CONECTAR");
		}
		
		return con;
	}

	@Override
	public int desconectar(Connection con) {
		// si es 0, se desconecto OK
		// si es -1 error
		try {
			con.close();
			System.out.println("CONEXION CERRADA");
			return 0;
		} catch (SQLException e) {
			System.out.println("ERROR AL CERRAR");
			return -1;
		}
	}

	
	
}
