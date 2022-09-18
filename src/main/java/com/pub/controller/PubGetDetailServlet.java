package com.pub.controller;
import static com.util.Constants.JSON_MIME_TYPE;
import static com.pub.service.PubConstants.SERVICE;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pub.entity.Pub;
@WebServlet("/PubDetail")
public class PubGetDetailServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Pub pub = new Pub();
		pub.setPub_no(Integer.parseInt(request.getParameter("pub_no")));
//		Pub pub = json2Pojo(request, Pub.class);
//		if(pub==null) {
//			pub = new Pub();
//			pub.setMessage("無會員資訊");
//			pub.setSuccessful(false);
//			writePojo2Json(response, pub);
//			return;
//		}
		pub = SERVICE.findByPrimaryKey(pub);
		if(pub.getPub_name()==null) {
			pub.setMessage("無會員資訊");
			pub.setSuccessful(false);
		}else {
			pub.setMessage("成功");
			pub.setSuccessful(true);
		}
		
//		ExclusionStrategy strategy = new ExclusionStrategy() {
//		    @Override
//		    public boolean shouldSkipClass(Class<?> clazz) {
//		        return false;
//		    }
//		    @Override
//		    public boolean shouldSkipField(FieldAttributes field) {
//		        return field.getName().startsWith("pub_1");
//		    }
//
//		};
//		Gson gson = new GsonBuilder()
//				  .addSerializationExclusionStrategy(strategy)
//				  .create();
		response.setCharacterEncoding("UTF-8");
		response.setContentType(JSON_MIME_TYPE);
//		try (PrintWriter pw = response.getWriter()) {
//			pw.print(gson.toJson(pub));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		request.setAttribute("pub", pub);
		request.getRequestDispatcher("/front-end/pages/pub/pupdetail.jsp").forward(request, response);
//		writePojo2Json(response, pub);
		return;
	}

}
