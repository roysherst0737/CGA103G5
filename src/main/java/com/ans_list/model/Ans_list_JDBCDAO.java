package com.ans_list.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ans_list_JDBCDAO implements Ans_list_DAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/lonelybar?serverTimezone=Asia/Taipei";
	String userid = "cga10305";
	String passwd = "123qweqwe";

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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
	public void update(Ans_list_VO ans_list_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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
	public void delete(Integer question_no, Integer firm_survey_no, Integer mem_no) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, question_no);
			pstmt.setInt(2, firm_survey_no);
			pstmt.setInt(3, mem_no);

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
	public Ans_list_VO findByPrimaryKey(Integer question_no, Integer firm_survey_no, Integer mem_no) {
		Ans_list_VO ans_list_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
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

		Ans_list_JDBCDAO dao = new Ans_list_JDBCDAO();

		// 新增
		Ans_list_VO ans_list_VO01 = new Ans_list_VO();
		ans_list_VO01.setQuestion_no(1);
		ans_list_VO01.setFirm_survey_no(1);
		ans_list_VO01.setMem_no(1);
		ans_list_VO01.setAns("回答");

		dao.insert(ans_list_VO01);

		// 修改
		Ans_list_VO ans_list_VO02 = new Ans_list_VO();
		ans_list_VO02.setAns("回答");
		ans_list_VO02.setQuestion_no(1);
		ans_list_VO02.setFirm_survey_no(1);
		ans_list_VO02.setMem_no(1);

		dao.update(ans_list_VO02);

		// 刪除
		dao.delete(1, 1, 1);

		// 查詢

		Ans_list_VO ans_list_VO03 = dao.findByPrimaryKey(1, 1, 1);
		System.out.print(ans_list_VO03.getQuestion_no() + ",");
		System.out.print(ans_list_VO03.getFirm_survey_no() + ",");
		System.out.print(ans_list_VO03.getMem_no() + ",");
		System.out.println(ans_list_VO03.getAns());
		System.out.println("---------------------");

		// 查詢
		List<Ans_list_VO> list = dao.getAll();
		for (Ans_list_VO aAns_list : list) {
			System.out.print(aAns_list.getQuestion_no() + ",");
			System.out.print(aAns_list.getFirm_survey_no() + ",");
			System.out.print(aAns_list.getMem_no() + ",");
			System.out.println(aAns_list.getAns());
			System.out.println();
		}
	}

}
