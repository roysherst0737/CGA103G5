package com.manager.model;

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

public class Manager_JNDIDAO implements Manager_DAO_interface {

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
		"INSERT INTO manager (mng_account,mng_password,mng_name,mng_phone,mng_pic,mng_status) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_MANAGER_STMT = 
		"SELECT mng_no,mng_account,mng_password,mng_name,mng_phone,mng_pic,mng_status FROM manager order by mng_no";
	private static final String GET_ONE_STMT = 
		"SELECT mng_no,mng_account,mng_password,mng_name,mng_phone,mng_pic,mng_status FROM manager where mng_no = ?";
	private static final String DELETE = 
		"DELETE FROM manager where mng_no = ?";
	private static final String UPDATE = 
		"UPDATE manager set mng_account=?, mng_password=?, mng_name=?, mng_phone=?, mng_pic=?, mng_status=? where mng_no = ?";


	@Override
	public void insert(Manager_VO manager_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, manager_VO.getMng_account());
			pstmt.setString(2, manager_VO.getMng_password());
			pstmt.setString(3, manager_VO.getMng_name());
			pstmt.setString(4, manager_VO.getMng_phone());
			pstmt.setBytes(5, manager_VO.getMng_pic());
			pstmt.setInt(6, manager_VO.getMng_status());

			pstmt.executeUpdate();

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
	public void update(Manager_VO manager_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, manager_VO.getMng_account());
			pstmt.setString(2, manager_VO.getMng_password());
			pstmt.setString(3, manager_VO.getMng_name());
			pstmt.setString(4, manager_VO.getMng_phone());
			pstmt.setBytes(5, manager_VO.getMng_pic());
			pstmt.setInt(6, manager_VO.getMng_status());
			pstmt.setInt(7, manager_VO.getMng_no());

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(Integer mng_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mng_no);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public Manager_VO findByPrimaryKey(Integer mng_no) {

		Manager_VO manager_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mng_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_Vo 也稱為 Domain objects
				manager_VO = new Manager_VO();
				manager_VO.setMng_no(rs.getInt("mng_no"));
				manager_VO.setMng_account(rs.getString("mng_account"));
				manager_VO.setMng_password(rs.getString("mng_password"));
				manager_VO.setMng_name(rs.getString("mng_name"));
				manager_VO.setMng_phone(rs.getString("mng_phone"));
				manager_VO.setMng_pic(rs.getBytes("mng_pic"));
				manager_VO.setMng_status(rs.getInt("mng_status"));
			}

			// Handle any driver errors
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
		return manager_VO;
	}

	@Override
	public List<Manager_VO> getAllManager() {
		List<Manager_VO> list = new ArrayList<Manager_VO>();
		Manager_VO manager_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MANAGER_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_Vo 也稱為 Domain objects
				manager_VO = new Manager_VO();
				manager_VO.setMng_no(rs.getInt("mng_no"));
				manager_VO.setMng_account(rs.getString("mng_account"));
				manager_VO.setMng_password(rs.getString("mng_password"));
				manager_VO.setMng_name(rs.getString("mng_name"));
				manager_VO.setMng_phone(rs.getString("mng_phone"));
				manager_VO.setMng_pic(rs.getBytes("mng_pic"));
				manager_VO.setMng_status(rs.getInt("mng_status"));
				list.add(manager_VO); // Store the row in the list
			}

			// Handle any driver errors
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
	
	@Override
	public List<Manager_VO> getAllManager(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
}