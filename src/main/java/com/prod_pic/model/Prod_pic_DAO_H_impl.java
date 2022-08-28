package com.prod_pic.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.prod_pic.service.Prod_pic_CompositeQuery;

public class Prod_pic_DAO_H_impl implements Prod_pic_DAO_H {

	@Override
	public int insert(Prod_pic pojo) {
		getSession().save(pojo);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		Prod_pic prod = new Prod_pic();
		prod.setProd_no(id);
		getSession().remove(prod);
		return 1;
	}

	@Override
	public int update(Prod_pic pojo) {
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
	public Prod_pic selectById(Integer id) {
		Prod_pic pojo = null;
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			pojo = (Prod_pic) session.get(Prod_pic.class, id);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return pojo;
	}

	@Override
	public List<Prod_pic> selectAll() {
		final String sql = "FROM prod_pic ORDER BY prod_pic_no";
		return getSession().createQuery(sql, Prod_pic.class).list();
	}
	
	public List<Prod_pic> getAll(Map<String, String[]> map) {
		List<Prod_pic> list = null;
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			list = Prod_pic_CompositeQuery.getAllC(map);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
}
