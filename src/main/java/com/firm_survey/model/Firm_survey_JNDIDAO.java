package com.firm_survey.model;

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

public class Firm_survey_JNDIDAO implements Firm_survey_DAO_interface {

	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lonelybar");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = "INSERT INTO firm_survey (act_no) VALUES (?)";
	private static final String GET_ALL_STMT = "SELECT firm_survey_no, act_no, survey_build_time, survey_revise_time FROM firm_survey order by firm_survey_no";
	private static final String GET_ONE_STMT = "SELECT firm_survey_no, act_no, survey_build_time, survey_revise_time FROM firm_survey where firm_survey_no = ?";
	private static final String DELETE = "DELETE FROM firm_survey where firm_survey_no = ?";
	private static final String UPDATE = "UPDATE firm_survey set act_no = ? where firm_survey_no = ?";

	@Override
	public void insert(Firm_survey_VO firm_survey_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, firm_survey_VO.getAct_no());

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
	public void update(Firm_survey_VO firm_survey_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, firm_survey_VO.getAct_no());
			pstmt.setInt(2, firm_survey_VO.getFirm_survey_no());

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
	public void delete(Integer firm_survey_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, firm_survey_no);

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
	public Firm_survey_VO findByPrimaryKey(Integer firm_survey_no) {
		Firm_survey_VO firm_survey_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, firm_survey_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				firm_survey_VO = new Firm_survey_VO();
				firm_survey_VO.setFirm_survey_no(rs.getInt("firm_survey_no"));
				firm_survey_VO.setAct_no(rs.getInt("act_no"));
				firm_survey_VO.setSurvey_build_time(rs.getTimestamp("survey_build_time"));
				firm_survey_VO.setSurvey_revise_time(rs.getTimestamp("survey_revise_time"));

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
		return firm_survey_VO;
	}

	@Override
	public List<Firm_survey_VO> getAll() {
		List<Firm_survey_VO> list = new ArrayList<Firm_survey_VO>();
		Firm_survey_VO firm_survey_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				firm_survey_VO = new Firm_survey_VO();
				firm_survey_VO.setFirm_survey_no(rs.getInt("firm_survey_no"));
				firm_survey_VO.setAct_no(rs.getInt("act_no"));
				firm_survey_VO.setSurvey_build_time(rs.getTimestamp("survey_build_time"));
				firm_survey_VO.setSurvey_revise_time(rs.getTimestamp("survey_revise_time"));
				list.add(firm_survey_VO); // Store the row in the list
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
