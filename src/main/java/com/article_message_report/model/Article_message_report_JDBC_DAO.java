package com.article_message_report.model;

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





public class Article_message_report_JDBC_DAO implements Article_message_report_DAO_interface{
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/LonglyBar");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	
	}
	private static final String INSERT_STMT = 
			"INSERT INTO article_message_report (mem_no,art_msg_no,rpt_time,rpt_msg_content,mng_no,msg_done_time,msg_states,msg_result,msg_note) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_STMT = 
			"SELECT art_msg_rpt,mem_no,art_msg_no,rpt_time,rpt_msg_content,mng_no,msg_done_time,msg_states,msg_result,msg_note FROM article_message_report order by art_msg_rpt";
		private static final String GET_ONE_STMT = 
			"SELECT art_msg_rpt,mem_no,art_msg_no,rpt_time,rpt_msg_content,mng_no,msg_done_time,msg_states,msg_result,msg_note FROM article_message_report where art_msg_rpt = ?";
		private static final String DELETE = 
			"DELETE FROM article_message_report where art_msg_rpt = ?";
		private static final String UPDATE = 
			"UPDATE article_message_report set mem_no = ?,art_msg_no = ?,rpt_time = ?,rpt_msg_content = ?,mng_no = ?,msg_done_time = ?,msg_states = ?,msg_result = ?,msg_note = ? where art_msg_rpt = ?";
	
	@Override
	public void insert(Article_message_report_VO article_message_report_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
		
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			
			
			pstmt.setInt(1, article_message_report_VO.getMem_no());
			pstmt.setInt(2, article_message_report_VO.getArt_msg_no());
			pstmt.setTimestamp(3, article_message_report_VO.getRpt_time());
			pstmt.setString(4, article_message_report_VO.getRpt_msg_content());
			pstmt.setInt(5, article_message_report_VO.getMng_no());
			pstmt.setTimestamp(6, article_message_report_VO.getMsg_done_time());
			pstmt.setInt(7, article_message_report_VO.getMsg_states());
			pstmt.setInt(8, article_message_report_VO.getMsg_result());
			pstmt.setString(9, article_message_report_VO.getMsg_note());
			

			pstmt.executeUpdate();

	
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
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
	public void update(Article_message_report_VO article_message_report_VO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, article_message_report_VO.getMem_no());
			pstmt.setInt(2, article_message_report_VO.getArt_msg_no());
			pstmt.setTimestamp(3, article_message_report_VO.getRpt_time());
			pstmt.setString(4, article_message_report_VO.getRpt_msg_content());
			pstmt.setInt(5, article_message_report_VO.getMng_no());
			pstmt.setTimestamp(6, article_message_report_VO.getMsg_done_time());
			pstmt.setInt(7, article_message_report_VO.getMsg_states());
			pstmt.setInt(8, article_message_report_VO.getMsg_result());
			pstmt.setString(9, article_message_report_VO.getMsg_note());
			pstmt.executeUpdate();

	
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
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
	public void delete(Integer art_msg_rpt) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, art_msg_rpt);

			pstmt.executeUpdate();

		
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
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
	public Article_message_report_VO findByPrimaryKey(Integer art_msg_rpt) {
		Article_message_report_VO article_message_report_VO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, art_msg_rpt);

			rs = pstmt.executeQuery();

			while (rs.next()) {
			
				article_message_report_VO = new Article_message_report_VO();
				article_message_report_VO.setArt_msg_rpt(rs.getInt("art_msg_rpt"));
				article_message_report_VO.setMem_no(rs.getInt("mem_no"));
				article_message_report_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_report_VO.setRpt_time(rs.getTimestamp("rpt_time"));
				article_message_report_VO.setRpt_msg_content(rs.getString("rpt_msg_content"));
				article_message_report_VO.setMng_no(rs.getInt("mng_no"));
				article_message_report_VO.setMsg_done_time(rs.getTimestamp("msg_done_time"));
				article_message_report_VO.setMsg_states(rs.getInt("msg_states"));
				article_message_report_VO.setMsg_result(rs.getInt("msg_result"));
				article_message_report_VO.setMsg_note(rs.getString("msg_note"));
				
				
				
			}

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
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
		return null;
	}

	@Override
	public List<Article_message_report_VO> getAll() {
		List<Article_message_report_VO> list = new ArrayList<Article_message_report_VO>();
		Article_message_report_VO article_message_report_VO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				article_message_report_VO = new Article_message_report_VO();
				article_message_report_VO.setArt_msg_rpt(rs.getInt("art_msg_rpt"));
				article_message_report_VO.setMem_no(rs.getInt("mem_no"));
				article_message_report_VO.setArt_msg_no(rs.getInt("art_msg_no"));
				article_message_report_VO.setRpt_time(rs.getTimestamp("rpt_time"));
				article_message_report_VO.setRpt_msg_content(rs.getString("rpt_msg_content"));
				article_message_report_VO.setMng_no(rs.getInt("mng_no"));
				article_message_report_VO.setMsg_done_time(rs.getTimestamp("msg_done_time"));
				article_message_report_VO.setMsg_states(rs.getInt("msg_states"));
				article_message_report_VO.setMsg_result(rs.getInt("msg_result"));
				article_message_report_VO.setMsg_note(rs.getString("msg_note"));
				
				list.add(article_message_report_VO); 
			}

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
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
//	public static void main(String[] args) {
//
//		Article_message_report_JDBC_DAO dao = new Article_message_report_JDBC_DAO();
//
//		// 新增
//		Article_message_report_VO empVO1 = newArticle_message_reportVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptno(10);
//		dao.insert(empVO1);
//
//		// 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptno(20);
//		dao.update(empVO2);
//
//		// 刪除
//		dao.delete(7014);
//
//		// 查詢
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		System.out.println(empVO3.getDeptno());
//		System.out.println("---------------------");
//
//		// 查詢
//		List<EmpVO> list = dao.getAll();
//		for (EmpVO aEmp : list) {
//			System.out.print(aEmp.getEmpno() + ",");
//			System.out.print(aEmp.getEname() + ",");
//			System.out.print(aEmp.getJob() + ",");
//			System.out.print(aEmp.getHiredate() + ",");
//			System.out.print(aEmp.getSal() + ",");
//			System.out.print(aEmp.getComm() + ",");
//			System.out.print(aEmp.getDeptno());
//			System.out.println();
//		}
//	}
}