package com.pub_reservation.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pub.service.Core;
@Entity
@Table(name = "pub_reservation")
public class Pub_Reservation extends Core{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pub_reservation_no;
	private Integer pub_no;
	private String pub_available;
	private Date pub_reservation_date;
	public Integer getPub_reservation_no() {
		return pub_reservation_no;
	}
	public void setPub_reservation_no(Integer pub_reservation_no) {
		this.pub_reservation_no = pub_reservation_no;
	}
	public Integer getPub_no() {
		return pub_no;
	}
	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}
	public String getPub_available() {
		return pub_available;
	}
	public void setPub_available(String pub_available) {
		this.pub_available = pub_available;
	}
	public Date getPub_reservation_date() {
		return pub_reservation_date;
	}
	public void setPub_reservation_date(Date pub_reservation_date) {
		this.pub_reservation_date = pub_reservation_date;
	}
}
