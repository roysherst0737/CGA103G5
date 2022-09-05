package com.act.model;

import java.sql.Timestamp;
import java.util.List;

public class Act_Service {

	private Act_DAO_interface dao;

	public Act_Service() {
		dao = new Act_DAO();
	}

	public Act_VO addAct(Integer pub_no, String act_name, String act_detail, String act_loc, Timestamp act_launch_time,
			Timestamp act_off_time, Integer current_count, Integer max_count, Integer min_count,
			Timestamp sign_up_begin_time, Timestamp sign_up_end_time, Timestamp act_start_time, Timestamp act_end_time) {

		Act_VO act_VO = new Act_VO();

		act_VO.setPub_no(pub_no);
		act_VO.setAct_name(act_name);
		act_VO.setAct_detail(act_detail);
		act_VO.setAct_loc(act_loc);
		act_VO.setAct_launch_time(act_launch_time);
		act_VO.setAct_off_time(act_off_time);
		act_VO.setCurrent_count(current_count);
		act_VO.setMax_count(max_count);
		act_VO.setMin_count(min_count);
		act_VO.setSign_up_begin_time(sign_up_begin_time);
		act_VO.setSign_up_end_time(sign_up_end_time);
		act_VO.setAct_start_time(act_start_time);
		act_VO.setAct_end_time(act_end_time);


		dao.insert(act_VO);

		return act_VO;
	}

	public Act_VO updateAct(Integer pub_no, String act_name, String act_detail, String act_loc,
			Timestamp act_launch_time, Timestamp act_off_time, Integer current_count, Integer max_count,
			Integer min_count, Timestamp sign_up_begin_time, Timestamp sign_up_end_time, Timestamp act_start_time,
			Timestamp act_end_time, Integer act_status, Integer apply_status, Integer act_no) {

		Act_VO act_VO = new Act_VO();

		act_VO.setPub_no(pub_no);
		act_VO.setAct_name(act_name);
		act_VO.setAct_detail(act_detail);
		act_VO.setAct_loc(act_loc);
		act_VO.setAct_launch_time(act_launch_time);
		act_VO.setAct_off_time(act_off_time);
		act_VO.setCurrent_count(current_count);
		act_VO.setMax_count(max_count);
		act_VO.setMin_count(min_count);
		act_VO.setSign_up_begin_time(sign_up_begin_time);
		act_VO.setSign_up_end_time(sign_up_end_time);
		act_VO.setAct_start_time(act_start_time);
		act_VO.setAct_end_time(act_end_time);
		act_VO.setAct_status(act_status);
		act_VO.setApply_status(apply_status);
		act_VO.setAct_no(act_no);

		dao.update(act_VO);

		return act_VO;
	}

	public void deleteAct(Integer act_no) {
		dao.delete(act_no);
	}

	public Act_VO getOneAct(Integer act_no) {
		return dao.findByPrimaryKey(act_no);
	}

	public List<Act_VO> getAll() {
		return dao.getAll();
	}
}
