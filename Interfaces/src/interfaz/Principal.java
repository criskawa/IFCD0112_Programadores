package interfaz;

import java.sql.Connection;
import java.util.List;

public class Principal implements DAO_Costantes {

	public static void main(String[] args) {

		
		DB_Helper db = new DB_Helper();
		//Connection con= db.conectar();
		
		db.insertarPersona(2, "CristinaP");
		
		db.modificarPErsona(2, "Esther");
		//for (Persona persona :  db.obtenerTodasPersonas()) {
			
		//}
		List <Persona> listaPersonas = db.obtenerTodasPersonas();
		System.out.println(listaPersonas);
		
		db.borrarPersona(1);
		
		//int resultado = db.desconectar(con);
		
		
		//Paso por parametros y paso de valor
		
		/*
		 * en una funcion podemos pasar por valo, por ejemplo tomando el valr de una variable en el 
		 * programa principal y utilizar ese valor dentro de la funcion, no modifica el valor del programa principal
		 * 
		 * Los objetos o wrappers se pasan por referencia, y si si devuelve un objeto modificado, no es copia
		 */
		
	}

}
