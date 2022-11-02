package main;

public class Comisaria {
	private int id;
	private String nombre;
	private Coordenada coordenada;
	public Comisaria(int id, String nombre, Coordenada coordenada) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.coordenada = coordenada;
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
	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}


	

}
