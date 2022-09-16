package com.pub_booking.service;

import com.pub_booking.dao.Pub_Booking_DAOImpl;
import com.pub_booking.entity.Pub_Booking;

public class Pub_Booking_ServiceImpl implements Pub_Booking_Service{
	private Pub_Booking_DAOImpl dao;
	public Pub_Booking_ServiceImpl() {
		dao=new Pub_Booking_DAOImpl();
	}

	@Override
	public Pub_Booking getBooking(Integer mem_no, Integer pub_no) {
		return dao.getByPubNoAndMemNO(pub_no, mem_no);
	}

	@Override
	public Integer InserBooking(Pub_Booking pub_Booking) {
		return dao.insert(pub_Booking);
	}
}
