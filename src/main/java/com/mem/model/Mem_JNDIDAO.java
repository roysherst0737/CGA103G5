package com.mem.model;

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

public class Mem_JNDIDAO implements Mem_DAO_interface{


	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	private int  result = 0;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/lonelybar");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO mem (mem_account, mem_password, mem_gender, mem_last_name, "
		+ "mem_first_name, mem_nickname, mem_tel_no, mem_cel_no, mem_email, mem_id, mem_birth,"
		+ " mem_addr, mem_permission, status, mem_build_time, mem_cert_status)"
		+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT mem_no, mem_account, mem_password, mem_gender, mem_last_name, mem_first_name,"
		+ " mem_nickname, mem_tel_no, mem_cel_no, mem_email, mem_id, mem_birth, mem_addr,"
		+ " mem_permission, status, mem_build_time, mem_cert_status FROM mem order by mem_no";
	private static final String GET_ONE_STMT = 
		"SELECT mem_no, mem_account, mem_password, mem_gender, mem_last_name, mem_first_name,"
		+ " mem_nickname, mem_tel_no, mem_cel_no, mem_email, mem_id, mem_birth, mem_addr,"
		+ " mem_permission, status, mem_build_time, mem_cert_status FROM mem where mem_no = ?";
	private static final String DELETE = 
		"DELETE FROM mem where mem_no = ?";
	private static final String UPDATE = 
		"UPDATE mem set mem_account=?, mem_password=?, mem_gender=?, mem_last_name=?, mem_first_name=?,"
		+ " mem_nickname=?, mem_tel_no=?, mem_cel_no=?, mem_email=?, mem_id=?, mem_birth=?, mem_addr=?, mem_permission=?,"
		+ " status=?, mem_build_time=?, mem_cert_status=? where mem_no = ?";

	private static final String LOGIN = 
			"SELECT mem_no, mem_account, mem_password, mem_gender, mem_last_name, mem_first_name,"
			+ " mem_nickname, mem_tel_no, mem_cel_no, mem_email, mem_id, mem_birth, mem_addr,"
			+ " mem_permission, status, mem_build_time, mem_cert_status  FROM mem where mem_account =? and mem_password =?";
	
	@Override
	public void insert(Mem_VO memVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, memVO.getMem_account());
			pstmt.setString(2, memVO.getMem_password());
			pstmt.setInt(3, memVO.getMem_gender());
			pstmt.setString(4, memVO.getMem_last_name());
			pstmt.setString(5, memVO.getMem_first_name());
			pstmt.setString(6, memVO.getMem_nickname());
			pstmt.setString(7, memVO.getMem_tel_no());
			pstmt.setString(8, memVO.getMem_cel_no());
			pstmt.setString(9, memVO.getMem_email());
			pstmt.setString(10, memVO.getMem_id());
			pstmt.setDate(11, memVO.getMem_birth());
			pstmt.setString(12, memVO.getMem_addr());
			pstmt.setInt(13, memVO.getMem_permission());
			pstmt.setInt(14, memVO.getStatus());
			pstmt.setTimestamp(15, memVO.getMem_build_time());
			pstmt.setInt(16, memVO.getMem_cert_status());





			pstmt.executeUpdate();

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
     public void update(Mem_VO memVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setString(1, memVO.getMem_account());
			pstmt.setString(2, memVO.getMem_password());
			pstmt.setInt(3, memVO.getMem_gender());
			pstmt.setString(4, memVO.getMem_last_name());
			pstmt.setString(5, memVO.getMem_first_name());
			pstmt.setString(6, memVO.getMem_nickname());
			pstmt.setString(7, memVO.getMem_tel_no());
			pstmt.setString(8, memVO.getMem_cel_no());
			pstmt.setString(9, memVO.getMem_email());
			pstmt.setString(10, memVO.getMem_id());
			pstmt.setDate(11, memVO.getMem_birth());
			pstmt.setString(12, memVO.getMem_addr());
			pstmt.setInt(13, memVO.getMem_permission());
			pstmt.setInt(14, memVO.getStatus());
			pstmt.setTimestamp(15, memVO.getMem_build_time());
			pstmt.setInt(16, memVO.getMem_cert_status());
			pstmt.setInt(17, memVO.getMem_no());
			
			pstmt.executeUpdate();

			// Handle any driver errors
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
    public void delete(Integer mem_no) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mem_no);

			pstmt.executeUpdate();

			// Handle any driver errors
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
	public Mem_VO findByPrimaryKey(Integer mem_no) {

		Mem_VO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mem_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memVO = new Mem_VO();
				memVO.setMem_no(rs.getInt("mem_no"));
				memVO.setMem_account(rs.getString("mem_account"));
				memVO.setMem_password(rs.getString("mem_password"));
				memVO.setMem_gender(rs.getInt("mem_gender"));
				memVO.setMem_last_name(rs.getString("mem_last_name"));
				memVO.setMem_first_name(rs.getString("mem_first_name"));
				memVO.setMem_nickname(rs.getString("mem_nickname"));
				memVO.setMem_tel_no(rs.getString("mem_tel_no"));
				memVO.setMem_cel_no(rs.getString("mem_cel_no"));
				memVO.setMem_email(rs.getString("mem_email"));
				memVO.setMem_id(rs.getString("mem_id"));
				memVO.setMem_birth(rs.getDate("mem_birth"));
				memVO.setMem_addr(rs.getString("mem_addr"));
				memVO.setMem_permission(rs.getInt("mem_permission"));
				memVO.setStatus(rs.getInt("status"));
				memVO.setMem_build_time(rs.getTimestamp("mem_build_time"));
				memVO.setMem_cert_status(rs.getInt("mem_cert_status"));
			}

			// Handle any driver errors
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
		return memVO;
	}

	@Override
	public List<Mem_VO> getAll() {
		List<Mem_VO> list = new ArrayList<Mem_VO>();
		Mem_VO memVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				memVO = new Mem_VO();
				memVO.setMem_no(rs.getInt("mem_no"));
				memVO.setMem_account(rs.getString("mem_account"));
				memVO.setMem_password(rs.getString("mem_password"));
				memVO.setMem_gender(rs.getInt("mem_gender"));
				memVO.setMem_last_name(rs.getString("mem_last_name"));
				memVO.setMem_first_name(rs.getString("mem_first_name"));
				memVO.setMem_nickname(rs.getString("mem_nickname"));
				memVO.setMem_tel_no(rs.getString("mem_tel_no"));
				memVO.setMem_cel_no(rs.getString("mem_cel_no"));
				memVO.setMem_email(rs.getString("mem_email"));
				memVO.setMem_id(rs.getString("mem_id"));
				memVO.setMem_birth(rs.getDate("mem_birth"));
				memVO.setMem_addr(rs.getString("mem_addr"));
				memVO.setMem_permission(rs.getInt("mem_permission"));
				memVO.setStatus(rs.getInt("status"));
				memVO.setMem_build_time(rs.getTimestamp("mem_build_time"));
				memVO.setMem_cert_status(rs.getInt("mem_cert_status"));
				list.add(memVO); // Store the row in the list
			}

			// Handle any driver errors
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
	
	@Override
    public Mem_VO login(String mem_account,String mem_password) {
		Mem_VO memVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(LOGIN);

			pstmt.setString(1, mem_account);
			pstmt.setString(2, mem_password);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				memVO = new Mem_VO();
				memVO.setMem_no(rs.getInt("mem_no"));
				memVO.setMem_account(rs.getString("mem_account"));
				memVO.setMem_password(rs.getString("mem_password"));
				memVO.setMem_gender(rs.getInt("mem_gender"));
				memVO.setMem_last_name(rs.getString("mem_last_name"));
				memVO.setMem_first_name(rs.getString("mem_first_name"));
				memVO.setMem_nickname(rs.getString("mem_nickname"));
				memVO.setMem_tel_no(rs.getString("mem_tel_no"));
				memVO.setMem_cel_no(rs.getString("mem_cel_no"));
				memVO.setMem_email(rs.getString("mem_email"));
				memVO.setMem_id(rs.getString("mem_id"));
				memVO.setMem_birth(rs.getDate("mem_birth"));
				memVO.setMem_addr(rs.getString("mem_addr"));
				memVO.setMem_permission(rs.getInt("mem_permission"));
				memVO.setStatus(rs.getInt("status"));
				memVO.setMem_build_time(rs.getTimestamp("mem_build_time"));
				memVO.setMem_cert_status(rs.getInt("mem_cert_status"));
			}
				
		}catch (SQLException se) {
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
		return memVO;
	}
}
