package com.pub_pics.service;

import java.util.List;

import com.pub_pics.dao.Pub_pics_DAO_H_impl;
import com.pub_pics.entity.Pub_pics;

public class Pub_Pics_Service_H_impl implements Pub_Pics_Service_H{
	private Pub_pics_DAO_H_impl dao;
	
	public Pub_Pics_Service_H_impl() {
		dao =new Pub_pics_DAO_H_impl();
	}

	@Override
	public Pub_pics inserPics(Pub_pics pub_pics) {
		if (pub_pics.getPub_pic() == null) {
			pub_pics.setMessage("照片未輸入");
			pub_pics.setSuccessful(false);
			return pub_pics;
		}
		
		try {
			final int resultCount = dao.insert(pub_pics);
			if (resultCount < 1) {
				pub_pics.setMessage("照片寫入錯誤，請聯絡管理員!");
				pub_pics.setSuccessful(false);
				return pub_pics;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		pub_pics.setMessage("照片寫入成功");
		pub_pics.setSuccessful(true);
		return pub_pics;
	}

	@Override
	public Pub_pics update(Pub_pics pub_pics) {
		// TODO Auto-generated method stub
		return pub_pics;
	}

	@Override
	public Pub_pics findByPrimaryKey(Pub_pics pub_pics) {
		// TODO Auto-generated method stub
		return pub_pics;
	}

	@Override
	public List<Pub_pics> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
