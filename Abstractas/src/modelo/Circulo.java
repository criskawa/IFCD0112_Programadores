package modelo;

public class Circulo extends Figura {

	private double radio;

	public Circulo(String nombre, double radio) {
		super(nombre);
		this.radio = radio;
	}

	public Circulo(String nombre) {
		super(nombre);
	}

	public Circulo() {
		super();
		this.radio = radio;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "radio= " + calcularArea();
	}

	
	public static Figura crearPidiendoDatos() {

		Circulo figura = new Circulo();
		String nom = Teclado.leerTexto("Introduce el nombre");
		double ra = Teclado.leerNumeroDouble("Introduce el lado");
		figura.setNombre(nom);
		figura.setRadio(ra);

		return figura;
	}

	@Override
	public double calcularArea() {

		double num = Math.PI * Math.pow(radio, 2.0);
		return num;
	}

}
