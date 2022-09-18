package com.pub_booking.dao;

import java.util.List;

import com.pub.service.CoreDao;
import com.pub_booking.entity.Pub_Booking;

public interface Pub_Booking_DAO extends CoreDao<Pub_Booking, Integer>{
	Pub_Booking getByPubNoAndMemNO(Integer pub_no,Integer mem_no);
	List<Pub_Booking>  getListByPubnoAndDate(Pub_Booking pub_Booking); 
}
