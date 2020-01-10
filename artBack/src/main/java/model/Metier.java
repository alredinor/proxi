package model;

public class Metier {
	
	private int id_metier;
	private String titre_metier;
	
	
	public Metier(int id_metier, String titre_metier) {
		super();
		this.id_metier = id_metier;
		this.titre_metier = titre_metier;
	}


	public int getId_metier() {
		return id_metier;
	}


	public void setId_metier(int id_metier) {
		this.id_metier = id_metier;
	}


	public String getTitre_metier() {
		return titre_metier;
	}


	public void setTitre_metier(String titre_metier) {
		this.titre_metier = titre_metier;
	}


	@Override
	public String toString() {
		return "Metier [id_metier=" + id_metier + ", titre_metier=" + titre_metier + "]";
	}
	
	
	
	
	
	
	

}
