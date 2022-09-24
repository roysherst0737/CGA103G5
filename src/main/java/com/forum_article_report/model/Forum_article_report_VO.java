package com.forum_article_report.model;

import java.sql.Timestamp;

import com.manager.model.Manager_Service;
import com.manager.model.Manager_VO;
import com.mem.model.Mem_Service;
import com.mem.model.Mem_VO;

public class Forum_article_report_VO implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer frm_art_rpt_no;
	private Integer mem_no;
	private Integer frm_art_no;
	private Timestamp rpt_time;
	private String rpt_content;
	private Integer mng_no;
	private Timestamp rpt_done_time;
	private Integer rpt_status;
	private Integer rpt_result;
	private String rpt_note;

	public Integer getFrm_art_rpt_no() {
		return frm_art_rpt_no;
	}

	public void setFrm_art_rpt_no(Integer frm_art_rpt_no) {
		this.frm_art_rpt_no = frm_art_rpt_no;
	}

	public Integer getMem_no() {
		return mem_no;
	}

	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}

	public Integer getFrm_art_no() {
		return frm_art_no;
	}

	public void setFrm_art_no(Integer frm_art_no) {
		this.frm_art_no = frm_art_no;
	}

	public Timestamp getRpt_time() {
		return rpt_time;
	}

	public void setRpt_time(Timestamp rpt_time) {
		this.rpt_time = rpt_time;
	}

	public String getRpt_content() {
		return rpt_content;
	}

	public void setRpt_content(String rpt_content) {
		this.rpt_content = rpt_content;
	}

	public Integer getMng_no() {
		return mng_no;
	}

	public void setMng_no(Integer mng_no) {
		this.mng_no = mng_no;
	}

	public Timestamp getRpt_done_time() {
		return rpt_done_time;
	}

	public void setRpt_done_time(Timestamp rpt_done_time) {
		this.rpt_done_time = rpt_done_time;
	}

	public Integer getRpt_status() {
		return rpt_status;
	}

	public void setRpt_status(Integer rpt_status) {
		this.rpt_status = rpt_status;
	}

	public Integer getRpt_result() {
		return rpt_result;
	}

	public void setRpt_result(Integer rpt_result) {
		this.rpt_result = rpt_result;
	}

	public String getRpt_note() {
		return rpt_note;
	}

	public void setRpt_note(String rpt_note) {
		this.rpt_note = rpt_note;
	}


	public Manager_VO getManager_VO() {
		Manager_Service manager_Svc = new Manager_Service();
		Manager_VO manager_VO = manager_Svc.getOneManager(mng_no);
		return manager_VO;
	}
	
	public Mem_VO getMem_VO() {
		Mem_Service mem_Svc = new Mem_Service();
		Mem_VO mem_VO = mem_Svc.getOneMem(mem_no);
		return mem_VO;
	}

}