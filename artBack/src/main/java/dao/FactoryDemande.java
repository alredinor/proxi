package dao;

public class FactoryDemande {
	
	static DAODemande dao=new DAODemandeJDBC();
	
	public static DAODemande getDAODemande() 
	{
		return dao;
	} 

}
