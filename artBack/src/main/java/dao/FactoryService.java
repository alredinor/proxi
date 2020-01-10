package dao;

public class FactoryService {
	
	static DAOService dao=new DAOServiceJDBC();
	
	public static DAOService getDAOService() 
	{
		return dao;
	}

}
