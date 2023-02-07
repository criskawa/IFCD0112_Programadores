package com.ipartek.modelo.dto;

public class Cancion {

	private int id;
	private String grupo;
	private String cancion;
	private String enlace;
	private String estilo;
	
	public Cancion(int id, String grupo, String cancion, String enlace, String estilo) {
		super();
		this.id = id;
		this.grupo = grupo;
		this.cancion = cancion;
		this.enlace = enlace;
		this.estilo = estilo;
	}
	public Cancion() {
		super();
		this.id = 0;
		this.grupo= "";
		this.cancion = "";
		this.enlace = "";
		this.estilo = "";
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	public String getCancion() {
		return cancion;
	}
	public void setCancion(String cancion) {
		this.cancion = cancion;
	}
	public String getEnlace() {
		return enlace;
	}
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	@Override
	public String toString() {
		return "Cancion [id=" + id + ", grupo=" + grupo + ", cancion=" + cancion + ", enlace=" + enlace + ", estilo="
				+ estilo + "]";
	}
	
	
	
	
}
