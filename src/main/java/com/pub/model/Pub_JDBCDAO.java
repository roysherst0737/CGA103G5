package com.pub.model;

import static com.util.Common.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pub_JDBCDAO implements Pub_DAO_interface {

	private static final String INSERT_STMT = "INSERT INTO pub(mem_no,pub_nop,pub_address,pub_open,"
			+ "pub_detail,pub_name,pub_lng,pub_lat,firm_name,firm_addr,firm_tel_no,"
			+ "firm_email,firm_tax_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String GET_ALL_STMT = "SELECT * FROM pub";
	private static final String GET_ONE_STMT = "SELECT * FROM pub where pub_no = ?";
	private static final String UPDATE = "UPDATE pub set pub_status=?,pub_nop=?,pub_rate_sum=?,"
			+ "pub_ratetotal=?,pub_application=?,pub_address=?,pub_open=?,pub_detail=?,"
			+ "pub_name=?,pub_lng=?,pub_lat=?,firm_name=?,firm_addr=?,firm_tel_no=?,"
			+ "firm_email=?,firm_tax_id=?where pub_no = ?";
	private static final String UPDATE_OPEN = "UPDATE pub set pub_open = ? where pub_no = ?";
	private static final String UPDATE_APPLICATION = "UPDATE pub set pub_application = ? where pub_no = ?";
	private static final String UPDATE_RATE = "UPDATE pub set pub_rate_sum = ?, pub_ratetotal = ? where pub_no = ?";

	@Override
	public void insert(Pub_VO pub_VO) {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Couldn't load database driver. " + e1.getMessage());
		}
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(INSERT_STMT);) {
			pstmt.setInt(1, pub_VO.getMem_no());
			pstmt.setInt(2, pub_VO.getPub_nop());
			pstmt.setString(3, pub_VO.getPub_address());
			pstmt.setString(4, pub_VO.getPub_open());
			pstmt.setString(5, pub_VO.getPub_detail());
			pstmt.setString(6, pub_VO.getPub_name());
			pstmt.setDouble(7, pub_VO.getPub_lng());
			pstmt.setDouble(8, pub_VO.getPub_lat());
			pstmt.setString(9, pub_VO.getFirm_name());
			pstmt.setString(10, pub_VO.getFirm_addr());
			pstmt.setString(11, pub_VO.getFirm_tel_no());
			pstmt.setString(12, pub_VO.getFirm_email());
			pstmt.setString(13, pub_VO.getFirm_tax_id());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Pub_VO pub_VO) {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Couldn't load database driver. " + e1.getMessage());
		}
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(UPDATE);) {
			pstmt.setBoolean(1, pub_VO.getPub_status());
			pstmt.setInt(2, pub_VO.getPub_nop());
			pstmt.setInt(3, pub_VO.getPub_rate_sum());
			pstmt.setInt(4, pub_VO.getPub_ratetotal());
			pstmt.setInt(5, pub_VO.getPub_application());
			pstmt.setString(6, pub_VO.getPub_address());
			pstmt.setString(7, pub_VO.getPub_open());
			pstmt.setString(8, pub_VO.getPub_detail());
			pstmt.setString(9, pub_VO.getPub_name());
			pstmt.setDouble(10, pub_VO.getPub_lng());
			pstmt.setDouble(11, pub_VO.getPub_lat());
			pstmt.setString(12, pub_VO.getFirm_name());
			pstmt.setString(13, pub_VO.getFirm_addr());
			pstmt.setString(14, pub_VO.getFirm_tel_no());
			pstmt.setString(15, pub_VO.getFirm_email());
			pstmt.setString(16, pub_VO.getFirm_tax_id());
			pstmt.setInt(17, pub_VO.getPub_no());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}
	}

	@Override
	public Pub_VO findByPrimaryKey(Integer pub_no) {
		Pub_VO pub_VO = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Couldn't load database driver. " + e1.getMessage());
		}
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(GET_ONE_STMT)) {
			pstmt.setInt(1, pub_no);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					pub_VO = new Pub_VO();
					pub_VO.setPub_no(rs.getInt(1));
					pub_VO.setMem_no(rs.getInt(2));
					pub_VO.setPub_status(rs.getBoolean(3));
					pub_VO.setPub_nop(rs.getInt(4));
					pub_VO.setPub_rate_sum(rs.getInt(5));
					pub_VO.setPub_ratetotal(rs.getInt(6));
					pub_VO.setPub_time(rs.getDate(7));
					pub_VO.setPub_application(rs.getInt(8));
					pub_VO.setPub_address(rs.getString(9));
					pub_VO.setPub_open(rs.getString(10));
					pub_VO.setPub_detail(rs.getString(11));
					pub_VO.setPub_name(rs.getString(12));
					pub_VO.setPub_lng(rs.getDouble(13));
					pub_VO.setPub_lat(rs.getDouble(14));
					pub_VO.setFirm_name(rs.getString(15));
					pub_VO.setFirm_addr(rs.getString(16));
					pub_VO.setFirm_tel_no(rs.getString(17));
					pub_VO.setFirm_email(rs.getString(18));
					pub_VO.setFirm_tax_id(rs.getString(19));
				}
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		}
		return pub_VO;
	}

	@Override
	public List<Pub_VO> getAll() {
		List<Pub_VO> list = new ArrayList<Pub_VO>();
		Pub_VO pub_VO = null;
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(GET_ALL_STMT);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				Class.forName(DRIVER);
				pub_VO = new Pub_VO();
				pub_VO.setPub_no(rs.getInt(1));
				pub_VO.setMem_no(rs.getInt(2));
				pub_VO.setPub_status(rs.getBoolean(3));
				pub_VO.setPub_nop(rs.getInt(4));
				pub_VO.setPub_rate_sum(rs.getInt(5));
				pub_VO.setPub_ratetotal(rs.getInt(6));
				pub_VO.setPub_time(rs.getDate(7));
				pub_VO.setPub_application(rs.getInt(8));
				pub_VO.setPub_address(rs.getString(9));
				pub_VO.setPub_open(rs.getString(10));
				pub_VO.setPub_detail(rs.getString(11));
				pub_VO.setPub_name(rs.getString(12));
				pub_VO.setPub_lng(rs.getDouble(13));
				pub_VO.setPub_lat(rs.getDouble(14));
				pub_VO.setFirm_name(rs.getString(15));
				pub_VO.setFirm_addr(rs.getString(16));
				pub_VO.setFirm_tel_no(rs.getString(17));
				pub_VO.setFirm_email(rs.getString(18));
				pub_VO.setFirm_tax_id(rs.getString(19));
				list.add(pub_VO);
			}

			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
			// Clean up JDBC resources
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Couldn't load database driver. " + e1.getMessage());
		}
		return list;
	}
	
	@Override
	public void updateRate(Integer pub_no, Integer pub_rate_sum, Integer pub_ratetotal) {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Couldn't load database driver. " + e1.getMessage());
		}
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(UPDATE_RATE);) {
			pstmt.setInt(1, pub_rate_sum);
			pstmt.setInt(2, pub_ratetotal);
			pstmt.setInt(3, pub_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}

	}

	@Override
	public void updateOpen(Integer pub_no, Integer pub_open) {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Couldn't load database driver. " + e1.getMessage());
		}
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(UPDATE_OPEN);) {
			pstmt.setInt(1, pub_open);
			pstmt.setInt(2, pub_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}

	}

	@Override
	public void updateApplication(Integer pub_no, Integer pub_application) {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e1) {
			throw new RuntimeException("Couldn't load database driver. " + e1.getMessage());
		}
		try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement pstmt = con.prepareStatement(UPDATE_APPLICATION);) {
			pstmt.setInt(1, pub_application);
			pstmt.setInt(2, pub_no);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException("A database error occured. " + e.getMessage());
		}

	}

}
