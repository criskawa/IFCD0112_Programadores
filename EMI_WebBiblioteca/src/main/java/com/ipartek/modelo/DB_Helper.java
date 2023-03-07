package com.ipartek.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.modelo.dto.Autor;
import com.ipartek.modelo.dto.Libro;
import com.ipartek.modelo.dto.LibroCompleto;

public class DB_Helper implements DAO_Constantes, DAO_Metodos {

	@Override
	public Connection conectar() {
		Connection con = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(RUTA);
			System.out.println("Conexion establecida");
		} catch (ClassNotFoundException e) {
			System.err.println("No se ha encontrado el driver");
		} catch (SQLException e) {
			System.err.println("La ruta no es correcta");
		}

		return con;
	}

	@Override
	public int desconectar(Connection con) {
		// si es cero, se desconecto correctamente
		// si es -1, error
		// si es -2 error por null
		try {
			con.close();
			System.out.println("Se ha cerrado correctamente");
			return 0;
		} catch (SQLException e) {
			System.err.println("No se pudo cerrar");
			return -1;
		} catch (NullPointerException e) {
			System.err.println("La conexion es null");
			return -2;
		}
	}

	@Override
	public List<Autor> obtenerTodosAutores(Connection con) {
		List<Autor> listaAutores = new ArrayList<Autor>();

		try {
			String sql = "select * from " + TABLA_AUTORES;

			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				Autor autor = new Autor();

				autor.setId(rs.getInt(AUTORES_ID));
				autor.setAutor(rs.getString(AUTORES_AUTOR));
				autor.setFallecido(rs.getBoolean(AUTORES_FALLECIDO));

				listaAutores.add(autor);
			}

		} catch (SQLException e) {
			System.err.println("No se puede mostrar la lista de autores");
		}

		return listaAutores;
	}

	@Override
	public int insertarLibro(Connection con, Libro libro) {
		int resultado = 0;

		try {
			String sql = "insert into " + TABLA_LIBROS + " values (null, ?, ?, ?)";

			PreparedStatement pStmt = con.prepareStatement(sql);

			pStmt.setString(1, libro.getTitulo());
			pStmt.setInt(2, libro.getFk_autor());
			pStmt.setDouble(3, libro.getPrecio());

			resultado = pStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error al insertar");
			resultado = -1;
		}

		return resultado;
	}

	@Override
	public int borrarLibro(Connection con, int id) {
		int resultado = 0;

		try {
			String sql = "delete from " + TABLA_LIBROS + " where " + LIBROS_ID + " = " + id;

			PreparedStatement pStmt = con.prepareStatement(sql);
			resultado = pStmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Ha ocurrido un error");
		}

		return resultado;
	}

	@Override
	public List<LibroCompleto> obtenerTodosLibrosCompletos(Connection con) {
		List<LibroCompleto> listaLibrosCompletos = new ArrayList<LibroCompleto>();

		try {
			String sql = "select * from " + VISTA_LIBROS_COMPLETOS;

			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					LibroCompleto libroCompleto = new LibroCompleto();

					libroCompleto.setId(rs.getInt(LIBROSCOMPLETO_ID));
					libroCompleto.setTitulo(rs.getString(LIBROSCOMPLETO_TITULO));
					libroCompleto.setFk_autor(rs.getInt(LIBROSCOMPLETO_FKAUTOR));
					libroCompleto.setPrecio(rs.getDouble(LIBROSCOMPLETO_PRECIO));
					libroCompleto.setAutor(rs.getString(LIBROSCOMPLETO_AUTOR));
					libroCompleto.setFallecido(rs.getBoolean(LIBROSCOMPLETO_FALLECIDO));

					listaLibrosCompletos.add(libroCompleto);
				}
			}
		} catch (SQLException e) {
			System.err.println("No se puede mostrar la lista de libros");
		}

		return listaLibrosCompletos;
	}

	@Override
	public List<LibroCompleto> obtenerLibroCompleto(Connection con, LibroCompleto libro, int filtroPrecio) {
		List<LibroCompleto> listaLibros = new ArrayList<LibroCompleto>();
		boolean whereUsado = false;

		String sql = "select * from " + VISTA_LIBROS_COMPLETOS;

		if (!libro.getTitulo().equals("")) {
			sql += " where " + LIBROSCOMPLETO_TITULO + " like '" + libro.getTitulo() + "'";

			whereUsado = true;
		} else {
			whereUsado = false;
		}

		if (libro.getFk_autor() != 0) {
			if (whereUsado) {
				sql += " and " + LIBROSCOMPLETO_FKAUTOR + " like " + libro.getFk_autor();
			} else {
				sql += " where " + LIBROSCOMPLETO_FKAUTOR + " like " + libro.getFk_autor();

				whereUsado = true;
			}
		}

		if (libro.getPrecio() != 0.0) {
			if (whereUsado) {
				sql += " and " + LIBROSCOMPLETO_PRECIO;
			} else {
				sql += " where " + LIBROSCOMPLETO_PRECIO;

				whereUsado = true;
			}

			if (filtroPrecio == 1) {
				sql += " > " + libro.getPrecio();
			} else if (filtroPrecio == 2) {
				sql += " < " + libro.getPrecio();
			} else if (filtroPrecio == 3) {
				sql += " = " + libro.getPrecio();
			}
		}

		try {
			PreparedStatement pStmt = con.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					LibroCompleto libroCompleto = new LibroCompleto();
					libroCompleto.setId(rs.getInt(LIBROSCOMPLETO_ID));
					libroCompleto.setTitulo(rs.getString(LIBROSCOMPLETO_TITULO));
					libroCompleto.setFk_autor(rs.getInt(LIBROSCOMPLETO_FKAUTOR));
					libroCompleto.setPrecio(rs.getDouble(LIBROSCOMPLETO_PRECIO));
					libroCompleto.setAutor(rs.getString(LIBROSCOMPLETO_AUTOR));
					libroCompleto.setFallecido(rs.getBoolean(LIBROSCOMPLETO_FALLECIDO));

					listaLibros.add(libroCompleto);
				}
			}
		} catch (SQLException e) {
			System.err.println("No se puede mostrar la lista de libros");
		}

		return listaLibros;
	}

	public Libro obtenerLibroPorId(Connection con, int id) {

		Libro li = new Libro();
		try {
			// String sql = "Select * from Libros where id=1";
			String sql = "Select * from " + TABLA_LIBROS + " where " + LIBROS_ID + "= " + id;
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			int cont= 0;
			while (rs.next()) {
				li.setId(rs.getInt(LIBROS_ID));
				li.setTitulo(rs.getString(LIBROS_TITULO));
				li.setFk_autor(rs.getInt(LIBROS_AUTOR));
				li.setPrecio(rs.getDouble(LIBROS_PRECIO));
				
				cont++;
			}
			//si devuelve mas de un libro
			if (cont>1) {
				System.out.println("varios libros obtenidos");
				throw new SQLException();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			li= new Libro();
			
		}

		return li;
	}

	public int modificarLibro(Connection con, Libro libro) {
		int resultado = 0;
		try {
			String sql = "Update "+TABLA_LIBROS+" SET "
					+LIBROS_TITULO+"=?, "+ LIBROS_AUTOR+"=?, "+LIBROS_PRECIO+"=?"
					+" where " +LIBROS_ID+"=?";
			System.out.println(sql);
			System.out.println(libro);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, libro.getTitulo());
			ps.setInt(2, libro.getFk_autor());
			ps.setDouble(3, libro.getPrecio());
			ps.setInt(4, libro.getId());
			
			resultado = ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error al modificar libro");
			e.printStackTrace();
		}
		return resultado;
	}

}
