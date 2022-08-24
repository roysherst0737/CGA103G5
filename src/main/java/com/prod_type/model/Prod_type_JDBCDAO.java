package com.prod_type.model;

import static com.util.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prod_type_JDBCDAO implements Prod_type_DAO_interface {

	private static final String INSERT_STMT = 
		"INSERT INTO prod_type (prod_type_name) VALUES (?)";
	private static final String GET_ALL_STMT = 
		"SELECT prod_type_no,prod_type_name FROM prod_type order by prod_type_no";
	private static final String GET_ONE_STMT = 
		"SELECT prod_type_no,prod_type_name FROM prod_type where prod_type_no = ?";
	private static final String DELETE = 
		"DELETE FROM prod_type where prod_type_no = ?";
	private static final String UPDATE = 
		"UPDATE prod_type set prod_type_name = ? where prod_type_no = ?";
	
	@Override
	public void insert(Prod_type_VO prod_typeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt.setString(1, prod_typeVO.getProd_type_name());

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
	public void update(Prod_type_VO prod_typeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, prod_typeVO.getProd_type_name());
			pstmt.setInt(2, prod_typeVO.getProd_type_no());
			
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
	public void delete(Integer prod_type_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, prod_type_no);

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
	public Prod_type_VO findByPrimaryKey(Integer prod_type_no) {
		Prod_type_VO prod_typeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			rs = pstmt.executeQuery();

			while (rs.next()) {
				prod_typeVO = new Prod_type_VO();
				prod_typeVO.setProd_type_no(rs.getInt("prod_type_no"));
				prod_typeVO.setProd_type_name(rs.getString("prod_type_name"));
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
		return prod_typeVO;
	}			


	@Override
	public List<Prod_type_VO> getAll() {
		List<Prod_type_VO> list = new ArrayList<Prod_type_VO>();
		Prod_type_VO prod_typeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				prod_typeVO = new Prod_type_VO();
				prod_typeVO.setProd_type_no(rs.getInt("prod_type_no"));
				prod_typeVO.setProd_type_name(rs.getString("prod_type_name"));
				
				list.add(prod_typeVO); // Store the row in the list
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

		Prod_type_JDBCDAO dao = new Prod_type_JDBCDAO();

		// 新增
		Prod_type_VO prod_typeVO1 = new Prod_type_VO();
		prod_typeVO1.setProd_type_name("調酒材料");
		dao.insert(prod_typeVO1);

		// 修改
		Prod_type_VO prod_typeVO2 = new Prod_type_VO();
		prod_typeVO2.setProd_type_no(6);
		prod_typeVO2.setProd_type_name(null);
		dao.update(prod_typeVO2);

		// 刪除
		dao.delete(4);
		

		// 查詢
		Prod_type_VO prod_typeVO3 = dao.findByPrimaryKey(1);
		System.out.print(prod_typeVO3.getProd_type_no() + ",");
		System.out.print(prod_typeVO3.getProd_type_name() + ",");
		System.out.println();
		System.out.println("-----------------------------------------");

		// 查詢
		List<Prod_type_VO> list = dao.getAll();
		for (Prod_type_VO allProd_type : list) {
			System.out.print(allProd_type.getProd_type_no() + ",");
			System.out.print(allProd_type.getProd_type_name() + ",");
			System.out.println();
		}
	}
}