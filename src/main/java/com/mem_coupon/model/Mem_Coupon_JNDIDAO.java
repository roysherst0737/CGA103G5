package com.mem_coupon.model;

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

public class Mem_Coupon_JNDIDAO implements Mem_Coupon_DAO_interface{

	// �@�����ε{����,�w��@�Ӹ�Ʈw ,�@�Τ@��DataSource�Y�i
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
		"INSERT INTO mem_coupon (coupon_no, mem_no, remain_amount) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT coupon_no, mem_no, remain_amount FROM mem_coupon order by mem_no, coupon_no";
	private static final String GET_ONE_STMT = 
		"SELECT coupon_no, mem_no, remain_amount FROM mem_coupon where mem_no = ? AND coupon_no = ?";
	private static final String DELETE = 
		"DELETE FROM mem_coupon where mem_no = ? AND coupon_no = ?";
	private static final String UPDATE = 
		"UPDATE mem_coupon set remain_amount? where mem_no = ? AND coupon_no = ?";

	@Override
	public void insert(Mem_Coupon_VO memCouponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, memCouponVO.getCoupon_no());
			pstmt.setInt(2, memCouponVO.getMem_no());
			pstmt.setInt(3, memCouponVO.getRemain_amount());

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
	public void update(Mem_Coupon_VO memCouponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, memCouponVO.getRemain_amount());
			pstmt.setInt(2, memCouponVO.getMem_no());
			pstmt.setInt(3, memCouponVO.getCoupon_no());


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
	public void delete(Integer coupon_no,Integer mem_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mem_no);
			pstmt.setInt(2, coupon_no);

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
	public Mem_Coupon_VO findByPrimaryKey(Integer coupon_no,Integer mem_no) {

		Mem_Coupon_VO memCouponVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mem_no);    
			pstmt.setInt(2, coupon_no);    

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				memCouponVO = new Mem_Coupon_VO();
				memCouponVO.setCoupon_no(rs.getInt("coupon_no"));
				memCouponVO.setMem_no(rs.getInt("mem_no"));
				memCouponVO.setRemain_amount(rs.getInt("Remain_amount"));

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
		return memCouponVO;
	}

	@Override
	public List<Mem_Coupon_VO> getAll() {
		List<Mem_Coupon_VO> list = new ArrayList<Mem_Coupon_VO>();
		Mem_Coupon_VO memCouponVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				memCouponVO = new Mem_Coupon_VO();
				memCouponVO.setCoupon_no(rs.getInt("coupon_no"));
				memCouponVO.setMem_no(rs.getInt("mem_no"));
				memCouponVO.setRemain_amount(rs.getInt("Remain_amount"));

				list.add(memCouponVO); // Store the row in the list
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