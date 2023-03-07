package com.ipartek.controlador.agregar;

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
import com.ipartek.modelo.dto.Libro;

@WebServlet("/AgregarLibro")
public class AgregarLibro extends HttpServlet implements DAO_Constantes
{
	private static final long serialVersionUID = 1L;

    public AgregarLibro() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = "";
		if(request.getParameter("titulo") != null)
		{
			titulo = request.getParameter("titulo").trim();
		}
		
		int autor = 0;
		if(request.getParameter("autor") != null)
		{
			autor = Integer.parseInt(request.getParameter("autor"));
		}
		
		double precio = 0.0;
		if(request.getParameter("precio") != null)
		{
			precio = Double.parseDouble(request.getParameter("precio"));
		}
		
		Libro libro = new Libro(0, titulo, autor, precio);
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		int resultado = db.insertarLibro(con, libro);
		
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		
		int estadoConexion = db.desconectar(con);
		
		request.setAttribute("atr_listaAutores", listaAutores);
		
		String mensaje = "";
		
		switch(resultado)
		{
		case -1:
			mensaje = "ERROR en la BD. Contacte con Sistemas";
			break;
		case 0:
			mensaje = "No se pudo insertar en la BD";
			break;
		case 1:
			mensaje = libro.getTitulo() + " insertado correctamente";
			break;
			default:
				break;
		}
		
		request.setAttribute("atr_mensaje", mensaje);
		
		request.getRequestDispatcher(JSP_AGREGAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
