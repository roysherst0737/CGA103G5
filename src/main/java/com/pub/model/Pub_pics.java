package com.pub.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.pub.service.Core;

@Entity
@Table(name="pub_pics")
public class Pub_pics extends Core {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pub_pic_no;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pub_no" ,updatable = false)
	private  Pub pub_1;
	
	private String pub_pic;	
	public Integer getPub_pic_no() {
		return pub_pic_no;
	}
	public void setPub_pic_no(Integer pub_pic_no) {
		this.pub_pic_no = pub_pic_no;
	}
	public String getPub_pic() {
		return pub_pic;
	}
	public void setPub_pic(String pub_pic) {
		this.pub_pic = pub_pic;
	}
	public Pub getPub() {
		return pub_1;
	}
	public void setPub(Pub pub) {
		this.pub_1 = pub;
	}

	
}
@Embeddable
class Pub_no implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pub_no;

	public Integer getPub_no() {
		return pub_no;
	}

	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}
	
}