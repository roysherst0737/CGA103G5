package com.pub_booking.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "pub_booking")
public class Pub_Booking implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pub_booking_no;
	private Integer pub_no;
	private Integer mem_no;
	private Date pub_booking_date;
	private String pub_booking_time;
	private Integer pub_booking_status;
	public Integer getPub_booking_no() {
		return pub_booking_no;
	}
	public void setPub_booking_no(Integer pub_booking_no) {
		this.pub_booking_no = pub_booking_no;
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
	public Date getPub_booking_date() {
		return pub_booking_date;
	}
	public void setPub_booking_date(Date pub_booking_date) {
		this.pub_booking_date = pub_booking_date;
	}
	public String getPub_booking_time() {
		return pub_booking_time;
	}
	public void setPub_booking_time(String pub_booking_time) {
		this.pub_booking_time = pub_booking_time;
	}
	public Integer getPub_booking_status() {
		return pub_booking_status;
	}
	public void setPub_booking_status(Integer pub_booking_status) {
		this.pub_booking_status = pub_booking_status;
	}
	
}
