package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOCompteJDBC;
import dao.DAODemandeJDBC;
import dao.DAODetailJDBC;
import dao.DAOMetierJDBC;
import dao.DAOServiceJDBC;
import model.*;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DAOCompteJDBC daoCompte = new DAOCompteJDBC();
		DAODemandeJDBC daoDemande = new DAODemandeJDBC();
		DAODetailJDBC daoDetail = new DAODetailJDBC();
		DAOMetierJDBC daoMetier = new DAOMetierJDBC();
		DAOServiceJDBC daoService = new DAOServiceJDBC();
		
		/*selectById
		Compte c= daoCompte.selectById(1);
		System.out.println(c);
		*/
		
		/*selectAll
		List<Compte> listeCompte = new ArrayList();
		listeCompte=daoCompte.selectAll();
		System.out.println(listeCompte);
		*/
		
		/*insert
		//login,mdp,email,adresse,ville,code_postal,type_compte,actif
		Compte c=new Compte("Hubert","mm","joooooooooooooooooo","6 rou","Paris","75009","Client",false);
		int idInsert=daoCompte.insert(c);
		//System.out.println(idInsert);
		System.out.println(daoCompte.selectById(idInsert));
		daoCompte.delete(idInsert); //supprimer la derniere ligne incrementée
		*/
		
		
		
		/*daoCompte.delete(2);
		daoCompte.delete(3);
		daoCompte.delete(4);
		daoCompte.delete(5);
		daoCompte.delete(6);
		daoCompte.delete(7);
		daoCompte.delete(idInsert);
		*/
		
		
		/*update
		Compte c= daoCompte.selectById(1);
		c.setLogin("Noco");
		daoCompte.update(c);
		c= daoCompte.selectById(1);
		System.out.println(c);
		*/
		
		
		
	}

}
