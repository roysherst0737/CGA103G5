package com.pub_rank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pub.service.Core;
@Entity
@Table(name="pub_rank")
public class Pub_Rank extends Core {
	private static final long serialVersionUID = 1L;
	@Id
	private Integer pub_no;
	@Id
	private Integer mem_no;
	private Double pub_rate;
	private String pub_comment;
	public Pub_Rank() {
		
	}
	public Integer getPub_no() {
		return pub_no;
	}
	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Double getPub_rate() {
		return pub_rate;
	}
	public void setPub_rate(Double pub_rate) {
		this.pub_rate = pub_rate;
	}
	public String getPub_comment() {
		return pub_comment;
	}
	public void setPub_comment(String pub_comment) {
		this.pub_comment = pub_comment;
	}
	
	
}
