package com.pub_booking.service;

import com.pub_booking.entity.Pub_Booking;

public class Pub_Booking_ServiceImpl implements Pub_Booking_Service{

	@Override
	public Pub_Booking getBooking(Integer mem_no, Integer pub_no) {
		final String sql = "FROM Pub_Booking WHERE pub_no= :pub_no AND mem_no=:mem_no";
		return getSession().createQuery(sql, Pub_Booking.class).setParameter("pub_no", pub_no)
				.setParameter("mem_no", mem_no).uniqueResult();
	}
}
