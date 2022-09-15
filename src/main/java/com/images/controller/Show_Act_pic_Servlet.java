package com.images.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/Show_Act_pic_Servlet")
public class Show_Act_pic_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Statement stmt = con.createStatement();
			String act_pic_no = req.getParameter("act_pic_no").trim();
			ResultSet rs = stmt.executeQuery(
				"SELECT act_pic FROM act_pic WHERE act_pic_no = " + act_pic_no);

			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("act_pic"));
				
				byte[] buf = in.readAllBytes();
				out.write(buf);
				in.close();
				
			} else {
				InputStream in = getServletContext().getResourceAsStream("/back-end/act_pic/images/coming_soon.jpg");
				byte[] b = new byte[in.available()];
				in.read(b);
				out.write(b);
				in.close();
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			InputStream in = getServletContext().getResourceAsStream("/back-end/act_pic/images/coming_soon_2.jpg");
			byte[] b = new byte[in.available()];
			in.read(b);
			out.write(b);
			in.close();
		}
	}

	public void init() throws ServletException {
    	try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/DBPool");
			con = ds.getConnection();
		} catch (NamingException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}