import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Faltas {

	public static void main(String[] args) {
		//HashMap<String,List<String>> resumenFaltas= new HashMap<String,List<String>>();
		
		//Crear lista de alumnos string
		List<String> listaAlumnos= new ArrayList<String>();
		
		//entradas de keys
		listaAlumnos.add("Alumno1");
		listaAlumnos.add("Alumno2");
		listaAlumnos.add("Alumno3");
		listaAlumnos.add("Alumno4");
		
		HashMap<String, List<String>> resumenFaltas= new HashMap<String, List<String>>();
		
		for (String elemento : listaAlumnos) {
			
			resumenFaltas.put(elemento,new ArrayList<String>());
		}
		
		//añadir faltas 
		
		if (resumenFaltas.get("Alumno1")!=null) {
			resumenFaltas.get("Alumno1").add("fallo lavadora");
		}
		
		if (resumenFaltas.get("Alumno2")!=null) {
			resumenFaltas.get("Alumno2").add("dormido");
		}
		
		if (resumenFaltas.get("Alumno3")!=null) {
			resumenFaltas.get("Alumno3").add("tren");
		}
		
		if (resumenFaltas.get("Alumno1")!=null) {
			resumenFaltas.get("Alumno1").add("resaca");
		}
		
		System.out.println(resumenFaltas);
		
	}

}
