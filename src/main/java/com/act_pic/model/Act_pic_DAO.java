package com.act_pic.model;

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

public class Act_pic_DAO implements Act_pic_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO act_pic (act_no, act_pic, act_pic_name) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT act_pic_no, act_no, act_pic, act_pic_name FROM act_pic order by act_pic_no";
	private static final String GET_ONE_STMT = "SELECT act_pic_no, act_no, act_pic, act_pic_name FROM act_pic where act_pic_no = ?";
	private static final String DELETE = "DELETE FROM act_pic where act_pic_no = ?";
	private static final String UPDATE = "UPDATE act_pic set act_no = ?, act_pic = ?, act_pic_name = ? where act_pic_no = ?";

	private static final String GET_FROM_ACT_NO_STMT = "SELECT act_pic_no, act_no, act_pic, act_pic_name FROM act_pic where act_no = ?";

	@Override
	public void insert(Act_pic_VO act_pic_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, act_pic_VO.getAct_no());
			pstmt.setBytes(2, act_pic_VO.getAct_pic());
			pstmt.setString(3, act_pic_VO.getAct_pic_name());

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
	public void update(Act_pic_VO act_pic_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, act_pic_VO.getAct_no());
			pstmt.setBytes(2, act_pic_VO.getAct_pic());
			pstmt.setString(3, act_pic_VO.getAct_pic_name());
			pstmt.setInt(4, act_pic_VO.getAct_pic_no());

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
	public void delete(Integer act_pic_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, act_pic_no);

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
	public Act_pic_VO findByPrimaryKey(Integer act_pic_no) {
		Act_pic_VO act_pic_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, act_pic_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				act_pic_VO = new Act_pic_VO();
				act_pic_VO.setAct_pic_no(rs.getInt("act_pic_no"));
				act_pic_VO.setAct_no(rs.getInt("act_no"));
				act_pic_VO.setAct_pic(rs.getBytes("act_pic"));
				act_pic_VO.setAct_pic_name(rs.getString("act_pic_name"));

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
		return act_pic_VO;
	}

	@Override
	public List<Act_pic_VO> getAll() {
		List<Act_pic_VO> list = new ArrayList<Act_pic_VO>();
		Act_pic_VO act_pic_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				act_pic_VO = new Act_pic_VO();
				act_pic_VO.setAct_pic_no(rs.getInt("act_pic_no"));
				act_pic_VO.setAct_no(rs.getInt("act_no"));
				act_pic_VO.setAct_pic(rs.getBytes("act_pic"));
				act_pic_VO.setAct_pic_name(rs.getString("act_pic_name"));
				list.add(act_pic_VO); // Store the row in the list
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

	@Override
	public List<Act_pic_VO> get_from_act_no(Integer act_no) {
		List<Act_pic_VO> list = new ArrayList<Act_pic_VO>();
		Act_pic_VO act_pic_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_FROM_ACT_NO_STMT);
			pstmt.setInt(1, act_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				act_pic_VO = new Act_pic_VO();
				act_pic_VO.setAct_pic_no(rs.getInt("act_pic_no"));
				act_pic_VO.setAct_no(rs.getInt("act_no"));
				act_pic_VO.setAct_pic(rs.getBytes("act_pic"));
				act_pic_VO.setAct_pic_name(rs.getString("act_pic_name"));
				list.add(act_pic_VO); // Store the row in the list
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
