package com.pub_reservation.model;

import static com.util.Common.JNDIURL;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class Pub_reservaion_DAO implements Pub_reservation_DAO_interface{
	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
		private static DataSource ds = null;
		static {
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup(JNDIURL);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		
		private static final String INSERT_STMT = "INSERT INTO pub_reservation(pub_no,pub_available,pub_reservation_date)VALUES (?,?,?);";
		private static final String GET_ONE_STMT = "SELECT * FROM pub where pub_no = ? and pub_reservation_date = ?";
		private static final String UPDATE = "UPDATE pub_reservation set pub_available=? WHERE pub_no = ? AND pub_reservation_date = ?";
		private static final String GET_ALL_STMT = "SELECT * FROM pub where pub_no = ? and (pub_reservation_date => ? and pub_reservation_date <= ?)";
		//mysql> SELECT * FROM table WHERE date >= '2018-05-10' AND date <= '2018-08-20';
		@Override
		public void insert(Pub_reservation_VO pub_reservation_VO) {
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {
				pstmt.setInt(1, pub_reservation_VO.getPub_no());
				pstmt.setString(2, pub_reservation_VO.getPub_available());
				pstmt.setDate(3, pub_reservation_VO.getPub_reservation_date());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException("A database error occured. " + e.getMessage());
			}
			
		}
		@Override
		public void update(Pub_reservation_VO pub_reservation_VO) {
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE)) {
				pstmt.setString(1, pub_reservation_VO.getPub_available());
				pstmt.setInt(2, pub_reservation_VO.getPub_no());
				pstmt.setDate(3, pub_reservation_VO.getPub_reservation_date());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException("A database error occured. " + e.getMessage());
			}
			
		}
		@Override
		public Pub_reservation_VO findReservation(Integer pub_no, Date pub_reservation_date) {
			Pub_reservation_VO pub_reservation_VO = null;
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {
				pstmt.setInt(1, pub_no);
				pstmt.setDate(2, pub_reservation_date);
				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						pub_reservation_VO = new Pub_reservation_VO();
						pub_reservation_VO.setPub_reservation_no(rs.getInt(0));
						pub_reservation_VO.setPub_no(rs.getInt(1));
						pub_reservation_VO.setPub_available(rs.getString(2));
						pub_reservation_VO.setPub_reservation_date(rs.getDate(4));
					}
				}

				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. " + se.getMessage());
				// Clean up JDBC resources
			}
			return pub_reservation_VO;
		}
		@Override
		public List<Pub_reservation_VO> getReservationRange(Integer pub_no, Date startDate, Date endDate) {
			List<Pub_reservation_VO> list = new ArrayList<Pub_reservation_VO>();
			Pub_reservation_VO pub_reservation_VO = null;
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT)) {
				pstmt.setInt(1, pub_no);
				pstmt.setDate(2, startDate);
				pstmt.setDate(3, endDate);
				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						pub_reservation_VO = new Pub_reservation_VO();
						pub_reservation_VO.setPub_reservation_no(rs.getInt(0));
						pub_reservation_VO.setPub_no(rs.getInt(1));
						pub_reservation_VO.setPub_available(rs.getString(2));
						pub_reservation_VO.setPub_reservation_date(rs.getDate(4));
						list.add(pub_reservation_VO);
					}
				}
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. " + se.getMessage());
				// Clean up JDBC resources
			}
			return list;
		}
	

}
