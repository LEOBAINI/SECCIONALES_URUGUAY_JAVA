package main;

import java.util.ArrayList;

public class Seccional {
	private int id;
	private String nombre;
	private ArrayList<Coordenada> coordenadas;
	
	public Seccional(int id,String nombre,ArrayList<Coordenada> coordenadas) {
		
		this.id=id;
		this.nombre=nombre;
		this.coordenadas=coordenadas;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Coordenada> getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenada(ArrayList<Coordenada> coordenadas) {
		this.coordenadas = coordenadas;
	}
	
	
	

}
