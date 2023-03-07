package com.ipartek.comtrolador;

import java.sql.Connection;
import java.util.List;

public interface DAO_metodos {
	Connection conectar();
	int desconectar(Connection con);
	
	
	
	
	
}
