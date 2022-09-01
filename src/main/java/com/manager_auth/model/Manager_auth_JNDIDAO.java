package com.manager_auth.model;

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

public class Manager_auth_JNDIDAO implements Manager_auth_DAO_interface {

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
		"INSERT INTO manager_auth (mng_no,mng_authfunc_no) VALUES (?, ?)";
	private static final String GET_ALL_MANAGER_AUTH_STMT = 
		"SELECT * FROM manager_auth order by mng_no";
	private static final String GET_ALL_MANAGER_AUTHFUNC_STMT = 
		"SELECT * FROM manager_auth order by mng_authfunc_no";
	private static final String GET_ONE_STMT = 
		"SELECT * FROM manager_auth where mng_no = ? AND mng_authfunc_no = ?";
	private static final String DELETE = 
		"DELETE FROM manager_auth where mng_no = ? AND mng_authfunc_no = ?";
	private static final String UPDATE = 
			"UPDATE manager_auth set mng_authfunc_no = ? where mng_no = ?";


	@Override
	public void insert(Manager_auth_VO manager_auth_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, manager_auth_VO.getMng_no());
			pstmt.setInt(2, manager_auth_VO.getMng_authfunc_no());

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
	public void update(Manager_auth_VO manager_auth_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, manager_auth_VO.getMng_no());
			pstmt.setInt(2, manager_auth_VO.getMng_authfunc_no());

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
	public void delete(Integer mng_no, Integer mng_authfunc_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mng_no);
			pstmt.setInt(2, mng_authfunc_no);

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
	public Manager_auth_VO findByPrimaryKey(Integer mng_no,Integer mng_authfunc_no) {

		Manager_auth_VO manager_auth_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mng_no);
			pstmt.setInt(2, mng_authfunc_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_Vo 也稱為 Domain objects
				manager_auth_VO = new Manager_auth_VO();
				manager_auth_VO.setMng_no(rs.getInt("mng_no"));
				manager_auth_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
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
		return manager_auth_VO;
	}

	@Override
	public List<Manager_auth_VO> getAllManager_auth(Integer mng_no) {
		List<Manager_auth_VO> list = new ArrayList<Manager_auth_VO>();
		Manager_auth_VO manager_auth_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MANAGER_AUTH_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_Vo 也稱為 Domain objects
				manager_auth_VO = new Manager_auth_VO();
				manager_auth_VO.setMng_no(rs.getInt("mng_no"));
				manager_auth_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
				list.add(manager_auth_VO); // Store the row in the list
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
	public List<Manager_auth_VO> getAllManager_authfunc(Integer mng_authfunc_no) {
		List<Manager_auth_VO> list = new ArrayList<Manager_auth_VO>();
		Manager_auth_VO manager_auth_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_MANAGER_AUTHFUNC_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// manager_Vo 也稱為 Domain objects
				manager_auth_VO = new Manager_auth_VO();
				manager_auth_VO.setMng_no(rs.getInt("mng_no"));
				manager_auth_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
				list.add(manager_auth_VO); // Store the row in the list
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
	public List<Manager_auth_VO> getAllManager_auth(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
}