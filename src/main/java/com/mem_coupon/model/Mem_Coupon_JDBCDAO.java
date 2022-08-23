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
			"UPDATE mem_coupon remain_amount? where mem_no = ? AND coupon_no = ?";

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
			pstmt.setInt(3, memCouponVO.getRenaim_amount());


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

			pstmt.setInt(1, memCouponVO.getRenaim_amount());
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
				// empVo 也稱為 Domain objects
				memCouponVO = new Mem_Coupon_VO();
				memCouponVO.setCoupon_no(rs.getInt("coupon_no"));
				memCouponVO.setMem_no(rs.getInt("mem_no"));
				memCouponVO.setRenaim_amount(rs.getInt("renaim_amount"));

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
				// empVO 也稱為 Domain objects
				memCouponVO = new Mem_Coupon_VO();
				memCouponVO.setCoupon_no(rs.getInt("coupon_no"));
				memCouponVO.setMem_no(rs.getInt("mem_no"));
				memCouponVO.setRenaim_amount(rs.getInt("renaim_amount"));

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

		// 新增
		EmpVO empVO1 = new EmpVO();
		empVO1.setEname("吳永志1");
		empVO1.setJob("MANAGER");
		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
		empVO1.setSal(new Double(50000));
		empVO1.setComm(new Double(500));
		empVO1.setDeptno(10);
		dao.insert(empVO1);

		// 修改
		EmpVO empVO2 = new EmpVO();
		empVO2.setEmpno(7001);
		empVO2.setEname("吳永志2");
		empVO2.setJob("MANAGER2");
		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
		empVO2.setSal(new Double(20000));
		empVO2.setComm(new Double(200));
		empVO2.setDeptno(20);
		dao.update(empVO2);

		// 刪除
		dao.delete(7014);

		// 查詢
		EmpVO empVO3 = dao.findByPrimaryKey(7001);
		System.out.print(empVO3.getEmpno() + ",");
		System.out.print(empVO3.getEname() + ",");
		System.out.print(empVO3.getJob() + ",");
		System.out.print(empVO3.getHiredate() + ",");
		System.out.print(empVO3.getSal() + ",");
		System.out.print(empVO3.getComm() + ",");
		System.out.println(empVO3.getDeptno());
		System.out.println("---------------------");

		// 查詢
		List<EmpVO> list = dao.getAll();
		for (EmpVO aEmp : list) {
			System.out.print(aEmp.getEmpno() + ",");
			System.out.print(aEmp.getEname() + ",");
			System.out.print(aEmp.getJob() + ",");
			System.out.print(aEmp.getHiredate() + ",");
			System.out.print(aEmp.getSal() + ",");
			System.out.print(aEmp.getComm() + ",");
			System.out.print(aEmp.getDeptno());
			System.out.println();
		}
	}
}