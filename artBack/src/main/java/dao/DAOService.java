package dao;

import java.util.List;

import model.Service;

public interface DAOService extends DAO<Service,Integer>

{
	public Service selectById(Integer id);
}
