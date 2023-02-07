package web.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB_Helper implements DAO_Costantes, DAO_metodos {

	@Override
	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(RUTA);
			System.out.println("Conexion ok");
		} catch (ClassNotFoundException e) {
			System.out.println(" no hay driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no se pudo conectar");
		}

		return con;
	}

	@Override
	public int desconectar(Connection con) {
		try {
			con.close();
			System.out.println("Conexion cerrada");
			return 0;// si es 0 se desconecto ok
		} catch (SQLException e) {
			System.out.println("No se pudo cerrar");
			return -1;// si muestra -1 es porque no la ha cerrado
		}

	}

}
