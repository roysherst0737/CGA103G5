package com.forum_article.model;


import java.sql.Timestamp;

public class Forum_article_VO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer frm_art_no;
	private Integer frm_no;
	private Integer mem_no;
	private Timestamp art_time;
	private String art_title;
	private String art_content;
	private Byte art_img;
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
	public Byte getArt_img() {
		return art_img;
	}
	public void setArt_img(Byte art_img) {
		this.art_img = art_img;
	}
	public Integer getArt_status() {
		return art_status;
	}
	public void setArt_status(Integer art_status) {
		this.art_status = art_status;
	}
	
}
