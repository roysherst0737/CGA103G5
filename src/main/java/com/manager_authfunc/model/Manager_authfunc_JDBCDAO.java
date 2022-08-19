package com.manager_authfunc.model;

import java.util.*;
import java.sql.*;

public class Manager_authfunc_JDBCDAO implements Manager_authfunc_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1005";

	private static final String INSERT_STMT = 
		"INSERT INTO manager_authfunc (mng_authfunc_no,mng_authfunc_name) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT mng_authfunc_name,mng_authfunc_no FROM manager_authfunc order by mng_authfunc_no";
	private static final String GET_ONE_STMT = 
		"SELECT mng_authfunc_no,mng_authfunc_name FROM manager_auth where mng_authfunc_no = ?";
	private static final String DELETE = 
		"DELETE FROM manager_authfunc where mng_authfunc_no = ?";
	private static final String UPDATE = 
		"UPDATE manager_authfunc set mng_authfunc_no=?, mng_authfunc_name=?";

	@Override
	public void insert(Manager_authfunc_VO manager_authfunc_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, manager_authfunc_VO.getMng_authfunc_no());
			pstmt.setString(2, manager_authfunc_VO.getMng_authfunc_name());

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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, manager_authfunc_VO.getMng_authfunc_no());
			pstmt.setString(2, manager_authfunc_VO.getMng_authfunc_name());

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
	public void delete(Integer mng_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mng_no);

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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mng_authfunc_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
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
	public List<Manager_authfunc_VO> getManager_authfuncAll() {
		List<Manager_authfunc_VO> list = new ArrayList<Manager_authfunc_VO>();
		Manager_authfunc_VO manager_authfunc_VO = null;

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

	public static void main(String[] args) {

		Manager_authfunc_JDBCDAO dao = new Manager_authfunc_JDBCDAO();

		// �s�W
		Manager_authfunc_VO manager_authfunc_VO1 = new Manager_authfunc_VO();
		manager_authfunc_VO1.setMng_authfunc_no(1);
		manager_authfunc_VO1.setMng_authfunc_name("����");
		dao.insert(manager_authfunc_VO1);

		// �ק�
//		Manager_VO manager_VO2 = new Manager_VO();
//		manager_VO2.setEmpno(7001);
//		manager_VO2.setEname("�d�ç�2");
//		manager_VO2.setJob("MANAGER2");
//		manager_VO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		manager_VO2.setSal(new Double(20000));
//		manager_VO2.setComm(new Double(200));
//		manager_VO2.setDeptno(20);
//		dao.update(manager_VO2);

		// �R��
//		dao.delete(7014);

		// �d��
//		Manager_VO manager_VO3 = dao.findByPrimaryKey(7001);
//		System.out.print(manager_VO3.getEmpno() + ",");
//		System.out.print(manager_VO3.getEname() + ",");
//		System.out.print(manager_VO3.getJob() + ",");
//		System.out.print(manager_VO3.getHiredate() + ",");
//		System.out.print(manager_VO3.getSal() + ",");
//		System.out.print(manager_VO3.getComm() + ",");
//		System.out.println(manager_VO3.getDeptno());
//		System.out.println("---------------------");

		// �d��
		List<Manager_authfunc_VO> list = dao.getManager_authfuncAll();
		for (Manager_authfunc_VO aManager_authfunc : list) {
			System.out.print(aManager_authfunc.getMng_authfunc_no() + ",");
			System.out.print(aManager_authfunc.getMng_authfunc_name());
			System.out.println();
		}
	}
}
