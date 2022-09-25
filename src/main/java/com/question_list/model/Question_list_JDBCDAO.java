package com.question_list.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Question_list_JDBCDAO implements Question_list_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "cga10305";
	String passwd = "123qweqwe";

	private static final String INSERT_STMT = "INSERT INTO question_list (question_no, firm_survey_no) VALUES (?, ?)";
	private static final String GET_ALL_STMT = "SELECT question_no, firm_survey_no FROM question_list order by question_no";
	private static final String GET_ONE_STMT = "SELECT question_no, firm_survey_no FROM question_list where question_no = ? and firm_survey_no = ?";
	private static final String DELETE = "DELETE FROM question_list where question_no = ? and firm_survey_no = ?";
	private static final String UPDATE = "UPDATE question_list set question_no = ?, firm_survey_no = ? where question_no = ? and firm_survey_no = ?";

	private static final String GET_ALL_FROM_FIRM_SURVEY_NO = "SELECT question_no, firm_survey_no FROM question_list where firm_survey_no = ?";

	@Override
	public void insert(Question_list_VO question_list_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, question_list_VO.getQuestion_no());
			pstmt.setInt(2, question_list_VO.getFirm_survey_no());

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
	public void update(Question_list_VO question_list_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, question_list_VO.getQuestion_no());
			pstmt.setInt(2, question_list_VO.getFirm_survey_no());
			pstmt.setInt(3, question_list_VO.getQuestion_no());
			pstmt.setInt(4, question_list_VO.getFirm_survey_no());

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
	public void delete(Integer question_no, Integer firm_survey_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, question_no);
			pstmt.setInt(2, firm_survey_no);

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
	public Question_list_VO findByPrimaryKey(Integer question_no, Integer firm_survey_no) {
		Question_list_VO question_list_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, question_no);
			pstmt.setInt(2, firm_survey_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				question_list_VO = new Question_list_VO();
				question_list_VO.setQuestion_no(rs.getInt("question_no"));
				question_list_VO.setFirm_survey_no(rs.getInt("firm_survey_no"));

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
		return question_list_VO;
	}

	@Override
	public List<Question_list_VO> getAll() {
		List<Question_list_VO> list = new ArrayList<Question_list_VO>();
		Question_list_VO question_list_VO = null;

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
				question_list_VO = new Question_list_VO();
				question_list_VO.setQuestion_no(rs.getInt("question_no"));
				question_list_VO.setFirm_survey_no(rs.getInt("firm_survey_no"));
				list.add(question_list_VO); // Store the row in the list
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
	
	
	@Override
	public List<Question_list_VO> getAllFromFirmSurveyNo(Integer firm_survey_no) {
		List<Question_list_VO> list = new ArrayList<Question_list_VO>();
		Question_list_VO question_list_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_FROM_FIRM_SURVEY_NO);
			pstmt.setInt(1, firm_survey_no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				question_list_VO = new Question_list_VO();
				question_list_VO.setQuestion_no(rs.getInt("question_no"));
				question_list_VO.setFirm_survey_no(rs.getInt("firm_survey_no"));
				list.add(question_list_VO); // Store the row in the list
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

		Question_list_JDBCDAO dao = new Question_list_JDBCDAO();

		// 新增
		Question_list_VO question_list_VO01 = new Question_list_VO();
		question_list_VO01.setQuestion_no(1);
		question_list_VO01.setFirm_survey_no(1);

		dao.insert(question_list_VO01);

		// 修改
		Question_list_VO question_list_VO02 = new Question_list_VO();
		question_list_VO02.setQuestion_no(1);
		question_list_VO02.setFirm_survey_no(1);
		question_list_VO02.setQuestion_no(1);
		question_list_VO02.setFirm_survey_no(1);

		dao.update(question_list_VO02);

		// 刪除
		dao.delete(1, 1);

		// 查詢

		Question_list_VO question_list_VO03 = dao.findByPrimaryKey(1, 1);
		System.out.print(question_list_VO03.getQuestion_no() + ",");
		System.out.println(question_list_VO03.getFirm_survey_no());
		System.out.println("---------------------");

		// 查詢
		List<Question_list_VO> list = dao.getAll();
		for (Question_list_VO aQuestion_list : list) {
			System.out.print(aQuestion_list.getQuestion_no() + ",");
			System.out.println(aQuestion_list.getFirm_survey_no());
			System.out.println();
		}
	}

}
