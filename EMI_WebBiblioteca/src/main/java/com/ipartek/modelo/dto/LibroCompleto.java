package com.ipartek.modelo.dto;

public class LibroCompleto 
{
	private int id;
	private String titulo;
	private int fk_autor;
	private double precio;
	private String autor;
	private boolean fallecido;
	
	
	public LibroCompleto(int id, String titulo, int fk_autor, double precio, String autor, boolean fallecido) 
	{
		super();
		this.id = id;
		this.titulo = titulo;
		this.fk_autor = fk_autor;
		this.precio = precio;
		this.autor = autor;
		this.fallecido = fallecido;
	}
	
	public LibroCompleto() 
	{
		super();
		this.id = 0;
		this.titulo = "";
		this.fk_autor = 0;
		this.precio = 0.0;
		this.autor = "";
		this.fallecido = false;
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

	public String getAutor() 
	{
		return autor;
	}

	public void setAutor(String autor) 
	{
		this.autor = autor;
	}

	public boolean isFallecido()
	{
		return fallecido;
	}

	public void setFallecido(boolean fallecido) 
	{
		this.fallecido = fallecido;
	}

	@Override
	public String toString() 
	{
		return "LibroCompleto id=" + id + ", titulo=" + titulo 
				+ ", fk_autor=" + fk_autor + ", precio=" + precio
				+ ", autor=" + autor + ", fallecido=" + fallecido;
	}
	
	
}
