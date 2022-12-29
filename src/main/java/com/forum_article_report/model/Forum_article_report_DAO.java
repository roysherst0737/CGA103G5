package com.forum_article_report.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Forum_article_report_DAO implements Forum_article_report_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	private static final String INSERT_STMT = "INSERT INTO forum_article_report (mem_no,frm_art_no,rpt_time,rpt_content) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT frm_art_rpt_no,mem_no,frm_art_no,rpt_time,rpt_content,mng_no,rpt_done_time,rpt_status,rpt_result,rpt_note FROM forum_article_report order by frm_art_rpt_no";
	private static final String GET_ONE_STMT = "SELECT frm_art_rpt_no,mem_no,frm_art_no,rpt_time,rpt_content,mng_no,rpt_done_time,rpt_status,rpt_result,rpt_note FROM forum_article_report where frm_art_rpt_no = ?";
	private static final String DELETE = "DELETE FROM forum_article_report where frm_art_rpt_no = ?";
	private static final String UPDATE = "UPDATE forum_article_report set mem_no = ?,frm_art_no = ?,rpt_time = ?,rpt_content = ?,mng_no = ?,rpt_done_time = ?,rpt_status = ?,rpt_result = ?,rpt_note = ? where frm_art_rpt_no = ?";
	private static final String CHECK = "UPDATE forum_article_report set mng_no = ?,rpt_done_time = ?,rpt_status = ?,rpt_result = ?,rpt_note = ? where frm_art_rpt_no = ?";

	@Override
	public void insert(Forum_article_report_VO forum_article_report_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, forum_article_report_VO.getMem_no());
			pstmt.setInt(2, forum_article_report_VO.getFrm_art_no());
			pstmt.setTimestamp(3, forum_article_report_VO.getRpt_time());
			pstmt.setString(4, forum_article_report_VO.getRpt_content());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, forum_article_report_VO.getMem_no());
			pstmt.setInt(2, forum_article_report_VO.getFrm_art_no());
			pstmt.setTimestamp(3, forum_article_report_VO.getRpt_time());
			pstmt.setString(4, forum_article_report_VO.getRpt_content());
			pstmt.setInt(5, forum_article_report_VO.getMng_no());
			pstmt.setTimestamp(6, forum_article_report_VO.getRpt_done_time());
			pstmt.setInt(7, forum_article_report_VO.getRpt_status());
			pstmt.setInt(8, forum_article_report_VO.getRpt_result());
			pstmt.setString(9, forum_article_report_VO.getRpt_note());
			pstmt.setInt(10, forum_article_report_VO.getFrm_art_rpt_no());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, frm_art_rpt_no);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, frm_art_rpt_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

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

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
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

				list.add(forum_article_report_VO);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
	public void check(Forum_article_report_VO forum_article_report_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(CHECK);

			pstmt.setInt(1, forum_article_report_VO.getMng_no());
			pstmt.setTimestamp(2, forum_article_report_VO.getRpt_done_time());
			pstmt.setInt(3, forum_article_report_VO.getRpt_status());
			pstmt.setInt(4, forum_article_report_VO.getRpt_result());
			pstmt.setString(5, forum_article_report_VO.getRpt_note());
			pstmt.setInt(6, forum_article_report_VO.getFrm_art_rpt_no());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

}