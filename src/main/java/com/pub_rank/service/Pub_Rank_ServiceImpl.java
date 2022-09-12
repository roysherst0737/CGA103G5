package com.pub_rank.service;

import java.util.List;

import com.pub.dao.Pub_DAO_H_impl_forWEB;
import com.pub.entity.Pub;
import com.pub_rank.dao.Pub_Rank_DAOImpl;
import com.pub_rank.entity.Pub_Rank;

public class Pub_Rank_ServiceImpl implements Pub_Rank_Service{
	private Pub_Rank_DAOImpl dao;
	private Pub_DAO_H_impl_forWEB Pubdao;
	private Double sum;
	public Pub_Rank_ServiceImpl() {
		dao=new Pub_Rank_DAOImpl();
		Pubdao=new Pub_DAO_H_impl_forWEB();
		sum=0.0;
	}

	@Override
	public Pub_Rank setRate(Pub_Rank pub_Rank) {
		try {
			final int result = dao.insert(pub_Rank);
			Pub pub= new Pub();
			pub=Pubdao.selectById(pub_Rank.getPub_no());
			System.out.println(pub_Rank.getPub_no()+"=getPubNO");
			dao.getSession().flush();
			List<Pub_Rank> list =getPubAllRate(pub_Rank.getPub_no());
			sum=0.0;
			list.forEach(e->{
				sum+=e.getPub_rate();
				});
			pub.setPub_rate_sum(sum/(double)list.size());
			 pub.setPub_ratetotal(list.size());
			
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

	@Override
	public List<Pub_Rank> getPubAllRate(Integer pub_no) {
		return dao.selectAllByPub_no(pub_no);
	}

}
