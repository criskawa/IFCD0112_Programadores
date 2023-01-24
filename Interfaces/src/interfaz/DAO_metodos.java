package interfaz;

import java.sql.Connection;
import java.util.List;

public interface DAO_metodos {
	Connection conectar();

	int desconectar(Connection con);

	int insertarPersona(int id, String nombre);

	int insertarPersona(Persona persona);

	int borrarPersona(int id);

	int borrarPersona(Persona persona);

	Persona obtenerPersona(int id);

	List<Persona> obtenerTodasPersonas();

	int modificarPErsona(int id, String nombre);

	int modificarPErsona(Persona persona);

}
