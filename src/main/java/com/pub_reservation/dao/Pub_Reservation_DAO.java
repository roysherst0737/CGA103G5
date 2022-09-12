package com.pub_reservation.dao;

import java.util.List;

import com.pub.entity.Pub;
import com.pub.service.CoreDao;
import com.pub_reservation.entity.Pub_Reservation;

public interface Pub_Reservation_DAO extends CoreDao<Pub_Reservation, Integer>{
	List<Pub_Reservation> getAllByPubNo();
	Integer insetReservation(List<Pub> pub_no);
}
