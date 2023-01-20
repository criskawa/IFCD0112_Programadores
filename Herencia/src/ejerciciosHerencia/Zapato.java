package ejerciciosHerencia;

public class Zapato extends Prenda {

	private boolean tieneCordones;
	private double alturaTacon;

	public Zapato(String nombre, double precio, String talla) {
		super(nombre, precio, talla);
		this.alturaTacon = alturaTacon;
		this.tieneCordones = tieneCordones;

	}

	public Zapato() {
		super();
		this.alturaTacon = 0.0;
		this.tieneCordones = true;
	}

	public Zapato(double precio, String nombre, String talla, double alturaTacon, boolean tieneCordones) {
		
	}

	public boolean isTieneCordones() {
		return tieneCordones;
	}

	public void setTieneCordones(boolean tieneCordones) {
		this.tieneCordones = tieneCordones;
	}

	public double getAlturaTacon() {
		return alturaTacon;
	}

	public void setAlturaTacon(double alturaTacon) {
		this.alturaTacon = alturaTacon;
	}

	@Override
	public String toString() {
		return "Zapato [tieneCordones=" + tieneCordones + ", alturaTacon=" + alturaTacon + ", toString()="
				+ super.toString() + "]";
	}

}