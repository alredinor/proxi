package model;

public class Compte {
	
	private int id_compte;
	private String login;
	private String mdp;
	private String email;
	private String adresse;
	private String ville;
	private String code_postal;
	private String type_compte;
	private boolean actif;
	
	public Compte(int id_Compte, String login, String mdp, String email, String adresse, String ville, String code_postal,
			String type_compte, boolean actif) {
		this.id_compte = id_Compte;
		this.login = login;
		this.mdp = mdp;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.code_postal = code_postal;
		this.type_compte = type_compte;
		this.actif = actif;
	}
	
	public Compte(String login, String mdp, String email, String adresse, String ville, String code_postal,
			String type_compte, boolean actif) {
		this.login = login;
		this.mdp = mdp;
		this.email = email;
		this.adresse = adresse;
		this.ville = ville;
		this.code_postal = code_postal;
		this.type_compte = type_compte;
		this.actif = actif;
	}

	public int getId_Compte() {
		return id_compte;
	}

	public void setId_Compte(int id_Compte) {
		this.id_compte = id_Compte;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getType_compte() {
		return type_compte;
	}

	public void setType_compte(String type_compte) {
		this.type_compte = type_compte;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	@Override
	public String toString() {
		return "Compte [id_Compte=" + id_compte + ", login=" + login + ", mdp=" + mdp + ", email=" + email
				+ ", adresse=" + adresse + ", ville=" + ville + ", code_postal=" + code_postal + ", type_compte="
				+ type_compte + ", actif=" + actif + "]";
	}
	
	
	
	
	

}
