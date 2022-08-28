package com.prod.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Prod_DAO implements Prod_DAO_interface{
	
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
		"INSERT INTO prod (prod_type_no,prod_name,prod_pic_no,prod_price,prod_stock,prod_status,off_time,prod_detail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT prod_no,prod_type_no,prod_name,prod_pic_no,prod_price,prod_stock,prod_status,launch_time,off_time,prod_detail FROM prod order by prod_no";
	private static final String GET_ONE_STMT = 
		"SELECT prod_no,prod_type_no,prod_name,prod_pic_no,prod_price,prod_stock,prod_status,launch_time,off_time,prod_detail FROM prod where prod_no = ?";
	private static final String DELETE = 
		"DELETE FROM prod where prod_no = ?";
	private static final String UPDATE = 
		"UPDATE prod set prod_type_no=?, prod_name=?, prod_pic_no=?, prod_price=?, prod_stock=?, prod_status=?, launch_time=?, off_time=?, prod_detail=? where prod_no = ?";

	@Override
	public void insert(Prod_VO prodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, prodVO.getProd_type_no());
			pstmt.setString(2, prodVO.getProd_name());
			pstmt.setInt(3, prodVO.getProd_pic_no());
			pstmt.setInt(4, prodVO.getProd_price());
			pstmt.setInt(5, prodVO.getProd_stock());
			pstmt.setInt(6, prodVO.getProd_status());
			pstmt.setTimestamp(7, prodVO.getOff_time());
			pstmt.setString(8, prodVO.getProd_detail());

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
	public void update(Prod_VO prodVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);
				pstmt.setInt(1, prodVO.getProd_no());
				pstmt.setInt(2, prodVO.getProd_type_no());
				pstmt.setString(3, prodVO.getProd_name());
				pstmt.setInt(4, prodVO.getProd_pic_no());
				pstmt.setInt(5, prodVO.getProd_price());
				pstmt.setInt(6, prodVO.getProd_stock());
				pstmt.setInt(7, prodVO.getProd_status());
				pstmt.setTimestamp(8, prodVO.getOff_time());
				pstmt.setTimestamp(9, prodVO.getOff_time());
				pstmt.setString(10, prodVO.getProd_detail());

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
	public void delete(Integer prod_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prod_no);

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
	public Prod_VO findByPrimaryKey(Integer prod_no) {
		Prod_VO prodVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, prod_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				prodVO = new Prod_VO();
				prodVO.setProd_no(rs.getInt("prod_no"));
				prodVO.setProd_type_no(rs.getInt("prod_type_no"));
				prodVO.setProd_name(rs.getString("prod_name"));
				prodVO.setProd_pic_no(rs.getInt("prod_pic_no"));
				prodVO.setProd_price(rs.getInt("prod_price"));
				prodVO.setProd_stock(rs.getInt("prod_stock"));
				prodVO.setProd_status(rs.getInt("prod_status"));
				prodVO.setLaunch_time(rs.getTimestamp("launch_time"));
				prodVO.setOff_time(rs.getTimestamp("off_time"));
				prodVO.setProd_detail(rs.getString("prod_detail"));
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
		return prodVO;
	}

	@Override
	public List<Prod_VO> getAll() {
		List<Prod_VO> list = new ArrayList<Prod_VO>();
		Prod_VO prodVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				prodVO = new Prod_VO();
				prodVO.setProd_no(rs.getInt("prod_no"));
				prodVO.setProd_type_no(rs.getInt("prod_type_no"));
				prodVO.setProd_name(rs.getString("prod_name"));
				prodVO.setProd_pic_no(rs.getInt("prod_pic_no"));
				prodVO.setProd_price(rs.getInt("prod_price"));
				prodVO.setProd_stock(rs.getInt("prod_stock"));
				prodVO.setProd_status(rs.getInt("prod_status"));
				prodVO.setLaunch_time(rs.getTimestamp("launch_time"));
				prodVO.setOff_time(rs.getTimestamp("off_time"));
				prodVO.setProd_detail(rs.getString("prod_detail"));
				
				list.add(prodVO); // Store the row in the list
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

	@Override
	public List<Prod_VO> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
}