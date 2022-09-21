package com.question_list.model;

import java.io.Serializable;

public class Question_list_VO implements Serializable{

	private Integer question_no;
	private Integer firm_survey_no;

	public Integer getQuestion_no() {
		return question_no;
	}

	public void setQuestion_no(Integer question_no) {
		this.question_no = question_no;
	}

	public Integer getFirm_survey_no() {
		return firm_survey_no;
	}

	public void setFirm_survey_no(Integer firm_survey_no) {
		this.firm_survey_no = firm_survey_no;
	}
	
    // for join dname from act_picno
    public com.question.model.Question_VO getQuestionVO() {
	    com.question.model.Question_Service questionSvc = new com.question.model.Question_Service();
	    com.question.model.Question_VO questionVO = questionSvc.getOneQuestion(question_no);
	    return questionVO;
    }

}
