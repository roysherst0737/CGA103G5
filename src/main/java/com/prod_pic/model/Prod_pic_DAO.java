package com.prod_pic.model;

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

public class Prod_pic_DAO implements Prod_pic_DAO_interface{
	
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
		"INSERT INTO prod_pic (prod_no,prod_pic,prod_pic_name) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT prod_pic_no,prod_no,prod_pic,prod_pic_name FROM prod_pic order by prod_pic_no";
	private static final String GET_ONE_STMT = 
		"SELECT prod_pic_no,prod_no,prod_pic,prod_pic_name FROM prod_pic where prod_pic_no = ?";
	private static final String DELETE = 
		"DELETE FROM prod_pic where prod_pic_no = ?";
	private static final String UPDATE = 
		"UPDATE prod_pic set prod_no=?, prod_pic=?, prod_pic_name=? where prod_pic_no = ?";

	@Override
	public void insert(Prod_pic_VO prod_picVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, prod_picVO.getProd_no());
			pstmt.setBlob(2, prod_picVO.getProd_pic());
			pstmt.setString(3, prod_picVO.getProd_pic_name());

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
	public void update(Prod_pic_VO prod_picVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, prod_picVO.getProd_no());
			pstmt.setBlob(2, prod_picVO.getProd_pic());
			pstmt.setString(3, prod_picVO.getProd_pic_name());
			pstmt.setInt(4, prod_picVO.getProd_pic_no());

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
	public void delete(Integer prod_pic_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, prod_pic_no);

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
	public Prod_pic_VO findByPrimaryKey(Integer prod_pic_no) {
		Prod_pic_VO prod_picVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, prod_pic_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				prod_picVO = new Prod_pic_VO();
				prod_picVO.setProd_pic_no(rs.getInt("prod_pic_no"));
				prod_picVO.setProd_no(rs.getInt("prod_no"));
				prod_picVO.setProd_pic(rs.getBlob("prod_pic"));
				prod_picVO.setProd_pic_name(rs.getString("prod_pic_name"));
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
		return prod_picVO;
	}

	@Override
	public List<Prod_pic_VO> getAll() {
		List<Prod_pic_VO> list = new ArrayList<Prod_pic_VO>();
		Prod_pic_VO prod_picVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				prod_picVO = new Prod_pic_VO();
				prod_picVO.setProd_pic_no(rs.getInt("prod_pic_no"));
				prod_picVO.setProd_no(rs.getInt("prod_no"));
				prod_picVO.setProd_pic(rs.getBlob("prod_pic"));
				prod_picVO.setProd_pic_name(rs.getString("prod_pic_name"));
				
				list.add(prod_picVO); // Store the row in the list
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
