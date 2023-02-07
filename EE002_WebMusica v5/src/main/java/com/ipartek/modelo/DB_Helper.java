package com.ipartek.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Cancion;

public class DB_Helper implements DAO_constantes, DAO_metodos {

	@Override
	public Connection conectar() {

		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(RUTA);
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

	@Override
	public List<Cancion> obtenerTodasConciones(Connection con) {

		List<Cancion> lista = new ArrayList<Cancion>();

		try {
			String sql = "select * from Canciones";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Cancion c = new Cancion();

				c.setId(rs.getInt(CANCIONES_ID));
				c.setGrupo(rs.getString(CANCIONES_GRUPO));
				c.setCancion(rs.getString(CANCIONES_CANCION));
				c.setEnlace(rs.getString(CANCIONES_ENLACE));
				c.setEstilo(rs.getString(CANCIONES_ESTILO));

				lista.add(c);
			}

		} catch (SQLException e) {
			System.out.println("SQL incorrecto");
			e.printStackTrace();
			
			//devuelve una lista vacia para que no devuelva una lista a medias en caso de error
			return new ArrayList<Cancion>();
		}

		return lista;
	}

}
