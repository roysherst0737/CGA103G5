package com.pub.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pub.dao.Pub_DAO_H;
import com.pub.entity.Pub;
import com.util.HibernateUtil;

public class Pub_DAO_H_impl implements Pub_DAO_H  {
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可


	public Integer insert1(Pub pub) {
			SessionFactory sessionFactory =HibernateUtil.getSessionFactory();
			Session session=sessionFactory.openSession();
			try {
				Transaction transaction=session.beginTransaction();
				session.persist(pub);
				transaction.commit();
				return pub.getPub_no();
			} catch (Exception e) {
				e.printStackTrace();
				session.getTransaction().rollback();
				return null;
			}


	}

	public List<Pub> getAll() {
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			Transaction transaction = session.beginTransaction();
			Query<Pub> query = session.createQuery("FROM pub",Pub.class);
//			Query<Pub> query = session.createQuery("SELECT new we.member.pojo.Member(username,password) FROM Member",Pub.class);
			List<Pub> list = query.list();
			transaction.commit();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		return null;
		}
		
	}

@Override
public int insert(Pub pojo) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int deleteById(Integer id) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int update(Pub pojo) {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public Pub selectById(Integer id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Pub> selectAll() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Pub> getMemAll(Integer mem_no) {
	// TODO Auto-generated method stub
	return null;
}

//	@Override
//	public void updateRate(Integer pub_no, Integer pub_rate_sum, Integer pub_ratetotal) {
//		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE_RATE);) {
//			pstmt.setInt(1, pub_rate_sum);
//			pstmt.setInt(2, pub_ratetotal);
//			pstmt.setInt(3, pub_no);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			throw new RuntimeException("A database error occured. " + e.getMessage());
//		}
//
//	}
//	
//	@Override
//	public void updateOpen(Integer pub_no, Integer pub_open) {
//		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE_OPEN);) {
//			pstmt.setInt(1, pub_open);
//			pstmt.setInt(2, pub_no);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			throw new RuntimeException("A database error occured. " + e.getMessage());
//		}
//
//	}
//
//	@Override
//	public void updateApplication(Integer pub_no, Integer pub_application) {
//		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE_APPLICATION);) {
//			pstmt.setInt(1, pub_application);
//			pstmt.setInt(2, pub_no);
//			pstmt.executeUpdate();
//		} catch (SQLException e) {
//			throw new RuntimeException("A database error occured. " + e.getMessage());
//		}
//
//	}

}
