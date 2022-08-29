package com.push_ads.model;

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

public class Push_Ads_DAO implements Push_Ads_DAO_interface{

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lonelybar");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO push_ads (ads_content, prod_no, act_no,"
		+ " pub_no, ads_pic, weights) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT ads_no, ads_content , prod_no , act_no,"
		+ " pub_no, ads_pic, weights FROM push_ads order by ads_no";
	private static final String GET_ONE_STMT = 
		"SELECT ads_no,ads_content , prod_no , act_no,"
		+ " pub_no, ads_pic, weights FROM push_ads where ads_no = ?";
	private static final String DELETE = 
		"DELETE FROM push_ads where ads_no = ?";
	private static final String UPDATE = 
		"UPDATE push_ads set ads_content=? , prod_no=?, act_no=?,"
		+ " pub_no=?, ads_pic=?, weights=? where ads_no = ?";

	@Override
	public void insert(Push_Ads_VO pushAdsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setString(1, pushAdsVO.getAds_content());
			pstmt.setInt(2, pushAdsVO.getProd_no());
			pstmt.setInt(3, pushAdsVO.getAct_no());
			pstmt.setInt(4, pushAdsVO.getPub_no());
			pstmt.setBlob(5, pushAdsVO.getAds_pic());
			pstmt.setInt(6, pushAdsVO.getWeights());

			pstmt.executeUpdate();

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
	public void update(Push_Ads_VO pushAdsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, pushAdsVO.getAds_content());
			pstmt.setInt(2, pushAdsVO.getProd_no());
			pstmt.setInt(3, pushAdsVO.getAct_no());
			pstmt.setInt(4, pushAdsVO.getPub_no());
			pstmt.setBlob(5, pushAdsVO.getAds_pic());
			pstmt.setInt(6, pushAdsVO.getWeights());
			pstmt.setInt(7, pushAdsVO.getAds_no());

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public void delete(Integer ads_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, ads_no);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public Push_Ads_VO findByPrimaryKey(Integer ads_no) {

		Push_Ads_VO pushAdsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, ads_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				pushAdsVO = new Push_Ads_VO();
				pstmt.setInt(1, pushAdsVO.getAds_no());
				pstmt.setString(2, pushAdsVO.getAds_content());
				pstmt.setInt(3, pushAdsVO.getProd_no());
				pstmt.setInt(4, pushAdsVO.getAct_no());
				pstmt.setInt(5, pushAdsVO.getPub_no());
				pstmt.setBlob(6, pushAdsVO.getAds_pic());
				pstmt.setInt(7, pushAdsVO.getWeights());

			}

			// Handle any driver errors
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
		return pushAdsVO;
	}

	@Override
	public List<Push_Ads_VO> getAll() {
		List<Push_Ads_VO> list = new ArrayList<Push_Ads_VO>();
		Push_Ads_VO pushAdsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				pushAdsVO = new Push_Ads_VO();
				pstmt.setInt(1, pushAdsVO.getAds_no());
				pstmt.setString(2, pushAdsVO.getAds_content());
				pstmt.setInt(3, pushAdsVO.getProd_no());
				pstmt.setInt(4, pushAdsVO.getAct_no());
				pstmt.setInt(5, pushAdsVO.getPub_no());
				pstmt.setBlob(6, pushAdsVO.getAds_pic());
				pstmt.setInt(7, pushAdsVO.getWeights());
				list.add(pushAdsVO); // Store the row in the list
			}

			// Handle any driver errors
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
}