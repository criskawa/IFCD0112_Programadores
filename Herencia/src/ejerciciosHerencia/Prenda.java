package ejerciciosHerencia;

public class Prenda {

	private String nombre;
	private double precio;
	private String talla;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public Prenda(String nombre, double precio, String talla) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.talla = talla;
	}
	public Prenda() {
		super();
		this.precio=0.0;
		this.nombre="";
		this.talla="";
		
	}
	
	
	
}
