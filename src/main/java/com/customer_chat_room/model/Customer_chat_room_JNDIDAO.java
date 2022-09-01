package com.customer_chat_room.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Customer_chat_room_JNDIDAO implements Customer_chat_room_DAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}

		private static final String INSERT_STMT = 
			"INSERT INTO customer_chat_room (mng_no,mem_no,prod_no,message,mem_question_pic,message_chat_time,chat_direction) VALUES (?, ?, ?, ?, ?, ?, ?)";
		private static final String GET_ALL_CUSTOMER_CHAT_ROOM_STMT = 
			"SELECT SN,mng_no,mem_no,prod_no,message,mem_question_pic,message_chat_time,chat_direction FROM customer_chat_room order by SN";
		private static final String GET_ONE_STMT = 
			"SELECT SN,mng_no,mem_no,prod_no,message,mem_question_pic,message_chat_time,chat_direction FROM customer_chat_room where SN = ?";
		private static final String DELETE = 
			"DELETE FROM customer_chat_room where SN = ?";
		private static final String UPDATE = 
			"UPDATE customer_chat_room set mng_no=?, mem_no=?, prod_no=?, message=?, mem_question_pic=?, message_chat_time=?, chat_direction=? where SN = ?";


		@Override
		public void insert(Customer_chat_room_VO customer_chat_room_VO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);

				pstmt.setInt(1, customer_chat_room_VO.getMng_no());
				pstmt.setInt(2, customer_chat_room_VO.getMem_no());
				pstmt.setInt(3, customer_chat_room_VO.getProd_no());
				pstmt.setString(4, customer_chat_room_VO.getMessage());
				pstmt.setBytes(5, customer_chat_room_VO.getMem_question_pic());
				pstmt.setTimestamp(6, customer_chat_room_VO.getMessage_chat_time());
				pstmt.setInt(7, customer_chat_room_VO.getChat_direction());

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
		public void update(Customer_chat_room_VO customer_chat_room_VO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setInt(1, customer_chat_room_VO.getMng_no());
				pstmt.setInt(2, customer_chat_room_VO.getMem_no());
				pstmt.setInt(3, customer_chat_room_VO.getProd_no());
				pstmt.setString(4, customer_chat_room_VO.getMessage());
				pstmt.setBytes(5, customer_chat_room_VO.getMem_question_pic());
				pstmt.setTimestamp(6, customer_chat_room_VO.getMessage_chat_time());
				pstmt.setInt(7, customer_chat_room_VO.getChat_direction());
				pstmt.setInt(8, customer_chat_room_VO.getSN());

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
		public void delete(Integer SN) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(DELETE);

				pstmt.setInt(1, SN);

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
		public Customer_chat_room_VO findByPrimaryKey(Integer SN) {

			Customer_chat_room_VO customer_chat_room_VO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, SN);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// manager_authfunc_Vo 也稱為 Domain objects
					customer_chat_room_VO = new Customer_chat_room_VO();
					customer_chat_room_VO.setSN(rs.getInt("SN"));
					customer_chat_room_VO.setMng_no(rs.getInt("mng_no"));
					customer_chat_room_VO.setMem_no(rs.getInt("mem_no"));
					customer_chat_room_VO.setProd_no(rs.getInt("prod_no"));
					customer_chat_room_VO.setMessage(rs.getString("message"));
					customer_chat_room_VO.setMem_question_pic(rs.getBytes("mem_question_pic"));
					customer_chat_room_VO.setMessage_chat_time(rs.getTimestamp("message_chat_time"));
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
			return customer_chat_room_VO;
		}

		@Override
		public List<Customer_chat_room_VO> getAllCustomer_chat_room() {
			List<Customer_chat_room_VO> list = new ArrayList<Customer_chat_room_VO>();
			Customer_chat_room_VO customer_chat_room_VO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_CUSTOMER_CHAT_ROOM_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// manager_authfunc_Vo 也稱為 Domain objects
					customer_chat_room_VO = new Customer_chat_room_VO();
					customer_chat_room_VO.setSN(rs.getInt("SN"));
					customer_chat_room_VO.setMng_no(rs.getInt("mng_no"));
					customer_chat_room_VO.setMem_no(rs.getInt("mem_no"));
					customer_chat_room_VO.setProd_no(rs.getInt("prod_no"));
					customer_chat_room_VO.setMessage(rs.getString("message"));
					customer_chat_room_VO.setMem_question_pic(rs.getBytes("mem_question_pic"));
					customer_chat_room_VO.setMessage_chat_time(rs.getTimestamp("message_chat_time"));
					list.add(customer_chat_room_VO); // Store the row in the list
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
		public List<Customer_chat_room_VO> getAllCustomer_chat_room(Map<String, String[]> map) {
			// TODO Auto-generated method stub
			return null;
		}
	}