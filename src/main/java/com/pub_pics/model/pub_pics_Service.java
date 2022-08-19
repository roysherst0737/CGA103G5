package com.pub_pics.model;

import java.util.List;

public class pub_pics_Service{
	Pub_pics_DAO_interface dao;
	public pub_pics_Service(){
		dao=new Pub_pics_DAO();
	}
	
	public void insert(Pub_pics_VO pub_pic_VO) {
		dao.insert(pub_pic_VO);
	}
	
	public void update(Pub_pics_VO pub_pic_VO) {
		dao.update(pub_pic_VO);
	}
	
	public void delete(Pub_pics_VO pub_pic_VO) {
		dao.delete(pub_pic_VO);
	}
	
	public Pub_pics_VO findByPrimaryKey(Integer pub_pic_no) {
		return dao.findByPrimaryKey(pub_pic_no);
	}
	
	public List<Pub_pics_VO> getAll(Integer pub_no) {
		return dao.getAll(pub_no);
	}
}
