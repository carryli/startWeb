package org.carryli.common.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.stat.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.carryli.common.util.ReflectUtil;


/**
 * 扩展HibernateDaoSupport的泛型基类
 * 使用HibernateDaoSupport的getSession方法来操作
 * 由于Dao最终必须要注入SessionFactory,这里可以获取Session,进行操作
 *
 * Dao中方法参数说明:
 * clazz 实体类
 * id 主键ID
 * entity 保存的实体对象
 * entityClass 参数T的反射类型
 */
@Repository
public class HibernateDao<T> extends HibernateDaoSupport{
	private Statistics stats;
	private int count;
	//在applicationContext_ssh.xml的beans加上default-autowire="byName" default-lazy-init="false"
	//或者采用下面的方法给共用Dao注入SessionFactory.否则会报错HibernateDao需要SessionFactory或HibernateTemplate
	@Autowired
	public void setSuperSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
		stats = sessionFactory.getStatistics();
		stats.setStatisticsEnabled(true);
	}
	
	/**
	 * @uml.property  name="entityClass"
	 */
	protected Class<T> entityClass;


	//在构造函数中利用反射机制获得参数T的具体类
	public HibernateDao() {
		entityClass = ReflectUtil.getClassGenricType(getClass());
	}

	//根据实体类与ID获得对象.
    public <X> X get(final Class<X> clazz, final Serializable id) {
		return (X)getSession().get(clazz, id);
	}

    //根据id获得对象
    public T get(Serializable id){
        return get(entityClass, id);
    }
    
    public <X> X load(final Class<X> clazz, final Serializable id) {
		return (X)getSession().load(clazz, id);
	}


    public T load(Serializable id){
        return load(entityClass, id);
    }

    //删除对象
	private boolean delete(final Object entity) throws RuntimeException{
		Session s = getSession();
		s.delete(entity);
		return true;
		
	}

	//根据ID删除对象
	public boolean delete(final Serializable id) {
		return delete(get(id));
	}

	//根据实体类与ID删除对象
	public boolean delete(final Class clazz, final Serializable id){
		return delete(get(clazz,id));
	}

    //保存对象 save update都调用saveOrUpdate
	public boolean saveOrUpdate(final Object entity)  throws RuntimeException {
		getSession().saveOrUpdate(entity);
		return true;
	}
	
	public boolean save(final Object entity) {
		return saveOrUpdate(entity);
	}
	
	public boolean update(final Object entity) {
		return saveOrUpdate(entity);
	}

	//获取所有数据
	public <X> List<X> getAll(final Class<X> entityClass) {
		return createCriteria(entityClass).list();
	}

	//获取所有数据
	public List<T> getAll() {
		return query();
	}

	/**
	 * 根据条件获取数据
	 * @param criterions 数量可变的Criterion
	 */
	public List<T> query(final Criterion... criterions) {
		return createCriteria(criterions).list();
	}

	/**
	 * HQL方式查询
	 * @param hql 符合HQL语法的查询语句
	 * @param values 数量可变的条件值,按顺序绑定
	 */
	public Query createQuery(final String hql, final Object... values){
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        int j = values.length;
        for(int i = 0; i < j; i++)
            query.setParameter(i, values[i]);
        return query;
    }

	/**
	 * SQL方式查询
	 * @param sql 符合SQL语法的查询语句
	 * @param values 数量可变的条件值,按顺序绑定
	 */
    public SQLQuery createSQLQuery(final String sql,final Object... values){
        SQLQuery query = getSession().createSQLQuery(sql);
        if (values != null) {
			for (int i = 0; i < values.length; i++) {
				query.setParameter(i, values[i]);
			}
		}
        return query;
    }

    /**
     * 根据类型创建查询对象
     * @param clazz 类型
     */
    public Criteria createCriteria(final Class clazz) {
		return createCriteria(clazz,new Criterion[]{});
	}

    /**
     * 对象化查询
     * @param entityClass 参数T的反射类型
     * @param criterions 数量可变的Criterion
     */
    public Criteria createCriteria(final Class clazz, final Criterion... criterions){
        Criteria criteria = getSession().createCriteria(clazz);
        for (Criterion c : criterions) {
			criteria.add(c);
		}
        // 开启Hibernate的缓存配置，查询时设置为缓存
        criteria.setCacheable(true);
        return criteria;
    }

    /**
     * 对象化查询
     * @param criterions 数量可变的Criterion
     */
    public Criteria createCriteria(final Criterion... criterions){
    	return createCriteria(entityClass, criterions);
    }

}