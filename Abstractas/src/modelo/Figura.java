package modelo;

public abstract class Figura {

	private String nombre;

	public Figura(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Figura() {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Figura [nombre=" + nombre + "]";
	}

//	public abstract Figura crearPidiendoDatos();

	public abstract double calcularArea();
}
