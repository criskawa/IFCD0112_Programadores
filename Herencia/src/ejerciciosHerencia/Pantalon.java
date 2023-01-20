package ejerciciosHerencia;

public class Pantalon extends Prenda {
	
	private String estilo;
	private boolean tieneBolsillos;
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public boolean isTieneBolsillos() {
		return tieneBolsillos;
	}
	public void setTieneBolsillos(boolean tieneBolsillos) {
		this.tieneBolsillos = tieneBolsillos;
	}
	public Pantalon(String nombre, double precio, String talla, String estilo, boolean tieneBolsillos) {
		super(nombre, precio, talla);
		this.estilo = estilo;
		this.tieneBolsillos = tieneBolsillos;
	}
	public Pantalon(String nombre, double precio, String talla) {
		super(nombre, precio, talla);
		this.estilo=estilo;
		this.tieneBolsillos=tieneBolsillos;
	}
	public Pantalon() {
		super();
		this.estilo="";
		this.tieneBolsillos=true;
	}
	public Pantalon(String estilo, boolean tieneBolsillos) {
		super();
		this.estilo = estilo;
		this.tieneBolsillos = tieneBolsillos;
	}
	@Override
	public String toString() {
		return "Pantalon [estilo=" + estilo + ", tieneBolsillos=" + tieneBolsillos + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
