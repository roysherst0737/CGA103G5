package com.forum.model;

import java.util.*;
import java.sql.*;

import static com.util.Common.*;

public class Forum_JDBC_DAO implements Forum_DAO_interface {
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/lonelybar?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
//	String userid = "cga10305";
//	String passwd = "123qweqwe";

	private static final String INSERT_STMT = 
		"INSERT INTO forum (frm_name_no,frm_status) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT frm_no,frm_name_no,frm_status FROM forum order by frm_no";
	private static final String GET_ONE_STMT = 
		"SELECT frm_no,frm_name_no,frm_status FROM forum where frm_no = ?";
	private static final String DELETE = 
		"DELETE FROM forum where frm_no = ?";
	private static final String UPDATE = 
		"UPDATE forum set frm_name_no = ?,frm_status = ? where frm_no = ?";
	@Override
	public void insert(Forum_VO forum_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, forum_VO.getFrm_name_no());
			pstmt.setInt(2, forum_VO.getFrm_status());

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
	public void update(Forum_VO forum_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setString(1, forum_VO.getFrm_name_no());
			pstmt.setInt(2, forum_VO.getFrm_status());
			pstmt.setInt(3, forum_VO.getFrm_no());//刪

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
	public void delete(Integer frm_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, frm_no);

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
	public Forum_VO findByPrimaryKey(Integer frm_no) {

		Forum_VO forum_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, frm_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				forum_VO = new Forum_VO();
				forum_VO.setFrm_no(rs.getInt("frm_no"));
				forum_VO.setFrm_name_no(rs.getString("frm_name_no"));
				forum_VO.setFrm_status(rs.getInt("frm_status"));
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
		return forum_VO;
	}

	@Override
	public List<Forum_VO> getAll() {
		List<Forum_VO> list = new ArrayList<Forum_VO>();
		Forum_VO forum_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				forum_VO = new Forum_VO();
				forum_VO.setFrm_no(rs.getInt("frm_no"));
				forum_VO.setFrm_name_no(rs.getString("frm_name_no"));
				forum_VO.setFrm_status(rs.getInt("frm_status"));
				list.add(forum_VO); // Store the row in the list
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

		Forum_JDBC_DAO dao = new Forum_JDBC_DAO();

		// 新增
		Forum_VO forum_VO1 = new Forum_VO();
		forum_VO1.setFrm_name_no("活動討論區");
		forum_VO1.setFrm_status(1);
		
		dao.insert(forum_VO1);

		// 修改
		Forum_VO forum_VO2 = new Forum_VO();
		forum_VO2.setFrm_no(2);
		forum_VO2.setFrm_name_no("揪團討論區");
		forum_VO2.setFrm_status(0);
		dao.update(forum_VO2);

		// 刪除
		dao.delete(10);

		// 查詢
		Forum_VO forum_VO3 = dao.findByPrimaryKey(1);
		System.out.print(forum_VO3.getFrm_no() + ",");
		System.out.print(forum_VO3.getFrm_name_no() + ",");
		System.out.println(forum_VO3.getFrm_name_no());
		System.out.println("---------------------");

		// 查詢
		List<Forum_VO> list = dao.getAll();
		for (Forum_VO aForum : list) {
			System.out.print(aForum.getFrm_no() + ",");
			System.out.print(aForum.getFrm_name_no() + ",");
			System.out.print(aForum.getFrm_name_no());
			System.out.println();
		}
	}
}