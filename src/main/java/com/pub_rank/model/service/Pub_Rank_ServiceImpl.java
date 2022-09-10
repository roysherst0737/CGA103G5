package com.pub_rank.model.service;

import java.util.List;

import com.pub.model.Pub_Rank;
import com.pub_rank.model.model.Pub_Rank_DAOImpl;

public class Pub_Rank_ServiceImpl implements Pub_Rank_Service{
	private Pub_Rank_DAOImpl dao;
	
	public Pub_Rank_ServiceImpl() {
		dao=new Pub_Rank_DAOImpl();
	}

	@Override
	public Pub_Rank setRate(Pub_Rank pub_Rank) {
		try {
			final int result = dao.insert(pub_Rank);
			if(result<1) {
				pub_Rank.setMessage("評分發生錯誤");
				pub_Rank.setSuccessful(false);
				return pub_Rank;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		pub_Rank.setSuccessful(true);
		pub_Rank.setMessage("感謝評論");
		return pub_Rank;
	}

	@Override
	public List<Pub_Rank> getAll() {
		return null;
	}

}
