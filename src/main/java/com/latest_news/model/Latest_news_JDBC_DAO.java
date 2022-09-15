package com.latest_news.model;

import java.util.*;
import java.sql.*;

import static com.util.Common.*;

public class Latest_news_JDBC_DAO implements Latest_news_DAO_interface {
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/lonelybar?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
//	String userid = "cga10305";
//	String passwd = "123qweqwe";

	private static final String INSERT_STMT = 
		"INSERT INTO latest_news (news_content,news_status) VALUES (?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT latest_news_no,news_content,news_status FROM latest_news order by latest_news_no";
	private static final String GET_ONE_STMT = 
		"SELECT latest_news_no,news_content,news_status FROM latest_news where latest_news_no = ?";
	private static final String DELETE = 
		"DELETE FROM latest_news where latest_news_no = ?";
	private static final String UPDATE = 
		"UPDATE latest_news set news_content = ?,news_status = ? where latest_news_no = ?";
		
	@Override
	public void insert(Latest_news_VO latest_news_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, latest_news_VO.getNews_content());
			pstmt.setInt(2, latest_news_VO.getNews_status());

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
	public void update(Latest_news_VO latest_news_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, latest_news_VO.getNews_content());
			pstmt.setInt(2, latest_news_VO.getNews_status());
			pstmt.setInt(2, latest_news_VO.getLatest_news_no());

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
	public void delete(Integer latest_news_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, latest_news_no);

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
	public Latest_news_VO findByPrimaryKey(Integer latest_news_no) {

		Latest_news_VO latest_news_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, latest_news_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				latest_news_VO = new Latest_news_VO();
				latest_news_VO.setLatest_news_no(rs.getInt("latest_news_no"));
				latest_news_VO.setNews_content(rs.getString("news_content"));
				latest_news_VO.setNews_status(rs.getInt("news_status"));
				
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
		return latest_news_VO;
	}

	@Override
	public List<Latest_news_VO> getAll() {
		List<Latest_news_VO> list = new ArrayList<Latest_news_VO>();
		Latest_news_VO latest_news_VO = null;

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
				latest_news_VO = new Latest_news_VO();
				latest_news_VO.setLatest_news_no(rs.getInt("latest_news_no"));
				latest_news_VO.setNews_content(rs.getString("news_content"));
				latest_news_VO.setNews_status(rs.getInt("news_status"));
				list.add(latest_news_VO);  // Store the row in the list
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

		Latest_news_JDBC_DAO dao = new Latest_news_JDBC_DAO();

		// 新增
		Latest_news_VO latest_news_VO1 = new Latest_news_VO();
		latest_news_VO1.setLatest_news_no(1);
		latest_news_VO1.setNews_content("琳琅滿目調酒器材8折起");
		latest_news_VO1.setNews_status(0);
		dao.insert(latest_news_VO1);

		// 修改
		Latest_news_VO latest_news_VO2 = new Latest_news_VO();
		latest_news_VO2.setLatest_news_no(1);
		latest_news_VO2.setNews_content("酒類商品全面87折");
		latest_news_VO2.setNews_status(1);
		dao.update(latest_news_VO2);

		// 刪除
		dao.delete(10);

		// 查詢
		Latest_news_VO latest_news_VO3 = dao.findByPrimaryKey(1);
		System.out.print(latest_news_VO3.getLatest_news_no() + ",");
		System.out.print(latest_news_VO3.getNews_content() + ",");
		System.out.print(latest_news_VO3.getNews_status());
		System.out.println("---------------------");

		// 查詢
		List<Latest_news_VO> list = dao.getAll();
		for (Latest_news_VO aLatest_news : list) {
			System.out.print(aLatest_news.getLatest_news_no() + ",");
			System.out.print(aLatest_news.getNews_content() + ",");
			System.out.print(aLatest_news.getNews_status());
			System.out.println();
		}
	}
}