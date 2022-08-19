package com.customer_feedback.model;

import java.util.*;
import java.sql.*;

public class Customer_feedback_JDBCDAO implements Customer_feedback_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1005";

	private static final String INSERT_STMT = 
		"INSERT INTO customer_feedback (mem_no,order_no,prod_no,pub_no,act_no,mng_no,feedback_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT SN,mem_no,order_no,prod_no,pub_no,act_no,mng_no,feedback_status FROM customer_feedback order by SN";
	private static final String GET_ONE_STMT = 
		"SELECT SN,mem_no,order_no,prod_no,pub_no,act_no,mng_no,feedback_status FROM customer_feedback where SN = ?";
	private static final String DELETE = 
		"DELETE FROM customer_feedback where mng_no = ?";
	private static final String UPDATE = 
		"UPDATE customer_feedback set mem_no=?, order_no=?, prod_no=?, pub_no=?, act_no=?, mng_no=?, feedback_status=? where SN = ?";

	@Override
	public void insert(Customer_feedback_VO customer_feedback_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, customer_feedback_VO.getMem_no());
			pstmt.setInt(2, customer_feedback_VO.getOrder_no());
			pstmt.setInt(3, customer_feedback_VO.getProd_no());
			pstmt.setInt(4, customer_feedback_VO.getPub_no());
			pstmt.setInt(5, customer_feedback_VO.getAct_no());
			pstmt.setInt(6, customer_feedback_VO.getMng_no());
			pstmt.setInt(7, customer_feedback_VO.getFeedback_status());

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
	public void update(Customer_feedback_VO customer_feedback_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, customer_feedback_VO.getMem_no());
			pstmt.setInt(2, customer_feedback_VO.getOrder_no());
			pstmt.setInt(3, customer_feedback_VO.getProd_no());
			pstmt.setInt(4, customer_feedback_VO.getPub_no());
			pstmt.setInt(5, customer_feedback_VO.getAct_no());
			pstmt.setInt(6, customer_feedback_VO.getMng_no());
			pstmt.setInt(7, customer_feedback_VO.getFeedback_status());
			pstmt.setInt(8, customer_feedback_VO.getSN());

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
	public void delete(Integer SN) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, SN);

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
	public Customer_feedback_VO findByPrimaryKey(Integer SN) {

		Customer_feedback_VO customer_feedback_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, SN);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				customer_feedback_VO = new Customer_feedback_VO();
				customer_feedback_VO.setSN(rs.getInt("SN"));
				customer_feedback_VO.setMem_no(rs.getInt("mem_no"));
				customer_feedback_VO.setOrder_no(rs.getInt("order_no"));
				customer_feedback_VO.setProd_no(rs.getInt("prod_no"));
				customer_feedback_VO.setPub_no(rs.getInt("pub_no"));
				customer_feedback_VO.setAct_no(rs.getInt("act_no"));
				customer_feedback_VO.setMng_no(rs.getInt("mng_no"));
				customer_feedback_VO.setFeedback_status(rs.getInt("feedback_status"));
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
		return customer_feedback_VO;
	}

	@Override
	public List<Customer_feedback_VO> getAll() {
		List<Customer_feedback_VO> list = new ArrayList<Customer_feedback_VO>();
		Customer_feedback_VO customer_feedback_VO = null;

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
				customer_feedback_VO = new Customer_feedback_VO();
				customer_feedback_VO.setSN(rs.getInt("SN"));
				customer_feedback_VO.setMem_no(rs.getInt("mem_no"));
				customer_feedback_VO.setOrder_no(rs.getInt("order_no"));
				customer_feedback_VO.setProd_no(rs.getInt("prod_no"));
				customer_feedback_VO.setPub_no(rs.getInt("pub_no"));
				customer_feedback_VO.setAct_no(rs.getInt("act_no"));
				customer_feedback_VO.setMng_no(rs.getInt("mng_no"));
				customer_feedback_VO.setFeedback_status(rs.getInt("feedback_status"));
				list.add(customer_feedback_VO); // Store the row in the list
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

		Customer_feedback_JDBCDAO dao = new Customer_feedback_JDBCDAO();

		// 新增
		Customer_feedback_VO customer_feedback_VO1 = new Customer_feedback_VO();
//		customer_feedback_VO1.setSN(1);
		customer_feedback_VO1.setMem_no(1);
		customer_feedback_VO1.setOrder_no(1);
		customer_feedback_VO1.setProd_no(1);
		customer_feedback_VO1.setPub_no(1);
		customer_feedback_VO1.setAct_no(1);
		customer_feedback_VO1.setMng_no(1);
		customer_feedback_VO1.setFeedback_status(1);
		dao.insert(customer_feedback_VO1);

		// 修改
//		Manager_VO manager_VO2 = new Manager_VO();
//		manager_VO2.setEmpno(7001);
//		manager_VO2.setEname("吳永志2");
//		manager_VO2.setJob("MANAGER2");
//		manager_VO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		manager_VO2.setSal(new Double(20000));
//		manager_VO2.setComm(new Double(200));
//		manager_VO2.setDeptno(20);
//		dao.update(manager_VO2);

		// 刪除
//		dao.delete(7014);

		// 查詢
//		Manager_VO manager_VO3 = dao.findByPrimaryKey(7001);
//		System.out.print(manager_VO3.getEmpno() + ",");
//		System.out.print(manager_VO3.getEname() + ",");
//		System.out.print(manager_VO3.getJob() + ",");
//		System.out.print(manager_VO3.getHiredate() + ",");
//		System.out.print(manager_VO3.getSal() + ",");
//		System.out.print(manager_VO3.getComm() + ",");
//		System.out.println(manager_VO3.getDeptno());
//		System.out.println("---------------------");

		// 查詢
		List<Customer_feedback_VO> list = dao.getAll();
		for (Customer_feedback_VO aCustomer_feedback : list) {
			System.out.print(aCustomer_feedback.getSN() + ",");
			System.out.print(aCustomer_feedback.getMem_no() + ",");
			System.out.print(aCustomer_feedback.getOrder_no() + ",");
			System.out.print(aCustomer_feedback.getProd_no() + ",");
			System.out.print(aCustomer_feedback.getPub_no() + ",");
			System.out.print(aCustomer_feedback.getAct_no() + ",");
			System.out.print(aCustomer_feedback.getMng_no() + ",");
			System.out.print(aCustomer_feedback.getFeedback_status());
			System.out.println();
		}
	}
}
