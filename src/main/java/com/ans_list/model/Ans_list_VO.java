package com.ans_list.model;

import java.io.Serializable;

public class Ans_list_VO implements Serializable{

	private Integer question_no;
	private Integer firm_survey_no;
	private Integer mem_no;
	private String ans;

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

	public Integer getMem_no() {
		return mem_no;
	}

	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
	public com.question.model.Question_VO getQuestionVO() {
	    com.question.model.Question_Service questionSvc = new com.question.model.Question_Service();
	    com.question.model.Question_VO questionVO = questionSvc.getOneQuestion(question_no);
	    return questionVO;
    }
	
	public com.mem.model.Mem_VO getMemVO() {
	    com.mem.model.Mem_Service memSvc = new com.mem.model.Mem_Service();
	    com.mem.model.Mem_VO memVO = memSvc.getOneMem(mem_no);
	    return memVO;
    }
}
