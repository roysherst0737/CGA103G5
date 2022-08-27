package com.util;

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

import com.prod.model.Prod;

public class CompositeQuery {
	
	@SuppressWarnings("removal")
	public static Predicate get_aPredicate_For_AnyDB(CriteriaBuilder builder, Root<Prod> root, String columnName, String value) {

		Predicate predicate = null;

		if ("prod_no".equals(columnName)) // 用於Integer
			predicate = builder.equal(root.get(columnName), new Integer(value));
		else if ("prod_type".equals(columnName)||"prod_name".equals(columnName)) // 用於varchar
			predicate = builder.like(root.get(columnName), "%" + value + "%");
		else if ("launch_time".equals(columnName) || "off_time".equals(columnName)) // 用於date
			predicate = builder.equal(root.get(columnName), java.sql.Date.valueOf(value));

		return predicate;
	}

	@SuppressWarnings("unchecked")
	public static List<Prod> getAllC(Map<String, String[]> map) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<Prod> list = null;
		try {
			// 【●創建 CriteriaBuilder】
			CriteriaBuilder builder = session.getCriteriaBuilder();
			// 【●創建 CriteriaQuery】
			CriteriaQuery<Prod> criteriaQuery = builder.createQuery(Prod.class);
			// 【●創建 Root】
			Root<Prod> root = criteriaQuery.from(Prod.class);

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
