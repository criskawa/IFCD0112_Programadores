package com.ipartek.controlador.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loguearse
 */
@WebServlet("/Loguearse")
public class Loguearse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Loguearse() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = "";

		if (request.getParameter("usuario") != null)
			usuario = request.getParameter("usuario");

		String password = "";

		if (request.getParameter("password") != null)
			password = request.getParameter("password");

		System.out.println("user: " + usuario);
		System.out.println("password: " + password);

		request.getRequestDispatcher("index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
