package herencia;

public class Pez extends Animal{
	
	private int numeroAgallas;
	private boolean esComestible;
	public int getNumeroAgallas() {
		return numeroAgallas;
	}
	public void setNumeroAgallas(int numeroAgallas) {
		this.numeroAgallas = numeroAgallas;
	}
	public boolean getEsComestible() {
		return esComestible;
	}
	public void setEsComestible(boolean esComestible) {
		this.esComestible = esComestible;
	}
	public Pez() {
		super();
		this.numeroAgallas = 0;
		this.esComestible = true;
	}
	public Pez(int numeroAgallas, boolean esComestible) {
		super();
		this.numeroAgallas = numeroAgallas;
		this.esComestible = esComestible;
	}
	@Override
	public String toString() {
		return "Pez [numeroAgallas=" + numeroAgallas + ", esComestible=" + esComestible + ", getNumeroAgallas()="
				+ getNumeroAgallas() + ", getEsComestible()=" + getEsComestible() + "]";
	}
	
	

}
