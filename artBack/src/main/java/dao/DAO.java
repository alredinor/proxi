package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T,K> {
	
	public T selectById(K id) ;
	public List<T> selectAll();
	public K insert(T object) ;
	public void update(T object);
	public void delete(K id) ;

}
