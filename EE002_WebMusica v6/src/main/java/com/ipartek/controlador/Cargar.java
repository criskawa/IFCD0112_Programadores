package com.ipartek.controlador;

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


@WebServlet("/Cargar")
public class Cargar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cargar() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//1 recepcion de parametros
				
				//2 maquetacion en DTO
									
				//3 Conexion a la BD
				DB_Helper db= new DB_Helper();
				Connection con= db.conectar();
				
				//4 hacer la operacion/es con la BD
				List<Cancion> listaCanciones = db.obtenerTodasCanciones(con);
				
				//5 desconectar
				int estadoConexion=db.desconectar(con);
				
				//6 mochila: preparacion de datos para el envio a la vista
				//Le damos nombre a la lista e indicamos lo que queremos enviar
				request.setAttribute("atr_listaCanciones", listaCanciones);
				
				//7 redireccion a una vista: ESTE ES OBLIGATORIO SIEMPRE
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
