package com.pub_booking.model;

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

public class Pub_booking_JNDIDAO implements Pub_booking_DAO_interface{
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
		
		private static final String INSERT_STMT = "INSERT INTO pub_booking(pub_no,mem_no,pub_booking_date,pub_booking_time,pub_booking_status)VALUES (?,?,?,?,?)";
		private static final String GET_ALL_PUB_STMT = "SELECT pub_no,mem_no,pub_booking_date,pub_booking_time,pub_status FROM pub_booking  where pub_no =?";
		private static final String GET_ALL_PUB_DATE_STMT = "SELECT pub_no,mem_no,pub_booking_date,pub_booking_time,pub_status FROM pub_booking  where pub_no =? and pub_booking_date = ?";
		private static final String GET_ALL_MEM_STMT = "SELECT pub_no,mem_no,pub_booking_date,pub_booking_time,pub_status FROM pub_booking  where mem_no =?";
		private static final String GET_ALL_MEM_DATE_STMT = "SELECT pub_no,mem_no,pub_booking_date,pub_booking_time,pub_status FROM pub_booking  where mem_no =? and pub_booking_date = ?";
		private static final String GET_ONE_STMT = "SELECT pub_no,mem_no,pub_booking_date,pub_booking_time,pub_status FROM pub_booking where pub_no = ? AND mem_no = ? AND pub_booking_date = ?";
		private static final String UPDATE = "UPDATE pub_booking set pub_booking_time=?,pub_booking_status = ? WHERE pub_no= ? mem_no = ? pub_booking_date = ? ";
		@Override
		public void insert(Pub_booking_VO pub_booking_VO) {
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {
				pstmt.setInt(1, pub_booking_VO.getPub_no());
				pstmt.setInt(2, pub_booking_VO.getMem_no());
				pstmt.setDate(3, pub_booking_VO.getPub_booking_date());
				pstmt.setString(4, pub_booking_VO.getPub_booking_time());
				pstmt.setInt(5, pub_booking_VO.getPub_booking_status());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException("A database error occured. " + e.getMessage());
			}
		}
		@Override
		public void update(Pub_booking_VO pub_booking_VO) {
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE)) {
				pstmt.setString(1, pub_booking_VO.getPub_booking_time());
				pstmt.setInt(2, pub_booking_VO.getPub_booking_status());
				pstmt.setInt(3, pub_booking_VO.getPub_no());
				pstmt.setInt(4, pub_booking_VO.getMem_no());
				pstmt.setDate(5, pub_booking_VO.getPub_booking_date());
				pstmt.executeUpdate();

			} catch (SQLException e) {
				throw new RuntimeException("A database error occured. " + e.getMessage());
			}
			
		}
		@Override
		public Pub_booking_VO findBooking(Integer pub_no, Integer mem_no, Date pub_booking_date) {
			Pub_booking_VO pub_booking_VO = null;

			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {

				pstmt.setInt(1, pub_no);
				pstmt.setInt(1, mem_no);
				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						pub_booking_VO = new Pub_booking_VO();
						pub_booking_VO.setPub_no(rs.getInt(0));
						pub_booking_VO.setMem_no(rs.getInt(1));
						pub_booking_VO.setPub_booking_date(rs.getDate(2));
						pub_booking_VO.setPub_booking_time(rs.getString(3));
						pub_booking_VO.setPub_booking_status(rs.getInt(4));
					}
				}

				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. " + se.getMessage());
				// Clean up JDBC resources
			}
			return pub_booking_VO;
		}
		@Override
		public List<Pub_booking_VO> getAllPubBooking(Integer pub_no, Date pub_booking_date) {
			List<Pub_booking_VO> list = new ArrayList<Pub_booking_VO>();
			Pub_booking_VO pub_booking_VO = null;
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_PUB_DATE_STMT)) {
				pstmt.setInt(1, pub_no);
				pstmt.setDate(2, pub_booking_date);
				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						pub_booking_VO = new Pub_booking_VO();
						pub_booking_VO.setPub_no(rs.getInt(0));
						pub_booking_VO.setMem_no(rs.getInt(1));
						pub_booking_VO.setPub_booking_date(rs.getDate(2));
						pub_booking_VO.setPub_booking_time(rs.getString(3));
						pub_booking_VO.setPub_booking_status(rs.getInt(4));
						list.add(pub_booking_VO);
					}
				}
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. " + se.getMessage());
				// Clean up JDBC resources
			}
			return list;
		}
		@Override
		public List<Pub_booking_VO> getAllPubBooking(Integer pub_no) {
			List<Pub_booking_VO> list = new ArrayList<Pub_booking_VO>();
			Pub_booking_VO pub_booking_VO = null;
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_PUB_STMT)) {
				pstmt.setInt(1, pub_no);
				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						pub_booking_VO = new Pub_booking_VO();
						pub_booking_VO.setPub_no(rs.getInt(0));
						pub_booking_VO.setMem_no(rs.getInt(1));
						pub_booking_VO.setPub_booking_date(rs.getDate(2));
						pub_booking_VO.setPub_booking_time(rs.getString(3));
						pub_booking_VO.setPub_booking_status(rs.getInt(4));
						list.add(pub_booking_VO);
					}
				}
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. " + se.getMessage());
				// Clean up JDBC resources
			}
			return list;
		}
		@Override
		public List<Pub_booking_VO> getAllMemBooking(Integer mem_no, Date pub_booking_date) {
			List<Pub_booking_VO> list = new ArrayList<Pub_booking_VO>();
			Pub_booking_VO pub_booking_VO = null;
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_MEM_DATE_STMT)) {
				pstmt.setInt(1, mem_no);
				pstmt.setDate(2, pub_booking_date);
				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						pub_booking_VO = new Pub_booking_VO();
						pub_booking_VO.setPub_no(rs.getInt(0));
						pub_booking_VO.setMem_no(rs.getInt(1));
						pub_booking_VO.setPub_booking_date(rs.getDate(2));
						pub_booking_VO.setPub_booking_time(rs.getString(3));
						pub_booking_VO.setPub_booking_status(rs.getInt(4));
						list.add(pub_booking_VO);
					}
				}
				// Handle any SQL errors
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. " + se.getMessage());
				// Clean up JDBC resources
			}
			return list;
		}
		@Override
		public List<Pub_booking_VO> getAllMemBooking(Integer mem_no) {
			List<Pub_booking_VO> list = new ArrayList<Pub_booking_VO>();
			Pub_booking_VO pub_booking_VO = null;
			try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_MEM_STMT)) {
				pstmt.setInt(1, mem_no);
				try (ResultSet rs = pstmt.executeQuery()) {

					while (rs.next()) {
						pub_booking_VO = new Pub_booking_VO();
						pub_booking_VO.setPub_no(rs.getInt(0));
						pub_booking_VO.setMem_no(rs.getInt(1));
						pub_booking_VO.setPub_booking_date(rs.getDate(2));
						pub_booking_VO.setPub_booking_time(rs.getString(3));
						pub_booking_VO.setPub_booking_status(rs.getInt(4));
						list.add(pub_booking_VO);
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
