package com.pub_reservation.model;

import java.sql.Date;
import java.util.List;


public interface Pub_reservation_DAO_interface {
	   public void insert(Pub_reservation_VO pub_reservation_VO);
	    public void update(Pub_reservation_VO pub_reservation_VO);
//	    public void delete(Pub_reservation_VO pub_reservation_VO);// 訂位不會刪除
	    public Pub_reservation_VO findReservation(Integer pub_no,Date pub_reservation_date);
	    public List<Pub_reservation_VO> getReservationRange(Integer pub_no,Date startDate,Date endDate);
}
