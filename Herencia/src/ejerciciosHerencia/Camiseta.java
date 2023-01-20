package ejerciciosHerencia;

public class Camiseta extends Prenda{

private String color;
private boolean tieneBotones;
public Camiseta(String nombre, boolean precio, String talla, String color, boolean tieneBotones) {
	super();
	this.color = color;
	this.tieneBotones = tieneBotones;
}
public Camiseta() {
	super();
	this.color = "";
	this.tieneBotones = false;
}

public Camiseta(String color, boolean tieneBotones) {
	super();
	this.color = color;
	this.tieneBotones = tieneBotones;
	
}

public Camiseta(String nombre, double precio, String talla, String color2, boolean tieneBotones2) {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Camiseta [color=" + color + ", tieneBotones=" + tieneBotones + "]";
}

}
