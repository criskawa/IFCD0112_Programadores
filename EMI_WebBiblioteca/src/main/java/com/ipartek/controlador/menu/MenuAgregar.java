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

@WebServlet("/MenuAgregar")
public class MenuAgregar extends HttpServlet implements DAO_Constantes
{
	private static final long serialVersionUID = 1L;

    public MenuAgregar() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//EXTRA2: en un txt diferente, almacenar el numero de veces que se entro
		//a este servlet
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		
		int estadoConexion = db.desconectar(con);
		
		request.setAttribute("atr_listaAutores", listaAutores);
		
		request.getRequestDispatcher(JSP_AGREGAR).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
