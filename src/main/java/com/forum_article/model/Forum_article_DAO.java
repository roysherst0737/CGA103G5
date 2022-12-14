package com.forum_article.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.article_message.model.Article_message_VO;
import com.forum_article_report.model.Forum_article_report_VO;

public class Forum_article_DAO implements Forum_article_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	private static final String INSERT_STMT = "INSERT INTO forum_article (frm_no,mem_no, art_title,art_content,art_img) VALUES (?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT frm_art_no,mem_no,frm_no,art_time,art_title,art_content,art_img,art_status FROM forum_article order by frm_art_no";
	private static final String GET_ONE_STMT = "SELECT frm_art_no,mem_no,frm_no,art_time,art_title,art_content,art_img,art_status FROM forum_article where frm_art_no = ?";
	private static final String DELETE = "DELETE FROM forum_article where frm_art_no = ?";
	private static final String UPDATE = "UPDATE forum set frm_no = ?,mem_no = ?,art_title = ?,art_content = ?,art_img = ?,art_status = ?  where frm_art_no = ?";
	private static final String GET_Article_message_ByForum_article_STMT = "SELECT art_msg_no,mem_no,frm_art_no,msg_time,msg_content FROM article_message where frm_art_no = ? order by art_msg_no";

	private static final String ChangeStatus = "UPDATE forum_article set art_status = art_status -1 where frm_art_no = ?";

	@Override
	public void insert(Forum_article_VO forum_article_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, forum_article_VO.getFrm_no());
			pstmt.setInt(2, forum_article_VO.getMem_no());
			pstmt.setString(3, forum_article_VO.getArt_title());
			pstmt.setString(4, forum_article_VO.getArt_content());
			pstmt.setBytes(5, forum_article_VO.getArt_img());

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
	public void update(Forum_article_VO forum_article_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, forum_article_VO.getFrm_no());
			pstmt.setInt(2, forum_article_VO.getMem_no());
//			pstmt.setTimestamp(2, forum_article_VO.getArt_time());
			pstmt.setString(3, forum_article_VO.getArt_title());
			pstmt.setString(4, forum_article_VO.getArt_content());
			pstmt.setBytes(5, forum_article_VO.getArt_img());
			pstmt.setInt(6, forum_article_VO.getArt_status());
			pstmt.setInt(7, forum_article_VO.getFrm_art_no());
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
	public void delete(Integer frm_art_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, frm_art_no);

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
	public Forum_article_VO findByPrimaryKey(Integer frm_art_no) {
		Forum_article_VO forum_article_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, frm_art_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				forum_article_VO = new Forum_article_VO();
				forum_article_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				forum_article_VO.setFrm_no(rs.getInt("frm_no"));
				forum_article_VO.setMem_no(rs.getInt("mem_no"));
				forum_article_VO.setArt_time(rs.getTimestamp("art_time"));
				forum_article_VO.setArt_title(rs.getString("art_title"));
				forum_article_VO.setArt_content(rs.getString("art_content"));
				forum_article_VO.setArt_img(rs.getBytes("art_img"));
				forum_article_VO.setArt_status(rs.getInt("art_status"));

				list.add(forum_article_VO);
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
	public Set<Article_message_VO> getArticle_messageByForum_article(Integer frm_art_no) {
		Set<Article_message_VO> set = new LinkedHashSet<Article_message_VO>();
		Article_message_VO article_message_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_Article_message_ByForum_article_STMT);
			pstmt.setInt(1, frm_art_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				article_message_VO = new Article_message_VO();
				article_message_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_VO.setMem_no(rs.getInt("mem_no"));
				article_message_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				article_message_VO.setMsg_time(rs.getTimestamp("msg_time"));
				article_message_VO.setMsg_content(rs.getString("msg_content"));

				set.add(article_message_VO); // Store the row in the vector
			}

			// Handle any SQL errors
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
		return set;
	}

	@Override
	public Integer ChangeStatus(Integer frm_art_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(ChangeStatus);

			pstmt.setInt(1, frm_art_no);

			pstmt.executeUpdate();

			// Handle any driver errors
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
		return frm_art_no;
	}

}