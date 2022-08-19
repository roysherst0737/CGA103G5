package com.prod_pic.model;

import java.io.Serializable;
import java.sql.Blob;

public class Prod_pic_VO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer prod_pic_no;
	private Integer prod_no;
	private Blob prod_pic;
	private String prod_pic_name;
	
	public Integer getProd_pic_no() {
		return prod_pic_no;
	}
	public void setProd_pic_no(Integer prod_pic_no) {
		this.prod_pic_no = prod_pic_no;
	}
	public Integer getProd_no() {
		return prod_no;
	}
	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}
	public Blob getProd_pic() {
		return prod_pic;
	}
	public void setProd_pic(Blob prod_pic) {
		this.prod_pic = prod_pic;
	}
	public String getProd_pic_name() {
		return prod_pic_name;
	}
	public void setProd_pic_name(String prod_pic_name) {
		this.prod_pic_name = prod_pic_name;
	}
}
