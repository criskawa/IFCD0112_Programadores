package com.ipartek.controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Cargar")
public class Cargar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cargar() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//aqui leo el archivo desde la direccion en que se encuentra
		File archivo= new File("C:\\ficheros\\datos.txt");
		FileReader fr= new FileReader(archivo);
		BufferedReader br= new BufferedReader(fr);
		
		
		//luego creo una lista para almecenar los datos que leo del archivo
		List<String>listaPack= new ArrayList<String>();
		
		
		//creo tambien una variable del tipo de dato que leo y la almaceno dentro de la lista
		String linea="";
		
		while((linea=br.readLine())!=null) {
			
			listaPack.add(linea);
					
		}
		
		//meto todo eso como atributo para enviarlo al jsp
		request.setAttribute("atr_listaFichero", listaPack);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
