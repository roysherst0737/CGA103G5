package com.order_detail.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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

public class Order_detail_JNDIDAO implements Order_detail_DAO_interface{
	
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, order_detailVO.getOrder_no());
			pstmt.setInt(2, order_detailVO.getProd_no());
			pstmt.setInt(3, order_detailVO.getProd_qty());
			pstmt.setInt(4, order_detailVO.getProd_price());
			pstmt.setInt(5, order_detailVO.getMem_no());
			pstmt.setTimestamp(6, order_detailVO.getComment_time());
			pstmt.setInt(7, order_detailVO.getComment_star());
			pstmt.setString(8, order_detailVO.getComment_content());
			InputStream is = getPictureStream("jigger1.jpg");
			pstmt.setBlob(9, is);

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
	public void update(Order_detail_VO order_detailVO) throws IOException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, order_detailVO.getProd_qty());
			pstmt.setInt(2, order_detailVO.getProd_price());
			pstmt.setInt(3, order_detailVO.getMem_no());
			pstmt.setTimestamp(4, order_detailVO.getComment_time());
			pstmt.setInt(5, order_detailVO.getComment_star());
			pstmt.setString(6, order_detailVO.getComment_content());
			InputStream is = getPictureStream("Familia_Torres1.png");
			pstmt.setBlob(7, is);
			pstmt.setInt(8, order_detailVO.getOrder_no());
			pstmt.setInt(9, order_detailVO.getProd_no());

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
	public void delete(Integer order_no, Integer prod_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, order_no);
			pstmt.setInt(2, prod_no);

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
	public Order_detail_VO findByPrimaryKey(Integer order_no) {
		Order_detail_VO order_detailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
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

			con = ds.getConnection();
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
