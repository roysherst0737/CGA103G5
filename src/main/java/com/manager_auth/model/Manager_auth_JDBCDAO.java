package com.manager_auth.model;

import java.util.*;
import java.sql.*;

public class Manager_auth_JDBCDAO implements Manager_auth_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1005";

	private static final String INSERT_STMT = 
		"INSERT INTO manager_auth (mng_no,mng_authfunc_no) VALUES (?, ?)";
	private static final String GET_ALL_MANAGER_STMT = 
		"SELECT * FROM manager order by mng_no";
	private static final String GET_ALL_MANAGER_AUTHFUNC_STMT = 
		"SELECT * FROM manager_authfunc order by mng_authfunc_no";
	private static final String GET_ONE_STMT = 
		"SELECT * FROM manager_auth where mng_no = ? AND mng_authfunc_no = ?";
	private static final String DELETE = 
		"DELETE FROM manager_auth where mng_no = ? AND mng_authfunc_no = ?";
	private static final String UPDATE = 
		"UPDATE manager_auth set mng_account=?, mng_password=?, mng_name=?, mng_phone=?, mng_pic=?, mng_status=?, mng_authfunc_name WHERE mng_no AND mng_authfunc_no";

	@Override
	public void insert(Manager_auth_VO manager_auth_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, manager_auth_VO.getMng_no());
			pstmt.setInt(2, manager_auth_VO.getMng_authfunc_no());

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
	public void update(Manager_auth_VO manager_auth_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, manager_auth_VO.getMng_no());
			pstmt.setInt(2, manager_auth_VO.getMng_authfunc_no());

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
	public void delete(Manager_auth_VO manager_auth_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, manager_auth_VO.getMng_no());
			pstmt.setInt(2, manager_auth_VO.getMng_authfunc_no());

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
	public Manager_auth_VO findByPrimaryKey(Integer mng_no,Integer mng_authfunc_no) {

		Manager_auth_VO manager_auth_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mng_no);
			pstmt.setInt(2, mng_authfunc_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				manager_auth_VO = new Manager_auth_VO();
				manager_auth_VO.setMng_no(rs.getInt("mng_no"));
				manager_auth_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
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
		return manager_auth_VO;
	}

	@Override
	public List<Manager_auth_VO> getManagerAll(Integer mem_no) {
		List<Manager_auth_VO> list = new ArrayList<Manager_auth_VO>();
		Manager_auth_VO manager_auth_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_MANAGER_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				manager_auth_VO = new Manager_auth_VO();
				manager_auth_VO.setMng_no(rs.getInt("mng_no"));
				manager_auth_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
				list.add(manager_auth_VO); // Store the row in the list
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
		
		@Override
		public List<Manager_auth_VO> getManager_authfuncAll(Integer mng_authfunc_no) {
			List<Manager_auth_VO> list = new ArrayList<Manager_auth_VO>();
			Manager_auth_VO manager_auth_VO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				Class.forName(driver);
				con = DriverManager.getConnection(url, userid, passwd);
				pstmt = con.prepareStatement(GET_ALL_MANAGER_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// empVO �]�٬� Domain objects
					manager_auth_VO = new Manager_auth_VO();
					manager_auth_VO.setMng_no(rs.getInt("mng_no"));
					manager_auth_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
					list.add(manager_auth_VO); // Store the row in the list
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

		Manager_auth_JDBCDAO dao = new Manager_auth_JDBCDAO();

		// 新增
		Manager_auth_VO manager_auth_VO1 = new Manager_auth_VO();
		manager_auth_VO1.setMng_no(3);
		manager_auth_VO1.setMng_authfunc_no(2);
		dao.insert(manager_auth_VO1);

		// 修改
//		Manager_auth_VO Manager_auth_VO2 = new Manager_auth_VO();
//		Manager_auth_VO2.setMng_no(1);
//		Manager_auth_VO2.setMng_authfunc_no(1);
//		dao.update(Manager_auth_VO2);

		// 刪除
//		dao.delete(1);

		// 查詢
		Manager_auth_VO manager_auth_VO3 = dao.findByPrimaryKey(1,2);
		System.out.print(manager_auth_VO3.getMng_no() + ",");
		System.out.println(manager_auth_VO3.getMng_authfunc_no());
		System.out.println("---------------------");

		// 查詢
//		List<Manager_auth_VO> list1 = dao.getManagerAll(1);
//		for (Manager_auth_VO aManager_auth : list1) {
//			System.out.print(aManager_auth.getMng_no() + ",");
//			System.out.print(aManager_auth.getMng_authfunc_no());
//			System.out.println();
//		}
		
//		List<Manager_auth_VO> list2 = dao.getManager_authfuncAll(1);
//		for (Manager_auth_VO aManager_auth : list2) {
//			System.out.print(aManager_auth.getMng_no() + ",");
//			System.out.print(aManager_auth.getMng_authfunc_no());
//			System.out.println();
//		}
		
		
	}
}
