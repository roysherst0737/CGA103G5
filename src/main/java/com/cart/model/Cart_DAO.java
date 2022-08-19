package com.cart.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Cart_DAO implements Cart_DAO_interface {
	
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
		"INSERT INTO cart (prod_no,prod_qty,add_time) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT mem_no,prod_no,prod_qty,add_time FROM cart order by mem_no";
	private static final String GET_ONE_STMT = 
		"SELECT mem_no,prod_no,prod_qty,add_time FROM cart where mem_no = ?";
	private static final String DELETE = 
		"DELETE FROM cart where mem_no = ?";
	private static final String UPDATE = 
		"UPDATE cart set prod_no=?, prod_qty=?, add_time=? where mem_no = ?";
	
	@Override
	public void insert(Cart_VO cartVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, cartVO.getProd_no());
			pstmt.setInt(2, cartVO.getProd_qty());
			pstmt.setTimestamp(3, cartVO.getAdd_time());

			pstmt.executeUpdate();
			
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
	public void update(Cart_VO cartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, cartVO.getProd_no());
			pstmt.setInt(2, cartVO.getProd_qty());
			pstmt.setTimestamp(3, cartVO.getAdd_time());
			pstmt.setInt(4, cartVO.getMem_no());

			pstmt.executeUpdate();
			
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
	public void delete(Integer mem_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mem_no);

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
	public Cart_VO findByForeignKey(Integer mem_no) {
		Cart_VO cartVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mem_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				cartVO = new Cart_VO();
				cartVO.setMem_no(rs.getInt("mem_no"));
				cartVO.setProd_no(rs.getInt("prod_no"));
				cartVO.setProd_qty(rs.getInt("prod_qty"));
				cartVO.setAdd_time(rs.getTimestamp("add_time"));
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
		return cartVO;
	}

	@Override
	public List<Cart_VO> getAll() {
		List<Cart_VO> list = new ArrayList<Cart_VO>();
		Cart_VO cartVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				cartVO = new Cart_VO();
				cartVO.setMem_no(rs.getInt("mem_no"));
				cartVO.setProd_no(rs.getInt("prod_no"));
				cartVO.setProd_qty(rs.getInt("prod_qty"));
				cartVO.setAdd_time(rs.getTimestamp("add_time"));
				
				list.add(cartVO); // Store the row in the list
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
