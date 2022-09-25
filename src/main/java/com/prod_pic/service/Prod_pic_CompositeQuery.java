package com.prod_pic.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.prod_pic.model.Prod_pic;
import com.util.HibernateUtil;

public class Prod_pic_CompositeQuery {
	
	@SuppressWarnings("removal")
	public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<Prod_pic> root, String columnName, String value) {

		Predicate predicate = null;

		if ("prod_pic_no".equals(columnName)) // 用於Integer
			predicate = builder.equal(root.get(columnName), new Integer(value));
		else if ("prod_pic_name".equals(columnName)) // 用於varchar
			predicate = builder.like(root.get(columnName), "%" + value + "%");
		
		return predicate;
	}

	@SuppressWarnings("unchecked")
	public static List<Prod_pic> getAllC(Map<String, String[]> map) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Prod_pic> list = null;
		try {
			// 【●創建 CriteriaBuilder】
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// 【●創建 CriteriaQuery】
			CriteriaQuery<Prod_pic> criteriaQuery = builder.createQuery(Prod_pic.class);
			// 【●創建 Root】
			Root<Prod_pic> root = criteriaQuery.from(Prod_pic.class);

			List<Predicate> predicateList = new ArrayList<Predicate>();
			
			Set<String> keys = map.keySet();
			int count = 0;
			for (String key : keys) {
				String value = map.get(key)[0];
				if (value != null && value.trim().length() != 0 && !"action".equals(key)) {
					count++;
					predicateList.add(get_aPredicate_For_AnyDB(builder, root, key, value));
					System.out.println("有送出查詢資料的欄位數count = " + count);
				}
			}
			System.out.println("predicateList.size()="+predicateList.size());
			criteriaQuery.where(predicateList.toArray(new Predicate[predicateList.size()]));
			criteriaQuery.orderBy(builder.asc(root.get("prod_no")));
			// 【●最後完成創建 javax.persistence.Query●】
			Query query = session.createQuery(criteriaQuery); //javax.persistence.Query; //Hibernate 5 開始 取代原 org.hibernate.Query 介面
			list = query.getResultList();

			tx.commit();
		} catch (RuntimeException ex) {
			if (tx != null)
				tx.rollback();
			throw ex; // System.out.println(ex.getMessage());
		} finally {
			session.close();
			// HibernateUtil.getSessionFactory().close();
		}		
		return list;
	}
}
