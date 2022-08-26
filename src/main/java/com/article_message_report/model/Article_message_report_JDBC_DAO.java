package com.article_message_report.model;

import java.util.*;
import java.sql.*;

import static com.util.Common.*;

public class Article_message_report_JDBC_DAO implements Article_message_report_DAO_interface {

//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/lonelybar?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
//	String userid = "cga10305";
//	String passwd = "123qweqwe";

	private static final String INSERT_STMT = 
		"INSERT INTO article_message_report (mem_no,art_msg_no,rpt_time,rpt_msg_content,mng_no,msg_done_time,msg_states,msg_result,msg_note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT art_msg_rpt,mem_no,art_msg_no,rpt_time,rpt_msg_content,mng_no,msg_done_time,msg_states,msg_result,msg_note FROM article_message_report order by art_msg_rpt";
	private static final String GET_ONE_STMT = 
		"SELECT art_msg_rpt,mem_no,art_msg_no,rpt_time,rpt_msg_content,mng_no,msg_done_time,msg_states,msg_result,msg_note FROM article_message_report where art_msg_rpt = ?";
	private static final String DELETE = 
		"DELETE FROM article_message_report where art_msg_rpt = ?";
	private static final String UPDATE = 
		"UPDATE article_message_report set mem_no = ?,art_msg_no = ?,rpt_time = ?,rpt_msg_content = ?,mng_no = ?,msg_done_time = ?,msg_states = ?,msg_result = ?,msg_note = ? where art_msg_rpt = ?";

	@Override
	public void insert(Article_message_report_VO article_message_report_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, article_message_report_VO.getMem_no());
			pstmt.setInt(2, article_message_report_VO.getArt_msg_no());
			pstmt.setTimestamp(3, article_message_report_VO.getRpt_time());
			pstmt.setString(4, article_message_report_VO.getRpt_msg_content());
			pstmt.setInt(5, article_message_report_VO.getMng_no());
			pstmt.setTimestamp(6, article_message_report_VO.getMsg_done_time());
			pstmt.setInt(7, article_message_report_VO.getMsg_states());
			pstmt.setInt(8, article_message_report_VO.getMsg_result());
			pstmt.setString(9, article_message_report_VO.getMsg_note());

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
	public void update(Article_message_report_VO article_message_report_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, article_message_report_VO.getMem_no());
			pstmt.setInt(2, article_message_report_VO.getArt_msg_no());
			pstmt.setTimestamp(3, article_message_report_VO.getRpt_time());
			pstmt.setString(4, article_message_report_VO.getRpt_msg_content());
			pstmt.setInt(5, article_message_report_VO.getMng_no());
			pstmt.setTimestamp(6, article_message_report_VO.getMsg_done_time());
			pstmt.setInt(7, article_message_report_VO.getMsg_states());
			pstmt.setInt(8, article_message_report_VO.getMsg_result());
			pstmt.setString(9, article_message_report_VO.getMsg_note());

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
	public void delete(Integer art_msg_rpt) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, art_msg_rpt);

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
	public Article_message_report_VO findByPrimaryKey(Integer art_msg_rpt) {

		Article_message_report_VO article_message_report_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, art_msg_rpt);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				article_message_report_VO = new Article_message_report_VO();
				article_message_report_VO.setArt_msg_rpt(rs.getInt("art_msg_rpt"));
				article_message_report_VO.setMem_no(rs.getInt("mem_no"));
				article_message_report_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_report_VO.setRpt_time(rs.getTimestamp("rpt_time"));
				article_message_report_VO.setRpt_msg_content(rs.getString("rpt_msg_content"));
				article_message_report_VO.setMng_no(rs.getInt("mng_no"));
				article_message_report_VO.setMsg_done_time(rs.getTimestamp("msg_done_time"));
				article_message_report_VO.setMsg_states(rs.getInt("msg_states"));
				article_message_report_VO.setMsg_result(rs.getInt("msg_result"));
				article_message_report_VO.setMsg_note(rs.getString("msg_note"));
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
		return article_message_report_VO;
	}

	@Override
	public List<Article_message_report_VO> getAll() {
		List<Article_message_report_VO> list = new ArrayList<Article_message_report_VO>();
		Article_message_report_VO article_message_report_VO = null;

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
				article_message_report_VO = new Article_message_report_VO();
				article_message_report_VO.setArt_msg_rpt(rs.getInt("art_msg_rpt"));
				article_message_report_VO.setMem_no(rs.getInt("mem_no"));
				article_message_report_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_report_VO.setRpt_time(rs.getTimestamp("rpt_time"));
				article_message_report_VO.setRpt_msg_content(rs.getString("rpt_msg_content"));
				article_message_report_VO.setMng_no(rs.getInt("mng_no"));
				article_message_report_VO.setMsg_done_time(rs.getTimestamp("msg_done_time"));
				article_message_report_VO.setMsg_states(rs.getInt("msg_states"));
				article_message_report_VO.setMsg_result(rs.getInt("msg_result"));
				article_message_report_VO.setMsg_note(rs.getString("msg_note"));
				;
				list.add(article_message_report_VO); // Store the row in the list
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

		Article_message_report_JDBC_DAO dao = new Article_message_report_JDBC_DAO();

		// 新增
		Article_message_report_VO article_message_report_VO1 = new Article_message_report_VO();
		article_message_report_VO1.setArt_msg_rpt(1);
		article_message_report_VO1.setMem_no(1);
		article_message_report_VO1.setArt_msg_no(123);
		article_message_report_VO1.setRpt_time(java.sql.Timestamp.valueOf("2022-05-07 01:23:45"));
		article_message_report_VO1.setRpt_msg_content("仇恨言論");
		article_message_report_VO1.setMng_no(1);
		article_message_report_VO1.setMsg_done_time(java.sql.Timestamp.valueOf("null"));
		article_message_report_VO1.setMsg_states(0);
		article_message_report_VO1.setMsg_result(0);
		article_message_report_VO1.setMsg_note("待審核");
		dao.insert(article_message_report_VO1);

		// 修改
		Article_message_report_VO article_message_report_VO2 = new Article_message_report_VO();
		article_message_report_VO2.setArt_msg_rpt(1);
		article_message_report_VO2.setMem_no(1);
		article_message_report_VO2.setArt_msg_no(123);
		article_message_report_VO2.setRpt_time(java.sql.Timestamp.valueOf("2022-05-07 01:23:45"));
		article_message_report_VO2.setRpt_msg_content("仇恨言論");
		article_message_report_VO2.setMng_no(1);
		article_message_report_VO2.setMsg_done_time(java.sql.Timestamp.valueOf("2022-05-07 12:20:45"));
		article_message_report_VO2.setMsg_states(1);
		article_message_report_VO2.setMsg_result(1);
		article_message_report_VO2.setMsg_note("已審核");
		dao.insert(article_message_report_VO2);

		// 刪除
		dao.delete(7014);

		// 查詢
		Article_message_report_VO article_message_report_VO3 = dao.findByPrimaryKey(7001);
		System.out.print(article_message_report_VO3.getArt_msg_rpt() + ",");
		System.out.print(article_message_report_VO3.getMem_no() + ",");
		System.out.print(article_message_report_VO3.getArt_msg_no() + ",");
		System.out.print(article_message_report_VO3.getRpt_time() + ",");
		System.out.print(article_message_report_VO3.getRpt_msg_content() + ",");
		System.out.print(article_message_report_VO3.getMng_no() + ",");
		System.out.println(article_message_report_VO3.getMsg_done_time());
		System.out.print(article_message_report_VO3.getMsg_states() + ",");
		System.out.print(article_message_report_VO3.getMsg_result() + ",");
		System.out.println(article_message_report_VO3.getMsg_note());
		System.out.println("---------------------");

		// 查詢
		List<Article_message_report_VO> list = dao.getAll();
		for (Article_message_report_VO aArticle_message_report : list) {
			System.out.print(aArticle_message_report.getArt_msg_rpt() + ",");
			System.out.print(aArticle_message_report.getMem_no() + ",");
			System.out.print(aArticle_message_report.getArt_msg_no() + ",");
			System.out.print(aArticle_message_report.getRpt_time() + ",");
			System.out.print(aArticle_message_report.getRpt_msg_content() + ",");
			System.out.print(aArticle_message_report.getMng_no() + ",");
			System.out.print(aArticle_message_report.getMsg_done_time());
			System.out.print(aArticle_message_report.getMsg_states() + ",");
			System.out.print(aArticle_message_report.getMsg_result() + ",");
			System.out.print(aArticle_message_report.getMsg_note());
			System.out.println();
		}
	}
}