package idv.rickyjian.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import idv.rickyjian.dao.BaseDAO;

@NoRepositoryBean
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {
	
	protected Class<T> entityClass;
	
	@Resource(name = "sessionFactory")
	public void setSuperSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	
	public BaseDAOImpl() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T getById(Serializable id) {
		T t = (T) this.getHibernateTemplate().get(entityClass, id);
		return t;
	}

	@Override
	public List<T> searchAll() {
		return (List<T>) this.getHibernateTemplate().loadAll(entityClass);
	}
	
	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		this.getHibernateTemplate().flush();
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().merge(entity);
		this.getHibernateTemplate().flush();
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
		
	}

}
