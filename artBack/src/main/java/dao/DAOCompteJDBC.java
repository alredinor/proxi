package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Compte;

public class DAOCompteJDBC implements DAO<Compte,Integer> {
	
	/*ReadbyId => select id*/
	@Override
	public Compte selectById(Integer id)  {
		Compte c=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_compte,login,mdp,email,adresse,ville,code_postal,type_compte,actif
		PreparedStatement pc = conn.prepareStatement("select * from compte where id_compte=?"); 
		
		pc.setInt(1, id); 
		
		ResultSet rc =pc.executeQuery();
		
		while(rc.next()) {
			
			 c = new Compte (id, rc.getString("login"),rc.getString("mdp"), rc.getString("email"), rc.getString("adresse"), rc.getString("ville"), rc.getString("code_postal"), rc.getString("type_compte"), rc.getBoolean("actif"));
			 
			 }
		
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return c;
	}
	
	
	/*ReadAll*/
	@Override
	public List<Compte> selectAll() {
		
		Compte c=null;
		List<Compte> listeSec = new ArrayList();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		PreparedStatement pc = conn.prepareStatement("select * from compte where type_compte='Artisant' or type_compte='Client'"); 
		
		
		ResultSet rc =pc.executeQuery(); 
		
		while(rc.next()) {
			
			c = new Compte (rc.getInt("id_compte"), rc.getString("login"),rc.getString("mdp"), rc.getString("email"), rc.getString("adresse"), rc.getString("ville"), rc.getString("code_postal"), rc.getString("type_compte"), rc.getBoolean("actif"));
			 listeSec.add(c);
			 
			 }
		
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return listeSec;
	}
	
	
	@Override
	public Integer insert(Compte c) {
		
		int idMaxReturn=0;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		//id_compte,login,mdp,email,adresse,ville,code_postal,type_compte,actif
		PreparedStatement pc = conn.prepareStatement("insert into compte (login,mdp,email,adresse,ville,code_postal,type_compte,actif) values(?,?,?,?,?,?,?,?)");
		
		pc.setString(1, c.getLogin());
		pc.setString(2, c.getMdp());
		pc.setString(3, c.getEmail());
		pc.setString(4, c.getAdresse());
		pc.setString(5, c.getVille());
		pc.setString(6, c.getCode_postal());
		pc.setString(7, c.getType_compte());
		pc.setBoolean(8, c.isActif());
		pc.executeUpdate();
		
		/*reccuperer l'id max dans la base de donnee*/
		PreparedStatement psIdMax = conn.prepareStatement("Select MAX(id_compte) as max from compte");
		ResultSet rs=psIdMax.executeQuery();
		while(rs.next()) 
		{
			idMaxReturn=rs.getInt("max");
		}

		
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return idMaxReturn;
	}
	
	@Override
	public void update(Compte c) {
		// TODO Auto-generated method stub
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); //chargement du pilote jdbc
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); //creation de l'objet connection à la base de donnée
		
		//id_compte,login,mdp,email,adresse,ville,code_postal,type_compte,actif
		PreparedStatement pc = conn.prepareStatement("update compte set login=?,mdp=?,email=?,adresse=?,ville=?,code_postal=?,type_compte=?,actif=? where id_compte=?"); //creation du flux en evitant les injection
		pc.setString(1, c.getLogin());
		pc.setString(2, c.getMdp());
		pc.setString(3, c.getEmail());
		pc.setString(4, c.getAdresse());
		pc.setString(5, c.getVille());
		pc.setString(6, c.getCode_postal());
		pc.setString(7, c.getType_compte());
		pc.setBoolean(8, c.isActif());
		pc.setInt(9,c.getId_Compte());
		System.out.println(pc);
		pc.executeUpdate();
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		
	}


	@Override
	public void delete(Integer id)  {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_compte,login,mdp,email,adresse,ville,code_postal,type_compte,actif
		PreparedStatement pc = conn.prepareStatement("delete from compte where id_compte=?"); 
		pc.setInt(1, id);
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
	}


	
	public Compte checkConnect(String nom,String pass) throws ClassNotFoundException, SQLException 
    {


        Class.forName("com.mysql.cj.jdbc.Driver"); 
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root", ""); 

        PreparedStatement ps = conn.prepareStatement("select * from compte where login=? and mdp=?");
        ps.setString(1,nom);
        ps.setString(2, pass);


        ResultSet rs = ps.executeQuery(); 

        Compte c= null; 

        while (rs.next())
        {
        	//id_compte,login,mdp,email,adresse,ville,code_postal,type_compte,actif
            c = new Compte (rs.getInt("id_Compte"), rs.getString("login"), rs.getString("mdp"), rs.getString("email"), rs.getString("adresse"), rs.getString("ville"), rs.getString("code_postal"), rs.getString("type_compte"), rs.getBoolean("actif")); 

        }

        conn.close(); 
        return c;


    }


}
