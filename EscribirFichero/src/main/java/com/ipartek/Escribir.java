package com.ipartek;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Escribir")
public class Escribir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Escribir() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		//el ultimo true es para que no sobrescriba lo que habia escrito de antes
		FileWriter fichero = new FileWriter("C:\\configuracion\\mi_archivo.txt", true);
		
		//si no existe el archivo lo crea, pero la ruta de existir
		//escribimos linea a linea
		fichero.write("ejemplo"+"\n");
		fichero.write("ejemplo22");
		fichero.close();
		
		
		List<String> lista = new ArrayList<String>();
		
		lista.add("Sarah connor");
		lista.add("Sarah connor");
		lista.add("Sarah connor");
		FileWriter fichero2 = new FileWriter("C:\\configuracion\\datosalumnos.txt, true");
		
		for(String elemento:lista) {
			fichero2.write(elemento +"\n");
			
		}
		fichero2.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
