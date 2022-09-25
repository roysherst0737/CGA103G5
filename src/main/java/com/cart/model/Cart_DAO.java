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
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String INSERT_STMT = 
		"INSERT INTO cart (mem_no,prod_no,prod_qty) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT mem_no,prod_no,prod_qty FROM cart order by mem_no";
	private static final String GET_ONE_STMT = 
		"SELECT mem_no,prod_no,prod_qty FROM cart where mem_no = ?";
	private static final String DELETE_ALL = 
		"DELETE FROM cart where mem_no = ?";
	private static final String UPDATE = 
		"UPDATE cart set  prod_qty=? where mem_no = ? and prod_no=?";
	
	private static final String GET_ADD_TO_CART = "SELECT prod_no FROM cart where mem_no = ?";
	private static final String CART_MINUS = "SELECT prod_no FROM cart where mem_no = ?";
	
	private static final String DELETE_PROD = "DELETE FROM cart where prod_no = ?";
	
	private static final String SELECT_BY_MEM_and_PROD = "SELECT *  FROM cart where mem_no = ? AND prod_no = ?";
	
	@Override
	public void insert(Cart_VO cartVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, cartVO.getMem_no());
			pstmt.setInt(2, cartVO.getProd_no());
			pstmt.setInt(3, cartVO.getProd_qty());

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
			
			pstmt.setInt(3, cartVO.getProd_no());
			pstmt.setInt(1, cartVO.getProd_qty());
			pstmt.setInt(2, cartVO.getMem_no());

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
	public void deleteAll(Integer mem_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_ALL);

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
	public void deleteProd(Integer prod_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE_PROD);

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
	
	@Override
	public Set<Integer> getAdd_to_Cart(Integer mem_no) {
		Set<Integer> set = new HashSet<Integer>();
		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ADD_TO_CART);
			pstmt.setInt(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				set.add(rs.getInt("prod_no")); 
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return set;
	}

	@Override
	public Cart_VO selectByMem_noAndProd_no(Integer mem_no, Integer prod_no) {
		
		Cart_VO cartVO =  new Cart_VO();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(SELECT_BY_MEM_and_PROD);
			pstmt.setInt(1, mem_no);
			pstmt.setInt(2, prod_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				cartVO.setMem_no(rs.getInt("mem_no"));
				cartVO.setProd_no(rs.getInt("prod_no"));
				cartVO.setProd_qty(rs.getInt("prod_qty"));
				
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
	public Set<Integer> getCart_Minus(Integer mem_no) {
		Set<Integer> set = new HashSet<Integer>();		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(CART_MINUS);
			pstmt.setInt(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				set.add(rs.getInt("prod_no")); 
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return set;
	}
}