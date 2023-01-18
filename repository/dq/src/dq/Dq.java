package dq;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class Dq {

	public static void main(String[] args) {
		//pila o cola, se puede utilizar como las 2
		//solo pueden salir los elementos de los extremos
		Deque <String> colaCine = new LinkedList<String>();
		
		Iterator iter = colaCine.iterator();
		//añadir un elemento a la cola
		colaCine.addLast("Pepe");
		
		System.out.println(colaCine);
		
		while (iter.hasNext()) {
			
		}
		
		
		

	}

}
