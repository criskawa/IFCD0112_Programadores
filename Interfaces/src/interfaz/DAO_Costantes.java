package interfaz;

import java.sql.Connection;
import java.util.List;

public interface DAO_Costantes {
	
	//Todo son constantes
	public static final String Nombre_BD="BD_Personas.db";
	String RUTA = "jdbc:sqlite:/C:\\Users\\Java\\Desktop\\BD\\" + Nombre_BD ;
	String DRIVER="org.sqlite.JDBC";
	String USUARIO = "";
	String PASS="";
	
	String TABLA_PERSONA="Personas";
	String PERSONA_ID="id";
	String PERSONA_NOMBRE="nombre";
	
	//Persona PERSONA1= new Persona(1,"Eduardo");
	//Los objetos aunque sean constantes, java permite modificar sus valores,
	//es decir, solo es constante el espacio que reserva en memoria
	
	
	
}