package com.pub_booking.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import com.pub_booking.entity.Pub_Booking;

public class Pub_Booking_DAOImpl implements Pub_Booking_DAO{

	@Override
	public int insert(Pub_Booking pojo) {
		getSession().save(pojo);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Pub_Booking pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pub_Booking selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pub_Booking> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub_Booking getByPubNoAndMemNO(Integer pub_no, Integer mem_no) {
		final String sql = "FROM Pub_Booking WHERE pub_no= :pub_no AND mem_no=:mem_no";
		return getSession().createQuery(sql, Pub_Booking.class).setParameter("pub_no", pub_no)
				.setParameter("mem_no", mem_no).uniqueResult();
	}

	@Override
	public List<Pub_Booking> getListByPubnoAndDate(Pub_Booking pub_Booking) {
		final String sql = "FROM Pub_Booking WHERE pub_no= :pub_no AND pub_booking_date=:pub_booking_date";
		return getSession().createQuery(sql, Pub_Booking.class).setParameter("pub_no", pub_Booking.getPub_no())
				.setParameter("pub_booking_date", pub_Booking.getPub_booking_date()).list();
	}

	@Override
	public List<Pub_Booking> getListByMem(Integer mem_no) {
		Long LongDay = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Date today = new Date(LongDay);
		final String sql = "FROM Pub_Booking WHERE mem_no= :mem_no and pub_booking_date>=:pub_booking_date";
		return getSession().createQuery(sql, Pub_Booking.class).setParameter("mem_no", mem_no).setParameter("pub_booking_date", today).list();
	
	}

	@Override
	public List<Pub_Booking> getListBypub(Integer pub_no) {
		Long LongDay = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Date today = new Date(LongDay);
		final String sql = "FROM Pub_Booking WHERE pub_no= :pub_no and pub_booking_date>=:pub_booking_date";
		return getSession().createQuery(sql, Pub_Booking.class).setParameter("pub_no", pub_no).setParameter("pub_booking_date", today).list();

	}

}
