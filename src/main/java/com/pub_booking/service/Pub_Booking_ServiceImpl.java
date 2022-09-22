package com.pub_booking.service;

import java.util.List;

import com.pub_booking.dao.Pub_Booking_DAOImpl;
import com.pub_booking.entity.Pub_Booking;
import com.pub_reservation.dao.Pub_Reservation_DAOImpl;
import com.pub_reservation.entity.Pub_Reservation;

import oracle.net.aso.i;

public class Pub_Booking_ServiceImpl implements Pub_Booking_Service {
	private Pub_Booking_DAOImpl dao;
	private Pub_Reservation_DAOImpl resDao;

	public Pub_Booking_ServiceImpl() {
		dao = new Pub_Booking_DAOImpl();
		resDao = new Pub_Reservation_DAOImpl();
	}

	@Override
	public Pub_Booking getBooking(Integer mem_no, Integer pub_no) {
		return dao.getByPubNoAndMemNO(pub_no, mem_no);
	}

	@Override
	public Integer InserBooking(Pub_Booking pub_Booking) {
		if (dao.insert(pub_Booking) == 1) {
//			List<Pub_Booking> list = dao.getListByPubnoAndDate(pub_Booking);
			int[] array = new int[24];
				String str = pub_Booking.getPub_booking_time();
				for (int i = 0; i < 24; i++) {
					array[i] += Integer.parseInt(str.substring(i * 3, (i + 1) * 3));
				}
			Pub_Reservation pub_Reservation= resDao.selectByPubNoDate(pub_Booking.getPub_no(),pub_Booking.getPub_booking_date());
			//讀出相減
			String oldsum=pub_Reservation.getPub_available();
			for(int i=0;i<24;i++) {
				array[i]=Integer.parseInt(oldsum.substring(i * 3, (i + 1) * 3))-array[i];
			}
			//寫入
			String sum="";
			for(int a :array) {
				if(a<10) {
					sum+="00"+a;
				}else if(a<100){
					sum+="0"+a;
				}else {
					sum+=a;
				}
			}
			pub_Reservation.setPub_available(sum);
			
		}
		return 1;
	}

	@Override
	public List<Pub_Booking> getMemALL(Integer mem_no) {
		return dao.getListByMem(mem_no);
	}

	@Override
	public List<Pub_Booking> getPubALL(Integer pub_no) {
		return dao.getListBypub(pub_no);
	}

	@Override
	public List<Pub_Booking> getAll() {
		return dao.selectAll();
	}
}
