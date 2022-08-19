package com.customer_chat_room.model;

import java.util.*;
import java.sql.*;

public class Customer_chat_room_JDBCDAO implements Customer_chat_room_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1005";

	private static final String INSERT_STMT = 
		"INSERT INTO customer_chat_room (mng_no,mem_no,prod_no,message,mem_question_pic,message_chat_time,chat_direction) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT SN,mng_no,mem_no,prod_no,message,mem_question_pic,message_chat_time,chat_direction FROM customer_chat_room order by SN";
	private static final String GET_ONE_STMT = 
		"SELECT SN,mng_no,mem_no,prod_no,message,mem_question_pic,message_chat_time,chat_direction FROM customer_chat_room where SN = ?";
	private static final String DELETE = 
		"DELETE FROM customer_chat_room where SN = ?";
	private static final String UPDATE = 
		"UPDATE customer_chat_room set mng_no=?, mem_no=?, prod_no=?, message=?, mem_question_pic=?, message_chat_time=?, chat_direction where SN = ?";

	@Override
	public void insert(Customer_chat_room_VO customer_chat_room_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, customer_chat_room_VO.getMng_no());
			pstmt.setInt(2, customer_chat_room_VO.getMem_no());
			pstmt.setInt(3, customer_chat_room_VO.getProd_no());
			pstmt.setString(4, customer_chat_room_VO.getMessage());
			pstmt.setString(5, customer_chat_room_VO.getMem_question_pic());
			pstmt.setDate(6, customer_chat_room_VO.getMessage_chat_time());
			pstmt.setInt(7, customer_chat_room_VO.getChat_direction());

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
	public void update(Customer_chat_room_VO customer_chat_room_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, customer_chat_room_VO.getMng_no());
			pstmt.setInt(2, customer_chat_room_VO.getMem_no());
			pstmt.setInt(3, customer_chat_room_VO.getProd_no());
			pstmt.setString(4, customer_chat_room_VO.getMessage());
			pstmt.setString(5, customer_chat_room_VO.getMem_question_pic());
			pstmt.setDate(6, customer_chat_room_VO.getMessage_chat_time());
			pstmt.setInt(7, customer_chat_room_VO.getChat_direction());
			pstmt.setInt(8, customer_chat_room_VO.getSN());

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
	public Customer_chat_room_VO findByPrimaryKey(Integer SN) {

		Customer_chat_room_VO customer_chat_room_VO = null;
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
				customer_chat_room_VO = new Customer_chat_room_VO();
				customer_chat_room_VO.setSN(rs.getInt("SN"));
				customer_chat_room_VO.setMng_no(rs.getInt("mng_no"));
				customer_chat_room_VO.setMem_no(rs.getInt("mem_no"));
				customer_chat_room_VO.setProd_no(rs.getInt("prod_no"));
				customer_chat_room_VO.setMessage(rs.getString("message"));
				customer_chat_room_VO.setMem_question_pic(rs.getBytes("mem_question_pic"));
				customer_chat_room_VO.setMessage_chat_time(rs.getDate("message_chat_time"));
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
		return customer_chat_room_VO;
	}

	@Override
	public List<Customer_chat_room_VO> getAll() {
		List<Customer_chat_room_VO> list = new ArrayList<Customer_chat_room_VO>();
		Customer_chat_room_VO customer_chat_room_VO = null;

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
				customer_chat_room_VO = new Customer_chat_room_VO();
				customer_chat_room_VO.setSN(rs.getInt("SN"));
				customer_chat_room_VO.setMng_no(rs.getInt("mng_no"));
				customer_chat_room_VO.setMem_no(rs.getInt("mem_no"));
				customer_chat_room_VO.setProd_no(rs.getInt("prod_no"));
				customer_chat_room_VO.setMessage(rs.getString("message"));
				customer_chat_room_VO.setMem_question_pic(rs.getBytes("mem_question_pic"));
				customer_chat_room_VO.setMessage_chat_time(rs.getDate("message_chat_time"));
				list.add(customer_chat_room_VO); // Store the row in the list
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

		Customer_chat_room_JDBCDAO dao = new Customer_chat_room_JDBCDAO();

		// 新增
		Customer_chat_room_VO customer_chat_room_VO1 = new Customer_chat_room_VO();
//		customer_chat_room_VO1.SN(2);
		customer_chat_room_VO1.setMng_no(1);
		customer_chat_room_VO1.setMem_no(1);
		customer_chat_room_VO1.setProd_no(1);
		customer_chat_room_VO1.setMessage("It's taste good!");
		customer_chat_room_VO1.setMem_question_pic(null);
		customer_chat_room_VO1.setMessage_chat_time(java.sql.Date.valueOf("now()"));
		dao.insert(customer_chat_room_VO1);

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
		List<Customer_chat_room_VO> list = dao.getAll();
		for (Customer_chat_room_VO aCustomer_chat_room_VO : list) {
			System.out.print(aCustomer_chat_room_VO.getSN() + ",");
			System.out.print(aCustomer_chat_room_VO.getMng_no() + ",");
			System.out.print(aCustomer_chat_room_VO.getMem_no() + ",");
			System.out.print(aCustomer_chat_room_VO.getProd_no() + ",");
			System.out.print(aCustomer_chat_room_VO.getMessage() + ",");
			System.out.print(aCustomer_chat_room_VO.getMem_question_pic() + ",");
			System.out.print(aCustomer_chat_room_VO.getMessage_chat_time() + ",");
			System.out.print(aCustomer_chat_room_VO.getChat_direction());
			System.out.println();
		}
	}
}
