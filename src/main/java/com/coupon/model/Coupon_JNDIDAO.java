package com.coupon.model;

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

public class Coupon_JNDIDAO implements Coupon_DAO_interface {

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
			"INSERT INTO coupon (coupon_name, coupon_code, coupon_content,"
			+ " coupon_discount, coupon_amount, launch_time, off_time,"
			+ " coupon_build_time, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT coupon_no, coupon_name, coupon_code, coupon_content,"
			+ " coupon_discount, coupon_amount, launch_time, off_time,"
			+ " coupon_build_time, status FROM coupon order by coupon_no";
		private static final String GET_ONE_STMT = 
			"SELECT coupon_no, coupon_name, coupon_code, coupon_content,"
			+ " coupon_discount, coupon_amount, launch_time, off_time,"
			+ " coupon_build_time, status FROM coupon where coupon_no = ?";
		private static final String DELETE = 
			"DELETE FROM coupon where coupon_no = ?";
		private static final String UPDATE = 
			"UPDATE coupon coupon_name=?, coupon_code=?, coupon_content=?,"
			+ " coupon_discount=?, coupon_amount=?, launch_time=?, off_time=?,"
			+ " coupon_build_time=?, status=? where coupon_no = ?";
	@Override
	public void insert(Coupon_VO couponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, couponVO.getCoupon_name());
			pstmt.setString(2, couponVO.getCoupon_code());
			pstmt.setString(3, couponVO.getCoupon_content());
			pstmt.setDouble(4, couponVO.getCoupon_discount());
			pstmt.setInt(5, couponVO.getCoupon_amount());
			pstmt.setTimestamp(6, couponVO.getLaunch_time());
			pstmt.setTimestamp(7, couponVO.getOff_time());
			pstmt.setTimestamp(8, couponVO.getCoupon_build_time());
			pstmt.setInt(9, couponVO.getStatus());

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
	public void update(Coupon_VO couponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, couponVO.getCoupon_name());
			pstmt.setString(2, couponVO.getCoupon_code());
			pstmt.setString(3, couponVO.getCoupon_content());
			pstmt.setDouble(4, couponVO.getCoupon_discount());
			pstmt.setInt(5, couponVO.getCoupon_amount());
			pstmt.setTimestamp(6, couponVO.getLaunch_time());
			pstmt.setTimestamp(7, couponVO.getOff_time());
			pstmt.setTimestamp(8, couponVO.getCoupon_build_time());
			pstmt.setInt(9, couponVO.getStatus());
			pstmt.setInt(10, couponVO.getCoupon_no());

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
	public void delete(Integer coupon_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, coupon_no);

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
	public Coupon_VO findByPrimaryKey(Integer coupon_no) {

		Coupon_VO couponVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, coupon_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo �]�٬� Domain objects
				couponVO = new Coupon_VO();
				couponVO.setCoupon_no(rs.getInt("coupon_no"));
				couponVO.setCoupon_name(rs.getString("coupon_name"));
				couponVO.setCoupon_code(rs.getString("coupon_code"));
				couponVO.setCoupon_content(rs.getString("coupon_content"));
				couponVO.setCoupon_discount(rs.getDouble("coupon_discount"));
				couponVO.setCoupon_amount(rs.getInt("coupon_amount"));
				couponVO.setLaunch_time(rs.getTimestamp("launch_time"));
				couponVO.setOff_time(rs.getTimestamp("off_time"));
				couponVO.setCoupon_build_time(rs.getTimestamp("coupon_build_time"));
				couponVO.setStatus(rs.getInt("status"));
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
		return couponVO;
	}

	@Override
	public List<Coupon_VO> getAll() {
		List<Coupon_VO> list = new ArrayList<Coupon_VO>();
		Coupon_VO couponVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO �]�٬� Domain objects
				couponVO = new Coupon_VO();
				couponVO.setCoupon_no(rs.getInt("coupon_no"));
				couponVO.setCoupon_name(rs.getString("coupon_name"));
				couponVO.setCoupon_code(rs.getString("coupon_code"));
				couponVO.setCoupon_content(rs.getString("coupon_content"));
				couponVO.setCoupon_discount(rs.getDouble("coupon_discount"));
				couponVO.setCoupon_amount(rs.getInt("coupon_amount"));
				couponVO.setLaunch_time(rs.getTimestamp("launch_time"));
				couponVO.setOff_time(rs.getTimestamp("off_time"));
				couponVO.setCoupon_build_time(rs.getTimestamp("coupon_build_time"));
				couponVO.setStatus(rs.getInt("status"));
				list.add(couponVO); // Store the row in the list
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