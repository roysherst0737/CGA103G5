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

}
