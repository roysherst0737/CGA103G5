package com.firm_survey.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Firm_survey_VO implements Serializable{

	private Integer firm_survey_no;
	private Integer act_no;
	private Timestamp survey_build_time;
	private Timestamp survey_revise_time;

	public Integer getFirm_survey_no() {
		return firm_survey_no;
	}

	public void setFirm_survey_no(Integer firm_survey_no) {
		this.firm_survey_no = firm_survey_no;
	}

	public Integer getAct_no() {
		return act_no;
	}

	public void setAct_no(Integer act_no) {
		this.act_no = act_no;
	}

	public Timestamp getSurvey_build_time() {
		return survey_build_time;
	}

	public void setSurvey_build_time(Timestamp survey_build_time) {
		this.survey_build_time = survey_build_time;
	}

	public Timestamp getSurvey_revise_time() {
		return survey_revise_time;
	}

	public void setSurvey_revise_time(Timestamp survey_revise_time) {
		this.survey_revise_time = survey_revise_time;
	}
	
	public com.act.model.Act_VO getActVO() {
	    com.act.model.Act_Service actSvc = new com.act.model.Act_Service();
	    com.act.model.Act_VO actVO = actSvc.getOneAct(act_no);
	    return actVO;
    }

}
