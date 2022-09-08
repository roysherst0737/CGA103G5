package com.pub_pics.model.model;

import java.util.List;

import com.pub.model.Pub_pics;

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
		getSession().update(pojo);
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

}
