package com.firm_survey.model;


import java.util.List;
import java.util.Set;

public class Firm_survey_Service {

	private Firm_survey_DAO_interface dao;

	public Firm_survey_Service() {
		dao = new Firm_survey_DAO();
	}

	public Firm_survey_VO addFirm_survey(Integer act_no) {

		Firm_survey_VO firm_survey_VO = new Firm_survey_VO();

		firm_survey_VO.setAct_no(act_no);

		dao.insert(firm_survey_VO);

		return firm_survey_VO;
	}

	public Firm_survey_VO updateFirm_survey(Integer act_no, Integer firm_survey_no) {

		Firm_survey_VO firm_survey_VO = new Firm_survey_VO();

		firm_survey_VO.setAct_no(act_no);
		firm_survey_VO.setFirm_survey_no(firm_survey_no);

		dao.update(firm_survey_VO);

		return firm_survey_VO;
	}

	public void deleteFirm_survey(Integer firm_survey_no) {
		dao.delete(firm_survey_no);
	}

	public Firm_survey_VO getOneFirm_survey(Integer firm_survey_no) {
		return dao.findByPrimaryKey(firm_survey_no);
	}

	public List<Firm_survey_VO> getAll() {
		return dao.getAll();
	}

	public Set<Integer> getAll_from_act_no(Integer act_no) {
		return dao.getAll_from_act_no(act_no);
	}

}
