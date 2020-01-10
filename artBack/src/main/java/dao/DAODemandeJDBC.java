package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Demande;

public class DAODemandeJDBC implements DAO<Demande,Integer> {
	
	/*ReadbyId => select id*/
	@Override
	public Demande selectById(Integer id) throws SQLException, ClassNotFoundException {
		
		//int id_demande, String message, int id_service, int id_compte_C, int id_compte_A
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		PreparedStatement pc = conn.prepareStatement("select * from Demande where id_demande=? and message=?,id_service=?,id_compte_C=?,id_compte_A=?"); 
		
		pc.setInt(1, id); 
		
		ResultSet rc =pc.executeQuery();
		
		Demande c=null; 
		
		while(rc.next()) {
			
			 c = new Demande (id, rc.getString("message"),rc.getInt("id_service"), rc.getInt("id_compte_C"), rc.getInt("id_compte_A"));
			 
			 }
		
		conn.close();
		
		return c;
	}
	
	
	/*ReadAll*/
	@Override
	public List<Demande> selectAll() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		PreparedStatement pc = conn.prepareStatement("select * from Demande where id_demande=?"); 
		
		
		ResultSet rc =pc.executeQuery(); 
		
		Demande c=null;
		
		List<Demande> listeSec = new ArrayList();
		
		while(rc.next()) {
			
			c = new Demande (rc.getInt("id_demande"), rc.getString("message"),rc.getInt("id_service"), rc.getInt("id_compte_C"), rc.getInt("id_compte_A"));
			 listeSec.add(c);
			 
			 }
		
		conn.close();
		
		return listeSec;
	}
	
	
	@Override
	public Integer insert(Demande c) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		
		//message, id_service, id_compte_C, id_compte_A
		PreparedStatement pc = conn.prepareStatement("insert into Demande (message,id_service,id_compte_C,id_compte_A) values(?,?,?,?)");
		
		pc.setString(1, c.getMessage());
		pc.setInt(2, c.getId_service());
		pc.setInt(3, c.getId_compte_C());
		pc.setInt(4, c.getId_compte_A());
		pc.executeUpdate();
		pc.close();
		conn.close();
		return null;
	}
	
	@Override
	public void update(Demande c) throws SQLException, ClassNotFoundException {
		
		
		Class.forName("com.mysql.jdbc.Driver"); //chargement du pilote jdbc
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); //creation de l'objet connection à la base de donnée
		
		//message, id_service, id_compte_C, id_compte_A
		PreparedStatement pc = conn.prepareStatement("update Demande set message=?,id_service=?,id_compte_C=?,id_compte_A=? where id_demande=?"); //creation du flux en evitant les injection
		pc.setString(1, c.getMessage());
		pc.setInt(2, c.getId_service());
		pc.setInt(3, c.getId_compte_C());
		pc.setInt(4, c.getId_compte_A());
		pc.setInt(5,c.getId_demande());
		pc.executeUpdate();
		pc.close();
		conn.close();
		
	}


	@Override
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_demande
		PreparedStatement pc = conn.prepareStatement("delete from Demande where id_demande=?"); 
		pc.setInt(1, id);
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		
	}




}
