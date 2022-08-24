package com.question_list.model;

import java.util.List;

public class Question_list_Service {

	private Question_list_DAO_interface dao;

	public Question_list_Service() {
		dao = new Question_list_DAO();
	}

	public Question_list_VO addQuestion_list(Integer question_no, Integer firm_survey_no) {

		Question_list_VO question_list_VO = new Question_list_VO();

		question_list_VO.setQuestion_no(question_no);
		question_list_VO.setFirm_survey_no(firm_survey_no);

		dao.insert(question_list_VO);

		return question_list_VO;
	}

	public Question_list_VO updateQuestion_list(Integer question_no, Integer firm_survey_no) {

		Question_list_VO question_list_VO = new Question_list_VO();

		question_list_VO.setQuestion_no(question_no);
		question_list_VO.setFirm_survey_no(firm_survey_no);
		question_list_VO.setQuestion_no(question_no);
		question_list_VO.setFirm_survey_no(firm_survey_no);

		dao.update(question_list_VO);

		return question_list_VO;
	}

	public void deleteQuestion_list(Integer question_no, Integer firm_survey_no) {
		dao.delete(question_no, firm_survey_no);
	}

	public Question_list_VO getOneQuestion_list(Integer question_no, Integer firm_survey_no) {
		return dao.findByPrimaryKey(question_no, firm_survey_no);
	}

	public List<Question_list_VO> getAll() {
		return dao.getAll();
	}

}
