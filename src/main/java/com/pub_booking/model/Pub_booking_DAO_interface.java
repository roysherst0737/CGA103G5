package com.pub_booking.model;

import java.sql.Date;
import java.util.List;


public interface Pub_booking_DAO_interface {
	   public void insert(Pub_booking_VO pub_booking_VO);
	    public void update(Pub_booking_VO pub_booking_VO);
//	    public void delete(Pub_booking_VO pub_booking_VO); // 定位沒有刪除
	    public Pub_booking_VO findBooking(Integer pub_no,Integer mem_no, Date pub_booking_date);
	    public List<Pub_booking_VO> getAllPubBooking(Integer pub_no, Date pub_booking_date);
	    public List<Pub_booking_VO> getAllPubBooking(Integer pub_no);
	    public List<Pub_booking_VO> getAllMemBooking(Integer mem_no, Date pub_booking_date);
	    public List<Pub_booking_VO> getAllMemBooking(Integer mem_no);
}
