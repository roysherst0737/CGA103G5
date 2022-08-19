package com.prod.model;

import static com.util.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Prod_JDBCDAO implements Prod_DAO_interface{
	
	private static final String INSERT_STMT = 
		"INSERT INTO prod (prod_type,prod_name,prod_price,prod_status,launch_time,off_time,prod_stock,prod_detail) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT prod_no,prod_type,prod_name,prod_price,prod_status,launch_time,off_time,prod_stock,prod_detail FROM prod order by prod_no";
	private static final String GET_ONE_STMT = 
		"SELECT prod_no,prod_type,prod_name,prod_price,prod_status,launch_time,off_time,prod_stock,prod_detail FROM prod where prod_no = ?";
	private static final String DELETE = 
		"DELETE FROM prod where prod_no = ?";
	private static final String UPDATE = 
		"UPDATE prod set prod_type=?, prod_name=?, prod_price=?, prod_status=?, launch_time=?, off_time=?, prod_stock=?, prod_detail=? where prod_no = ?";

	@Override
	public void insert(Prod_VO prodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setString(1, prodVO.getProd_type());
			pstmt.setString(2, prodVO.getProd_name());
			pstmt.setInt(3, prodVO.getProd_price());
			pstmt.setInt(4, prodVO.getProd_status());
			pstmt.setTimestamp(5, prodVO.getLaunch_time());
			pstmt.setTimestamp(6, prodVO.getOff_time());
			pstmt.setInt(7, prodVO.getProd_stock());
			pstmt.setString(8, prodVO.getProd_detail());

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
	public void update(Prod_VO prodVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, prodVO.getProd_type());
			pstmt.setString(2, prodVO.getProd_name());
			pstmt.setInt(3, prodVO.getProd_price());
			pstmt.setInt(4, prodVO.getProd_status());
			pstmt.setTimestamp(5, prodVO.getLaunch_time());
			pstmt.setTimestamp(6, prodVO.getOff_time());
			pstmt.setInt(7, prodVO.getProd_stock());
			pstmt.setString(8, prodVO.getProd_detail());
			pstmt.setInt(9, prodVO.getProd_no());

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
	public void delete(Integer prod_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(DELETE);
			
			pstmt.setInt(1, prod_no);

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
	public Prod_VO findByPrimaryKey(Integer prod_no) {
		Prod_VO prodVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ONE_STMT);
			
			pstmt.setInt(1, prod_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				prodVO = new Prod_VO();
				prodVO.setProd_no(rs.getInt("prod_no"));
				prodVO.setProd_type(rs.getString("prod_type"));
				prodVO.setProd_name(rs.getString("prod_name"));
				prodVO.setProd_price(rs.getInt("prod_price"));
				prodVO.setProd_status(rs.getInt("prod_status"));
				prodVO.setLaunch_time(rs.getTimestamp("launch_time"));
				prodVO.setOff_time(rs.getTimestamp("off_time"));
				prodVO.setProd_stock(rs.getInt("prod_stock"));
				prodVO.setProd_detail(rs.getString("prod_detail"));
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
		return prodVO;
	}

	@Override
	public List<Prod_VO> getAll() {
		List<Prod_VO> list = new ArrayList<Prod_VO>();
		Prod_VO prodVO = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();		

			while (rs.next()) {

				prodVO = new Prod_VO();
				prodVO.setProd_no(rs.getInt("prod_no"));
				prodVO.setProd_type(rs.getString("prod_type"));
				prodVO.setProd_name(rs.getString("prod_name"));
				prodVO.setProd_price(rs.getInt("prod_price"));
				prodVO.setProd_status(rs.getInt("prod_status"));
				prodVO.setLaunch_time(rs.getTimestamp("launch_time"));
				prodVO.setOff_time(rs.getTimestamp("off_time"));
				prodVO.setProd_stock(rs.getInt("prod_stock"));
				prodVO.setProd_detail(rs.getString("prod_detail"));
				
				list.add(prodVO); // Store the row in the list
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

		Prod_JDBCDAO dao = new Prod_JDBCDAO();

		// 新增
		Prod_VO prodVO1 = new Prod_VO();
		prodVO1.setProd_type("杯具");
		prodVO1.setProd_name("水晶杯");
		prodVO1.setProd_price(50000);
		prodVO1.setProd_status(0);
		prodVO1.setLaunch_time(java.sql.Timestamp.valueOf("2022-01-01 10:10:10"));
		prodVO1.setOff_time(java.sql.Timestamp.valueOf("2022-01-01 10:10:10"));
		prodVO1.setProd_stock(1000);
		prodVO1.setProd_detail("掉到地上都不會破的水晶杯喔喔喔！");
		dao.insert(prodVO1);		

		// 修改
		Prod_VO prodVO2 = new Prod_VO();
		prodVO2.setProd_no(4);
		prodVO2.setProd_type("wow");
		prodVO2.setProd_name("來試試看阿");
		prodVO2.setProd_price(100);
		prodVO2.setProd_status(1);
		prodVO2.setLaunch_time(java.sql.Timestamp.valueOf("2022-01-01 10:10:10"));
		prodVO2.setOff_time(java.sql.Timestamp.valueOf("2022-01-01 10:10:10"));
		prodVO2.setProd_stock(1);
		prodVO2.setProd_detail("我好爽");
		dao.update(prodVO2);

		// 刪除
		dao.delete(9);
		

		// 查詢
		Prod_VO prodVO3 = dao.findByPrimaryKey(1);
		System.out.print(prodVO3.getProd_type() + ",");
		System.out.print(prodVO3.getProd_name() + ",");
		System.out.print(prodVO3.getProd_price() + ",");
		System.out.print(prodVO3.getProd_status() + ",");
		System.out.print(prodVO3.getLaunch_time() + ",");
		System.out.print(prodVO3.getOff_time() + ",");
		System.out.print(prodVO3.getProd_stock() + ",");
		System.out.print(prodVO3.getProd_detail() + ",");
		System.out.print(prodVO3.getProd_no() + ",");
		System.out.println();
		System.out.println("-----------------------------------------");

		// 查詢
		List<Prod_VO> list = dao.getAll();
		for (Prod_VO allProd : list) {
			System.out.print(allProd.getProd_type() + ",");
			System.out.print(allProd.getProd_name() + ",");
			System.out.print(allProd.getProd_price() + ",");
			System.out.print(allProd.getProd_status() + ",");
			System.out.print(allProd.getLaunch_time() + ",");
			System.out.print(allProd.getOff_time() + ",");
			System.out.print(allProd.getProd_stock() + ",");
			System.out.print(allProd.getProd_detail() + ",");
			System.out.print(allProd.getProd_no() + ",");
			System.out.println();
		}
	}
}
