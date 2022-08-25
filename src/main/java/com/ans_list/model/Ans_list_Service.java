package com.ans_list.model;

import java.util.List;

public class Ans_list_Service {

	private Ans_list_DAO_interface dao;

	public Ans_list_Service() {
		dao = new Ans_list_DAO();
	}

	public Ans_list_VO addAns_list(Integer question_no, Integer firm_survey_no, Integer mem_no, String ans) {

		Ans_list_VO ans_list_VO = new Ans_list_VO();

		ans_list_VO.setQuestion_no(question_no);
		ans_list_VO.setFirm_survey_no(firm_survey_no);
		ans_list_VO.setMem_no(mem_no);
		ans_list_VO.setAns(ans);

		dao.insert(ans_list_VO);

		return ans_list_VO;
	}

	public Ans_list_VO updateAns_list(String ans, Integer question_no, Integer firm_survey_no, Integer mem_no) {

		Ans_list_VO ans_list_VO = new Ans_list_VO();

		ans_list_VO.setAns(ans);
		ans_list_VO.setQuestion_no(question_no);
		ans_list_VO.setFirm_survey_no(firm_survey_no);
		ans_list_VO.setMem_no(mem_no);

		dao.update(ans_list_VO);

		return ans_list_VO;
	}

	public void deleteAns_list(Integer question_no, Integer firm_survey_no, Integer mem_no) {
		dao.delete(question_no, firm_survey_no, mem_no);
	}

	public Ans_list_VO getOneAns_list(Integer question_no, Integer firm_survey_no, Integer mem_no) {
		return dao.findByPrimaryKey(question_no, firm_survey_no, mem_no);
	}

	public List<Ans_list_VO> getAll() {
		return dao.getAll();
	}

}
