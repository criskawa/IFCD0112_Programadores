package modelo;

public class Principal {

	public static void main(String[] args) {
		
		Figura cir2 = Circulo.crearPidiendoDatos();
		
		System.out.println(cir2);
		/*he cambiado el tostring de la clase circulo, he llamado 
		a la clase calcular area para que devuelva el resultado, como 
		devuelve un objeto, solo muestra la cantidad que se ingresa por teclado, sin calcularlo*/
	}

}
