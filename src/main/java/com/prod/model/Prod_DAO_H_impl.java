package com.prod.model;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.prod.service.Prod_CompositeQuery;
import com.util.HibernateUtil;

public class Prod_DAO_H_impl implements Prod_DAO_H {
	
	private static final String GET_ALL_STMT = "from Prod order by prod_no";

	@Override
	public void insert(Prod prod) {
		Session session = com.util.HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(prod);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void update(Prod prod) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(prod);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public void deleteById(Integer prod_no) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();

//        【此時多方(宜)可採用HQL刪除】
//			Query query = session.createQuery("delete EmpVO where empno=?0");
//			query.setParameter(0, empno);
//			System.out.println("刪除的筆數=" + query.executeUpdate());

//        【或此時多方(也)可採用去除關聯關係後，再刪除的方式】
			Prod prod = new Prod();
			prod.setProd_no(prod_no);
			session.delete(prod);

//        【此時多方不可(不宜)採用cascade聯級刪除】
//        【多方emp2.hbm.xml如果設為 cascade="all"或 cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除】
//			EmpVO empVO = (EmpVO) session.get(EmpVO.class, empno);
//			session.delete(empVO);

			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
	}

	@Override
	public Prod selectById(Integer prod_no) {
		Prod prod = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			prod = (Prod) session.get(Prod.class, prod_no);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return prod;
	}

	@Override
	public List<Prod> getAll() {
		List<Prod> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			Query<Prod> query = session.createQuery(GET_ALL_STMT, Prod.class);
			list = query.getResultList();
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
	
	@Override
	public List<Prod> getAll(Map<String, String[]> map) {
		List<Prod> list = null;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			list = Prod_CompositeQuery.getAllC(map);
			session.getTransaction().commit();
		} catch (RuntimeException ex) {
			session.getTransaction().rollback();
			throw ex;
		}
		return list;
	}
}