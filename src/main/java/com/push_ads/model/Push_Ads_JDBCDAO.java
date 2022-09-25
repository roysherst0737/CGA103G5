package com.push_ads.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Push_Ads_JDBCDAO implements Push_Ads_DAO_interface{
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "208127";

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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, pushAdsVO.getAds_content());
			pstmt.setInt(2, pushAdsVO.getProd_no());
			pstmt.setInt(3, pushAdsVO.getAct_no());
			pstmt.setInt(4, pushAdsVO.getPub_no());
			pstmt.setBlob(5, pushAdsVO.getAds_pic());
			pstmt.setInt(6, pushAdsVO.getWeights());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public void delete(Integer ads_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, ads_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
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
	public Push_Ads_VO findByPrimaryKey(Integer ads_no) {

		Push_Ads_VO pushAdsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, ads_no);


			rs = pstmt.executeQuery();

			while (rs.next()) {

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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
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
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
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

	public static void main(String[] args) {

		Push_Ads_JDBCDAO dao = new Push_Ads_JDBCDAO();

		// �s�W
		Push_Ads_VO pushAdsVO1 = new Push_Ads_VO();
		pushAdsVO1.setAds_content("�ӫ~");
		pushAdsVO1.setProd_no(1);
		pushAdsVO1.setAct_no(null);
		pushAdsVO1.setPub_no(null);
		pushAdsVO1.setAds_pic(null);
		pushAdsVO1.setWeights(1);

		dao.insert(pushAdsVO1);

		// �ק�
		Push_Ads_VO pushAdsVO2 = new Push_Ads_VO();
		pushAdsVO2.setAds_content("�ӫ~");
		pushAdsVO2.setProd_no(1);
		pushAdsVO2.setAct_no(null);
		pushAdsVO2.setPub_no(null);
		pushAdsVO2.setAds_pic(null);
		pushAdsVO2.setWeights(1);
		pushAdsVO2.setAds_no(1);
		
		dao.update(pushAdsVO2);

		// �R��
		dao.delete(1);

		// �d��
		Push_Ads_VO Push_Ads_VO3 = dao.findByPrimaryKey(1);
		System.out.print(Push_Ads_VO3.getAds_no() + ",");
		System.out.print(Push_Ads_VO3.getAds_content() + ",");
		System.out.print(Push_Ads_VO3.getProd_no() + ",");
		System.out.print(Push_Ads_VO3.getAct_no() + ",");
		System.out.print(Push_Ads_VO3.getPub_no() + ",");
		System.out.print(Push_Ads_VO3.getAds_pic() + ",");
		System.out.print(Push_Ads_VO3.getWeights() + ",");

		System.out.println("---------------------");

		// �d��
		List<Push_Ads_VO> list = dao.getAll();
		for (Push_Ads_VO aEmp : list) {
			System.out.print(aEmp.getAds_no() + ",");
			System.out.print(aEmp.getAds_content() + ",");
			System.out.print(aEmp.getProd_no() + ",");
			System.out.print(aEmp.getAct_no() + ",");
			System.out.print(aEmp.getPub_no() + ",");
			System.out.print(aEmp.getAds_pic() + ",");
			System.out.print(aEmp.getWeights() + ",");

			System.out.println();
		}
	}
}