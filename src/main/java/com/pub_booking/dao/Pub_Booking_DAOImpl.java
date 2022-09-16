package com.pub_booking.dao;

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

}
