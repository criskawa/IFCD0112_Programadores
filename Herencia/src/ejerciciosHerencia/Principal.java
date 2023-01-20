package ejerciciosHerencia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Principal {

	public static void main(String[] args) {

		List<Prenda> listaPrendas = new ArrayList<Prenda>();

		Prenda p1 = new Zapato(25.50, "zapato1", "38", 1.0, false);
		Prenda p2 = new Zapato(45.99, "zapato2", "39", 4.0, true);
		Prenda p3 = new Zapato(25.50, "zapato2", "37", 8.0, false);

		Prenda p4 = new Camiseta("Camiseta1", 25.50, "XL", "verde", false);
		Prenda p5 = new Camiseta("Camiseta2", 35.50, "M", "azul", false);

		Prenda p6 = new Pantalon("pantalon2", 25.50, "XXL", "Straight", true);

		listaPrendas.add(p1);
		listaPrendas.add(p2);
		listaPrendas.add(p3);
		listaPrendas.add(p4);
		listaPrendas.add(p5);
		listaPrendas.add(p6);

		List<String> listaKeys = new ArrayList<String>();

		listaKeys.add("Zapato");
		listaKeys.add("Pantalon");
		listaKeys.add("Camiseta");

		HashMap<String, List<Prenda>> hmCategorias = new HashMap<String, List<Prenda>>();

		// añade los keys
		for (String elemento : listaKeys) {
			hmCategorias.put(elemento, new ArrayList<Prenda>());
		}
		// añade las prendas a cada tipo de prenda
		for (Prenda elemento : listaPrendas) {
			if (elemento instanceof Zapato) {
				hmCategorias.get("Zapato").add(elemento);
			} else if (elemento instanceof Pantalon) {
				hmCategorias.get("Pantalon").add(elemento);
			} else if (elemento instanceof Camiseta) {
				hmCategorias.get("Camiseta").add(elemento);
			} else {
				System.out.println("Es otra prenda diferente que no es zapato,pantalon ni camiseta");
			}
		}

		for (String elemento : hmCategorias.keySet()) {
			System.out.println(elemento + ": ");
			System.out.println(hmCategorias.get(elemento));

		}
	}

}
