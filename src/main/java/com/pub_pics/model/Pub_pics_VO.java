package com.pub_pics.model;

import java.io.Serializable;
import java.sql.Blob;

public class Pub_pics_VO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pub_pic_no;
	private Integer pub_no;
	private Blob pub_pic;
	public Integer getPub_pic_no() {
		return pub_pic_no;
	}
	public void setPub_pic_no(Integer pub_pic_no) {
		this.pub_pic_no = pub_pic_no;
	}
	public Integer getPub_no() {
		return pub_no;
	}
	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}
	public Blob getPub_pic() {
		return pub_pic;
	}
	public void setPub_pic(Blob pub_pic) {
		this.pub_pic = pub_pic;
	}
}
