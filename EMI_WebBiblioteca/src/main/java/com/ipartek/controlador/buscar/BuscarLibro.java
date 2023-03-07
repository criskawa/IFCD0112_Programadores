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

@WebServlet("/BuscarLibro")
public class BuscarLibro extends HttpServlet implements DAO_Constantes
{
	private static final long serialVersionUID = 1L;

    public BuscarLibro() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//recibir los datos de la busqueda
		String titulo = "";
		if(request.getParameter("titulo") != null)
		{
			titulo = request.getParameter("titulo").trim();
		}
		
		int fk_autor = 0;
		if(request.getParameter("autor") != null)
		{
			fk_autor = Integer.parseInt(request.getParameter("autor"));
		}
		
		Double precio = 0.0;
		if(request.getParameter("precio") != null 
			&& !request.getParameter("precio").equals(""))
		{
			precio = Double.parseDouble(request.getParameter("precio"));
		}
		
		int filtroPrecio = 0;
		if(request.getParameter("select_filtro_precio") != null)
		{
			filtroPrecio = Integer.parseInt(request.getParameter("select_filtro_precio"));
		}
		
		//buscar el los libros
		LibroCompleto libroCompleto = new LibroCompleto(0, titulo, fk_autor, precio, "", false);
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<LibroCompleto> listaLibros = db.obtenerLibroCompleto(con, libroCompleto, filtroPrecio);
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		
		int cerrado = db.desconectar(con);
		
		if(listaLibros.isEmpty())
		{
			String mensaje = "No se encuentra ningun libro con los datos introducidos";
			request.setAttribute("mensaje", mensaje);
		} else
		{
			request.setAttribute("atr_listaLibrosCompletos", listaLibros);
		}
		
		request.setAttribute("atr_listaAutores", listaAutores);
		
		//pasarselos al jsp buscar en la mochila
		
		request.getRequestDispatcher(JSP_BUSCAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
