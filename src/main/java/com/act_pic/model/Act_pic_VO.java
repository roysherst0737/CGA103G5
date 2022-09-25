package com.act_pic.model;

import java.io.Serializable;
import java.sql.Blob;

public class Act_pic_VO implements Serializable {

	private Integer act_pic_no;
	private Integer act_no;
	private byte[] act_pic;
	private String act_pic_name;

	public Integer getAct_pic_no() {
		return act_pic_no;
	}

	public void setAct_pic_no(Integer act_pic_no) {
		this.act_pic_no = act_pic_no;
	}

	public Integer getAct_no() {
		return act_no;
	}

	public void setAct_no(Integer act_no) {
		this.act_no = act_no;
	}

	public byte[] getAct_pic() {
		return act_pic;
	}

	public void setAct_pic(byte[] act_pic) {
		this.act_pic = act_pic;
	}

	public String getAct_pic_name() {
		return act_pic_name;
	}

	public void setAct_pic_name(String act_pic_name) {
		this.act_pic_name = act_pic_name;
	}
	
    // for join dname from act_picno
    public com.act.model.Act_VO getActVO() {
	    com.act.model.Act_Service actSvc = new com.act.model.Act_Service();
	    com.act.model.Act_VO actVO = actSvc.getOneAct(act_no);
	    return actVO;
    }

}
