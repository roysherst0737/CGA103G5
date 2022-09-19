package com.manager_authfunc.model;

import java.util.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.manager.model.Manager_JDBCDAO;
import com.manager.model.Manager_VO;


public class Manager_authfunc_DAO implements Manager_authfunc_DAO_interface {

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
			"INSERT INTO manager_authfunc (mng_authfunc_name) VALUES (?)";
		private static final String GET_ALL_MANAGER_AUTHFUNC_STMT = 
			"SELECT mng_authfunc_no, mng_authfunc_name FROM manager_authfunc order by mng_authfunc_no";
		private static final String GET_ONE_STMT = 
			"SELECT mng_authfunc_no, mng_authfunc_name FROM manager_authfunc where mng_authfunc_no = ?";
		private static final String DELETE_Mngs = 
			"DELETE FROM manager where mng_authfunc_no = ?";
		private static final String DELETE_Mng_authfunc = 
			"DELETE FROM manager_authfunc where mng_authfunc_no = ?";
		private static final String UPDATE = 
			"UPDATE manager_authfunc set mng_authfunc_name = ? where mng_authfunc_no = ?";
		private static final String GET_Mngs_ByMng_authfunc_noSTMT = 
			"SELECT mng_no,mng_account,mng_password,mng_name,mng_phone,mng_pic,mng_status,mng_authfunc_no "
			+ "FROM manager where mng_authfunc_no = ? order by mng_no";

		@Override
		public void insert(Manager_authfunc_VO manager_authfunc_VO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(INSERT_STMT);
				pstmt.setString(1, manager_authfunc_VO.getMng_authfunc_name());
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
		public void update(Manager_authfunc_VO manager_authfunc_VO) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(UPDATE);

				pstmt.setString(1, manager_authfunc_VO.getMng_authfunc_name());
				pstmt.setInt(2, manager_authfunc_VO.getMng_authfunc_no());

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
		public void delete(Integer mng_authfunc_no) {
			int updateCount_Mngs = 0;
			
			Connection con = null;
			PreparedStatement pstmt = null;

				try {

					con = ds.getConnection();

					// 1●設定於 pstm.executeUpdate()之前
					con.setAutoCommit(false);

					// 先刪除管理員
					pstmt = con.prepareStatement(DELETE_Mngs);
					pstmt.setInt(1, mng_authfunc_no);
					updateCount_Mngs = pstmt.executeUpdate();
					// 再刪除權限
					pstmt = con.prepareStatement(DELETE_Mng_authfunc);
					pstmt.setInt(1, mng_authfunc_no);
					pstmt.executeUpdate();

					// 2●設定於 pstm.executeUpdate()之後
					con.commit();
					con.setAutoCommit(true);
					System.out.println("刪除權限編號" + mng_authfunc_no + "時,共有管理員" + updateCount_Mngs
							+ "人同時被刪除");
					
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
		public Manager_authfunc_VO findByPrimaryKey(Integer mng_authfunc_no) {

			Manager_authfunc_VO manager_authfunc_VO = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ONE_STMT);

				pstmt.setInt(1, mng_authfunc_no);

				rs = pstmt.executeQuery();

				while (rs.next()) {
					// manager_authfunc_Vo 也稱為 Domain objects
					manager_authfunc_VO = new Manager_authfunc_VO();
					manager_authfunc_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
					manager_authfunc_VO.setMng_authfunc_name(rs.getString("mng_authfunc_name"));
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
			return manager_authfunc_VO;
		}

		@Override
		public List<Manager_authfunc_VO> getAllManager_authfunc() {
			List<Manager_authfunc_VO> list = new ArrayList<Manager_authfunc_VO>();
			Manager_authfunc_VO manager_authfunc_VO = null;

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {

				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_ALL_MANAGER_AUTHFUNC_STMT);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					// manager_authfunc_Vo 也稱為 Domain objects
					manager_authfunc_VO = new Manager_authfunc_VO();
					manager_authfunc_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
					manager_authfunc_VO.setMng_authfunc_name(rs.getString("mng_authfunc_name"));
					list.add(manager_authfunc_VO); // Store the row in the list
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
		public List<Manager_authfunc_VO> getAllManager_authfunc(Map<String, String[]> map) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Set<Manager_VO> getMngsByMng_authfunc_no(Integer mng_authfunc_no) {
			Set<Manager_VO> set = new HashSet<Manager_VO>();
			Manager_VO manager_VO = null;
		
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			try {
		
				con = ds.getConnection();
				pstmt = con.prepareStatement(GET_Mngs_ByMng_authfunc_noSTMT);
				pstmt.setInt(1, mng_authfunc_no);
				rs = pstmt.executeQuery();
		
				while (rs.next()) {
					manager_VO = new Manager_VO();
					manager_VO.setMng_no(rs.getInt("mng_no"));
					manager_VO.setMng_account(rs.getString("mng_account"));
					manager_VO.setMng_password(rs.getString("mng_password"));
					manager_VO.setMng_name(rs.getString("mng_name"));
					manager_VO.setMng_phone(rs.getString("mng_phone"));
					manager_VO.setMng_pic(rs.getBytes("mng_pic"));
					manager_VO.setMng_status(rs.getInt("mng_status"));
					manager_VO.setMng_authfunc_no(rs.getInt("mng_authfunc_no"));
					set.add(manager_VO); // Store the row in the vector
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
			return set;
		}

		@Override
		public void insertWithMngs(Manager_authfunc_VO manager_authfunc_VO , List<Manager_VO> list) {

			Connection con = null;
			PreparedStatement pstmt = null;

			try {

				con = ds.getConnection();
				
				// 1●設定於 pstm.executeUpdate()之前
	    		con.setAutoCommit(false);
				
	    		// 先新增部門
				String cols[] = {"MNG_AUTHFUNC_NO"};
				pstmt = con.prepareStatement(INSERT_STMT , cols);			
				pstmt.setString(1, manager_authfunc_VO.getMng_authfunc_name());

	Statement stmt=	con.createStatement();
	stmt.executeUpdate("set auto_increment_offset=10;");    //自增主鍵-初始值
	stmt.executeUpdate("set auto_increment_increment=10;"); //自增主鍵-遞增
				pstmt.executeUpdate();
				//掘取對應的自增主鍵值
				String next_mng_authfunc_no = null;
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					next_mng_authfunc_no = rs.getString(1);
					System.out.println("自增主鍵值= " + next_mng_authfunc_no +"(剛新增成功的部門編號)");
				} else {
					System.out.println("未取得自增主鍵值");
				}
				rs.close();
				// 再同時新增員工
				Manager_JDBCDAO dao = new Manager_JDBCDAO();
				System.out.println("list.size()-A="+list.size());
				for (Manager_VO aManager : list) {
					aManager.setMng_authfunc_no(new Integer(next_mng_authfunc_no)) ;
					dao.insert2(aManager,con);
				}

				// 2●設定於 pstm.executeUpdate()之後
				con.commit();
				con.setAutoCommit(true);
				System.out.println("list.size()-B="+list.size());
				System.out.println("新增部門編號" + next_mng_authfunc_no + "時,共有員工" + list.size()
						+ "人同時被新增");
				
			} catch (SQLException se) {
				if (con != null) {
					try {
						// 3●設定於當有exception發生時之catch區塊內
						System.err.print("Transaction is being ");
						System.err.println("rolled back-由-dept");
						con.rollback();
					} catch (SQLException excep) {
						throw new RuntimeException("rollback error occured. "
								+ excep.getMessage());
					}
				}
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
}
