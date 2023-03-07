package com.ipartek.controlador.menu;

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

@WebServlet("/MenuBuscar")
public class MenuBuscar extends HttpServlet implements DAO_Constantes
{
	private static final long serialVersionUID = 1L;

    public MenuBuscar() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		List<LibroCompleto> listaLibrosCompletos = db.obtenerTodosLibrosCompletos(con);
		
		int cerrado = db.desconectar(con);
		
		request.setAttribute("atr_listaAutores", listaAutores);
		request.setAttribute("atr_listaLibrosCompletos", listaLibrosCompletos);
		
		request.getRequestDispatcher(JSP_BUSCAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
