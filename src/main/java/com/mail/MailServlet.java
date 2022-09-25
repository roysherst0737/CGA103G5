package com.mail;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet(urlPatterns ={"/front-end/mem/MailServlet"})
public class MailServlet extends HttpServlet{
	
	public void sendMail(String to, String subject, String messageText) {
		
		   try {
			   // 設定使用SSL連線至 Gmail smtp Server
			   Properties props = new Properties();
			   props.put("mail.smtp.host", "smtp.gmail.com");
			   props.put("mail.smtp.socketFactory.port", "465");
			   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
			   props.put("mail.smtp.auth", "true");
			   props.put("mail.smtp.port", "465");

	       // ●設定 gmail 的帳號 & 密碼 (將藉由你的Gmail來傳送Email)
	       // ●1) 登入你的Gmail的: 
	       // ●2) 點選【管理你的 Google 帳戶】
	       // ●3) 點選左側的【安全性】
	       
	       // ●4) 完成【兩步驟驗證】的所有要求如下:
	       //     ●4-1) (請自行依照步驟要求操作之.....)
	       
	       // ●5) 完成【應用程式密碼】的所有要求如下:
	       //     ●5-1) 下拉式選單【選取應用程式】--> 選取【郵件】
	       //     ●5-2) 下拉式選單【選取裝置】--> 選取【Windows 電腦】
	       //     ●5-3) 最後按【產生】密碼
//		     final String myGmail = "ixlogic.wu@gmail.com";
//		     final String myGmail_password = "ddjomltcnypgcstn";
			 final String myGmail ="ge1793578@gmail.com";
		     final String myGmail_password ="orpxlhrcoixaxicl";
			   Session session = Session.getInstance(props, new Authenticator() {
				   protected PasswordAuthentication getPasswordAuthentication() {
					   return new PasswordAuthentication(myGmail, myGmail_password);
				   }
			   });

			   Message message = new MimeMessage(session);
			   message.setFrom(new InternetAddress(myGmail));
			   message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			  
			   //設定信中的主旨  
			   message.setSubject(subject);
			   //設定信中的內容 
			   message.setText(messageText);

			   Transport.send(message);
			   System.out.println("傳送成功!");
	     }catch (MessagingException e){
		     System.out.println("傳送失敗!");
		     e.printStackTrace();
	     }
	   }
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action =  req.getParameter("action");

		
		if ("findbyemail".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
			/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
			String email = req.getParameter("mem_email");
			if(email == null || email.trim().length() == 0) {
				errorMsgs.add("會員電子郵件: 請勿空白");
			}
			
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/mem/Forgot_password.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			
			/***************************2.開始查詢資料*****************************************/
			Mem_Service memSvc = new Mem_Service();
			Mem_VO find_by_email = memSvc.find_by_email(email);
			if(find_by_email == null) {
				errorMsgs.add("會員電子郵件: 查無此電子信箱");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req
						.getRequestDispatcher("/front-end/mem/Forgot_password.jsp");
				failureView.forward(req, res);
				return;//程式中斷
			}
			/***************************3.查詢完成,準備轉交(Send the Success view)*************/
			String to = email;
		      
			String subject = "密碼通知";

			
			String ch_name = find_by_email.getMem_nickname();

			String messageText = "Hello! " + ch_name + " 更改密碼網址:" +"\n"+"http://localhost:8081/CGA103G5ALL/front-end/mem/Email_Success.jsp?mem_email=" + email +"\n" + "點擊重新設置密碼" ; 
			   
			MailServlet mailServlet = new MailServlet();
			mailServlet.sendMail(to, subject, messageText);
			
			String url = "/CGA103G5ALL/front-end/index.jsp";
			res.sendRedirect(url);
		}
		 
	}
}
