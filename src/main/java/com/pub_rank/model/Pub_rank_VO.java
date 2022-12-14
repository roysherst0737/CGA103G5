package com.pub_rank.model;

import java.io.Serializable;

public class Pub_rank_VO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer pub_no;
	private Integer mem_no;
	private Integer pub_rate;
	private String pub_comment;

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

	public Integer getPub_rate() {
		return pub_rate;
	}

	public void setPub_rate(Integer pub_rate) {
		this.pub_rate = pub_rate;
	}

	public String getPub_comment() {
		return pub_comment;
	}

	public void setPub_comment(String pub_comment) {
		this.pub_comment = pub_comment;
	}

}
