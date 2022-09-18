package com.order.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.order_detail.model.Order_detail_VO;

public class Order_DAO implements Order_DAO_interface{
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
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
		"INSERT INTO `order` (mem_no,coupon_no,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,receiver_name,receiver_address,receiver_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT order_no,mem_no,coupon_no,order_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,receiver_name,receiver_address,receiver_phone FROM `order` order by order_no";
	private static final String GET_ONE_STMT = 
		"SELECT order_no,mem_no,coupon_no,order_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,receiver_name,receiver_address,receiver_phone FROM `order` where order_no = ?";
	private static final String DELETE = 
		"DELETE FROM `order` where order_no = ?";
	private static final String UPDATE = 
		"UPDATE `order` set mem_no=?, coupon_no=?, order_time=?, order_price_total=?, dis_price_total=?, order_status=?, payment_method=?, pickup_method=?, shipping_fee=?, receiver_name=?, receiver_address=?, receiver_phone=? where order_no = ?";
	
	private static final String GET_Order_details_ByOrder_STMT = "SELECT order_no,prod_no,prod_qty,prod_price,mem_no FROM order_detail where order_no = ? order by order_no";
	
	@Override
	public void insert(Order_VO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, orderVO.getMem_no());
			pstmt.setInt(2, orderVO.getCoupon_no());
			pstmt.setInt(3, orderVO.getOrder_price_total());
			pstmt.setInt(4, orderVO.getDis_price_total());
			pstmt.setInt(5, orderVO.getOrder_status());
			pstmt.setInt(6, orderVO.getPayment_method());
			pstmt.setInt(7, orderVO.getPickup_method());
			pstmt.setInt(8, orderVO.getShipping_fee());
			pstmt.setString(9, orderVO.getReceiver_name());
			pstmt.setString(10, orderVO.getReceiver_address());
			pstmt.setString(11, orderVO.getReceiver_phone());

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


				pstmt.setInt(1, orderVO.getMem_no());
				pstmt.setInt(2, orderVO.getCoupon_no());
				pstmt.setTimestamp(3, orderVO.getOrder_time());
				pstmt.setInt(4, orderVO.getOrder_price_total());
				pstmt.setInt(5, orderVO.getDis_price_total());
				pstmt.setInt(6, orderVO.getOrder_status());
				pstmt.setInt(7, orderVO.getPayment_method());
				pstmt.setInt(8, orderVO.getPickup_method());
				pstmt.setInt(9, orderVO.getShipping_fee());
				pstmt.setString(10, orderVO.getReceiver_name());
				pstmt.setString(11, orderVO.getReceiver_address());
				pstmt.setString(12, orderVO.getReceiver_phone());
				pstmt.setInt(13, orderVO.getOrder_no());

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
				orderVO.setOrder_price_total(rs.getInt("order_price_total"));
				orderVO.setDis_price_total(rs.getInt("dis_price_total"));
				orderVO.setOrder_status(rs.getInt("order_status"));
				orderVO.setPayment_method(rs.getInt("payment_method"));
				orderVO.setPickup_method(rs.getInt("pickup_method"));
				orderVO.setShipping_fee(rs.getInt("shipping_fee"));
				orderVO.setReceiver_name(rs.getString("receiver_name"));
				orderVO.setReceiver_address(rs.getString("receiver_address"));
				orderVO.setReceiver_phone(rs.getString("receiver_phone"));
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
				orderVO.setOrder_price_total(rs.getInt("order_price_total"));
				orderVO.setDis_price_total(rs.getInt("dis_price_total"));
				orderVO.setOrder_status(rs.getInt("order_status"));
				orderVO.setPayment_method(rs.getInt("payment_method"));
				orderVO.setPickup_method(rs.getInt("pickup_method"));
				orderVO.setShipping_fee(rs.getInt("shipping_fee"));
				orderVO.setReceiver_name(rs.getString("receiver_name"));
				orderVO.setReceiver_address(rs.getString("receiver_address"));
				orderVO.setReceiver_phone(rs.getString("receiver_phone"));
				
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
	
	@Override
	public Set<Order_detail_VO> getOrder_detailsByOrder(Integer order_no) {
		Set<Order_detail_VO> set = new LinkedHashSet<Order_detail_VO>();
		Order_detail_VO order_detailVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
	
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_Order_details_ByOrder_STMT);
			pstmt.setInt(1, order_no);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				order_detailVO = new Order_detail_VO();
				order_detailVO.setOrder_no(rs.getInt("order_no"));
				order_detailVO.setProd_no(rs.getInt("prod_no"));
				order_detailVO.setProd_qty(rs.getInt("prod_qty"));
				order_detailVO.setProd_price(rs.getInt("prod_price"));
				order_detailVO.setMem_no(rs.getInt("mem_no"));
				set.add(order_detailVO); // Store the row in the vector
			}
	
			// Handle any SQL errors
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
		return set;
	}
}