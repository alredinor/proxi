package model;

public class Detail {
	
	private int id_demande;
	private int id_service;
	private boolean statut;
	
	
	public Detail(int id_demande, int id_service, boolean statut) {
		super();
		this.id_demande = id_demande;
		this.id_service = id_service;
		this.statut = statut;
	}


	public int getId_demande() {
		return id_demande;
	}


	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}


	public int getid_service() {
		return id_service;
	}


	public void setid_service(int id_service) {
		this.id_service = id_service;
	}


	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}


	@Override
	public String toString() {
		return "Detail [id_demande=" + id_demande + ", id_service=" + id_service + ", statut=" + statut + "]";
	}
	
	
	
	
	
	

}
