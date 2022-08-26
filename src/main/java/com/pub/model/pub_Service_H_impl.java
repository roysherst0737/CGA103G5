package com.pub.model;

import java.util.List;
import java.util.stream.Collectors;

public class pub_Service_H_impl implements pub_Service_H{
	private Pub_DAO_H_impl_forWEB dao;

	public pub_Service_H_impl() {
		dao = new Pub_DAO_H_impl_forWEB();
	}
	@Override
	public Pub insert(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub update(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub updateRate(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub updateOpen(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub updateApplication(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub findByPrimaryKey(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pub> getAll() {
		return dao.selectAll();
	}
	@Override
	public List<Pub> check(Integer i) {
		return dao.selectAll().stream().filter(e->e.getPub_application()==i).collect(Collectors.toList());
	}

}
