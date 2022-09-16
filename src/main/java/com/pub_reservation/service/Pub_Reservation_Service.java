package com.pub_reservation.service;

import java.sql.Date;
import java.util.List;

import com.pub.service.CoreService;
import com.pub_reservation.entity.Pub_Reservation;

public interface Pub_Reservation_Service extends CoreService{
	List<String> setReservation();
	List<String> removeReservation();
	List<Pub_Reservation> getListByDatePubNo(Integer pub_no,Date date);
	List<Pub_Reservation> getListByPubNo(Integer pub_no);
	Integer setAvailableByDatePubNo(Integer pub_no,Date date);
	Integer removeAvailableByDatePubNo(Integer pub_no,Date date);
	Pub_Reservation getReservation(Integer pub_no,Date date);
}
