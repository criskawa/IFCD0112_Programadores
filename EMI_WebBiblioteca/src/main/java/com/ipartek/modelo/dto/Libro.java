package com.ipartek.modelo.dto;

public class Libro 
{
	private int id;
	private String titulo;
	private int fk_autor;
	private double precio;
	
	
	public Libro(int id, String titulo, int fk_autor, double precio) 
	{
		super();
		this.id = id;
		this.titulo = titulo;
		this.fk_autor = fk_autor;
		this.precio = precio;
	}
	
	public Libro() 
	{
		super();
		this.id = 0;
		this.titulo = "";
		this.fk_autor = 0;
		this.precio = 0.0;
	}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getTitulo() 
	{
		return titulo;
	}

	public void setTitulo(String titulo) 
	{
		this.titulo = titulo;
	}

	public int getFk_autor() 
	{
		return fk_autor;
	}

	public void setFk_autor(int fk_autor) 
	{
		this.fk_autor = fk_autor;
	}

	public double getPrecio() 
	{
		return precio;
	}

	public void setPrecio(double precio) 
	{
		this.precio = precio;
	}

	@Override
	public String toString() 
	{
		return "Libro id=" + id + ", titulo=" + titulo + ", fk_autor=" + fk_autor + ", precio=" + precio;
	}
	
}
