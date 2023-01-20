package modelo;

public class Cuadrado extends Figura {

	private double longitudLado;

	public Cuadrado(String nombre, double longitudLado) {
		super(nombre);
		this.longitudLado = longitudLado;
	}

	public Cuadrado() {
		super();
		this.longitudLado = longitudLado;
	}

	// Constructor medio
	public Cuadrado(double longitudLado) {
		super();
		this.longitudLado = longitudLado;
	}

	public double getLongitudLado() {
		return longitudLado;
	}

	public void setLongitudLado(double longitudLado) {
		this.longitudLado = longitudLado;
	}

	@Override
	public String toString() {
		return "Cuadrado [longitudLado=" + longitudLado + "]";
	}

	
	public static Figura crearPidiendoDatos() {
	
		Cuadrado figura = new Cuadrado();
		//leemos el lado y el nombre y los establecemos para despues poder calcular
		String nom = Teclado.leerTexto("Introduce el nombre");
		double la = Teclado.leerNumeroDouble("Introduce el lado");
		figura.setNombre(nom);
		figura.longitudLado=la;
		
		return figura;
	}

	@Override
	public double calcularArea() {
		return longitudLado *longitudLado;
		
	}
	
	
}
