package model;

public class Demande {
	
	private int id_demande;
	private String message;
	private int id_service;
	private int id_compte_C;
	private int id_compte_A;
	
	
	public Demande(int id_demande, String message, int id_service, int id_compte_C, int id_compte_A) {
		//super();
		this.id_demande = id_demande;
		this.message = message;
		this.id_service = id_service;
		this.id_compte_C = id_compte_C;
		this.id_compte_A = id_compte_A;
	}


	public int getId_demande() {
		return id_demande;
	}


	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getId_service() {
		return id_service;
	}


	public void setId_service(int id_service) {
		this.id_service = id_service;
	}


	public int getId_compte_C() {
		return id_compte_C;
	}


	public void setId_compte_C(int id_compte_C) {
		this.id_compte_C = id_compte_C;
	}


	public int getId_compte_A() {
		return id_compte_A;
	}


	public void setId_compte_A(int id_compte_A) {
		this.id_compte_A = id_compte_A;
	}


	@Override
	public String toString() {
		return "Demande [id_demande=" + id_demande + ", message=" + message + ", id_service=" + id_service
				+ ", id_compte_C=" + id_compte_C + ", id_compte_A=" + id_compte_A + "]";
	}
	
	
	
	
	
	
	
	


}
