package model;

import application.TestArtinuaire;
import dao.DAOCompteJDBC;

import java.sql.SQLException;

import application.Artinuaire;
import application.Test;

public class Artisan extends Compte {
	


	public Artisan(int id_Compte, String login, String mdp, String email, String adresse, String ville,
			String code_postal, String type_compte, boolean actif) {
		super(id_Compte, login, mdp, email, adresse, ville, code_postal, type_compte, actif);
		// TODO Auto-generated constructor stub
	}


	public void ModifierProfil() throws ClassNotFoundException, SQLException {
		setLogin(TestArtinuaire.saisieString("Saisir nouveau login"));
		setMdp(TestArtinuaire.saisieString("Saisir nouveau mot de passe"));
		setEmail(TestArtinuaire.saisieString("Saisir un email"));
		setAdresse(TestArtinuaire.saisieString("Saisir une adresse"));
		setVille(TestArtinuaire.saisieString("Saisir une ville"));
		setCode_postal(TestArtinuaire.saisieString("Saisir un code postal"));
		setType_compte(TestArtinuaire.saisieString("Saisir nouveau le type de compte"));
		
		//Compte p=new Compte(logN,mdpN,mail,rue,vil,cp,typeC,true);
		DAOCompteJDBC DAOc =new DAOCompteJDBC();
		DAOc.update(this);
//		Compte p=new Compte(logN,mdpN,mail,rue,vil,cp,typeC,true);
//		
//		Artinuaire.getInstance().addCompte(p);
		
	}
	
	
	public void Valider() {
		/*A faire plus tard*/
	}

	

}
