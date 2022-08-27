package com.prod.model;

import java.util.List;
import java.util.Map;

public class Prod_Service_H_impl implements Prod_Service_H{
	private Prod_DAO_H_impl dao;

	public Prod_Service_H_impl() {
		dao = new Prod_DAO_H_impl();
	}
	@Override
	public Prod insert(Prod prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prod update(Prod prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prod updatePic(Prod prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prod findByPrimaryKey(Prod prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Prod> getAll() {
		return dao.selectAll();
	}
	@Override
	public List<Prod> getAll(Map<String, String[]> map) {
		// TODO Auto-generated method stub
		return null;
	}
}
