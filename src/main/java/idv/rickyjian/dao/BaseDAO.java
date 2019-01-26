package idv.rickyjian.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDAO<T> {
	
	public T getById(Serializable id);
	
	public List<T> searchAll();
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);

	
}
