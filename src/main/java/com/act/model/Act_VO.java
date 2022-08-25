package com.act.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Act_VO implements Serializable {

	private Integer act_no;
	private Integer pub_no;
	private String act_name;
	private String act_detail;
	private String act_loc;
	private Timestamp act_launch_time;
	private Timestamp act_off_time;
	private Integer current_count;
	private Integer max_count;
	private Integer min_count;
	private Timestamp sign_up_begin_time;
	private Timestamp sign_up_end_time;
	private Timestamp act_start_time;
	private Timestamp act_end_time;
	private Integer act_status;
	private Timestamp apply_time;
	private Integer apply_status;

	public Integer getAct_no() {
		return act_no;
	}

	public void setAct_no(Integer act_no) {
		this.act_no = act_no;
	}

	public Integer getPub_no() {
		return pub_no;
	}

	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}

	public String getAct_name() {
		return act_name;
	}

	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	public String getAct_detail() {
		return act_detail;
	}

	public void setAct_detail(String act_detail) {
		this.act_detail = act_detail;
	}

	public String getAct_loc() {
		return act_loc;
	}

	public void setAct_loc(String act_loc) {
		this.act_loc = act_loc;
	}

	public Timestamp getAct_launch_time() {
		return act_launch_time;
	}

	public void setAct_launch_time(Timestamp act_launch_time) {
		this.act_launch_time = act_launch_time;
	}

	public Timestamp getAct_off_time() {
		return act_off_time;
	}

	public void setAct_off_time(Timestamp act_off_time) {
		this.act_off_time = act_off_time;
	}

	public Integer getCurrent_count() {
		return current_count;
	}

	public void setCurrent_count(Integer current_count) {
		this.current_count = current_count;
	}

	public Integer getMax_count() {
		return max_count;
	}

	public void setMax_count(Integer max_count) {
		this.max_count = max_count;
	}

	public Integer getMin_count() {
		return min_count;
	}

	public void setMin_count(Integer min_count) {
		this.min_count = min_count;
	}

	public Timestamp getSign_up_begin_time() {
		return sign_up_begin_time;
	}

	public void setSign_up_begin_time(Timestamp sign_up_begin_time) {
		this.sign_up_begin_time = sign_up_begin_time;
	}

	public Timestamp getSign_up_end_time() {
		return sign_up_end_time;
	}

	public void setSign_up_end_time(Timestamp sign_up_end_time) {
		this.sign_up_end_time = sign_up_end_time;
	}

	public Timestamp getAct_start_time() {
		return act_start_time;
	}

	public void setAct_start_time(Timestamp act_start_time) {
		this.act_start_time = act_start_time;
	}

	public Timestamp getAct_end_time() {
		return act_end_time;
	}

	public void setAct_end_time(Timestamp act_end_time) {
		this.act_end_time = act_end_time;
	}

	public Integer getAct_status() {
		return act_status;
	}

	public void setAct_status(Integer act_status) {
		this.act_status = act_status;
	}

	public Timestamp getApply_time() {
		return apply_time;
	}

	public void setApply_time(Timestamp apply_time) {
		this.apply_time = apply_time;
	}

	public Integer getApply_status() {
		return apply_status;
	}

	public void setApply_status(Integer apply_status) {
		this.apply_status = apply_status;
	}

}
