package com.article_message.model;

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



public class Article_message_DAO implements Article_message_DAO_interface{
	
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
			"INSERT INTO article_message (mem_no,frm_art_no,msg_time,msg_content) VALUES (?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT art_msg_no,mem_no,frm_art_no,msg_time,msg_content FROM article_message order by art_msg_no";
		private static final String GET_ONE_STMT = 
			"SELECT art_msg_no,mem_no,frm_art_no,msg_time,msg_content FROM article_message where art_msg_no = ?";
		private static final String DELETE = 
			"DELETE FROM article_message where art_msg_no = ?";
		private static final String UPDATE = 
			"UPDATE article_message set art_msg_no = ?,mem_no = ?,frm_art_no = ?,msg_time = ?,msg_content = ?";
	
	@Override
	public void insert(Article_message_VO article_message_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			
			pstmt.setInt(1, article_message_VO.getMem_no());
			pstmt.setInt(2, article_message_VO.getFrm_art_no());
			pstmt.setTimestamp(3, article_message_VO.getMsg_time());
			pstmt.setString(4, article_message_VO.getMsg_content());
			

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
	public void update(Article_message_VO article_message_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, article_message_VO.getMem_no());
			pstmt.setInt(2, article_message_VO.getFrm_art_no());
			pstmt.setTimestamp(3, article_message_VO.getMsg_time());
			pstmt.setString(4, article_message_VO.getMsg_content());
			

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
	public void delete(Integer art_msg_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, art_msg_no);

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
	public Article_message_VO findByPrimaryKey(Integer art_msg_no) {
		Article_message_VO article_message_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, art_msg_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				article_message_VO = new Article_message_VO();
				article_message_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_VO.setMem_no(rs.getInt("mem_no"));
				article_message_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				article_message_VO.setMsg_time(rs.getTimestamp("msg_time"));
				article_message_VO.setMsg_content(rs.getString("msg_content"));
				
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
	public List<Article_message_VO> getAll() {
		List<Article_message_VO> list = new ArrayList<Article_message_VO>();
		Article_message_VO article_message_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				article_message_VO = new Article_message_VO();
				article_message_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_VO.setMem_no(rs.getInt("mem_no"));
				article_message_VO.setFrm_art_no(rs.getInt("frm_art_no"));
				article_message_VO.setMsg_time(rs.getTimestamp("msg_time"));
				article_message_VO.setMsg_content(rs.getString("msg_content"));
				
				list.add(article_message_VO); 
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