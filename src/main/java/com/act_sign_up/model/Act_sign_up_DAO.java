package com.act_sign_up.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Act_sign_up_DAO implements Act_sign_up_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO act_sign_up (act_no, mem_no, accompany_count) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT sign_up_no, act_no, mem_no, sign_up_time, accompany_count FROM act_sign_up order by sign_up_no";
	private static final String GET_ONE_STMT = "SELECT sign_up_no, act_no, mem_no, sign_up_time, accompany_count FROM act_sign_up where sign_up_no = ?";
	private static final String DELETE = "DELETE FROM act_sign_up where sign_up_no = ?";
	private static final String UPDATE = "UPDATE act_sign_up set act_no = ?, mem_no = ?, accompany_count = ? where sign_up_no = ?";

	private static final String GET_ACT_SIGN_UP = "SELECT act_no FROM act_sign_up where mem_no = ?";
	private static final String GET_MY_ACT_SIGN_UP = "SELECT sign_up_no, act_no, mem_no, sign_up_time, accompany_count FROM act_sign_up where mem_no = ?";
	
	@Override
	public void insert(Act_sign_up_VO act_sign_up_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, act_sign_up_VO.getAct_no());
			pstmt.setInt(2, act_sign_up_VO.getMem_no());
			pstmt.setInt(3, act_sign_up_VO.getAccompany_count());

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
	public void update(Act_sign_up_VO act_sign_up_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, act_sign_up_VO.getAct_no());
			pstmt.setInt(2, act_sign_up_VO.getMem_no());
			pstmt.setInt(3, act_sign_up_VO.getAccompany_count());
			pstmt.setInt(4, act_sign_up_VO.getSign_up_no());

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
	public void delete(Integer sign_up_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, sign_up_no);

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
	public Act_sign_up_VO findByPrimaryKey(Integer sign_up_no) {
		Act_sign_up_VO act_sign_up_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, sign_up_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				act_sign_up_VO = new Act_sign_up_VO();
				act_sign_up_VO.setSign_up_no(rs.getInt("sign_up_no"));
				act_sign_up_VO.setAct_no(rs.getInt("act_no"));
				act_sign_up_VO.setMem_no(rs.getInt("mem_no"));
				act_sign_up_VO.setSign_up_time(rs.getTimestamp("sign_up_time"));
				act_sign_up_VO.setAccompany_count(rs.getInt("accompany_count"));

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
		return act_sign_up_VO;
	}

	@Override
	public List<Act_sign_up_VO> getAll() {
		List<Act_sign_up_VO> list = new ArrayList<Act_sign_up_VO>();
		Act_sign_up_VO act_sign_up_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				act_sign_up_VO = new Act_sign_up_VO();
				act_sign_up_VO.setSign_up_no(rs.getInt("sign_up_no"));
				act_sign_up_VO.setAct_no(rs.getInt("act_no"));
				act_sign_up_VO.setMem_no(rs.getInt("mem_no"));
				act_sign_up_VO.setSign_up_time(rs.getTimestamp("sign_up_time"));
				act_sign_up_VO.setAccompany_count(rs.getInt("accompany_count"));
				list.add(act_sign_up_VO); // Store the row in the list
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
	public Set<Integer> getAct_sign_up(Integer mem_no) {
		Set<Integer> set = new HashSet<Integer>();
		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ACT_SIGN_UP);
			pstmt.setInt(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				set.add(rs.getInt("act_no")); // Store the row in the list
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
	public List<Act_sign_up_VO> getMy_act_sign_up(Integer mem_no) {
		List<Act_sign_up_VO> list = new ArrayList<Act_sign_up_VO>();
		Act_sign_up_VO act_sign_up_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_MY_ACT_SIGN_UP);
			pstmt.setInt(1, mem_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				act_sign_up_VO = new Act_sign_up_VO();
				act_sign_up_VO.setSign_up_no(rs.getInt("sign_up_no"));
				act_sign_up_VO.setAct_no(rs.getInt("act_no"));
				act_sign_up_VO.setMem_no(rs.getInt("mem_no"));
				act_sign_up_VO.setSign_up_time(rs.getTimestamp("sign_up_time"));
				act_sign_up_VO.setAccompany_count(rs.getInt("accompany_count"));
				list.add(act_sign_up_VO); // Store the row in the list
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
