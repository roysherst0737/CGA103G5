package com.forum.model;

import com.forum_article.model.Forum_article_Service;
import com.forum_article.model.Forum_article_VO;

public class Forum_VO implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer frm_no;
	private String frm_name_no;
	private Integer frm_status;
	private byte[] frm_img;

	public Integer getFrm_no() {
		return frm_no;
	}

	public void setFrm_no(Integer frm_no) {
		this.frm_no = frm_no;
	}

	public String getFrm_name_no() {
		return frm_name_no;
	}

	public void setFrm_name_no(String frm_name_no) {
		this.frm_name_no = frm_name_no;
	}

	public Integer getFrm_status() {
		return frm_status;
	}

	public void setFrm_status(Integer frm_status) {
		this.frm_status = frm_status;
	}

	public byte[] getFrm_img() {
		return frm_img;
	}

	public void setFrm_img(byte[] frm_img) {
		this.frm_img = frm_img;
	}

	public Forum_article_VO getForum_article_VO() {
		Forum_article_Service forum_article_Svc = new Forum_article_Service();
		Forum_article_VO forum_article_VO = forum_article_Svc.getOneForum_article(frm_no);
		return forum_article_VO;
	}
}
