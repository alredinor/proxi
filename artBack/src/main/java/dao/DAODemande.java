package dao;

//import java.util.List;

import model.Demande;

public interface DAODemande extends DAO<Demande,Integer> 
{
	public Demande selectById(Integer id);
}
