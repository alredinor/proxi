package dao;

public class FactoryMetier {
	
	static DAOMetierJDBC dao=new DAOMetierJDBC();
	
	public static DAOMetierJDBC getDAOMetier() 
	{
		return dao;
	}

}
