package com.prod.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.util.CompositeQuery;

public class Prod_DAO_H_impl implements Prod_DAO_H {

	@Override
	public int insert(Prod pojo) {
		getSession().save(pojo);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		Prod prod = new Prod();
		prod.setProd_no(id);
		getSession().remove(prod);
		return 1;
	}

	@Override
	public int update(Prod pojo) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(pojo);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return 0;
	}

	@Override
	public Prod selectById(Integer id) {
		Prod pojo = null;
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			pojo = (Prod) session.get(Prod.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return pojo;
	}

	@Override
	public List<Prod> selectAll() {
		final String sql = "FROM prod ORDER BY prod_no";
		return getSession().createQuery(sql, Prod.class).list();
	}
	
	public List<Prod> getAll(Map<String, String[]> map) {
		List<Prod> list = null;
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			list = CompositeQuery.getAllC(map);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
}
