package com.pub.model;

import java.util.List;

public class pub_Service {
	private Pub_DAO_interface dao;
	
	public pub_Service() {
		dao =new Pub_DAO();
	}


	public void insert(Pub_VO pubVO) {
		dao.insert(pubVO);
	}

	
	public void update(Pub_VO pubVO) {
		dao.update(pubVO);
	}

	
	public void updateRate(Integer pub_no, Integer pub_rate_sum, Integer pub_ratetotal) {
		dao.updateRate(pub_no, pub_rate_sum, pub_ratetotal);		
	}

	
	public void updateOpen(Integer pub_no, Integer pub_open) {
		dao.updateOpen(pub_no, pub_open);
	}

	
	public void updateApplication(Integer pub_no, Integer pub_application) {
		dao.updateApplication(pub_no, pub_application);
	}

	
	public Pub_VO findByPrimaryKey(Integer pub_no) {
		return dao.findByPrimaryKey(pub_no);
	}

	
	public List<Pub_VO> getAll() {
		return dao.getAll();
	}

}
