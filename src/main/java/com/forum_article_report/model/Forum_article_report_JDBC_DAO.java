package com.forum_article_report.model;

import java.util.*;
import java.sql.*;

import static com.util.Common.*;

public class Forum_article_report_JDBC_DAO implements Forum_article_report_DAO_interface {
//	String driver = "com.mysql.cj.jdbc.Driver";
//	String url = "jdbc:mysql://localhost:3306/lonelybar?useUnicode=yes&characterEncoding=utf8&useSSL=true&serverTimezone=Asia/Taipei";
//	String userid = "cga10305";
//	String passwd = "123qweqwe";

	private static final String INSERT_STMT = 
		"INSERT INTO forum_article_report (mem_no,frm_art_no,rpt_time,rpt_content,mng_no,rpt_done_time,rpt_status,rpt_result,rpt_note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT frm_art_rpt_no,mem_no,frm_art_no,rpt_time,rpt_content,mng_no,rpt_done_time,rpt_status,rpt_result,rpt_note FROM forum_article_report order by frm_art_rpt_no";
	private static final String GET_ONE_STMT = 
		"SELECT frm_art_rpt_no,mem_no,frm_art_no,rpt_time,rpt_content,mng_no,rpt_done_time,rpt_status,rpt_result,rpt_note FROM forum_article_report where frm_art_rpt_no = ?";
	private static final String DELETE = 
		"DELETE FROM forum_article where frm_art_rpt_no = ?";
	private static final String UPDATE = 
		"UPDATE forum_article set frm_art_rpt_no = ?,mem_no = ?,frm_art_no = ?,rpt_time = ?,rpt_content = ?,mng_no = ?,rpt_done_time = ?,rpt_status = ?,rpt_result = ?,rpt_note = ? where frm_art_rpt_no = ?";
		

	@Override
	public void insert(Forum_article_report_VO forum_article_report_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

//			pstmt.setInt(1, forum_article_report_VO.getFrm_art_rpt_no());
			pstmt.setInt(2, forum_article_report_VO.getMem_no());
			pstmt.setInt(3, forum_article_report_VO.getFrm_art_no());
			pstmt.setTimestamp(4, forum_article_report_VO.getRpt_time());
			pstmt.setString(5, forum_article_report_VO.getRpt_content());
			pstmt.setInt(6, forum_article_report_VO.getMng_no());
			pstmt.setTimestamp(7, forum_article_report_VO.getRpt_done_time());
			pstmt.setInt(8, forum_article_report_VO.getRpt_status());
			pstmt.setInt(9, forum_article_report_VO.getRpt_result());
			pstmt.setString(10, forum_article_report_VO.getRpt_note());

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
	public void update(Forum_article_report_VO forum_article_report_VO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);

//			pstmt.setInt(1, forum_article_report_VO.getFrm_art_rpt_no());
			pstmt.setInt(2, forum_article_report_VO.getMem_no());
			pstmt.setInt(3, forum_article_report_VO.getFrm_art_no());
			pstmt.setTimestamp(4, forum_article_report_VO.getRpt_time());
			pstmt.setString(5, forum_article_report_VO.getRpt_content());
			pstmt.setInt(6, forum_article_report_VO.getMng_no());
			pstmt.setTimestamp(7, forum_article_report_VO.getRpt_done_time());
			pstmt.setInt(8, forum_article_report_VO.getRpt_status());
			pstmt.setInt(9, forum_article_report_VO.getRpt_result());
			pstmt.setString(10, forum_article_report_VO.getRpt_note());

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
	public void delete(Integer frm_art_rpt_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, frm_art_rpt_no);

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
	public Forum_article_report_VO findByPrimaryKey(Integer frm_art_rpt_no) {

		Forum_article_report_VO forum_article_report_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, frm_art_rpt_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				forum_article_report_VO = new Forum_article_report_VO();
				forum_article_report_VO.setFrm_art_rpt_no(rs.getInt("frm_art_rpt_no"));
				forum_article_report_VO.setMem_no(rs.getInt("mem_no"));
				forum_article_report_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				forum_article_report_VO.setRpt_time(rs.getTimestamp("rpt_time"));
				forum_article_report_VO.setRpt_content(rs.getString("rpt_content"));
				forum_article_report_VO.setMng_no(rs.getInt("mng_no"));
				forum_article_report_VO.setRpt_done_time(rs.getTimestamp("rpt_done_time"));
				forum_article_report_VO.setRpt_status(rs.getInt("rpt_status"));
				forum_article_report_VO.setRpt_result(rs.getInt("rpt_result"));
				forum_article_report_VO.setRpt_note(rs.getString("rpt_note"));

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
		return forum_article_report_VO;
	}

	@Override
	public List<Forum_article_report_VO> getAll() {
		List<Forum_article_report_VO> list = new ArrayList<Forum_article_report_VO>();
		Forum_article_report_VO forum_article_report_VO = null;

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
				forum_article_report_VO = new Forum_article_report_VO();
				forum_article_report_VO.setFrm_art_rpt_no(rs.getInt("frm_art_rpt_no"));
				forum_article_report_VO.setMem_no(rs.getInt("mem_no"));
				forum_article_report_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				forum_article_report_VO.setRpt_time(rs.getTimestamp("rpt_time"));
				forum_article_report_VO.setRpt_content(rs.getString("rpt_content"));
				forum_article_report_VO.setMng_no(rs.getInt("mng_no"));
				forum_article_report_VO.setRpt_done_time(rs.getTimestamp("rpt_done_time"));
				forum_article_report_VO.setRpt_status(rs.getInt("rpt_status"));
				forum_article_report_VO.setRpt_result(rs.getInt("rpt_result"));
				forum_article_report_VO.setRpt_note(rs.getString("rpt_note"));

				list.add(forum_article_report_VO); // Store the row in the list
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

		Forum_article_report_JDBC_DAO dao = new Forum_article_report_JDBC_DAO();

		// 新增
		Forum_article_report_VO forum_article_report_VO1 = new Forum_article_report_VO();
		forum_article_report_VO1.setFrm_art_rpt_no(1);
		forum_article_report_VO1.setMem_no(1);
		forum_article_report_VO1.setFrm_art_no(1);
		forum_article_report_VO1.setRpt_time(java.sql.Timestamp.valueOf("2022-08-08 12:12:12"));
		forum_article_report_VO1.setRpt_content("文章有仇恨言論");
		forum_article_report_VO1.setMng_no(10);
		forum_article_report_VO1.setRpt_done_time(java.sql.Timestamp.valueOf("null"));
		forum_article_report_VO1.setRpt_status(0);
		forum_article_report_VO1.setRpt_result(0);
		forum_article_report_VO1.setRpt_note("待審查");
		dao.insert(forum_article_report_VO1);

		/// 修改
		Forum_article_report_VO forum_article_report_VO2 = new Forum_article_report_VO();
		forum_article_report_VO2.setFrm_art_rpt_no(1);
		forum_article_report_VO2.setMem_no(1);
		forum_article_report_VO2.setFrm_art_no(1);
		forum_article_report_VO1.setRpt_time(java.sql.Timestamp.valueOf("2022-08-08 12:12:12"));
		forum_article_report_VO2.setRpt_content("文章有仇恨言論");
		forum_article_report_VO2.setMng_no(10);
		forum_article_report_VO1.setRpt_done_time(java.sql.Timestamp.valueOf("2022-08-08 13:13:13"));
		forum_article_report_VO2.setRpt_status(1);
		forum_article_report_VO2.setRpt_result(1);
		forum_article_report_VO2.setRpt_note("已審核");
		dao.update(forum_article_report_VO2);

		// 刪除
		dao.delete(7014);

		// 查詢
		Forum_article_report_VO forum_article_report_VO3 = dao.findByPrimaryKey(7001);
		System.out.print(forum_article_report_VO3.getFrm_art_rpt_no() + ",");
		System.out.print(forum_article_report_VO3.getMem_no() + ",");
		System.out.print(forum_article_report_VO3.getFrm_art_no() + ",");
		System.out.print(forum_article_report_VO3.getRpt_time() + ",");
		System.out.print(forum_article_report_VO3.getRpt_content() + ",");
		System.out.print(forum_article_report_VO3.getMng_no() + ",");
		System.out.print(forum_article_report_VO3.getRpt_done_time()+",");
		System.out.print(forum_article_report_VO3.getRpt_status()+",");
		System.out.print(forum_article_report_VO3.getRpt_result()+",");
		System.out.print(forum_article_report_VO3.getRpt_note());
		System.out.println("---------------------");

		
		// 查詢
		List<Forum_article_report_VO> list = dao.getAll();
		for (Forum_article_report_VO aForum_article_report : list) {
			System.out.print(aForum_article_report.getFrm_art_rpt_no() + ",");
			System.out.print(aForum_article_report.getMem_no() + ",");
			System.out.print(aForum_article_report.getFrm_art_no() + ",");
			System.out.print(aForum_article_report.getRpt_time() + ",");
			System.out.print(aForum_article_report.getRpt_content() + ",");
			System.out.print(aForum_article_report.getMng_no() + ",");
			System.out.print(aForum_article_report.getRpt_done_time() + ",");
			System.out.print(aForum_article_report.getRpt_status() + ",");
			System.out.print(aForum_article_report.getRpt_result() + ",");
			System.out.print(aForum_article_report.getRpt_note());
			System.out.println();
		}
	}
}