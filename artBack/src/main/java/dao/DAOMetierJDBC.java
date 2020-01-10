package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Metier;

public class DAOMetierJDBC implements DAO<Metier,Integer> {
	
	/*ReadbyId => select id*/
	@Override
	public Metier selectById(Integer id) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_metier, titre_metier
		PreparedStatement pc = conn.prepareStatement("select * from Metier where id_metier=?,titre_metier=?"); 
		
		pc.setInt(1, id); 
		
		ResultSet rc =pc.executeQuery();
		
		Metier c=null;
		
		while(rc.next()) {
			
			 c = new Metier (id,rc.getString("titre_metier"));
			 
			 }
		
		conn.close();
		
		return c;
	}
	
	
	/*ReadAll*/
	@Override
	public List<Metier> selectAll() throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		PreparedStatement pc = conn.prepareStatement("select * from Metier where id_metier=?"); 
		
		
		ResultSet rc =pc.executeQuery(); 
		
		Metier c=null;
		
		List<Metier> listeSec = new ArrayList();
		
		//id_metier, titre_metier
		while(rc.next()) {
			
			c = new Metier (rc.getInt("id_metier"), rc.getString("titre_metier"));
			 listeSec.add(c);
			 
			 }
		
		conn.close();
		
		return listeSec;
	}
	
	
	@Override
	public Integer insert(Metier c) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root","");
		
		
		//id_metier, titre_metier
		PreparedStatement pc = conn.prepareStatement("insert into Metier (id_metier,titre_Metier) values(?,?)");
		
		pc.setInt(1, c.getId_metier());
		pc.setString(2, c.getTitre_metier());
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		return null;
		
	}
	
	@Override
	public void update(Metier c) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); //chargement du pilote jdbc
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); //creation de l'objet connection à la base de donnée
		
		//id_metier, titre_metier
		PreparedStatement pc = conn.prepareStatement("update Metier set titre_Metier=? where id_metier=?"); //creation du flux en evitant les injection
		
		pc.setString(1, c.getTitre_metier());
		pc.setInt(2, c.getId_metier());
		pc.executeUpdate();
		pc.close();
		conn.close();
		
	}


	@Override
	public void delete(Integer id) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/artinuaire","root",""); 
		
		//id_metier, titre_metier
		PreparedStatement pc = conn.prepareStatement("delete from Metier where id_metier=?"); 
		pc.setInt(1, id);
		
		pc.executeUpdate();
		pc.close();
		conn.close();
		
	}




}
