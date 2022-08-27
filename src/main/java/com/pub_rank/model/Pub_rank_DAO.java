package com.pub_rank.model;

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

public class Pub_rank_DAO implements Pub_rank_DAO_interface {
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

	private static final String INSERT_STMT = "INSERT INTO pub_rank(pub_no,mem_no,pub_rate," + "pub_comment)"
			+ "VALUES (?,?,?,?)";
	private static final String GET_ALL_PUB_STMT = "SELECT * FROM pub_rank WHERE pub_no = ?";
	private static final String GET_ALL_MEM_STMT = "SELECT * FROM pub_rank WHERE mem_no = ?";
	private static final String GET_ONE_STMT = "SELECT * FROM pub_rank where pub_no = ? AND mem_no = ?";
	private static final String UPDATE = "UPDATE pub_rank set pub_rate=?,pub_comment=?)"
			+ "where pub_no = ? AND mem_no = ?";
	private static final String DELETE = "DELETE pub_rank where pub_no = ? AND mem_no = ?";

	@Override
	public void insert(Pub_rank_VO pub_rank_VO) {

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(INSERT_STMT)) {
			pstmt.setInt(1, pub_rank_VO.getPub_no());
			pstmt.setInt(2, pub_rank_VO.getMem_no());
			pstmt.setInt(3, pub_rank_VO.getPub_rate());
			pstmt.setString(4, pub_rank_VO.getPub_comment());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}
	}

	@Override
	public void update(Pub_rank_VO pub_rank_VO) {
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(UPDATE)) {
			pstmt.setInt(1, pub_rank_VO.getPub_rate());
			pstmt.setString(2, pub_rank_VO.getPub_comment());
			pstmt.setInt(3, pub_rank_VO.getPub_no());
			pstmt.setInt(4, pub_rank_VO.getMem_no());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}

	}

	@Override
	public void delete(Pub_rank_VO pub_rank_VO) {
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(DELETE)) {
			pstmt.setInt(1, pub_rank_VO.getPub_no());
			pstmt.setInt(2, pub_rank_VO.getMem_no());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}
	}

	@Override
	public Pub_rank_VO findByPrimaryKey(Integer pub_no, Integer mem_no) {
		Pub_rank_VO pub_rank_VO = null;

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {

			pstmt.setInt(1, pub_no);
			pstmt.setInt(2, mem_no);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					pub_rank_VO = new Pub_rank_VO();
					pub_rank_VO.setPub_no(rs.getInt(0));
					pub_rank_VO.setMem_no(rs.getInt(1));
					pub_rank_VO.setPub_rate(rs.getInt(2));
					pub_rank_VO.setPub_comment(rs.getString(3));
				}
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		}
		return pub_rank_VO;
	}

	@Override
	public List<Pub_rank_VO> getMemAll(Integer mem_no) {
		List<Pub_rank_VO> list = new ArrayList<Pub_rank_VO>();
		Pub_rank_VO pub_rank_VO = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_MEM_STMT)) {
			pstmt.setInt(1, mem_no);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					pub_rank_VO = new Pub_rank_VO();
					pub_rank_VO.setPub_no(rs.getInt(0));
					pub_rank_VO.setMem_no(rs.getInt(1));
					pub_rank_VO.setPub_rate(rs.getInt(2));
					pub_rank_VO.setPub_comment(rs.getString(3));
					list.add(pub_rank_VO);
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
	public List<Pub_rank_VO> getPubAll(Integer pub_no) {
		List<Pub_rank_VO> list = new ArrayList<Pub_rank_VO>();
		Pub_rank_VO pub_rank_VO = null;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(GET_ALL_PUB_STMT)) {
			pstmt.setInt(1, pub_no);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					pub_rank_VO = new Pub_rank_VO();
					pub_rank_VO.setPub_no(rs.getInt(0));
					pub_rank_VO.setMem_no(rs.getInt(1));
					pub_rank_VO.setPub_rate(rs.getInt(2));
					pub_rank_VO.setPub_comment(rs.getString(3));
					list.add(pub_rank_VO);
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
