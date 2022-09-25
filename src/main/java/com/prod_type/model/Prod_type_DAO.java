package com.prod_type.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.prod.model.Prod_VO;

public class Prod_type_DAO implements Prod_type_DAO_interface {
	
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static final String INSERT_STMT = 
		"INSERT INTO prod_type (prod_type_name) VALUES (?)";
	private static final String GET_ALL_STMT = 
		"SELECT prod_type_no,prod_type_name FROM prod_type order by prod_type_no";
	private static final String GET_ONE_STMT = 
		"SELECT prod_type_no,prod_type_name FROM prod_type where prod_type_no = ?";
	private static final String GET_Prods_ByProd_type_STMT = 
		"SELECT prod_no,prod_type_no,prod_name,prod_price,prod_stock,prod_status,launch_time,off_time,prod_detail FROM prod where prod_type_no = ? order by prod_no";
	private static final String DELETE_Prods = 
		"DELETE FROM prod where prod_type_no = ?";
	private static final String DELETE_Prod_type = 
		"DELETE FROM prod_type where prod_type_no = ?";
	private static final String UPDATE = 
		"UPDATE prod_type set prod_type_name = ? where prod_type_no = ?";
	
	@Override
	public void insert(Prod_type_VO prod_typeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setString(1, prod_typeVO.getProd_type_name());

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
	public void update(Prod_type_VO prod_typeVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			
			pstmt.setString(1, prod_typeVO.getProd_type_name());
			pstmt.setInt(2, prod_typeVO.getProd_type_no());

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

	@SuppressWarnings("resource")
	@Override
	public void delete(Integer prod_type_no) {
		int updateCount_Prods = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			con.setAutoCommit(false);
			
			// 先刪除商品
			pstmt = con.prepareStatement(DELETE_Prods);
			pstmt.setInt(1, prod_type_no);
			updateCount_Prods = pstmt.executeUpdate();
			
			//再刪除商品類別
			pstmt = con.prepareStatement(DELETE_Prod_type);
			pstmt.setInt(1, prod_type_no);
			pstmt.executeUpdate();
			
			// 2●設定於 pstm.executeUpdate()之後
			con.commit();
			con.setAutoCommit(true);
			System.out.println("刪除商品類別編號" + prod_type_no + "時,共有商品" + updateCount_Prods
					+ "件同時被刪除");

			// Handle any SQL errors
		} catch (SQLException se) {
			if (con != null) {
				try {
					// 3●設定於當有exception發生時之catch區塊內
					con.rollback();
				} catch (SQLException excep) {
					throw new RuntimeException("rollback error occured. "
							+ excep.getMessage());
				}
			}
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
	public Prod_type_VO findByPrimaryKey(Integer prod_type_no) {
		Prod_type_VO prod_typeVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, prod_type_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				prod_typeVO = new Prod_type_VO();
				prod_typeVO.setProd_type_no(rs.getInt("prod_type_no"));
				prod_typeVO.setProd_type_name(rs.getString("prod_type_name"));
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
		return prod_typeVO;
	}

	@Override
	public List<Prod_type_VO> getAll() {
		List<Prod_type_VO> list = new ArrayList<Prod_type_VO>();
		Prod_type_VO prod_typeVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				prod_typeVO = new Prod_type_VO();
				prod_typeVO.setProd_type_no(rs.getInt("prod_type_no"));
				prod_typeVO.setProd_type_name(rs.getString("prod_type_name"));
				
				list.add(prod_typeVO); // Store the row in the list
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
	
	public Set<Prod_VO> getProdsByProd_type(Integer prod_type_no) {
		Set<Prod_VO> set = new LinkedHashSet<Prod_VO>();
		Prod_VO prodVO = null;
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		try {
	
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_Prods_ByProd_type_STMT);
			pstmt.setInt(1, prod_type_no);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				prodVO = new Prod_VO();
				prodVO.setProd_no(rs.getInt("prod_no"));
				prodVO.setProd_type_no(rs.getInt("prod_type_no"));
				prodVO.setProd_name(rs.getString("prod_name"));
				prodVO.setProd_price(rs.getInt("prod_price"));
				prodVO.setProd_stock(rs.getInt("prod_stock"));
				prodVO.setProd_status(rs.getInt("prod_status"));
				prodVO.setLaunch_time(rs.getTimestamp("launch_time"));
				prodVO.setOff_time(rs.getTimestamp("off_time"));
				prodVO.setProd_detail(rs.getString("prod_detail"));
				set.add(prodVO); // Store the row in the vector
			}
	
			// Handle any SQL errors
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
		return set;
	}
}