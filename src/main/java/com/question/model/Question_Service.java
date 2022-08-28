package com.question.model;

import java.util.List;

public class Question_Service {

	private Question_DAO_interface dao;

	public Question_Service() {
		dao = new Question_DAO();
	}

	public Question_VO addQuestion(String que) {

		Question_VO question_VO = new Question_VO();

		question_VO.setQue(que);

		dao.insert(question_VO);

		return question_VO;
	}

	public Question_VO updateQuestion(String que, Integer question_no) {

		Question_VO question_VO = new Question_VO();

		question_VO.setQue(que);
		question_VO.setQuestion_no(question_no);

		dao.update(question_VO);

		return question_VO;
	}

	public void deleteQuestion(Integer question_no) {
		dao.delete(question_no);
	}

	public Question_VO getOneQuestion(Integer question_no) {
		return dao.findByPrimaryKey(question_no);
	}

	public List<Question_VO> getAll() {
		return dao.getAll();
	}

}
