package dao;



import java.util.List;

import model.Metier;

public interface DAOMetier extends DAO<Metier,Integer>
{
	public List<Metier> selectById(String titre_metier);
	// version alban
}