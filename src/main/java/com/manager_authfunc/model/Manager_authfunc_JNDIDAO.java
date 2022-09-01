package com.manager_authfunc.model;

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

import com.manager.model.Manager_VO;

public class Manager_authfunc_JNDIDAO implements Manager_authfunc_DAO_interface {

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
		"INSERT INTO manager_authfunc_authfunc (mng_authfunc_no,mng_authfunc_name) VALUES (?, ?)";
	private static final String GET_ALL_MANAGER_AUTHFUNC_STMT = 
		"SELECT mng_authfunc_no,mng_authfunc_name FROM manager_authfunc_authfunc order by mng_authfunc_no";
	private static final String GET_ONE_STMT = 
		"SELECT mng_authfunc_no,mng_authfunc_name FROM manager_authfunc_authfunc where mng_authfunc_no = ?";
	private static final String DELETE = 
		"DELETE FROM manager_authfunc_authfunc where mng_authfunc_no = ?";
	private static final String UPDATE = 
		"UPDATE manager_authfunc_authfunc set mng_authfunc_name=? where mng_authfunc_no=?";


	@Override
	public void insert(Manager_authfunc_VO manager_authfunc_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, manager_authfunc_VO.getMng_authfunc_no());
			pstmt.setString(2, manager_authfunc_VO.getMng_authfunc_name());

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
	public void update(Manager_authfunc_VO manager_authfunc_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, manager_authfunc_VO.getMng_authfunc_name());
			pstmt.setInt(2, manager_authfunc_VO.getMng_authfunc_no());

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
	public void delete(Integer mng_authfunc_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mng_authfunc_no);

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
	public Manager_authfunc_VO findByPrimaryKey(Integer mng_authfunc_no) {

		Manager_authfunc_VO manager_authfunc_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mng_authfunc_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_authfunc_Vo 也稱為 Domain objects
				manager_authfunc_VO = new Manager_authfunc_VO();
				manager_authfunc_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
				manager_authfunc_VO.setMng_authfunc_name(rs.getString("mng_authfunc_name"));
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
		return manager_authfunc_VO;
	}

	@Override
	public List<Manager_authfunc_VO> getAllManager_authfunc() {
		List<Manager_authfunc_VO> list = new ArrayList<Manager_authfunc_VO>();
		Manager_authfunc_VO manager_authfunc_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MANAGER_AUTHFUNC_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_authfunc_Vo 也稱為 Domain objects
				manager_authfunc_VO = new Manager_authfunc_VO();
				manager_authfunc_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
				manager_authfunc_VO.setMng_authfunc_name(rs.getString("mng_authfunc_name"));
				list.add(manager_authfunc_VO); // Store the row in the list
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
	public List<Manager_authfunc_VO> getAllManager_authfunc(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
}