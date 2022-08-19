package com.order.model;

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

public class Order_JNDIDAO implements Order_DAO_interface{
	
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
		"INSERT INTO `order` (mem_no,coupon_no,order_time,sold_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,tracking_no,receiver_name,receiver_address,receiver_phone,pickup_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT order_no,mem_no,coupon_no,order_time,sold_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,tracking_no,receiver_name,receiver_address,receiver_phone,pickup_time FROM `order` order by order_no";
	private static final String GET_ONE_STMT = 
		"SELECT order_no,mem_no,coupon_no,order_time,sold_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,tracking_no,receiver_name,receiver_address,receiver_phone,pickup_time FROM `order` where order_no = ?";
	private static final String DELETE = 
		"DELETE FROM `order` where order_no = ?";
	private static final String UPDATE = 
		"UPDATE `order` set order_no=?, mem_no=?, coupon_no=?, order_time=?, sold_time=?, order_price_total=?, dis_price_total=?, order_status=?, payment_method=?, pickup_method=?, shipping_fee=?, tracking_no=?, receiver_name=?, receiver_address=?, receiver_phone=?, pickup_time=? where order_no = ?";

	@Override
	public void insert(Order_VO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, orderVO.getMem_no());
			pstmt.setInt(2, orderVO.getCoupon_no());
			pstmt.setTimestamp(3, orderVO.getOrder_time());
			pstmt.setTimestamp(4, orderVO.getSold_time());
			pstmt.setInt(5, orderVO.getOrder_price_total());
			pstmt.setInt(6, orderVO.getDis_price_total());
			pstmt.setInt(7, orderVO.getOrder_status());
			pstmt.setInt(8, orderVO.getPayment_method());
			pstmt.setInt(9, orderVO.getPickup_method());
			pstmt.setInt(10, orderVO.getShipping_fee());
			pstmt.setInt(11, orderVO.getTracking_no());
			pstmt.setString(12, orderVO.getReceiver_name());
			pstmt.setString(13, orderVO.getReceiver_address());
			pstmt.setString(14, orderVO.getReceiver_phone());
			pstmt.setTimestamp(15, orderVO.getPickup_time());

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
	public void update(Order_VO orderVO) {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, orderVO.getOrder_no());
				pstmt.setInt(2, orderVO.getMem_no());
				pstmt.setInt(3, orderVO.getCoupon_no());
				pstmt.setTimestamp(4, orderVO.getOrder_time());
				pstmt.setTimestamp(5, orderVO.getSold_time());
				pstmt.setInt(6, orderVO.getOrder_price_total());
				pstmt.setInt(7, orderVO.getDis_price_total());
				pstmt.setInt(8, orderVO.getOrder_status());
				pstmt.setInt(9, orderVO.getPayment_method());
				pstmt.setInt(10, orderVO.getPickup_method());
				pstmt.setInt(11, orderVO.getShipping_fee());
				pstmt.setInt(12, orderVO.getTracking_no());
				pstmt.setString(13, orderVO.getReceiver_name());
				pstmt.setString(14, orderVO.getReceiver_address());
				pstmt.setString(15, orderVO.getReceiver_phone());
				pstmt.setTimestamp(16, orderVO.getPickup_time());

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
	public void delete(Integer order_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, order_no);

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
	public Order_VO findByPrimaryKey(Integer order_no) {
		Order_VO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, order_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				orderVO = new Order_VO();
				orderVO.setOrder_no(rs.getInt("order_no"));
				orderVO.setMem_no(rs.getInt("mem_no"));
				orderVO.setCoupon_no(rs.getInt("coupon_no"));
				orderVO.setOrder_time(rs.getTimestamp("order_time"));
				orderVO.setSold_time(rs.getTimestamp("sold_time"));
				orderVO.setOrder_price_total(rs.getInt("order_price_total"));
				orderVO.setDis_price_total(rs.getInt("dis_price_total"));
				orderVO.setOrder_status(rs.getInt("order_status"));
				orderVO.setPayment_method(rs.getInt("payment_method"));
				orderVO.setPickup_method(rs.getInt("pickup_method"));
				orderVO.setShipping_fee(rs.getInt("shipping_fee"));
				orderVO.setTracking_no(rs.getInt("tracking_no"));
				orderVO.setReceiver_name(rs.getString("receiver_name"));
				orderVO.setReceiver_address(rs.getString("receiver_address"));
				orderVO.setReceiver_phone(rs.getString("receiver_phone"));
				orderVO.setPickup_time(rs.getTimestamp("pickup_time"));
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
		return orderVO;
	}

	@Override
	public List<Order_VO> getAll() {
		List<Order_VO> list = new ArrayList<Order_VO>();
		Order_VO orderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				orderVO = new Order_VO();
				orderVO.setOrder_no(rs.getInt("order_no"));
				orderVO.setMem_no(rs.getInt("mem_no"));
				orderVO.setCoupon_no(rs.getInt("coupon_no"));
				orderVO.setOrder_time(rs.getTimestamp("order_time"));
				orderVO.setSold_time(rs.getTimestamp("sold_time"));
				orderVO.setOrder_price_total(rs.getInt("order_price_total"));
				orderVO.setDis_price_total(rs.getInt("dis_price_total"));
				orderVO.setOrder_status(rs.getInt("order_status"));
				orderVO.setPayment_method(rs.getInt("payment_method"));
				orderVO.setPickup_method(rs.getInt("pickup_method"));
				orderVO.setShipping_fee(rs.getInt("shipping_fee"));
				orderVO.setTracking_no(rs.getInt("tracking_no"));
				orderVO.setReceiver_name(rs.getString("receiver_name"));
				orderVO.setReceiver_address(rs.getString("receiver_address"));
				orderVO.setReceiver_phone(rs.getString("receiver_phone"));
				orderVO.setPickup_time(rs.getTimestamp("pickup_time"));
				
				list.add(orderVO); // Store the row in the list
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
