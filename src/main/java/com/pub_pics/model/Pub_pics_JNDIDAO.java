package com.pub_pics.model;

import static com.util.Common.JNDIURL;

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

public class Pub_pics_JNDIDAO implements Pub_pics_DAO_interface {
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

	private static final String INSERT_STMT = "INSERT INTO pub_pics(pub_no,pub_pic)VALUES (?,?)";
	private static final String GET_ALL_STMT = "SELECT * FROM pub_pics where pub_no = ?";
	private static final String GET_ONE_STMT = "SELECT * FROM pub_pics where pub_pic_no = ?";
	private static final String UPDATE = "UPDATE pub_pics set pub_no=?,pub_pic=?where pub_pic_no = ?";
	private static final String DELETE = "DELETE pub_pics WHERE pub_pic_no=?";

	@Override
	public void insert(Pub_pics_VO pub_pic_no) {

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {
			pstmt.setInt(1, pub_pic_no.getPub_no());
			pstmt.setBlob(2, pub_pic_no.getPub_pic());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}
	}

	@Override
	public void update(Pub_pics_VO pub_pic_no) {

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE)) {
			pstmt.setInt(1, pub_pic_no.getPub_no());
			pstmt.setBlob(2, pub_pic_no.getPub_pic());
			pstmt.setInt(3, pub_pic_no.getPub_pic_no());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}

	}

	@Override
	public void delete(Pub_pics_VO pub_pic_no) {
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(DELETE)) {
			pstmt.setInt(1, pub_pic_no.getPub_pic_no());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}

	}

	@Override
	public Pub_pics_VO findByPrimaryKey(Integer pub_pic_no) {
		Pub_pics_VO pub_pics_VO = null;

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {

			pstmt.setInt(1, pub_pic_no);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					pub_pics_VO = new Pub_pics_VO();
					pub_pics_VO.setPub_pic_no(rs.getInt(0));
					pub_pics_VO.setPub_no(rs.getInt(1));
					pub_pics_VO.setPub_pic(rs.getBlob(2));
				}
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		}
		return pub_pics_VO;
	}

	@Override
	public List<Pub_pics_VO> getAll(Integer pub_no) {
		List<Pub_pics_VO> list = new ArrayList<Pub_pics_VO>();
		Pub_pics_VO pub_pics_VO = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT)) {

			pstmt.setInt(1, pub_no);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					pub_pics_VO = new Pub_pics_VO();
					pub_pics_VO.setPub_pic_no(rs.getInt(0));
					pub_pics_VO.setPub_no(rs.getInt(1));
					pub_pics_VO.setPub_pic(rs.getBlob(2));
					list.add(pub_pics_VO);
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
