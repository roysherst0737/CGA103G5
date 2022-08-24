package com.question.model;

import java.io.Serializable;

public class Question_VO implements Serializable{
	private Integer question_no;
	private String que;

	public Integer getQuestion_no() {
		return question_no;
	}

	public void setQuestion_no(Integer question_no) {
		this.question_no = question_no;
	}

	public String getQue() {
		return que;
	}

	public void setQue(String que) {
		this.que = que;
	}

}
