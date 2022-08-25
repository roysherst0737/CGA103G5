package com.forum_article.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;



public class Forum_article_JNDI_DAO implements Forum_article_DAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/LonglyBar");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	
	}
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
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, forum_article_VO.getFrm_no());
			pstmt.setInt(2, forum_article_VO.getMem_no());
			pstmt.setTimestamp(3, forum_article_VO.getArt_time());
			pstmt.setString(4, forum_article_VO.getArt_title());
			pstmt.setString(5, forum_article_VO.getArt_content());
			pstmt.setByte(6, forum_article_VO.getArt_img());
			pstmt.setInt(7, forum_article_VO.getArt_status());
			
			

			pstmt.executeUpdate();

	
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
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
			pstmt.setTimestamp(3, forum_article_VO.getArt_time());
			pstmt.setString(4, forum_article_VO.getArt_title());
			pstmt.setString(5, forum_article_VO.getArt_content());
			pstmt.setByte(6, forum_article_VO.getArt_img());
			pstmt.setInt(7, forum_article_VO.getArt_status());
			pstmt.executeUpdate();

	
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
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
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
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
				forum_article_VO.setArt_img(rs.getByte("art_img"));
				forum_article_VO.setArt_status(rs.getInt("art_status"));
				
			}

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
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
		return null;
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
				forum_article_VO.setArt_img(rs.getByte("art_img"));
				forum_article_VO.setArt_status(rs.getInt("art_status"));
				
				list.add(forum_article_VO); 
			}

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
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
	
}