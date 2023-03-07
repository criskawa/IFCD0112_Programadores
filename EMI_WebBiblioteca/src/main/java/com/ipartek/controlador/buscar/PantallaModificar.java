package com.ipartek.controlador.buscar;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
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

/**
 * Servlet implementation class PantallaModificar
 */
@WebServlet("/PantallaModificar")
public class PantallaModificar extends HttpServlet implements DAO_Constantes{
	private static final long serialVersionUID = 1L;
    
    public PantallaModificar() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=0;
		if(request.getParameter("id")!=null) {
			id= Integer.parseInt(request.getParameter("id"));
		}
		
		DB_Helper db = new DB_Helper();
		Connection con = db.conectar();
		
		Libro libro = db.obtenerLibroPorId(con, id);
		
		List<Autor> listaAutores = db.obtenerTodosAutores(con);
		
		
		int cierre=db.desconectar(con);
		
		
		
		
		request.setAttribute("atr_libro", libro);
		request.setAttribute("atr_listaAutores", listaAutores);
		
		request.getRequestDispatcher(JSP_FORM_MODIF).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
