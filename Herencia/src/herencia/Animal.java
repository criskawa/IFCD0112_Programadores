package herencia;

public class Animal {

	private String nombre;
	private boolean estaExtinto;
	
	public Animal(String nombre, boolean estaExtinto) {
		super();
		this.nombre = nombre;
		this.estaExtinto = estaExtinto;
	}
	
	public Animal() {
		super();
		this.nombre = "";
		this.estaExtinto = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstaExtinto() {
		return estaExtinto;
	}

	public void setEstaExtinto(boolean estaExtinto) {
		this.estaExtinto = estaExtinto;
	}

	@Override
	public String toString() {
		return "Animal [nombre=" + nombre + ", estaExtinto=" + estaExtinto + "]";
	}
	
	public void saludar()
	{
		System.out.println("Hola, soy un animal");
	}
	
	
}
