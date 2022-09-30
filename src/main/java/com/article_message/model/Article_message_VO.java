package com.article_message.model;

import java.sql.Timestamp;

import com.article_message_report.model.Article_message_report_Service;
import com.article_message_report.model.Article_message_report_VO;
import com.forum_article.model.Forum_article_Service;
import com.forum_article.model.Forum_article_VO;
import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

public class Article_message_VO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer art_msg_no;
	private Integer mem_no;
	private Integer frm_art_no;
	private Timestamp msg_time;
	private String msg_content;
	private Integer msg_status;
	
	public Integer getArt_msg_no() {
		return art_msg_no;
	}
	public void setArt_msg_no(Integer art_msg_no) {
		this.art_msg_no = art_msg_no;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Integer getFrm_art_no() {
		return frm_art_no;
	}
	public void setFrm_art_no(Integer frm_art_no) {
		this.frm_art_no = frm_art_no;
	}
	public Timestamp getMsg_time() {
		return msg_time;
	}
	public void setMsg_time(Timestamp msg_time) {
		this.msg_time = msg_time;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public Integer getMsg_status() {
		return msg_status;
	}
	public void setMsg_status(Integer msg_status) {
		this.msg_status = msg_status;
	}
	
	public Mem_VO getMem_VO() {
		Mem_Service mem_Svc = new Mem_Service();
		Mem_VO mem_VO = mem_Svc.getOneMem(mem_no);
		return mem_VO;
	}
	
	public Article_message_report_VO getArticle_message_report_VO() {
		Article_message_report_Service article_message_report_Svc = new Article_message_report_Service();
		Article_message_report_VO article_message_report_VO = article_message_report_Svc.getOneArticle_message_report(art_msg_no);
		return article_message_report_VO;
		
	}
	
	public Forum_article_VO getForum_article_VO() {
		Forum_article_Service forum_article_Svc = new Forum_article_Service();
		Forum_article_VO forum_article_VO = forum_article_Svc.getOneForum_article(frm_art_no);
		return forum_article_VO;		
	}

	
}