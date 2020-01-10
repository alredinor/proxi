package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Service;

public class DAOServiceJDBC implements DAOService {
	
	/*ReadbyId => select id*/
	@Override
	public Service selectById(Integer id) {
		
		Service c=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_service, id_metier, titre_service
		PreparedStatement pc = conn.prepareStatement("select * from Service where id_service=?,id_metier=?,titre_service=?"); 
		
		pc.setInt(1, id); 
		
		ResultSet rc =pc.executeQuery();
		
		while(rc.next()) {
			
			 c = new Service (id,rc.getInt("id_metier"),rc.getString("titre_service"));
			 
			 }
		
		conn.close();
		}catch(Exception e) {
			e.printStackTrace();
			}
		return c;
	}
	
	
	/*ReadAll*/
	@Override
	public List<Service> selectAll() {
		Service c=null;
		
		List<Service> listeSec = new ArrayList();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		PreparedStatement pc = conn.prepareStatement("select * from Service where id_service=?"); 
		
		
		ResultSet rc =pc.executeQuery(); 
		
		
	
		//id_service, id_metier, titre_service
		while(rc.next()) {
			
			c = new Service (rc.getInt("id_service"), rc.getInt("id_metier"),rc.getString("titre_service"));
			 listeSec.add(c);
			 
			 }
		
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return listeSec;
	}
	
	
	@Override
	public Integer insert(Service c)  {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		
		//id_service, id_metier, titre_service
		PreparedStatement pc = conn.prepareStatement("insert into Service (id_service,id_metier,titre_service) values(?,?,?)");
		
		pc.setInt(1, c.getId_service());
		pc.setInt(2, c.getId_metier());
		pc.setString(3, c.getTitre_service());
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return null;
		
	}
	
	@Override
	public void update(Service c)  {
		// TODO Auto-generated method stub
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); //chargement du pilote jdbc
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); //creation de l'objet connection à la base de donnée
		
		//id_service, id_metier, titre_service
		PreparedStatement pc = conn.prepareStatement("update Service set id_metier=?,titre_service=? where id_service=?"); //creation du flux en evitant les injection
		
		pc.setInt(1, c.getId_metier());
		pc.setString(2, c.getTitre_service());
		pc.setInt(3, c.getId_service());
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
		
		//id_service, id_metier, titre_service
		PreparedStatement pc = conn.prepareStatement("delete from Service where id_service=?"); 
		pc.setInt(1, id);
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		
	}




}
