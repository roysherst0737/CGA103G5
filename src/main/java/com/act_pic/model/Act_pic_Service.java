package com.act_pic.model;

import java.util.List;

public class Act_pic_Service {

	private Act_pic_DAO_interface dao;

	public Act_pic_Service() {
		dao = new Act_pic_DAO();
	}

	public Act_pic_VO addAct_pic(Integer act_no, byte[] act_pic, String act_pic_name) {

		Act_pic_VO act_pic_VO = new Act_pic_VO();

		act_pic_VO.setAct_no(act_no);
		act_pic_VO.setAct_pic(act_pic);
		act_pic_VO.setAct_pic_name(act_pic_name);

		dao.insert(act_pic_VO);

		return act_pic_VO;
	}

	public Act_pic_VO updateAct_pic(Integer act_no, byte[] act_pic, String act_pic_name, Integer act_pic_no) {

		Act_pic_VO act_pic_VO = new Act_pic_VO();

		act_pic_VO.setAct_no(act_no);
		act_pic_VO.setAct_pic(act_pic);
		act_pic_VO.setAct_pic_name(act_pic_name);
		act_pic_VO.setAct_pic_no(act_pic_no);

		dao.update(act_pic_VO);

		return act_pic_VO;
	}

	public void deleteAct_pic(Integer act_pic_no) {
		dao.delete(act_pic_no);
	}

	public Act_pic_VO getOneAct_pic(Integer act_pic_no) {
		return dao.findByPrimaryKey(act_pic_no);
	}

	public List<Act_pic_VO> getAll() {
		return dao.getAll();
	}

}
