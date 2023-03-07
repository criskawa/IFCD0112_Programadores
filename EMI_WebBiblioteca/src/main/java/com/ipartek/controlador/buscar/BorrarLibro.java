package com.ipartek.controlador.buscar;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.modelo.DAO_Constantes;
import com.ipartek.modelo.DB_Helper;
import com.ipartek.modelo.dto.Autor;
import com.ipartek.modelo.dto.LibroCompleto;

@WebServlet("/BorrarLibro")
public class BorrarLibro extends HttpServlet implements DAO_Constantes
{
	private static final long serialVersionUID = 1L;

    public BorrarLibro()
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//recibir el parametro id que me pasa desde buscar.jsp
		int id = 0;
		if(request.getParameter("id") != null)
		{
			id = Integer.parseInt(request.getParameter("id"));
		}
		
		//hacer las cosas que hagan falta para borrar ese libro
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		int borrado = db.borrarLibro(con, id);
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		List<LibroCompleto> listaLibrosCompletos = db.obtenerTodosLibrosCompletos(con);
		
		int resultado = db.desconectar(con);
		 
		String mensaje = "";
		
		switch(borrado)
		{
			case -1:
				mensaje = "ERROR en la BD. Contacte con Sistemas";
				break;
			case 0:
				mensaje = "No se pudo borrar el libro";
				break;
			case 1:
				mensaje = "Libro borrado correctamente";
				break;
			default:
				break;
		}
			
		request.setAttribute("atr_mensaje", mensaje);
		request.setAttribute("atr_listaAutores", listaAutores);
		request.setAttribute("atr_listaLibrosCompletos", listaLibrosCompletos);
		
		request.getRequestDispatcher(JSP_BUSCAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
