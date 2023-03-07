package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Autor;
import com.ipartek.modelo.dto.Libro;
import com.ipartek.modelo.dto.LibroCompleto;

public interface DAO_Metodos
{
	Connection conectar();
	int desconectar(Connection con);
	
	List<Autor> obtenerTodosAutores(Connection con);
	
	int insertarLibro(Connection con, Libro libro);
	List<LibroCompleto> obtenerTodosLibrosCompletos(Connection con);
	int borrarLibro(Connection con, int id);
	List<LibroCompleto> obtenerLibroCompleto(Connection con, LibroCompleto libro, int filtroPrecio);
	Libro obtenerLibroPorId(Connection con, int id);
	
}
