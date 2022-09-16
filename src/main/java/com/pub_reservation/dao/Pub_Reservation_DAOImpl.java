package com.pub_reservation.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.pub.entity.Pub;
import com.pub_reservation.entity.Pub_Reservation;

public class Pub_Reservation_DAOImpl implements Pub_Reservation_DAO {

	@Override
	public int insert(Pub_Reservation pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Pub_Reservation pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Pub_Reservation> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pub_Reservation> getAllByPubNo(Integer pub_no) {
		final String sql = "FROM Pub_Reservation WHERE pub_no= :pub_no";
		return getSession().createQuery(sql, Pub_Reservation.class).setParameter("pub_no", pub_no).list();

	}

	@Override
	public Integer insetReservation(List<Pub> list) {
		Session session = getOpenSession();
		Long LongDay = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Date today = new Date(LongDay);
		Pub_Reservation pub_Reservation = new Pub_Reservation();
		final String sql = "FROM Pub_Reservation WHERE pub_no= :pub_no AND pub_reservation_date=:pub_reservation_date";
		for (int i = 0; i < 7; i++) {
			today.setTime((i * 60 * 60 * 24 * 1000 + LongDay));
			pub_Reservation.setPub_reservation_date(today);

			list.forEach(pub -> {
				Transaction txn = session.beginTransaction();
				String nop = "";
				pub_Reservation.setPub_no(pub.getPub_no());
				if (pub.getPub_nop() == 0) {
					nop = "000000000000000000000000000000000000000000000000000000000000000000000000";
				} else if (pub.getPub_nop() < 100) {
					nop = ("0" + pub.getPub_nop().toString()).repeat(24);
				} else if (pub.getPub_nop() < 10) {
					nop = ("00" + pub.getPub_nop().toString()).repeat(24);
				} else {
					nop = (pub.getPub_nop().toString()).repeat(24);
				}
				Pub_Reservation reservation = session.createQuery(sql, Pub_Reservation.class)
						.setParameter("pub_no", pub.getPub_no())
						.setParameter("pub_reservation_date", pub_Reservation.getPub_reservation_date()).uniqueResult();
				if (reservation == null) {
					pub_Reservation.setPub_available(nop);
					session.merge(pub_Reservation);
				}
				txn.commit();
			});
		}
		session.close();
		System.out.println("新增預約表完成");
		return 1;
	}

	@Override
	public Integer removeReservation() {
		Session session = getOpenSession();
		Long LongDay = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
		Date today = new Date(LongDay);
		final String sql = "DELETE Pub_Reservation WHERE pub_reservation_date<:pub_reservation_date";
		today.setTime((60 * 60 * 24 * 2000 - LongDay));
		Transaction txn = session.beginTransaction();
		session.createQuery(sql).setParameter("pub_reservation_date", today).executeUpdate();
		txn.commit();
		session.close();
		System.out.println("刪除過期酒吧預約表完成");
		return 1;
	}

	@Override
	public Pub_Reservation selectByPubNoDate(Integer pub_no, Date date) {
		final String sql = "FROM Pub_Reservation WHERE pub_no= :pub_no AND pub_reservation_date=:pub_reservation_date";
		return getSession().createQuery(sql, Pub_Reservation.class).setParameter("pub_no", pub_no)
				.setParameter("pub_reservation_date", date).uniqueResult();
	}

	@Override
	public Pub_Reservation selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
