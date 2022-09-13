package com.pub_reservation.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.pub.dao.Pub_DAO_H_impl_forWEB;
import com.pub.entity.Pub;
import com.pub_reservation.dao.Pub_Reservation_DAOImpl;
import com.pub_reservation.entity.Pub_Reservation;

public class Pub_Reservation_ServiceImpl implements Pub_Reservation_Service{
	private Pub_DAO_H_impl_forWEB PubDao;
	private Pub_Reservation_DAOImpl reserveDao;
	public Pub_Reservation_ServiceImpl(){
		PubDao = new Pub_DAO_H_impl_forWEB();
		reserveDao = new Pub_Reservation_DAOImpl();
	}

	@Override
	public List<String> setReservation() {
		List<Pub> pubList = PubDao.getAllbyOpen();
		reserveDao.insetReservation(pubList);
		return null;
	}

	@Override
	public List<String> removeReservation() {
		reserveDao.removeReservation();
		return null;
	}

	@Override
	public List<Pub_Reservation> getListByDatePubNo(Integer pub_no, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer setAvailableByDatePubNo(Integer pub_no, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer removeAvailableByDatePubNo(Integer pub_no, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

}
