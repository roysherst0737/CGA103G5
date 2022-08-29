package com.coupon.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Coupon_JDBCDAO implements Coupon_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "208127";

	private static final String INSERT_STMT = 
			"INSERT INTO coupon (coupon_name, coupon_code, coupon_content,"
			+ " coupon_discount, coupon_amount, launch_time, off_time,"
			+ " coupon_build_time, state) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT coupon_no, coupon_name, coupon_code, coupon_content,"
			+ " coupon_discount, coupon_amount, launch_time, off_time,"
			+ " coupon_build_time, state FROM coupon order by coupon_no";
		private static final String GET_ONE_STMT = 
			"SELECT coupon_no, coupon_name, coupon_code, coupon_content,"
			+ " coupon_discount, coupon_amount, launch_time, off_time,"
			+ " coupon_build_time, state FROM coupon where coupon_no = ?";
		private static final String DELETE = 
			"DELETE FROM coupon where coupon_no = ?";
		private static final String UPDATE = 
			"UPDATE coupon coupon_name=?, coupon_code=?, coupon_content=?,"
			+ " coupon_discount=?, coupon_amount=?, launch_time=?, off_time=?,"
			+ " coupon_build_time=?, state=? where coupon_no = ?";

	@Override
	public void insert(Coupon_VO couponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, couponVO.getCoupon_name());
			pstmt.setString(2, couponVO.getCoupon_code());
			pstmt.setString(3, couponVO.getCoupon_content());
			pstmt.setDouble(4, couponVO.getCoupon_discount());
			pstmt.setInt(5, couponVO.getCoupon_amount());
			pstmt.setTimestamp(6, couponVO.getLaunch_time());
			pstmt.setTimestamp(7, couponVO.getOff_time());
			pstmt.setTimestamp(8, couponVO.getCoupon_build_time());
			pstmt.setInt(9, couponVO.getStatus());

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
	public void update(Coupon_VO couponVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, couponVO.getCoupon_name());
			pstmt.setString(2, couponVO.getCoupon_code());
			pstmt.setString(3, couponVO.getCoupon_content());
			pstmt.setDouble(4, couponVO.getCoupon_discount());
			pstmt.setInt(5, couponVO.getCoupon_amount());
			pstmt.setTimestamp(6, couponVO.getLaunch_time());
			pstmt.setTimestamp(7, couponVO.getOff_time());
			pstmt.setTimestamp(8, couponVO.getCoupon_build_time());
			pstmt.setInt(9, couponVO.getStatus());
			pstmt.setInt(10, couponVO.getCoupon_no());

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
	public void delete(Integer coupon_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, coupon_no);

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
	public Coupon_VO findByPrimaryKey(Integer coupon_no) {

		Coupon_VO couponVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, coupon_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				couponVO = new Coupon_VO();
				couponVO.setCoupon_no(rs.getInt("coupon_no"));
				couponVO.setCoupon_name(rs.getString("coupon_name"));
				couponVO.setCoupon_code(rs.getString("coupon_code"));
				couponVO.setCoupon_content(rs.getString("coupon_content"));
				couponVO.setCoupon_discount(rs.getDouble("coupon_discount"));
				couponVO.setCoupon_amount(rs.getInt("coupon_amount"));
				couponVO.setLaunch_time(rs.getTimestamp("launch_time"));
				couponVO.setOff_time(rs.getTimestamp("off_time"));
				couponVO.setCoupon_build_time(rs.getTimestamp("coupon_build_time"));
				couponVO.setStatus(rs.getInt("status"));
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
		return couponVO;
	}

	@Override
	public List<Coupon_VO> getAll() {
		List<Coupon_VO> list = new ArrayList<Coupon_VO>();
		Coupon_VO couponVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				couponVO = new Coupon_VO();
				couponVO.setCoupon_no(rs.getInt("coupon_no"));
				couponVO.setCoupon_name(rs.getString("coupon_name"));
				couponVO.setCoupon_code(rs.getString("coupon_code"));
				couponVO.setCoupon_content(rs.getString("coupon_content"));
				couponVO.setCoupon_discount(rs.getDouble("coupon_discount"));
				couponVO.setCoupon_amount(rs.getInt("coupon_amount"));
				couponVO.setLaunch_time(rs.getTimestamp("launch_time"));
				couponVO.setOff_time(rs.getTimestamp("off_time"));
				couponVO.setCoupon_build_time(rs.getTimestamp("coupon_build_time"));
				couponVO.setStatus(rs.getInt("status"));
				list.add(couponVO); // Store the row in the list
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

		Coupon_JDBCDAO dao = new Coupon_JDBCDAO();

		// 新增
		Coupon_VO couponVO1 = new Coupon_VO();
		couponVO1.setCoupon_name("半價優惠券");
		couponVO1.setCoupon_code("ABCDE123");
		couponVO1.setCoupon_content("針對酒類商品全面半價");
		couponVO1.setCoupon_discount(0.5);
		couponVO1.setCoupon_amount(50);
		couponVO1.setLaunch_time(java.sql.Timestamp.valueOf("2022-10-10 00:00:00"));
		couponVO1.setOff_time(java.sql.Timestamp.valueOf("2022-12-25 00:00:00"));
		couponVO1.setCoupon_build_time(java.sql.Timestamp.valueOf("2022-08-18 16:13:09"));
		couponVO1.setStatus(0);

		dao.insert(couponVO1);

		// 修改
		Coupon_VO couponVO2 = new Coupon_VO();

		couponVO2.setCoupon_name("半價優惠券");
		couponVO2.setCoupon_code("ABCDE123");
		couponVO2.setCoupon_content("針對酒類商品全面半價");
		couponVO2.setCoupon_discount(0.5);
		couponVO2.setCoupon_amount(50);
		couponVO2.setLaunch_time(java.sql.Timestamp.valueOf("2022-10-10 00:00:00"));
		couponVO2.setOff_time(java.sql.Timestamp.valueOf("2022-12-25 00:00:00"));
		couponVO2.setCoupon_build_time(java.sql.Timestamp.valueOf("2022-08-18 16:13:09"));
		couponVO2.setStatus(0);
		couponVO2.setCoupon_no(1);
		dao.update(couponVO2);
		System.out.println("update success!");

		// 刪除
		dao.delete(1);

		// 查詢
		Coupon_VO couponVO3 = dao.findByPrimaryKey(2);
		System.out.print(couponVO3.getCoupon_no() + ",");
		System.out.print(couponVO3.getCoupon_name() + ",");
		System.out.print(couponVO3.getCoupon_code() + ",");
		System.out.print(couponVO3.getCoupon_content() + ",");
		System.out.print(couponVO3.getCoupon_discount() + ",");
		System.out.print(couponVO3.getCoupon_amount() + ",");
		System.out.print(couponVO3.getLaunch_time() + ",");
		System.out.println(couponVO3.getOff_time());
		System.out.print(couponVO3.getCoupon_build_time() + ",");
		System.out.print(couponVO3.getStatus() + ",");


		System.out.println("---------------------");

		// 查詢
		List<Coupon_VO> list = dao.getAll();
		for (Coupon_VO aEmp : list) {
			System.out.print(aEmp.getCoupon_no() + ",");
			System.out.print(aEmp.getCoupon_name() + ",");
			System.out.print(aEmp.getCoupon_code() + ",");
			System.out.print(aEmp.getCoupon_content() + ",");
			System.out.print(aEmp.getCoupon_discount() + ",");
			System.out.print(aEmp.getCoupon_amount() + ",");
			System.out.println(aEmp.getLaunch_time());
			System.out.print(aEmp.getOff_time() + ",");
			System.out.print(aEmp.getCoupon_build_time() + ",");
			System.out.print(aEmp.getStatus() + ",");
	
			System.out.println();
		}
	}
}