package com.pub_rank.model;

import java.util.List;

public class pub_rank_Service {
	Pub_rank_DAO_interface dao;
	public pub_rank_Service(){
		dao = new Pub_rank_DAO();
	}

	
	public void insert(Pub_rank_VO pub_rank_VO) {
		dao.insert(pub_rank_VO);
	}

	
	public void update(Pub_rank_VO pub_rank_VO) {
		dao.update(pub_rank_VO);
	}

	
	public void delete(Pub_rank_VO pub_rank_VO) {
		dao.delete(pub_rank_VO);
	}

	
	public Pub_rank_VO findByPrimaryKey(Integer pub_no, Integer mem_no) {
		return dao.findByPrimaryKey(pub_no, mem_no);
	}

	
	public List<Pub_rank_VO> getMemAll(Integer mem_no) {
		return dao.getMemAll(mem_no);
	}

	
	public List<Pub_rank_VO> getPubAll(Integer pub_no) {
		return dao.getPubAll(pub_no);
	}
}
