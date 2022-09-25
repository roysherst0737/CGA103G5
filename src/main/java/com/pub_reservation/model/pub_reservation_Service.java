package com.pub_reservation.model;

import java.sql.Date;
import java.util.List;

public class pub_reservation_Service{
	private Pub_reservation_DAO_interface dao;

	public pub_reservation_Service() {
		dao = new Pub_reservaion_DAO();
	}

	public void insert(Pub_reservation_VO pub_reservation_VO) {
		dao.insert(pub_reservation_VO);
	}

	public void update(Pub_reservation_VO pub_reservation_VO) {
		dao.update(pub_reservation_VO);
	}

	public Pub_reservation_VO findReservation(Integer pub_no, Date pub_reservation_date) {
		return dao.findReservation(pub_no, pub_reservation_date);
	}

	public List<Pub_reservation_VO> getReservationRange(Integer pub_no, Date startDate, Date endDate) {
		return dao.getReservationRange(pub_no, startDate, endDate);
	}
	
}
