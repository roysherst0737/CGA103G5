package com.act.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Act_DAO implements Act_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

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

			con = ds.getConnection();
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

			con = ds.getConnection();
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, act_no);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public Act_VO findByPrimaryKey(Integer act_no) {
		Act_VO act_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, act_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
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

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
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
