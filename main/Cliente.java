package main;

public class Cliente {
	
	private String site_no;
	private Coordenada coordenada;
	private String queryUpdate;
	private int seccional_id=0;
	
	public Cliente(String site_no,Coordenada coordenada) {
		
		this.site_no=site_no;
		this.coordenada=coordenada;
		this.queryUpdate=Utilidades.getQueryActualizadora();
		this.queryUpdate=queryUpdate.replace("{site_no}",String.valueOf(this.site_no));
		
	}
	public Cliente() {
		this.queryUpdate=Utilidades.getQueryActualizadora();
		
	}

	

	public Coordenada getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	public String getSite_no() {
		return site_no;
	}
	public void setSite_no(String site_no) {
		this.site_no = site_no;
		this.queryUpdate=queryUpdate.replace("{site_no}",String.valueOf(this.site_no));
	}
	public String getQueryUpdate() {
		return queryUpdate;
	}
	public void setQueryUpdate(String queryUpdate) {
		this.queryUpdate = queryUpdate;
	}
	public int getSeccional_id() {
		return seccional_id;
	}
	public void setSeccional_id(int seccional_id) {
		this.queryUpdate=queryUpdate.replace("{jurisdiction_id}",String.valueOf(seccional_id));	
		this.seccional_id = seccional_id; 
	}
	
	

}
