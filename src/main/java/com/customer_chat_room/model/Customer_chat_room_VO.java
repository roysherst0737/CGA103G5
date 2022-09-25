package com.customer_chat_room.model;

import java.sql.Timestamp;
import java.io.Serializable;

public class Customer_chat_room_VO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer SN;
	private Integer mng_no;
	private Integer mem_no;
	private Integer prod_no;
	private String message;
	private byte[] mem_question_pic;
	private Timestamp message_chat_time;
	private Integer chat_direction;
	public Integer getSN() {
		return SN;
	}
	public void setSN(Integer sN) {
		SN = sN;
	}
	public Integer getMng_no() {
		return mng_no;
	}
	public void setMng_no(Integer mng_no) {
		this.mng_no = mng_no;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Integer getProd_no() {
		return prod_no;
	}
	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public byte[] getMem_question_pic() {
		return mem_question_pic;
	}
	public void setMem_question_pic(byte[] mem_question_pic) {
		this.mem_question_pic = mem_question_pic;
	}
	public Timestamp getMessage_chat_time() {
		return message_chat_time;
	}
	public void setMessage_chat_time(Timestamp message_chat_time) {
		this.message_chat_time = message_chat_time;
	}
	public Integer getChat_direction() {
		return chat_direction;
	}
	public void setChat_direction(Integer chat_direction) {
		this.chat_direction = chat_direction;
	}
	
}
