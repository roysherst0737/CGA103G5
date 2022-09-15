package com.forum.model;

public class Forum_VO implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private Integer frm_no;
	private String frm_name_no;
	private Integer	frm_status;
	
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
	
}
