package com.manager_authfunc.model;

import static com.util.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager_authfunc_JDBCDAO implements Manager_authfunc_DAO_interface {

	private static final String INSERT_STMT = 
		"INSERT INTO manager_authfunc (mng_authfunc_name) VALUES (?)";
	private static final String GET_ALL_MANAGER_AUTHFUNC_STMT = 
		"SELECT mng_authfunc_no, mng_authfunc_name FROM manager_authfunc order by mng_authfunc_no";
	private static final String GET_ONE_STMT = 
		"SELECT mng_authfunc_no, mng_authfunc_name FROM manager_authfunc where mng_authfunc_no = ?";
	private static final String DELETE = 
		"DELETE FROM manager_authfunc where mng_authfunc_no = ?";
	private static final String UPDATE = 
		"UPDATE manager_authfunc set mng_authfunc_name = ? where mng_authfunc_no = ?";

	@Override
	public void insert(Manager_authfunc_VO manager_authfunc_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, manager_authfunc_VO.getMng_authfunc_name());
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
	public void update(Manager_authfunc_VO manager_authfunc_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, manager_authfunc_VO.getMng_authfunc_name());
			pstmt.setInt(2, manager_authfunc_VO.getMng_authfunc_no());

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
	public void delete(Integer mng_authfunc_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mng_authfunc_no);

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
	public Manager_authfunc_VO findByPrimaryKey(Integer mng_authfunc_no) {

		Manager_authfunc_VO manager_authfunc_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

//	public static void main(String[] args) {
//
//		Manager_authfunc_JDBCDAO dao = new Manager_authfunc_JDBCDAO();

		// 新增
//		Manager_authfunc_VO manager_authfunc_VO1 = new Manager_authfunc_VO();
//		manager_authfunc_VO1.setMng_authfunc_no(5);
//		manager_authfunc_VO1.setMng_authfunc_name("活動網站管理");
//		dao.insert(manager_authfunc_VO1);

		// 修改
//		Manager_authfunc_VO manager_authfunc_VO2 = new Manager_authfunc_VO();
//		manager_authfunc_VO2.setMng_authfunc_no(4);
//		manager_authfunc_VO2.setMng_authfunc_name("後台網站管理");
//		dao.update(manager_authfunc_VO2);

		// 刪除
//		dao.delete(5);

		// 查詢
//		Manager_authfunc_VO manager_authfunc_VO3 = dao.findByPrimaryKey(4);
//		System.out.print(manager_authfunc_VO3.getMng_authfunc_no() + ",");
//		System.out.println(manager_authfunc_VO3.getMng_authfunc_name());
//		System.out.println("---------------------");

		// 查詢
//		List<Manager_authfunc_VO> list = dao.getManager_authfuncAll();
//		for (Manager_authfunc_VO aManager_authfunc : list) {
//			System.out.print(aManager_authfunc.getMng_authfunc_no() + ",");
//			System.out.print(aManager_authfunc.getMng_authfunc_name());
//			System.out.println();
//		}
//	}
	
	@Override
	public List<Manager_authfunc_VO> getAllManager_authfunc(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
}
