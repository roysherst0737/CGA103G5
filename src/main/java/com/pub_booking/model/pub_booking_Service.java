package com.pub_booking.model;

import java.sql.Date;
import java.util.List;

public class pub_booking_Service {
	Pub_booking_DAO_interface dao;
	
	public void insert(Pub_booking_VO pub_booking_VO) {
		dao.insert(pub_booking_VO);
	}

	
	public void update(Pub_booking_VO pub_booking_VO) {
		dao.update(pub_booking_VO);		
	}

	
	public Pub_booking_VO findBooking(Integer pub_no, Integer mem_no, Date pub_booking_date) {
		return dao.findBooking(pub_no, mem_no, pub_booking_date);
	}

	
	public List<Pub_booking_VO> getAllPubBooking(Integer pub_no, Date pub_booking_date) {
		return dao.getAllPubBooking(pub_no, pub_booking_date);
	}

	
	public List<Pub_booking_VO> getAllPubBooking(Integer pub_no) {
		return dao.getAllPubBooking(pub_no);
	}

	
	public List<Pub_booking_VO> getAllMemBooking(Integer mem_no, Date pub_booking_date) {
		return dao.getAllMemBooking(mem_no, pub_booking_date);
	}

	
	public List<Pub_booking_VO> getAllMemBooking(Integer mem_no) {
		return dao.getAllMemBooking(mem_no);
	}

}
