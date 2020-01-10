package model;

public class Service {
	
	private int id_service;
	private int id_metier;
	private String titre_service;
	
	
	public Service(int id_service, int id_metier, String titre_service) {
		//super();
		this.id_service = id_service;
		this.id_metier = id_metier;
		this.titre_service = titre_service;
	}


	public int getId_service() {
		return id_service;
	}


	public void setId_service(int id_service) {
		this.id_service = id_service;
	}


	public int getId_metier() {
		return id_metier;
	}


	public void setId_metier(int id_metier) {
		this.id_metier = id_metier;
	}


	public String getTitre_service() {
		return titre_service;
	}


	public void setTitre_service(String titre_service) {
		this.titre_service = titre_service;
	}


	@Override
	public String toString() {
		return "Service [id_service=" + id_service + ", id_metier=" + id_metier + ", titre_service=" + titre_service
				+ "]";
	}
	
	
	
	


}
