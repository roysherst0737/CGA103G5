package com.pub_booking.service;

import com.pub.service.CoreService;
import com.pub_booking.entity.Pub_Booking;

public interface Pub_Booking_Service extends CoreService{
	Pub_Booking getBooking(Integer mem_no,Integer pub_no);
}
