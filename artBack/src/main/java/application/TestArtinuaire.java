package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import dao.DAOCompteJDBC;
import dao.DAODemandeJDBC;
import dao.DAODetailJDBC;
import dao.DAOMetierJDBC;
import dao.DAOServiceJDBC;
import model.*;

public class TestArtinuaire {
	
	public static int saisieInt(String msg) {
		Scanner sc= new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}


	public static double saisieDouble(String msg) {
		Scanner sc= new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}


	public static String saisieString(String msg) {
		Scanner sc= new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}
	
	
	private static void menuConnect() throws ClassNotFoundException, SQLException  {
        String nom = "";
        String password = "";

        DAOCompteJDBC daoCompte = new DAOCompteJDBC();

        nom=saisieString("Saisir votre login");
        password=saisieString("Saisir password");
        Compte connexion=daoCompte.checkConnect(nom, password);
System.out.println(connexion);
        if(connexion==null) {
        	System.out.println("Compte invalide");
        	menuConnect();
        }
        else if(connexion.getType_compte().equals("Artisan")) 
        {
            menuArtisan(new Artisan(connexion.getId_Compte(), nom,password, "Artisan", password, password, password, password, false));
        }
        else if(connexion.getType_compte().equals("Client")) 
        {
            menuClient(new Client(nom,password, "Client"));
        }
        else if(connexion.getType_compte().equals("admin")) 
        {
            menuAdmin(new Admin(nom,password, "Admin"));
        }
        else 
		{
			System.out.println("------------------------\nIdentifiants incorrects\n------------------------");
			menuConnect();
		}
    }
	
	
	/*Menu principal
	private static void menuConnect() throws ClassNotFoundException, SQLException {
		String login = "";
		String mdp = "";
		String type_compte="";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		PreparedStatement nom = conn.prepareStatement("Select login from compte");
		PreparedStatement pass = conn.prepareStatement("Select mdp from compte");
		PreparedStatement type = conn.prepareStatement("Select type_compte from compte where type_compte='Client' or type_compte='Artisan'");
		ResultSet rsNom=nom.executeQuery();
		ResultSet rsPass=pass.executeQuery();
		ResultSet rsType=pass.executeQuery();
		
		try 
		{
			login=saisieString("Saisir votre login");
			mdp=saisieString("Saisir mdp");
			type_compte=saisieString("Saisir le type de compte");
		}
		catch(Exception e) {
			menuConnect();
			}
		System.out.println(login+"/"+rsNom);
		System.out.println(mdp+"/"+rsPass);
		System.out.println(type_compte+"/"+rsType);
		if((login.equals(rsNom) && mdp.equals(rsPass) && type_compte.equals(rsType))) 
		{
			System.out.println(login+"/"+rsNom);
			System.out.println(mdp+"/"+rsPass);
			System.out.println(type_compte+"/"+rsType);
			menuArtisan(new Artisan(login,mdp,type_compte));
		}
		else 
		{
			System.out.println("------------------------\nIdentifiants incorrects\n------------------------");
			menuConnect();
		}
		
	}
	*/

	/*Menu artisan*/
	private static void menuArtisan(Artisan art) throws ClassNotFoundException, SQLException {
		int choix = 0;
		
		System.out.println("\n Bienvenue sur votre menu d'accueil ");
		System.out.println("---------------Que voulez vous faire ?---------------");
		System.out.println("1 - Modifier profil");
		System.out.println("2 - Valider");
		System.out.println("3 - Se deconnecter");
		
		try 
		{
			choix=saisieInt("");
		}
		catch(InputMismatchException e) {
			System.out.println("Merci de saisir un chiffre !");
			}
		
		switch(choix) 
		{
		case 1: art.ModifierProfil();
		menuArtisan(art);
		break;
		case 2: art.Valider();
		menuArtisan(art);
		break;
		case 3: System.out.println("Connexion perdue...");
		menuConnect();
		break;
		default : System.out.println("Choix invalide");
		menuArtisan(art);
		}
		
		
	}

	/*Menu Client*/
	private static void menuClient(Client client) throws ClassNotFoundException, SQLException {
		
		int choix = 0;
		System.out.println("\nBienvenue sur votre menu d'accueil ");
		System.out.println("Que voulez vous faire ?");
		System.out.println("1 - Rechercher un artisan");
		System.out.println("2 - Consulter profil");
		System.out.println("3 - Prendre RDV");
		System.out.println("4 - Se deconnecter");
		
		try 
		{
			choix=saisieInt("");
		}
		catch(InputMismatchException e) {
			System.out.println("Merci de saisir un chiffre !");
			}
		
		switch(choix) 
		{
		case 1: client.RechercherArtisan();
		menuClient(client);
		break;
		case 2: client.ConsulterProfil();
		menuClient(client);break;
		case 3: client.PrendreRdv();
		menuClient(client);
		break;
		case 4: System.out.println("Connexion perdue...");
		menuConnect();
		break;
		default : System.out.println("Choix invalide");
		menuClient(client);
		}
		
		
	}
	
	/*Menu Admin*/
	private static void menuAdmin(Admin root) throws ClassNotFoundException, SQLException {
		
		int choix = 0;
		System.out.println("\nBienvenue sur votre menu d'accueil ");
		System.out.println("Que voulez vous faire ?");
		System.out.println("1 - Gestion compte");
		System.out.println("2 - Valider compte");
		System.out.println("3 - Gestion catégorie");
		System.out.println("4 - Se deconnecter");
		
		try 
		{
			choix=saisieInt("");
		}
		catch(InputMismatchException e) {
			System.out.println("Merci de saisir un chiffre !");
			}
		
		switch(choix) 
		{
		case 1: root.GestionCompte();
		menuAdmin(root);
		break;
		case 2: root.ValiderCompte();
		menuAdmin(root);
		break;
		case 3: root.ValiderCategorie();
		menuAdmin(root);
		break;
		case 4: System.out.println("Connexion perdue...");
		menuConnect();
		break;
		default : System.out.println("Choix invalide");
		menuAdmin(root);
		}
		
		
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DAOCompteJDBC daoCompte = new DAOCompteJDBC();
		DAODemandeJDBC daoDemande = new DAODemandeJDBC();
		DAODetailJDBC daoDetail = new DAODetailJDBC();
		DAOMetierJDBC daoMetier = new DAOMetierJDBC();
		DAOServiceJDBC daoService = new DAOServiceJDBC();
		
		
		menuConnect();
		
		
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
