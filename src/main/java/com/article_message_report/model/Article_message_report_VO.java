package com.article_message_report.model;

import java.sql.Timestamp;

public class Article_message_report_VO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer art_msg_rpt;
	private Integer mem_no;
	private Integer art_msg_no;
	private Timestamp rpt_time;
	private String rpt_msg_content;
	private Integer mng_no;
	private Timestamp msg_done_time;
	private Integer msg_states;
	private Integer msg_result;
	private String msg_note;
	public Integer getArt_msg_rpt() {
		return art_msg_rpt;
	}
	public void setArt_msg_rpt(Integer art_msg_rpt) {
		this.art_msg_rpt = art_msg_rpt;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Integer getArt_msg_no() {
		return art_msg_no;
	}
	public void setArt_msg_no(Integer art_msg_no) {
		this.art_msg_no = art_msg_no;
	}
	public Timestamp getRpt_time() {
		return rpt_time;
	}
	public void setRpt_time(Timestamp rpt_time) {
		this.rpt_time = rpt_time;
	}
	public String getRpt_msg_content() {
		return rpt_msg_content;
	}
	public void setRpt_msg_content(String rpt_msg_content) {
		this.rpt_msg_content = rpt_msg_content;
	}
	public Integer getMng_no() {
		return mng_no;
	}
	public void setMng_no(Integer mng_no) {
		this.mng_no = mng_no;
	}
	public Timestamp getMsg_done_time() {
		return msg_done_time;
	}
	public void setMsg_done_time(Timestamp msg_done_time) {
		this.msg_done_time = msg_done_time;
	}
	public Integer getMsg_states() {
		return msg_states;
	}
	public void setMsg_states(Integer msg_states) {
		this.msg_states = msg_states;
	}
	public Integer getMsg_result() {
		return msg_result;
	}
	public void setMsg_result(Integer msg_result) {
		this.msg_result = msg_result;
	}
	public String getMsg_note() {
		return msg_note;
	}
	public void setMsg_note(String msg_note) {
		this.msg_note = msg_note;
	}
	
}