package com.pub.service;

import java.util.List;

import org.hibernate.Session;

import static com.util.HibernateUtil.*;

public interface CoreDao<P, I> {
	
	default Session getSession() {
		return getSessionFactory().getCurrentSession();
//		return getSessionFactory().openSession();
	};
	default Session getOpenSession() {
//		return getSessionFactory().getCurrentSession();
		return getSessionFactory().openSession();
	};
	
	int insert(P pojo);

	int deleteById(I id);

	int update(P pojo);

	P selectById(I id);

	List<P> selectAll();
}
