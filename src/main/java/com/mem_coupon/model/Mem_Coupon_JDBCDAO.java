package com.mem_coupon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Mem_Coupon_JDBCDAO implements Mem_Coupon_DAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "208127";

	private static final String INSERT_STMT = 
			"INSERT INTO mem_coupon (coupon_no, mem_no, remain_amount) VALUES (?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT coupon_no, mem_no, remain_amount FROM mem_coupon order by mem_no, coupon_no";
		private static final String GET_ONE_STMT = 
			"SELECT coupon_no, mem_no, remain_amount FROM mem_coupon where mem_no = ? AND coupon_no = ?";
		private static final String DELETE = 
			"DELETE FROM mem_coupon where mem_no = ? AND coupon_no = ?";
		private static final String UPDATE = 
			"UPDATE mem_coupon set remain_amount? where mem_no = ? AND coupon_no = ?";

	@Override
	public void insert(Mem_Coupon_VO memCouponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, memCouponVO.getCoupon_no());
			pstmt.setInt(2, memCouponVO.getMem_no());
			pstmt.setInt(3, memCouponVO.getRemain_amount());


			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(Mem_Coupon_VO memCouponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, memCouponVO.getRemain_amount());
			pstmt.setInt(2, memCouponVO.getMem_no());
			pstmt.setInt(3, memCouponVO.getCoupon_no());


			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer coupon_no,Integer mem_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mem_no);
			pstmt.setInt(2, coupon_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public Mem_Coupon_VO findByPrimaryKey(Integer coupon_no,Integer mem_no) {

		Mem_Coupon_VO memCouponVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mem_no);    
			pstmt.setInt(2, coupon_no);  

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				memCouponVO = new Mem_Coupon_VO();
				memCouponVO.setCoupon_no(rs.getInt("coupon_no"));
				memCouponVO.setMem_no(rs.getInt("mem_no"));
				memCouponVO.setRemain_amount(rs.getInt("remain_amount"));

			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memCouponVO;
	}

	@Override
	public List<Mem_Coupon_VO> getAll() {
		List<Mem_Coupon_VO> list = new ArrayList<Mem_Coupon_VO>();
		Mem_Coupon_VO memCouponVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				memCouponVO = new Mem_Coupon_VO();
				memCouponVO.setCoupon_no(rs.getInt("coupon_no"));
				memCouponVO.setMem_no(rs.getInt("mem_no"));
				memCouponVO.setRemain_amount(rs.getInt("renaim_amount"));

				list.add(memCouponVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		Mem_Coupon_JDBCDAO dao = new Mem_Coupon_JDBCDAO();

//		// �s�W
//		Mem_Coupon_VO memCouponVO1 = new Mem_Coupon_VO();
//		memCouponVO1.setCoupon_no(1);
//		memCouponVO1.setMem_no(1);
//		memCouponVO1.setRemain_amount(2);
//
//		dao.insert(memCouponVO1);
//
//		// �ק�
//		Mem_Coupon_VO memCouponVO2 = new Mem_Coupon_VO();
//		memCouponVO2.setCoupon_no(1);
//		memCouponVO2.setMem_no(1);
//		memCouponVO2.setRemain_amount(2);
//		dao.update(memCouponVO2);
//
//		// �R��
//		dao.delete(1,1);
//
		// �d��
		Mem_Coupon_VO memCouponVO3 = dao.findByPrimaryKey(1,1);
		System.out.print(memCouponVO3.getCoupon_no() + ",");
		System.out.print(memCouponVO3.getMem_no() + ",");
		System.out.print(memCouponVO3.getRemain_amount() + ",");

		System.out.println("---------------------");

		// �d��
//		List<Mem_Coupon_VO> list = dao.getAll();
//		for (Mem_Coupon_VO aEmp : list) {
//			System.out.print(aEmp.getCoupon_no() + ",");
//			System.out.print(aEmp.getMem_no() + ",");
//			System.out.print(aEmp.getRemain_amount() + ",");
//
//			System.out.println();
//		}
	}
}