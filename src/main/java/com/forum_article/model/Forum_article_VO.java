package com.forum_article.model;

import java.sql.Timestamp;
import com.article_message.model.Article_message_Service;
import com.article_message.model.Article_message_VO;
import com.forum.model.Forum_Service;
import com.forum.model.Forum_VO;
import com.forum_article_report.model.Forum_article_report_Service;
import com.forum_article_report.model.Forum_article_report_VO;
import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

public class Forum_article_VO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer frm_art_no;
	private Integer frm_no;
	private Integer mem_no;
	private Timestamp art_time;
	private String art_title;
	private String art_content;
	private byte[] art_img;
	private Integer art_status;

	public Integer getFrm_art_no() {
		return frm_art_no;
	}

	public void setFrm_art_no(Integer frm_art_no) {
		this.frm_art_no = frm_art_no;
	}

	public Integer getFrm_no() {
		return frm_no;
	}

	public void setFrm_no(Integer frm_no) {
		this.frm_no = frm_no;
	}

	public Integer getMem_no() {
		return mem_no;
	}

	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}

	public Timestamp getArt_time() {
		return art_time;
	}

	public void setArt_time(Timestamp art_time) {
		this.art_time = art_time;
	}

	public String getArt_title() {
		return art_title;
	}

	public void setArt_title(String art_title) {
		this.art_title = art_title;
	}

	public String getArt_content() {
		return art_content;
	}

	public void setArt_content(String art_content) {
		this.art_content = art_content;
	}

	public byte[] getArt_img() {
		return art_img;
	}

	public void setArt_img(byte[] art_img) {
		this.art_img = art_img;
	}

	public Integer getArt_status() {
		return art_status;
	}

	public void setArt_status(Integer art_status) {
		this.art_status = art_status;
	}

	public Article_message_VO getArticle_message_VO() {
		Article_message_Service article_message_Svc = new Article_message_Service();
		Article_message_VO article_message_VO = article_message_Svc.getOneArticle_message(frm_art_no);
		return article_message_VO;
	}

	public Mem_VO getMem_VO() {
		Mem_Service mem_Svc = new Mem_Service();
		Mem_VO mem_VO = mem_Svc.getOneMem(mem_no);
		return mem_VO;
	}

	public Forum_article_report_VO getForum_article_report_VO() {
		Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
		Forum_article_report_VO forum_article_report_VO = forum_article_report_Svc
				.getOneForum_article_report(frm_art_no);
		return forum_article_report_VO;
	}

	public Forum_VO getForum_VO() {
		Forum_Service forum_Svc = new Forum_Service();
		Forum_VO forum_VO = forum_Svc.getOneForum(frm_no);
		return forum_VO;
	}

}
