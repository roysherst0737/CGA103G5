package com.act_sign_up.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Act_sign_up_VO implements Serializable{

	private Integer sign_up_no;
	private Integer act_no;
	private Integer mem_no;
	private Timestamp sign_up_time;
	private Integer accompany_count;
	private Integer sign_up_status;

	public Integer getSign_up_no() {
		return sign_up_no;
	}

	public void setSign_up_no(Integer sign_up_no) {
		this.sign_up_no = sign_up_no;
	}

	public Integer getAct_no() {
		return act_no;
	}

	public void setAct_no(Integer act_no) {
		this.act_no = act_no;
	}

	public Integer getMem_no() {
		return mem_no;
	}

	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}

	public Timestamp getSign_up_time() {
		return sign_up_time;
	}

	public void setSign_up_time(Timestamp sign_up_time) {
		this.sign_up_time = sign_up_time;
	}

	public Integer getAccompany_count() {
		return accompany_count;
	}

	public void setAccompany_count(Integer accompany_count) {
		this.accompany_count = accompany_count;
	}

	public Integer getSign_up_status() {
		return sign_up_status;
	}

	public void setSign_up_status(Integer sign_up_status) {
		this.sign_up_status = sign_up_status;
	}
}
