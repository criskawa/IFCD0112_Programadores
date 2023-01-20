package herencia;

public class Mamifero {
	private String colorPelo;
	private String tieneCola;
	public String getColorPelo() {
		return colorPelo;
	}
	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}
	public String getTieneCola() {
		return tieneCola;
	}
	public void setTieneCola(String tieneCola) {
		this.tieneCola = tieneCola;
	}
	@Override
	public String toString() {
		return "Mamifero [colorPelo=" + colorPelo + ", tieneCola=" + tieneCola + "]";
	}
	public Mamifero(String colorPelo, String tieneCola) {
		super();
		this.colorPelo = colorPelo;
		this.tieneCola = tieneCola;
	}
	public Mamifero() {
		super();
	}
	public Mamifero(String string, int i, boolean b, String string2, boolean c) {
		
	}
	
	

}
