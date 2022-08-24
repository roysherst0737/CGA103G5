package com.cart.model;

import static com.util.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cart_JDBCDAO implements Cart_DAO_interface{
	
	private static final String INSERT_STMT = 
		"INSERT INTO cart (mem_no,prod_no,prod_qty) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT mem_no,prod_no,prod_qty FROM cart order by mem_no";
	private static final String GET_ONE_STMT = 
		"SELECT mem_no,prod_no,prod_qty FROM cart where mem_no = ?";
	private static final String DELETE = 
		"DELETE FROM cart where mem_no = ?";
	private static final String UPDATE = 
		"UPDATE cart set prod_no=?, prod_qty=? where mem_no = ?";

	@Override
	public void insert(Cart_VO cartVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setInt(1, cartVO.getMem_no());
			pstmt.setInt(2, cartVO.getProd_no());
			pstmt.setInt(3, cartVO.getProd_qty());

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
	public void update(Cart_VO cartVO) {
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setInt(1, cartVO.getProd_no());
			pstmt.setInt(2, cartVO.getProd_qty());
			pstmt.setInt(3, cartVO.getMem_no());

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
	public void delete(Integer mem_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, mem_no);

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
	public Cart_VO findByForeignKey(Integer mem_no) {
		Cart_VO cartVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
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

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				cartVO = new Cart_VO();
				cartVO.setMem_no(rs.getInt("mem_no"));
				cartVO.setProd_no(rs.getInt("prod_no"));
				cartVO.setProd_qty(rs.getInt("prod_qty"));
				
				list.add(cartVO); // Store the row in the list
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

		Cart_JDBCDAO dao = new Cart_JDBCDAO();

		// 新增
		Cart_VO cartVO1 = new Cart_VO();
		cartVO1.setMem_no(2);
		cartVO1.setProd_no(2);
		cartVO1.setProd_qty(5);
		dao.insert(cartVO1);

		// 修改
		Cart_VO cartVO2 = new Cart_VO();
		cartVO1.setMem_no(1);
		cartVO1.setProd_no(1002);
		cartVO1.setProd_qty(10);
		dao.update(cartVO2);

		// 刪除
		dao.delete(2);
		
		// 查詢
		Cart_VO cartVO3 = dao.findByForeignKey(1);
		System.out.print(cartVO3.getMem_no() + ",");
		System.out.print(cartVO3.getProd_no() + ",");
		System.out.print(cartVO3.getProd_qty() + ",");
		System.out.println("---------------------");

		// 查詢
		List<Cart_VO> list = dao.getAll();
		for (Cart_VO allCart : list) {
			System.out.print(allCart.getMem_no() + ",");
			System.out.print(allCart.getProd_no() + ",");
			System.out.print(allCart.getProd_qty() + ",");
			System.out.println();
		}
	}
}