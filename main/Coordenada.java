package main;

public class Coordenada {
	private double latitud;
	private double longitud;
	
	public Coordenada(double latitud,double longitud) {
		
		this.latitud=Math.round(latitud * 100000000d) / 100000000d;
		this.longitud=Math.round(longitud * 100000000d) / 100000000d;
	}

	public Coordenada() {
		// TODO Auto-generated constructor stub
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = Math.round(latitud * 100000000d) / 100000000d;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = Math.round(longitud * 100000000d) / 100000000d;
	}

	
	
}
