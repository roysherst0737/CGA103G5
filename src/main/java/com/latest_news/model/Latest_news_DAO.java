package com.latest_news.model;

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



public class Latest_news_DAO implements Latest_news_DAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	
	}
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, latest_news_VO.getNews_content());
			pstmt.setInt(2, latest_news_VO.getNews_status());
			

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
	public void update(Latest_news_VO latest_news_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, latest_news_VO.getNews_content());
			pstmt.setInt(2, latest_news_VO.getNews_status());
			pstmt.setInt(3, latest_news_VO.getLatest_news_no());
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
	public void delete(Integer latest_news_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, latest_news_no);

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
	public Latest_news_VO findByPrimaryKey(Integer latest_news_no) {
		Latest_news_VO latest_news_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, latest_news_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				latest_news_VO = new Latest_news_VO();
				latest_news_VO.setLatest_news_no(rs.getInt("latest_news_no"));
				latest_news_VO.setNews_content(rs.getString("news_content"));
				latest_news_VO.setNews_status(rs.getInt("news_status"));
				
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				latest_news_VO = new Latest_news_VO();
				latest_news_VO.setLatest_news_no(rs.getInt("latest_news_no"));
				latest_news_VO.setNews_content(rs.getString("news_content"));
				latest_news_VO.setNews_status(rs.getInt("news_status"));
				list.add(latest_news_VO); 
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