package com.pub.model;

import java.util.List;

public class Pub_DAO_H_impl_forWEB implements Pub_DAO_H  {

@Override
public int insert(Pub pojo) {
	getSession().save(pojo);
	return 1;
}

@Override
public int deleteById(Integer id) {
	Pub pub = new Pub();
	pub.setPub_no(id);
	getSession().remove(pub);
	return 1;
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
	final String sql = "FROM Pub ORDER BY id";
	return getSession().createQuery(sql, Pub.class).list();
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
