package com.manager.model;

import static com.util.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager_JDBCDAO implements Manager_DAO_interface {

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
		private static final String SELECT_FOR_LOGIN = "SELECT * FROM manager WHERE mng_account= ? and mng_password= ? ";

	@Override
	public void insert(Manager_VO manager_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, manager_VO.getMng_account());
			pstmt.setString(2, manager_VO.getMng_password());
			pstmt.setString(3, manager_VO.getMng_name());
			pstmt.setString(4, manager_VO.getMng_phone());
			pstmt.setBytes(5, manager_VO.getMng_pic());
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

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
				
				System.out.println(rs.getString("mng_pic"));
				
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
	public List<Manager_VO> getAllManager() {
		List<Manager_VO> list = new ArrayList<Manager_VO>();
		Manager_VO manager_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
	
	public boolean mngLogin(Manager_VO manager_VO) {
		boolean status = false;

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(SELECT_FOR_LOGIN);

			pstmt.setString(1, manager_VO.getMng_account());
			pstmt.setString(2, manager_VO.getMng_password());

//			pstmt.executeUpdate();

			System.out.println(pstmt);
			ResultSet rs = pstmt.executeQuery();
			status = rs.next();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
	}
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	
	@Override
	public List<Manager_VO> getAllManager(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}

//	public static void main(String[] args) {
//
//		Manager_JDBCDAO dao = new Manager_JDBCDAO();

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
//		Manager_VO manager_VO2 = new Manager_VO();
//		manager_VO2.setMng_no(4);
//		manager_VO2.setMng_account("manager4");
//		manager_VO2.setMng_password("4234");
//		manager_VO2.setMng_name("廣東五虎");
//		manager_VO2.setMng_phone("0950000005");
//		manager_VO2.setMng_pic("C:/Users/Tibame_T14/Desktop/BLOB/items/FC_Barcelona.png");
//		manager_VO2.setMng_status(0);
//		dao.update(manager_VO2);

		// 刪除
//		dao.delete(5);

		// 查詢
//		Manager_VO manager_VO3 = dao.findByPrimaryKey(1);
//		System.out.print(manager_VO3.getMng_no() + ",");
//		System.out.print(manager_VO3.getMng_account() + ",");
//		System.out.print(manager_VO3.getMng_password() + ",");
//		System.out.print(manager_VO3.getMng_phone() + ",");
//		System.out.print(manager_VO3.getMng_pic() + ",");
//		System.out.println(manager_VO3.getMng_status());
//		System.out.println("---------------------");

		// 查詢
//		List<Manager_VO> list = dao.getAllManager();
//		for (Manager_VO aManager : list) {
//			System.out.print(aManager.getMng_no() + ",");
//			System.out.print(aManager.getMng_account() + ",");
//			System.out.print(aManager.getMng_password() + ",");
//			System.out.print(aManager.getMng_name() + ",");
//			System.out.print(aManager.getMng_phone() + ",");
//			System.out.print(aManager.getMng_pic() + ",");
//			System.out.print(aManager.getMng_status());
//			System.out.println();
//		}
//	}
	
}
