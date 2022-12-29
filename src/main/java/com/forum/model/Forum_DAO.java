package com.forum.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.forum_article.model.Forum_article_VO;

public class Forum_DAO implements Forum_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}
	private static final String INSERT_STMT = "INSERT INTO forum (frm_name_no,frm_status,frm_img) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT frm_no,frm_name_no,frm_status,frm_img FROM forum order by frm_no";
	private static final String GET_ONE_STMT = "SELECT frm_no,frm_name_no,frm_status,frm_img FROM forum where frm_no = ?";
	private static final String DELETE = "DELETE FROM forum where frm_no = ?";
	private static final String UPDATE = "UPDATE forum set frm_name_no = ?,frm_status = ? where frm_no = ?";
	private static final String GET_Forum_article_ByForum_STMT = "SELECT frm_art_no,frm_no,mem_no,art_time,art_title,art_content,art_img,art_status FROM forum_article where frm_no = ? order by frm_art_no";

	@Override
	public void insert(Forum_VO forum_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, forum_VO.getFrm_name_no());
			pstmt.setInt(2, forum_VO.getFrm_status());
			pstmt.setBytes(3, forum_VO.getFrm_img());

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
	public void update(Forum_VO forum_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, forum_VO.getFrm_name_no());
			pstmt.setInt(2, forum_VO.getFrm_status());
			pstmt.setInt(3, forum_VO.getFrm_no());

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
	public void delete(Integer frm_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, frm_no);

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
	public Forum_VO findByPrimaryKey(Integer frm_no) {
		Forum_VO forum_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, frm_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				forum_VO = new Forum_VO();
				forum_VO.setFrm_no(rs.getInt("frm_no"));
				forum_VO.setFrm_name_no(rs.getString("frm_name_no"));
				forum_VO.setFrm_status(rs.getInt("frm_status"));
				forum_VO.setFrm_img(rs.getBytes("frm_img"));

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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				forum_VO = new Forum_VO();
				forum_VO.setFrm_no(rs.getInt("frm_no"));
				forum_VO.setFrm_name_no(rs.getString("frm_name_no"));
				forum_VO.setFrm_status(rs.getInt("frm_status"));
				forum_VO.setFrm_img(rs.getBytes("frm_img"));
				list.add(forum_VO);
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
	public Set<Forum_article_VO> getForum_articleByForum(Integer frm_no) {
		Set<Forum_article_VO> set = new LinkedHashSet<Forum_article_VO>();
		Forum_article_VO forum_article_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_Forum_article_ByForum_STMT);
			pstmt.setInt(1, frm_no);
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

				set.add(forum_article_VO); // Store the row in the vector
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

}