package com.ans_list.model;

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

public class Ans_list_JNDIDAO implements Ans_list_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lonelybar");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO ans_list (question_no, firm_survey_no, mem_no, ans) VALUES (?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT question_no, firm_survey_no, mem_no, ans FROM ans_list order by question_no";
	private static final String GET_ONE_STMT = "SELECT question_no, firm_survey_no, mem_no, ans FROM ans_list where question_no = ? and firm_survey_no = ? and mem_no = ?";
	private static final String DELETE = "DELETE FROM ans_list where question_no = ? and firm_survey_no = ? and mem_no = ?";
	private static final String UPDATE = "UPDATE ans_list set ans = ? where question_no = ? and firm_survey_no = ? and mem_no = ?";

	@Override
	public void insert(Ans_list_VO ans_list_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, ans_list_VO.getQuestion_no());
			pstmt.setInt(2, ans_list_VO.getFirm_survey_no());
			pstmt.setInt(3, ans_list_VO.getMem_no());
			pstmt.setString(4, ans_list_VO.getAns());

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
	public void update(Ans_list_VO ans_list_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, ans_list_VO.getAns());
			pstmt.setInt(2, ans_list_VO.getQuestion_no());
			pstmt.setInt(3, ans_list_VO.getFirm_survey_no());
			pstmt.setInt(4, ans_list_VO.getMem_no());

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
	public void delete(Integer question_no, Integer firm_survey_no, Integer mem_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, question_no);
			pstmt.setInt(2, firm_survey_no);
			pstmt.setInt(3, mem_no);

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
	public Ans_list_VO findByPrimaryKey(Integer question_no, Integer firm_survey_no, Integer mem_no) {
		Ans_list_VO ans_list_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, question_no);
			pstmt.setInt(2, firm_survey_no);
			pstmt.setInt(3, mem_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				ans_list_VO = new Ans_list_VO();
				ans_list_VO.setQuestion_no(rs.getInt("question_no"));
				ans_list_VO.setFirm_survey_no(rs.getInt("firm_survey_no"));
				ans_list_VO.setMem_no(rs.getInt("mem_no"));
				ans_list_VO.setAns(rs.getString("ans"));

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
		return ans_list_VO;
	}

	@Override
	public List<Ans_list_VO> getAll() {
		List<Ans_list_VO> list = new ArrayList<Ans_list_VO>();
		Ans_list_VO ans_list_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				ans_list_VO = new Ans_list_VO();
				ans_list_VO.setQuestion_no(rs.getInt("question_no"));
				ans_list_VO.setFirm_survey_no(rs.getInt("firm_survey_no"));
				ans_list_VO.setMem_no(rs.getInt("mem_no"));
				ans_list_VO.setAns(rs.getString("ans"));
				list.add(ans_list_VO); // Store the row in the list
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
