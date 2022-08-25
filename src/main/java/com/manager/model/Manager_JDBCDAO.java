package com.manager.model;

import java.util.*;

import java.sql.*;

public class Manager_JDBCDAO implements Manager_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "1005";

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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, manager_VO.getMng_account());
			pstmt.setString(2, manager_VO.getMng_password());
			pstmt.setString(3, manager_VO.getMng_name());
			pstmt.setString(4, manager_VO.getMng_phone());
			pstmt.setString(5, manager_VO.getMng_pic());
			pstmt.setInt(6, manager_VO.getMng_status());

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
	public void update(Manager_VO manager_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, manager_VO.getMng_account());
			pstmt.setString(2, manager_VO.getMng_password());
			pstmt.setString(3, manager_VO.getMng_name());
			pstmt.setString(4, manager_VO.getMng_phone());
			byte[] Img64Decode = Base64.getDecoder().decode(manager_VO.getMng_pic());
			pstmt.setBytes(5, Img64Decode);
			pstmt.setInt(6, manager_VO.getMng_status());
			pstmt.setInt(7, manager_VO.getMng_no());

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
	public Manager_VO findByPrimaryKey(Integer mng_no) {

		Manager_VO manager_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		return manager_VO;
	}

	@Override
	public List<Manager_VO> getManagerAll() {
		List<Manager_VO> list = new ArrayList<Manager_VO>();
		Manager_VO manager_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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

		Manager_JDBCDAO dao = new Manager_JDBCDAO();

//		// 新增
//		Manager_VO manager_VO1 = new Manager_VO();
//		manager_VO1.setMng_account("manager4");
//		manager_VO1.setMng_password("4234");
//		manager_VO1.setMng_name("鐵拳無敵孫中山");
//		manager_VO1.setMng_phone("0940000004");
//		manager_VO1.setMng_pic(null);
//		manager_VO1.setMng_status(1);
//		dao.insert(manager_VO1);

		// 修改
		Manager_VO manager_VO2 = new Manager_VO();
		manager_VO2.setMng_no(4);
		manager_VO2.setMng_account("manager4");
		manager_VO2.setMng_password("4234");
		manager_VO2.setMng_name("廣東五虎");
		manager_VO2.setMng_phone("0950000005");
		manager_VO2.setMng_pic(null);
		manager_VO2.setMng_status(0);
		dao.update(manager_VO2);

		// 刪除
//		dao.delete(5);

		// 查詢
		Manager_VO manager_VO3 = dao.findByPrimaryKey(1);
		System.out.print(manager_VO3.getMng_no() + ",");
		System.out.print(manager_VO3.getMng_account() + ",");
		System.out.print(manager_VO3.getMng_password() + ",");
		System.out.print(manager_VO3.getMng_phone() + ",");
		System.out.print(manager_VO3.getMng_pic() + ",");
		System.out.println(manager_VO3.getMng_status());
		System.out.println("---------------------");

		// 查詢
		List<Manager_VO> list = dao.getManagerAll();
		for (Manager_VO aManager : list) {
			System.out.print(aManager.getMng_no() + ",");
			System.out.print(aManager.getMng_account() + ",");
			System.out.print(aManager.getMng_password() + ",");
			System.out.print(aManager.getMng_name() + ",");
			System.out.print(aManager.getMng_phone() + ",");
			System.out.print(aManager.getMng_pic() + ",");
			System.out.print(aManager.getMng_status());
			System.out.println();
		}
	}
}
