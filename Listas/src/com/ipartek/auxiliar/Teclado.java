package com.ipartek.auxiliar;

import java.util.Scanner;

public class Teclado {

	public static Scanner sc = new Scanner(System.in);

	public static String leerTexto(String mensaje) {
		System.out.println(mensaje);
		String textoLeido = sc.nextLine();

		return textoLeido;
	}

	public static int leerNumeroEntero(String mensaje) {
		boolean salir = false;
		int numeroEntero = 0;

		do {
			System.out.println(mensaje);
			String textoLeido = sc.nextLine();

			if (textoLeido.matches("[0-9]*")) {
				numeroEntero = Integer.parseInt(textoLeido);
				salir = true;
			}
		} while (salir == false);

		return numeroEntero;
	}
	
//	
//	public static int leerNumeroEnteroExcepcion(String mensaje) {
//		
//		boolean salir=false;
//		int numeroEntero=0;
//		
//		do {
//			System.out.println(mensaje);
//			String textoLeido = sc.nextLine();
//			try {
//				numeroEntero = Integer.parseInt(textoLeido);
//				salir= true;
//			} catch (NumberFormatException e) {	
//				e.printStackTrace();
//			} 
//		} while (salir==false);
//		
//		return numeroEntero;	
//	}

	public static double leerNumeroDouble(String mensaje) {

		boolean salir = false;
		double numeroDouble = 0.0;
		// "^[0-9]+(,[0-9]+)?$"
		do {
			System.out.print(mensaje);
			System.out.println(", el separado decimal es el punto(.)");
			String textoLeido = sc.nextLine();
			textoLeido = textoLeido.replace(',', '.');

			if (textoLeido.matches("^[0-9]+(.[0-9]+)?$")) {

				numeroDouble = Double.parseDouble(textoLeido);
				salir = true;
			}
		} while (salir == false);

		return numeroDouble;// cambiar por el resultado bueno
	}

	public static int leerNumeroEnteroRango(String mensaje, int min, int max) {
		boolean salir = false;
		int numeroEntero = 0;
		int maxReal = Math.max(max, min);
		int minReal = Math.min(max, min);
		do {
			System.out.println(mensaje);
			String textoLeido = sc.nextLine();

			if (textoLeido.matches("[0-9]*")) {
				numeroEntero = Integer.parseInt(textoLeido);
				if (numeroEntero >= minReal && numeroEntero <= maxReal) {
					salir = true;
				} else {
					System.out.println("Núm no válido.");
				}
			} else {
				System.out.println("Esto no es un núm.");
			}
		} while (salir == false);
		return numeroEntero;
	}

	public static double leerNumeroRealRango(String mensaje, double min, double max) {
		boolean salir = false;
		double numeroDouble = 0.0;
		double maxReal = Math.max(max, min);
		double minReal = Math.min(max, min);

		do {
			System.out.println(mensaje);
			String textoLeido = sc.nextLine();

			if (textoLeido.matches("^[0-9]+(.[0-9]+)?$")) {
				numeroDouble = Double.parseDouble(textoLeido);
				if (numeroDouble >= minReal && numeroDouble <= maxReal) {
					salir = true;
				} else {
					System.out.println("No esta en el rango");
				}
			} else {
				System.out.println("Esto no es un numero");
			}

		} while (salir == false);

		return numeroDouble;
	}

	
}
