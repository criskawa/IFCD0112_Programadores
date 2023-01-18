package com.ipartek.ej1;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.auxiliar.Teclado;

public class Principal {

	public static void main(String[] args) {
		
		List<String> listaNombres= new ArrayList<String>();
		
		for (int i = 0; i < 10; i++) {
			String nombre=Teclado.leerTexto((i+1)+" Introduce el nombre:");
			listaNombres.add(nombre);
		}
		
		for (String nombre : listaNombres) {
			System.out.println(nombre);
		}
		
		

	}

}
