package com.pub.model;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.pub.service.Core;
@Entity

public class Pub_pics extends Core {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pub_pic_no;
	@ManyToOne
	@JoinColumn(name = "pub_no")
	private Pub pub;
	private Blob pub_pic;
	
	public Pub getPub() {
		return pub;
	}
	public void setPub(Pub pub) {
		this.pub = pub;
	}
	public Integer getPub_pic_no() {
		return pub_pic_no;
	}
	public void setPub_pic_no(Integer pub_pic_no) {
		this.pub_pic_no = pub_pic_no;
	}
	public Blob getPub_pic() {
		return pub_pic;
	}
	public void setPub_pic(Blob pub_pic) {
		this.pub_pic = pub_pic;
	}
}
