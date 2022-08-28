package com.article_message.model;

import java.util.*;
import java.sql.*;

import static com.util.Common.*;


public class Article_message_JDBC_DAO implements Article_message_DAO_interface {
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/lonelybar?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
//	String userid = "cga10305";
//	String passwd = "123qweqwe";

	private static final String INSERT_STMT = 
		"INSERT INTO article_message (mem_no,frm_art_no,msg_time,msg_content) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT art_msg_no,mem_no,frm_art_no,msg_time,msg_content FROM article_message order by art_msg_no";
	private static final String GET_ONE_STMT = 
		"SELECT art_msg_no,mem_no,frm_art_no,msg_time,msg_content FROM article_message where art_msg_no = ?";
	private static final String DELETE = 
		"DELETE FROM article_message where art_msg_no = ?";
	private static final String UPDATE = 
		"UPDATE article_message set art_msg_no = ?,mem_no = ?,frm_art_no = ?,msg_time = ?,msg_content = ?  where art_msg_no = ?";

	@Override
	public void insert(Article_message_VO article_message_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, article_message_VO.getMem_no());
			pstmt.setInt(2, article_message_VO.getFrm_art_no());
			pstmt.setTimestamp(3, article_message_VO.getMsg_time());
			pstmt.setString(4, article_message_VO.getMsg_content());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(Article_message_VO article_message_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, article_message_VO.getMem_no());
			pstmt.setInt(2, article_message_VO.getFrm_art_no());
			pstmt.setTimestamp(3, article_message_VO.getMsg_time());
			pstmt.setString(4, article_message_VO.getMsg_content());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer art_msg_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, art_msg_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public Article_message_VO findByPrimaryKey(Integer art_msg_no) {

		Article_message_VO article_message_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, art_msg_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				article_message_VO = new Article_message_VO();
				article_message_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_VO.setMem_no(rs.getInt("mem_no"));
				article_message_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				article_message_VO.setMsg_time(rs.getTimestamp("msg_time"));
				article_message_VO.setMsg_content(rs.getString("msg_content"));
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return article_message_VO;
	}

	@Override
	public List<Article_message_VO> getAll() {
		List<Article_message_VO> list = new ArrayList<Article_message_VO>();
		Article_message_VO article_message_VO = null;

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
				article_message_VO = new Article_message_VO();
				article_message_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_VO.setMem_no(rs.getInt("mem_no"));
				article_message_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				article_message_VO.setMsg_time(rs.getTimestamp("msg_time"));
				article_message_VO.setMsg_content(rs.getString("msg_content"));

				list.add(article_message_VO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. " + e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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

		Article_message_JDBC_DAO dao = new Article_message_JDBC_DAO();

		// 新增
		Article_message_VO article_message_VO1 = new Article_message_VO();

		article_message_VO1.setArt_msg_no(1);
		article_message_VO1.setMem_no(1);
		article_message_VO1.setFrm_art_no(1);
		article_message_VO1.setMsg_time(java.sql.Timestamp.valueOf("2021-12-25 10:10:10"));
		article_message_VO1.setMsg_content("這家酒吧氣氛很讚!服務又好!");
		dao.insert(article_message_VO1);
		// 修改
		Article_message_VO article_message_VO2 = new Article_message_VO();
		article_message_VO2.setArt_msg_no(2);
		article_message_VO2.setMem_no(2);
		article_message_VO2.setFrm_art_no(2);
		article_message_VO2.setMsg_time(java.sql.Timestamp.valueOf("2021-12-25 10:10:10"));
		article_message_VO2.setMsg_content("這家酒吧氣氛很讚!服務又好!重點是調酒師又很帥~");

		// 刪除
		dao.delete(7014);

		// 查詢
		Article_message_VO article_message_VO3 = dao.findByPrimaryKey(7001);
		System.out.print(article_message_VO3.getArt_msg_no() + ",");
		System.out.print(article_message_VO3.getMem_no() + ",");
		System.out.print(article_message_VO3.getFrm_art_no() + ",");
		System.out.print(article_message_VO3.getMsg_time() + ",");
		System.out.println(article_message_VO3.getMsg_content());
		System.out.println("---------------------");

		// 查詢
		List<Article_message_VO> list = dao.getAll();
		for (Article_message_VO aArticle_message_VO : list) {
			System.out.print(aArticle_message_VO.getArt_msg_no() + ",");
			System.out.print(aArticle_message_VO.getMem_no() + ",");
			System.out.print(aArticle_message_VO.getFrm_art_no() + ",");
			System.out.print(aArticle_message_VO.getMsg_time() + ",");
			System.out.print(aArticle_message_VO.getMsg_content());
			System.out.println();
		}
	}
}