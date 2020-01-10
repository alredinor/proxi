package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Detail;

public class DAODetailJDBC implements DAO<Detail,Integer> {
	
	/*ReadbyId => select id*/
	@Override
	public Detail selectById(Integer id)  {
		
		Detail c=null;
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_demande, id_service, statut
		PreparedStatement pc = conn.prepareStatement("select * from Detail where id_demande=?,id_service=?,statut=?"); 
		
		pc.setInt(1, id); 
		
		ResultSet rc =pc.executeQuery();
		
		
		
		while(rc.next()) {
			
			 c = new Detail (id,rc.getInt("id_service"),rc.getBoolean("statut"));
			 
			 }
		
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return c;
	}
	
	
	/*ReadAll*/
	@Override
	public List<Detail> selectAll() {
		
		Detail c=null;
		List<Detail> listeSec = new ArrayList();
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		PreparedStatement pc = conn.prepareStatement("select * from Detail where id_demande=?"); 
		
		
		ResultSet rc =pc.executeQuery(); 
		
		
		
		//id_demande, id_service, statut
		while(rc.next()) {
			
			c = new Detail (rc.getInt("id_demande"), rc.getInt("id_service"),rc.getBoolean("statut"));
			 listeSec.add(c);
			 
			 }
		
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return listeSec;
	}
	
	
	@Override
	public Integer insert(Detail c) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		
		//id_demande, id_service, statut
		PreparedStatement pc = conn.prepareStatement("insert into Detail (id_demande,id_service,statut) values(?,?,?)");
		
		pc.setInt(1, c.getId_demande());
		pc.setInt(2, c.getid_service());
		pc.setBoolean(3, c.isStatut());
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
		return null;
		
	}
	
	@Override
	public void update(Detail c)  {
		// TODO Auto-generated method stub
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); //chargement du pilote jdbc
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); //creation de l'objet connection à la base de donnée
		
		//id_demande, id_metier, titre_Detail
		PreparedStatement pc = conn.prepareStatement("update Detail set id_service=?,statut=? where id_demande=?"); //creation du flux en evitant les injection
		
		pc.setInt(1, c.getid_service());
		pc.setBoolean(2, c.isStatut());
		pc.setInt(3, c.getId_demande());
		pc.executeUpdate();
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
	}


	@Override
	public void delete(Integer id) {
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_demande, id_metier, titre_Detail
		PreparedStatement pc = conn.prepareStatement("delete from Detail where id_demande=?"); 
		pc.setInt(1, id);
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		}catch(Exception e) {e.printStackTrace();}
	}




}
