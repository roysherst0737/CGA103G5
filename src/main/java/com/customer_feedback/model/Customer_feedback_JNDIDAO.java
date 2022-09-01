package com.customer_feedback.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Customer_feedback_JNDIDAO implements Customer_feedback_DAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
			"INSERT INTO customer_feedback (mem_no,order_no,prod_no,pub_no,act_no,mng_no,feedback_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_CUSTOMER_FEEDBACK_STMT = 
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, customer_feedback_VO.getMem_no());
			pstmt.setInt(2, customer_feedback_VO.getOrder_no());
			pstmt.setInt(3, customer_feedback_VO.getProd_no());
			pstmt.setInt(4, customer_feedback_VO.getPub_no());
			pstmt.setInt(5, customer_feedback_VO.getAct_no());
			pstmt.setInt(6, customer_feedback_VO.getMng_no());
			pstmt.setInt(7, customer_feedback_VO.getFeedback_status());

			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

			con = ds.getConnection();
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
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, SN);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, SN);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_authfunc_Vo 也稱為 Domain objects
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
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public List<Customer_feedback_VO> getAllCustomer_feedback() {
		List<Customer_feedback_VO> list = new ArrayList<Customer_feedback_VO>();
		Customer_feedback_VO customer_feedback_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_CUSTOMER_FEEDBACK_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_authfunc_Vo 也稱為 Domain objects
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
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	
	@Override
	public List<Customer_feedback_VO> getAllCustomer_feedback(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
}