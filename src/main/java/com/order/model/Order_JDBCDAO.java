package com.order.model;

import static com.util.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order_JDBCDAO implements Order_DAO_interface {
	
	private static final String INSERT_STMT = 
		"INSERT INTO `order` (mem_no,coupon_no,sold_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,tracking_no,receiver_name,receiver_address,receiver_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT order_no,mem_no,coupon_no,order_time,sold_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,tracking_no,receiver_name,receiver_address,receiver_phone FROM `order` order by order_no";
	private static final String GET_ONE_STMT = 
		"SELECT order_no,mem_no,coupon_no,order_time,sold_time,order_price_total,dis_price_total,order_status,payment_method,pickup_method,shipping_fee,tracking_no,receiver_name,receiver_address,receiver_phone FROM `order` where order_no = ?";
	private static final String DELETE = 
		"DELETE FROM `order` where order_no = ?";
	private static final String UPDATE = 
		"UPDATE `order` set mem_no=?, coupon_no=?, order_time=?, sold_time=?, order_price_total=?, dis_price_total=?, order_status=?, payment_method=?, pickup_method=?, shipping_fee=?, tracking_no=?, receiver_name=?, receiver_address=?, receiver_phone=? where order_no = ?";
	
	@Override
	public void insert(Order_VO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, orderVO.getMem_no());
			pstmt.setInt(2, orderVO.getCoupon_no());
			pstmt.setTimestamp(3, orderVO.getSold_time());
			pstmt.setInt(4, orderVO.getOrder_price_total());
			pstmt.setInt(5, orderVO.getDis_price_total());
			pstmt.setInt(6, orderVO.getOrder_status());
			pstmt.setInt(7, orderVO.getPayment_method());
			pstmt.setInt(8, orderVO.getPickup_method());
			pstmt.setInt(9, orderVO.getShipping_fee());
			pstmt.setInt(10, orderVO.getTracking_no());
			pstmt.setString(11, orderVO.getReceiver_name());
			pstmt.setString(12, orderVO.getReceiver_address());
			pstmt.setString(13, orderVO.getReceiver_phone());

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
	public void update(Order_VO orderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
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
			pstmt.setInt(15, orderVO.getOrder_no());

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
	public void delete(Integer order_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, order_no);

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
	public Order_VO findByPrimaryKey(Integer order_no) {
		Order_VO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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
				
				list.add(orderVO); // Store the row in the list
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

		Order_JDBCDAO dao = new Order_JDBCDAO();

		// 新增
		Order_VO orderVO1 = new Order_VO();
		orderVO1.setMem_no(3);
		orderVO1.setCoupon_no(2);
		orderVO1.setSold_time(java.sql.Timestamp.valueOf("2022-08-08 08:08:08"));
		orderVO1.setOrder_price_total(10000);
		orderVO1.setDis_price_total(8888);
		orderVO1.setOrder_status(0);
		orderVO1.setPayment_method(1);
		orderVO1.setPickup_method(2);
		orderVO1.setShipping_fee(0);
		orderVO1.setTracking_no(12345678);
		orderVO1.setReceiver_name("吳小志");
		orderVO1.setReceiver_address("你心裡");
		orderVO1.setReceiver_phone("091234567");
		dao.insert(orderVO1);

		// 修改
		Order_VO orderVO2 = new Order_VO();
		orderVO2.setOrder_no(4);
		orderVO2.setMem_no(1002);
		orderVO2.setCoupon_no(2987);
		orderVO2.setOrder_time(java.sql.Timestamp.valueOf("2022-10-10 08:08:08"));
		orderVO2.setSold_time(java.sql.Timestamp.valueOf("2022-10-10 08:08:08"));
		orderVO2.setOrder_price_total(5000);
		orderVO2.setDis_price_total(888);
		orderVO2.setOrder_status(1);
		orderVO2.setPayment_method(2);
		orderVO2.setPickup_method(0);
		orderVO2.setShipping_fee(1);
		orderVO2.setTracking_no(5678123);
		orderVO2.setReceiver_name("有大志");
		orderVO2.setReceiver_address("大家的心裡");
		orderVO2.setReceiver_phone("097654321");
		dao.update(orderVO2);

		// 刪除
		dao.delete(6);
		

		// 查詢
		Order_VO orderVO3 = dao.findByPrimaryKey(1);
		System.out.print(orderVO3.getOrder_no() + ",");
		System.out.print(orderVO3.getMem_no() + ",");
		System.out.print(orderVO3.getCoupon_no() + ",");
		System.out.print(orderVO3.getOrder_time() + ",");
		System.out.print(orderVO3.getSold_time() + ",");
		System.out.print(orderVO3.getOrder_price_total() + ",");
		System.out.print(orderVO3.getDis_price_total() + ",");
		System.out.print(orderVO3.getOrder_status() + ",");
		System.out.print(orderVO3.getPayment_method() + ",");
		System.out.print(orderVO3.getPickup_method() + ",");
		System.out.print(orderVO3.getShipping_fee() + ",");
		System.out.print(orderVO3.getTracking_no() + ",");
		System.out.print(orderVO3.getReceiver_name() + ",");
		System.out.print(orderVO3.getReceiver_address() + ",");
		System.out.print(orderVO3.getReceiver_phone() + ",");
		System.out.println();
		System.out.println("-------------------------------------------");

		// 查詢
		List<Order_VO> list = dao.getAll();
		for (Order_VO allOrder : list) {
			System.out.print(allOrder.getOrder_no() + ",");
			System.out.print(allOrder.getMem_no() + ",");
			System.out.print(allOrder.getCoupon_no() + ",");
			System.out.print(allOrder.getOrder_time() + ",");
			System.out.print(allOrder.getSold_time() + ",");
			System.out.print(allOrder.getOrder_price_total() + ",");
			System.out.print(allOrder.getDis_price_total() + ",");
			System.out.print(allOrder.getOrder_status() + ",");
			System.out.print(allOrder.getPayment_method() + ",");
			System.out.print(allOrder.getPickup_method() + ",");
			System.out.print(allOrder.getShipping_fee() + ",");
			System.out.print(allOrder.getTracking_no() + ",");
			System.out.print(allOrder.getReceiver_name() + ",");
			System.out.print(allOrder.getReceiver_address() + ",");
			System.out.print(allOrder.getReceiver_phone() + ",");
			System.out.println();
		}
	}
}