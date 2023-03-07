package com.ipartek.modelo.dto;

public class Autor 
{
	private int id;
	private String autor;
	private boolean fallecido;
	
	
	public Autor(int id, String autor, boolean fallecido) 
	{
		super();
		this.id = id;
		this.autor = autor;
		this.fallecido = fallecido;
	}
	
	public Autor() 
	{
		super();
		this.id = 0;
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

	public String getAutor() 
	{
		return autor;
	}

	public void setAutor(String autor) 
	{
		this.autor = autor;
	}

	public boolean getFallecido() 
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
		return "Autor id=" + id + ", autor=" + autor + ", fallecido=" + fallecido;
	}
	
}
