package com.forum_article.model;

import java.util.*;
import java.sql.*;

import static com.util.Common.*;

public class Forum_article_JDBC_DAO implements Forum_article_DAO_interface {
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
//	String userid = "root";
//	String passwd = "123456";

	private static final String INSERT_STMT = 
		"INSERT INTO forum_article (frm_no,mem_no,art_time,art_title,art_content,art_img,art_status) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT frm_art_no,frm_no,mem_no,art_time,art_title,art_content,art_img,art_status FROM forum_article order by frm_art_no";
	private static final String GET_ONE_STMT = 
		"SELECT frm_art_no,frm_no,mem_no,art_time,art_title,art_content,art_img,art_status FROM forum_article FROM forum where frm_art_no = ?";
	private static final String DELETE = 
		"DELETE FROM forum_article where frm_art_no = ?";
	private static final String UPDATE = 
		"UPDATE forum set frm_no = ?,mem_no = ?,art_time = ?,art_title = ?,art_content = ?,art_img = ?,art_status = ? where frm_art_no = ?";
		
	@Override
	public void insert(Forum_article_VO forum_article_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, forum_article_VO.getFrm_no());
			pstmt.setInt(2, forum_article_VO.getMem_no());
			pstmt.setTimestamp(3, forum_article_VO.getArt_time());
			pstmt.setString(4, forum_article_VO.getArt_title());
			pstmt.setString(5, forum_article_VO.getArt_content());
			pstmt.setBytes(6, forum_article_VO.getArt_img());
			pstmt.setInt(7, forum_article_VO.getArt_status());
			

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
	public void update(Forum_article_VO forum_article_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, forum_article_VO.getFrm_no());
			pstmt.setInt(2, forum_article_VO.getMem_no());
			pstmt.setTimestamp(3, forum_article_VO.getArt_time());
			pstmt.setString(4, forum_article_VO.getArt_title());
			pstmt.setString(5, forum_article_VO.getArt_content());
			pstmt.setBytes(6, forum_article_VO.getArt_img());
			pstmt.setInt(7, forum_article_VO.getArt_status());

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
	public void delete(Integer frm_art_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, frm_art_no);

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
	public Forum_article_VO findByPrimaryKey(Integer frm_art_no) {

		Forum_article_VO forum_article_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, frm_art_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				forum_article_VO = new Forum_article_VO();
				forum_article_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				forum_article_VO.setFrm_no(rs.getInt("frm_no"));
				forum_article_VO.setMem_no(rs.getInt("mem_no"));
				forum_article_VO.setArt_time(rs.getTimestamp("art_time"));
				forum_article_VO.setArt_title(rs.getString("art_title"));
				forum_article_VO.setArt_content(rs.getString("art_content"));
				forum_article_VO.setArt_img(rs.getBytes("art_img"));
				forum_article_VO.setArt_status(rs.getInt("art_status"));
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
		return forum_article_VO;
	}

	@Override
	public List<Forum_article_VO> getAll() {
		List<Forum_article_VO> list = new ArrayList<Forum_article_VO>();
		Forum_article_VO forum_article_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				forum_article_VO = new Forum_article_VO();
				forum_article_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				forum_article_VO.setFrm_no(rs.getInt("frm_no"));
				forum_article_VO.setMem_no(rs.getInt("mem_no"));
				forum_article_VO.setArt_time(rs.getTimestamp("art_time"));
				forum_article_VO.setArt_title(rs.getString("art_title"));
				forum_article_VO.setArt_content(rs.getString("art_content"));
				forum_article_VO.setArt_img(rs.getBytes("art_img"));
				forum_article_VO.setArt_status(rs.getInt("art_status"));
				
				list.add(forum_article_VO);// Store the row in the list
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

		Forum_article_JDBC_DAO dao = new Forum_article_JDBC_DAO();

		// 新增
		Forum_article_VO forum_article_VO1 = new Forum_article_VO();
		forum_article_VO1.setFrm_art_no(1);
		forum_article_VO1.setFrm_no(1);
		forum_article_VO1.setMem_no(1);
		forum_article_VO1.setArt_time(java.sql.Timestamp.valueOf("2022-08-07"));
		forum_article_VO1.setArt_title("周末無限暢飲");
		forum_article_VO1.setArt_content("穿著比基尼到現場，限定酒款無限暢飲");
		forum_article_VO1.setArt_img(null);
		forum_article_VO1.setArt_status(0);
		dao.insert(forum_article_VO1);

		// 修改
		Forum_article_VO forum_article_VO2 = new Forum_article_VO();
		forum_article_VO2.setFrm_art_no(1);
		forum_article_VO2.setFrm_no(1);
		forum_article_VO2.setMem_no(1);
		forum_article_VO2.setArt_time(java.sql.Timestamp.valueOf("2022-08-07"));
		forum_article_VO2.setArt_title("周末無限暢飲");
		forum_article_VO2.setArt_content("穿著比基尼到現場，限定酒款無限暢飲");
		forum_article_VO2.setArt_img(null);
		forum_article_VO2.setArt_status(1);
		dao.update(forum_article_VO2);

		// 刪除
		dao.delete(7014);

		// 查詢
		Forum_article_VO forum_article_VO = dao.findByPrimaryKey(7001);
		System.out.print(forum_article_VO.getFrm_art_no() + ",");
		System.out.print(forum_article_VO.getFrm_no() + ",");
		System.out.print(forum_article_VO.getMem_no() + ",");
		System.out.print(forum_article_VO.getArt_time() + ",");
		System.out.print(forum_article_VO.getArt_title() + ",");
		System.out.print(forum_article_VO.getArt_content() + ",");
		System.out.print(forum_article_VO.getArt_img() + ",");
		System.out.println(forum_article_VO.getArt_status());
		System.out.println("---------------------");

		// 查詢
		List<Forum_article_VO> list = dao.getAll();
		for (Forum_article_VO aForum_article : list) {
			System.out.print(aForum_article.getFrm_art_no() + ",");
			System.out.print(aForum_article.getFrm_no() + ",");
			System.out.print(aForum_article.getMem_no() + ",");
			System.out.print(aForum_article.getArt_time() + ",");
			System.out.print(aForum_article.getArt_title() + ",");
			System.out.print(aForum_article.getArt_content() + ",");
			System.out.print(aForum_article.getArt_img() + ",");
			System.out.print(aForum_article.getArt_status());
			System.out.println();
		}
	}
}