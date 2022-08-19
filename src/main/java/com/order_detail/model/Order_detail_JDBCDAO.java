package com.order_detail.model;

import static com.util.Common.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Order_detail_JDBCDAO implements Order_detail_DAO_interface{
	
	private static final String INSERT_STMT = 
		"INSERT INTO order_detail (order_no,prod_no,prod_qty,prod_price,mem_no,comment_time,comment_star,comment_content,comment_pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT order_no,prod_no,prod_qty,prod_price,mem_no,comment_time,comment_star,comment_content,comment_pic FROM order_detail order by order_no";
	private static final String GET_ONE_STMT = 
		"SELECT order_no,prod_no,prod_qty,prod_price,mem_no,comment_time,comment_star,comment_content,comment_pic FROM order_detail where order_no = ?";
	private static final String DELETE = 
		"DELETE FROM order_detail where order_no = ? AND prod_no = ?";
	private static final String UPDATE = 
		"UPDATE order_detail set prod_qty=?, prod_price=?, mem_no=?, comment_time=?, comment_star=?, comment_content=?, comment_pic=? where order_no = ? AND prod_no=?";
	
	public static InputStream getPictureStream(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		return fis;
	}

	@Override
	public void insert(Order_detail_VO order_detailVO) throws IOException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, order_detailVO.getOrder_no());
			pstmt.setInt(2, order_detailVO.getProd_no());
			pstmt.setInt(3, order_detailVO.getProd_qty());
			pstmt.setInt(4, order_detailVO.getProd_price());
			pstmt.setInt(5, order_detailVO.getMem_no());
			pstmt.setTimestamp(6, order_detailVO.getComment_time());
			pstmt.setInt(7, order_detailVO.getComment_star());
			pstmt.setString(8, order_detailVO.getComment_content());
			InputStream is = getPictureStream("src/main/webapp/back-end/cart/images/jigger1.jpg");
			pstmt.setBlob(9, is);

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
	public void update(Order_detail_VO order_detailVO) throws IOException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, order_detailVO.getProd_qty());
			pstmt.setInt(2, order_detailVO.getProd_price());
			pstmt.setInt(3, order_detailVO.getMem_no());
			pstmt.setTimestamp(4, order_detailVO.getComment_time());
			pstmt.setInt(5, order_detailVO.getComment_star());
			pstmt.setString(6, order_detailVO.getComment_content());
			InputStream is = getPictureStream("src/main/webapp/back-end/cart/images/Familia_Torres1.png");
			pstmt.setBlob(7, is);
			pstmt.setInt(8, order_detailVO.getOrder_no());
			pstmt.setInt(9, order_detailVO.getProd_no());

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
	public void delete(Integer order_no, Integer prod_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, order_no);
			pstmt.setInt(2, prod_no);

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
	public Order_detail_VO findByPrimaryKey(Integer order_no) {
		Order_detail_VO order_detailVO = null;
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

				order_detailVO = new Order_detail_VO();
				order_detailVO.setOrder_no(rs.getInt("order_no"));
				order_detailVO.setProd_no(rs.getInt("prod_no"));
				order_detailVO.setProd_qty(rs.getInt("prod_qty"));
				order_detailVO.setProd_price(rs.getInt("prod_price"));
				order_detailVO.setMem_no(rs.getInt("mem_no"));
				order_detailVO.setComment_time(rs.getTimestamp("comment_time"));
				order_detailVO.setComment_star(rs.getInt("comment_star"));
				order_detailVO.setComment_content(rs.getString("comment_content"));
				order_detailVO.setComment_pic(rs.getBlob("comment_pic"));
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
		return order_detailVO;
	}
	
	@Override
	public List<Order_detail_VO> getAll() {
		List<Order_detail_VO> list = new ArrayList<Order_detail_VO>();
		Order_detail_VO order_detailVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				order_detailVO = new Order_detail_VO();
				order_detailVO.setOrder_no(rs.getInt("order_no"));
				order_detailVO.setProd_no(rs.getInt("prod_no"));
				order_detailVO.setProd_qty(rs.getInt("prod_qty"));
				order_detailVO.setProd_price(rs.getInt("prod_price"));
				order_detailVO.setMem_no(rs.getInt("mem_no"));
				order_detailVO.setComment_time(rs.getTimestamp("comment_time"));
				order_detailVO.setComment_star(rs.getInt("comment_star"));
				order_detailVO.setComment_content(rs.getString("comment_content"));
				order_detailVO.setComment_pic(rs.getBlob("comment_pic"));
				
				list.add(order_detailVO); // Store the row in the list
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
	
	public static void main(String[] args) throws IOException {

		Order_detail_JDBCDAO dao = new Order_detail_JDBCDAO();

		// 新增
		Order_detail_VO order_detailVO1 = new Order_detail_VO();
		order_detailVO1.setOrder_no(7);
		order_detailVO1.setProd_no(7);
		order_detailVO1.setProd_qty(50);
		order_detailVO1.setProd_price(50000);
		order_detailVO1.setMem_no(100289);
		order_detailVO1.setComment_time(java.sql.Timestamp.valueOf("2022-01-01 10:10:10"));
		order_detailVO1.setComment_star(5);
		order_detailVO1.setComment_content("我就是土豪可以花錢不手軟，咬我啊！");
		order_detailVO1.setComment_pic(null);
		dao.insert(order_detailVO1);

		// 修改
		Order_detail_VO order_detailVO2 = new Order_detail_VO();
		order_detailVO2.setOrder_no(1);
		order_detailVO2.setProd_no(1);
		order_detailVO2.setProd_qty(50);
		order_detailVO2.setProd_price(50000);
		order_detailVO2.setMem_no(100289);
		order_detailVO2.setComment_time(java.sql.Timestamp.valueOf("2022-01-01 10:10:10"));
		order_detailVO2.setComment_star(5);
		order_detailVO2.setComment_content("我就是土豪可以花錢不手軟，咬我啊！");
		order_detailVO2.setComment_pic(null);
		dao.update(order_detailVO2);

		// 刪除
		dao.delete(4, 4);
		

		// 查詢
		Order_detail_VO order_detailVO3 = dao.findByPrimaryKey(3);
		System.out.print(order_detailVO3.getOrder_no() + ",");
		System.out.print(order_detailVO3.getProd_no() + ",");
		System.out.print(order_detailVO3.getProd_qty() + ",");
		System.out.print(order_detailVO3.getProd_price() + ",");
		System.out.print(order_detailVO3.getMem_no() + ",");
		System.out.print(order_detailVO3.getComment_time() + ",");
		System.out.print(order_detailVO3.getComment_star() + ",");
		System.out.print(order_detailVO3.getComment_content() + ",");
		System.out.print(order_detailVO3.getComment_pic() + ",");
		System.out.println();
		System.out.println("-----------------------------------------");

		// 查詢
		List<Order_detail_VO> list = dao.getAll();
		for (Order_detail_VO allOrder_detail : list) {
			System.out.print(allOrder_detail.getOrder_no() + ",");
			System.out.print(allOrder_detail.getProd_no() + ",");
			System.out.print(allOrder_detail.getProd_qty() + ",");
			System.out.print(allOrder_detail.getProd_price() + ",");
			System.out.print(allOrder_detail.getMem_no() + ",");
			System.out.print(allOrder_detail.getComment_time() + ",");
			System.out.print(allOrder_detail.getComment_star() + ",");
			System.out.print(allOrder_detail.getComment_content() + ",");
			System.out.print(allOrder_detail.getComment_pic() + ",");
			System.out.println();
		}
	}
}
