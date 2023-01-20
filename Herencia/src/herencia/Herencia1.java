package herencia;

import java.util.ArrayList;
import java.util.List;

public class Herencia1 {

	public static void main(String[] args) {
		
		List <Mamifero> listaMamiferos= new ArrayList<Mamifero>();
		Mamifero ma1 = new Mamifero("gato",18,false,"Naranja", true);
		
		Mamifero ma2= new Mamifero("negro",20, true,"Azul",true);
		
		listaMamiferos.add(ma1);
		listaMamiferos.add(ma2);
		
		System.out.println(listaMamiferos);


	}

}
