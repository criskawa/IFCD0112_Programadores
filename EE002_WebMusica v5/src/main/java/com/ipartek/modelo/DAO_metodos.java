package com.ipartek.modelo;

import java.sql.Connection;
import java.util.List;

import com.ipartek.modelo.dto.Cancion;

public interface DAO_metodos {
	Connection conectar();
	int desconectar(Connection con);
	List<Cancion> obtenerTodasConciones(Connection con);
	
	
	
	
	
}
