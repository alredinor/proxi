package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T,K> {
	
	public T selectById(K id) throws SQLException, ClassNotFoundException;
	public List<T> selectAll() throws SQLException, ClassNotFoundException;
	public K insert(T object) throws SQLException, ClassNotFoundException;
	public void update(T object) throws SQLException, ClassNotFoundException;
	public void delete(K id) throws SQLException, ClassNotFoundException;

}
