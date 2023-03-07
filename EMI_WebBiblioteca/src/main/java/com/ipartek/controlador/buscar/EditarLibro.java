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
import com.ipartek.modelo.dto.Libro;
import com.ipartek.modelo.dto.LibroCompleto;

@WebServlet("/EditarLibro")
public class EditarLibro extends HttpServlet implements DAO_Constantes
{
	private static final long serialVersionUID = 1L;

    public EditarLibro() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = 0;
		if(request.getParameter("id") != null)
		{
			id = Integer.parseInt(request.getParameter("id"));
		}
		
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
		
		Libro libro = new Libro(id, titulo, autor, precio);
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		int resultado = db.modificarLibro(con,libro);
		
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		List<LibroCompleto> listaLibros = db.obtenerTodosLibrosCompletos(con);
		
		
		request.setAttribute("atr_listaLibrosCompletos", listaLibros);
		request.setAttribute("atr_listaAutores", listaAutores);
		request.getRequestDispatcher(JSP_BUSCAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
