package com.pub_booking.service;


import java.util.List;

import com.pub.service.CoreService;
import com.pub_booking.entity.Pub_Booking;

public interface Pub_Booking_Service extends CoreService{
	Pub_Booking getBooking(Integer mem_no,Integer pub_no);
	Integer InserBooking(Pub_Booking pub_Booking);
	List<Pub_Booking> getMemALL(Integer mem_no);
	List<Pub_Booking> getPubALL(Integer pub_no);
	List<Pub_Booking> getAll();
}
