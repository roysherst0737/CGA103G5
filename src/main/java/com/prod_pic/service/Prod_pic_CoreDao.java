package com.prod_pic.service;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import static com.util.HibernateUtil.*;

public interface Prod_pic_CoreDao<P, I> {
	
	default Session getSession() {
		return getSessionFactory().getCurrentSession();
	};
	
	int insert(P pojo);

	int deleteById(I id);

	int update(P pojo);

	P selectById(I id);

	List<P> selectAll();
	
	List<P> getAll(Map<String, String[]> map); 
}
