package com.act.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Act_JDBCDAO implements Act_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "cga10305";
	String passwd = "123qweqwe";

	private static final String INSERT_STMT = "INSERT INTO act (pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, current_count, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT act_no, pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, current_count, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time, act_status, apply_time, apply_status FROM act order by act_no";
	private static final String GET_ONE_STMT = "SELECT act_no, pub_no, act_name, act_detail, act_loc, act_launch_time, act_off_time, current_count, max_count, min_count, sign_up_begin_time, sign_up_end_time, act_start_time, act_end_time, act_status, apply_time, apply_status FROM act where act_no = ?";
	private static final String DELETE = "DELETE FROM act where act_no = ?";
	private static final String UPDATE = "UPDATE act set pub_no = ?, act_name = ?, act_detail = ?, act_loc = ?, act_launch_time = ?, act_off_time = ?, current_count = ?, max_count = ?, min_count = ?, sign_up_begin_time = ?, sign_up_end_time = ?, act_start_time = ?, act_end_time = ?, act_status = ?, apply_status = ? where act_no = ?";

	@Override
	public void insert(Act_VO act_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, act_VO.getPub_no());
			pstmt.setString(2, act_VO.getAct_name());
			pstmt.setString(3, act_VO.getAct_detail());
			pstmt.setString(4, act_VO.getAct_loc());
			pstmt.setTimestamp(5, act_VO.getAct_launch_time());
			pstmt.setTimestamp(6, act_VO.getAct_off_time());
			pstmt.setInt(7, act_VO.getCurrent_count());
			pstmt.setInt(8, act_VO.getMax_count());
			pstmt.setInt(9, act_VO.getMin_count());
			pstmt.setTimestamp(10, act_VO.getSign_up_begin_time());
			pstmt.setTimestamp(11, act_VO.getSign_up_end_time());
			pstmt.setTimestamp(12, act_VO.getAct_start_time());
			pstmt.setTimestamp(13, act_VO.getAct_end_time());


			pstmt.executeUpdate();

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void update(Act_VO act_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, act_VO.getPub_no());
			pstmt.setString(2, act_VO.getAct_name());
			pstmt.setString(3, act_VO.getAct_detail());
			pstmt.setString(4, act_VO.getAct_loc());
			pstmt.setTimestamp(5, act_VO.getAct_launch_time());
			pstmt.setTimestamp(6, act_VO.getAct_off_time());
			pstmt.setInt(7, act_VO.getCurrent_count());
			pstmt.setInt(8, act_VO.getMax_count());
			pstmt.setInt(9, act_VO.getMin_count());
			pstmt.setTimestamp(10, act_VO.getSign_up_begin_time());
			pstmt.setTimestamp(11, act_VO.getSign_up_end_time());
			pstmt.setTimestamp(12, act_VO.getAct_start_time());
			pstmt.setTimestamp(13, act_VO.getAct_end_time());
			pstmt.setInt(14, act_VO.getAct_status());
			pstmt.setInt(15, act_VO.getApply_status());
			pstmt.setInt(16, act_VO.getAct_no());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public void delete(Integer act_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, act_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	public Act_VO findByPrimaryKey(Integer act_no) {
		Act_VO act_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, act_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				act_VO = new Act_VO();
				act_VO.setAct_no(rs.getInt("act_no"));
				act_VO.setPub_no(rs.getInt("pub_no"));
				act_VO.setAct_name(rs.getString("act_name"));
				act_VO.setAct_detail(rs.getString("act_detail"));
				act_VO.setAct_loc(rs.getString("act_loc"));
				act_VO.setAct_launch_time(rs.getTimestamp("act_launch_time"));
				act_VO.setAct_off_time(rs.getTimestamp("act_off_time"));
				act_VO.setCurrent_count(rs.getInt("current_count"));
				act_VO.setMax_count(rs.getInt("max_count"));
				act_VO.setMin_count(rs.getInt("min_count"));
				act_VO.setSign_up_begin_time(rs.getTimestamp("sign_up_begin_time"));
				act_VO.setSign_up_end_time(rs.getTimestamp("sign_up_end_time"));
				act_VO.setAct_start_time(rs.getTimestamp("act_start_time"));
				act_VO.setAct_end_time(rs.getTimestamp("act_end_time"));
				act_VO.setAct_status(rs.getInt("act_status"));
				act_VO.setApply_time(rs.getTimestamp("apply_time"));
				act_VO.setApply_status(rs.getInt("apply_status"));

			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return act_VO;
	}

	@Override
	public List<Act_VO> getAll() {
		List<Act_VO> list = new ArrayList<Act_VO>();
		Act_VO act_VO = null;

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
				act_VO = new Act_VO();
				act_VO.setAct_no(rs.getInt("act_no"));
				act_VO.setPub_no(rs.getInt("pub_no"));
				act_VO.setAct_name(rs.getString("act_name"));
				act_VO.setAct_detail(rs.getString("act_detail"));
				act_VO.setAct_loc(rs.getString("act_loc"));
				act_VO.setAct_launch_time(rs.getTimestamp("act_launch_time"));
				act_VO.setAct_off_time(rs.getTimestamp("act_off_time"));
				act_VO.setCurrent_count(rs.getInt("current_count"));
				act_VO.setMax_count(rs.getInt("max_count"));
				act_VO.setMin_count(rs.getInt("min_count"));
				act_VO.setSign_up_begin_time(rs.getTimestamp("sign_up_begin_time"));
				act_VO.setSign_up_end_time(rs.getTimestamp("sign_up_end_time"));
				act_VO.setAct_start_time(rs.getTimestamp("act_start_time"));
				act_VO.setAct_end_time(rs.getTimestamp("act_end_time"));
				act_VO.setAct_status(rs.getInt("act_status"));
				act_VO.setApply_time(rs.getTimestamp("apply_time"));
				act_VO.setApply_status(rs.getInt("apply_status"));
				list.add(act_VO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		Act_JDBCDAO dao = new Act_JDBCDAO();

		// 新增
		Act_VO act_VO01 = new Act_VO();
		act_VO01.setPub_no(1);
		act_VO01.setAct_name("我想死");
		act_VO01.setAct_detail("揪團自殺");
		act_VO01.setAct_loc("懸崖邊");
		act_VO01.setAct_launch_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO01.setAct_off_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO01.setCurrent_count(0);
		act_VO01.setMax_count(30);
		act_VO01.setMin_count(10);
		act_VO01.setSign_up_begin_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO01.setSign_up_end_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO01.setAct_start_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO01.setAct_end_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO01.setAct_status(0);
		act_VO01.setApply_status(0);

		dao.insert(act_VO01);

		// 修改
		Act_VO act_VO02 = new Act_VO();
		act_VO02.setPub_no(3);
		act_VO02.setAct_name("我想死");
		act_VO02.setAct_detail("揪團自殺");
		act_VO02.setAct_loc("懸崖邊");
		act_VO02.setAct_launch_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO02.setAct_off_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO02.setCurrent_count(0);
		act_VO02.setMax_count(30);
		act_VO02.setMin_count(10);
		act_VO02.setSign_up_begin_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO02.setSign_up_end_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO02.setAct_start_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO02.setAct_end_time(java.sql.Timestamp.valueOf("2022-10-10 10:10:10"));
		act_VO02.setAct_status(1);
		act_VO02.setApply_status(1);
		act_VO02.setAct_no(4);

		dao.update(act_VO02);

		// 刪除
		dao.delete(1);

		// 查詢

		Act_VO act_VO03 = dao.findByPrimaryKey(1);
		System.out.print(act_VO03.getAct_no() + ",");
		System.out.print(act_VO03.getPub_no() + ",");
		System.out.print(act_VO03.getAct_name() + ",");
		System.out.print(act_VO03.getAct_detail() + ",");
		System.out.print(act_VO03.getAct_loc() + ",");
		System.out.print(act_VO03.getAct_launch_time() + ",");
		System.out.print(act_VO03.getAct_off_time() + ",");
		System.out.print(act_VO03.getCurrent_count() + ",");
		System.out.print(act_VO03.getMax_count() + ",");
		System.out.print(act_VO03.getMin_count() + ",");
		System.out.print(act_VO03.getSign_up_begin_time() + ",");
		System.out.print(act_VO03.getSign_up_end_time() + ",");
		System.out.print(act_VO03.getAct_start_time() + ",");
		System.out.print(act_VO03.getAct_end_time() + ",");
		System.out.print(act_VO03.getAct_status() + ",");
		System.out.print(act_VO03.getApply_time() + ",");
		System.out.println(act_VO03.getApply_status());
		System.out.println("---------------------");

		// 查詢
		List<Act_VO> list = dao.getAll();
		for (Act_VO aAct : list) {
			System.out.print(aAct.getAct_no() + ",");
			System.out.print(aAct.getPub_no() + ",");
			System.out.print(aAct.getAct_name() + ",");
			System.out.print(aAct.getAct_detail() + ",");
			System.out.print(aAct.getAct_loc() + ",");
			System.out.print(aAct.getAct_launch_time() + ",");
			System.out.print(aAct.getAct_off_time() + ",");
			System.out.print(aAct.getCurrent_count() + ",");
			System.out.print(aAct.getMax_count() + ",");
			System.out.print(aAct.getMin_count() + ",");
			System.out.print(aAct.getSign_up_begin_time() + ",");
			System.out.print(aAct.getSign_up_end_time() + ",");
			System.out.print(aAct.getAct_start_time() + ",");
			System.out.print(aAct.getAct_end_time() + ",");
			System.out.print(aAct.getAct_status() + ",");
			System.out.print(aAct.getApply_time() + ",");
			System.out.println(aAct.getApply_status());
			System.out.println();
		}
	}

}
