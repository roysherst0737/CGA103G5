package com.util;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static com.util.Constants.GSON;
import static com.util.Constants.JSON_MIME_TYPE;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommonUtil {
	
//	public static Connection getConnection() throws NamingException, SQLException {
//		if (DATASOURCE == null) {
//			DATASOURCE = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/javaFramework");
//		}
//		return DATASOURCE.getConnection();
//	}

	public static <P> P json2Pojo(HttpServletRequest request, Class<P> classOfPojo) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		try (BufferedReader br = request.getReader()) {
//			String str = null;
//		      while((str = br.readLine()) != null){
//		      System.out.println(str);//此時str就儲存了一行字串
//		}
			return GSON.fromJson(br, classOfPojo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <P> void writePojo2Json(HttpServletResponse response, P pojo) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType(JSON_MIME_TYPE);
		try (PrintWriter pw = response.getWriter()) {
			pw.print(GSON.toJson(pojo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
