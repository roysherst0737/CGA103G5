package com.pub.dao;

import java.util.List;

import org.hibernate.Session;

import com.pub.entity.Pub;

public class Pub_DAO_impl implements Pub_DAO  {

@Override
public int insert(Pub pojo) {
	getSession().save(pojo);
	return 1;
}


@Override
public int update(Pub pojo) {
	getSession().update(pojo);
	return 1;
}

@Override
public Pub selectById(Integer id) {
	 return getSession().get(Pub.class, id);
}

@Override
public List<Pub> selectAll() {
	final String sql = "FROM Pub ORDER BY pub_no";
	return getSession().createQuery(sql, Pub.class).list();
}
@Override
public List<Pub> getMemAll(Integer mem_no) {
	final String sql = "FROM Pub WHERE mem_no= : mem_no ORDER BY pub_no";
	return getSession().createQuery(sql, Pub.class).setParameter("mem_no", mem_no).list();
}

@Override
public List<Pub> getAllbyOpen() {
	final String sql = "FROM Pub ORDER BY pub_no";
	Session session = getOpenSession();
	List<Pub> list=session.createQuery(sql, Pub.class).list();
	session.close();
	return list;
}
@Override
public int deleteById(Integer id) {
	return 1;
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
