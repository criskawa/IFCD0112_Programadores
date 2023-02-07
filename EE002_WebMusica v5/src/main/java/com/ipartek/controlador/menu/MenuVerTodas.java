package com.ipartek.controlador.menu;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Cancion;


@WebServlet("/MenuVerTodas")
public class MenuVerTodas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MenuVerTodas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//recepcion de parametros
		
		//maquetacion en dto
		
		//conectar a bd
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		//hacer operaciones con bd
		List <Cancion> listaCanciones = db.obtenerTodasConciones(con);
		
		
		//desconectar 
		int estadoConexion = db.desconectar(con);
		
		
		//preparar datos para enviar a lista como atributos
		 
		request.setAttribute("atributo_listaCanciones", listaCanciones);
		
		//redireccion a una vista, obligatorio siempre
				
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
