package com.pub_pics.dao;

import java.util.List;

import com.pub_pics.entity.Pub_pics;

public class Pub_pics_DAO_H_impl implements Pub_pics_DAO_H{

	@Override
	public int insert(Pub_pics pojo) {
		getSession().save(pojo);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		return 0;
	}

	@Override
	public int update(Pub_pics pojo) {
		getSession().merge(pojo);
		return 1;
	}

	@Override
	public Pub_pics selectById(Integer id) {
		return null;
	}

	@Override
	public List<Pub_pics> selectAll() {
		return null;
	}

	@Override
	public Pub_pics findByPubNo(Integer pub_no) {
		
		
		final String sql = "FROM Pub_pics WHERE pub_no= : pub_no";
		return getSession().createQuery(sql, Pub_pics.class).setParameter("pub_no", pub_no).uniqueResult();
	}

}
