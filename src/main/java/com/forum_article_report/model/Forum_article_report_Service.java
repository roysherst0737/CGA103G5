package com.forum_article_report.model;

import java.sql.Timestamp;
import java.util.List;

public class Forum_article_report_Service {
	private Forum_article_report_DAO_interface dao;

	public Forum_article_report_Service() {
		dao = new Forum_article_report_DAO();
	}

	public Forum_article_report_VO addForum_article_report(Integer frm_art_rpt_no, Integer mem_no, Integer frm_art_no,
			Timestamp rpt_time, String rpt_content, Integer mng_no, Timestamp rpt_done_time, Integer rpt_status,
			Integer rpt_result, String rpt_note) {

		Forum_article_report_VO forum_article_reportVO = new Forum_article_report_VO();

		forum_article_reportVO.setFrm_art_rpt_no(frm_art_rpt_no);
		forum_article_reportVO.setMem_no(mem_no);
		forum_article_reportVO.setFrm_art_no(frm_art_no);
		forum_article_reportVO.setRpt_time(rpt_time);
		forum_article_reportVO.setRpt_content(rpt_content);
		forum_article_reportVO.setMng_no(mng_no);
		forum_article_reportVO.setRpt_done_time(rpt_done_time);
		forum_article_reportVO.setRpt_status(rpt_status);
		forum_article_reportVO.setRpt_result(rpt_result);
		forum_article_reportVO.setRpt_note(rpt_note);

		dao.insert(forum_article_reportVO);
		return forum_article_reportVO;
	}

	public Forum_article_report_VO updateForum_article_report(Integer frm_art_rpt_no, Integer mem_no, Integer frm_art_no,
			Timestamp rpt_time, String rpt_content, Integer mng_no, Timestamp rpt_done_time, Integer rpt_status,
			Integer rpt_result, String rpt_note) {

		Forum_article_report_VO forum_article_reportVO = new Forum_article_report_VO();

		forum_article_reportVO.setFrm_art_rpt_no(frm_art_rpt_no);
		forum_article_reportVO.setMem_no(mem_no);
		forum_article_reportVO.setFrm_art_no(frm_art_no);
		forum_article_reportVO.setRpt_time(rpt_time);
		forum_article_reportVO.setRpt_content(rpt_content);
		forum_article_reportVO.setMng_no(mng_no);
		forum_article_reportVO.setRpt_done_time(rpt_done_time);
		forum_article_reportVO.setRpt_status(rpt_status);
		forum_article_reportVO.setRpt_result(rpt_result);
		forum_article_reportVO.setRpt_note(rpt_note);
		
		
		dao.update(forum_article_reportVO);

		return forum_article_reportVO;
	}

	public void deleteForum_article_report(Integer frm_art_rpt_no) {
		dao.delete(frm_art_rpt_no);
	}

	public Forum_article_report_VO getOneForum_article_report(Integer frm_art_rpt_no) {
		return dao.findByPrimaryKey(frm_art_rpt_no);
	}

	public List<Forum_article_report_VO> getAll() {
		return dao.getAll();
	}
}