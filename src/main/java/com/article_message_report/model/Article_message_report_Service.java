package com.article_message_report.model;

import java.sql.Timestamp;
import java.util.List;



public class Article_message_report_Service {
	private Article_message_report_DAO_interface dao;

	public Article_message_report_Service() {
		dao = new Article_message_report_DAO();
	}

	public Article_message_report_VO addArticle_message_report(Integer mem_no, Integer art_msg_no,Timestamp rpt_time,
			String rpt_msg_content, Integer mng_no, Timestamp msg_done_time, Integer msg_states,
			Integer msg_result,String msg_note) {

		Article_message_report_VO article_message_report_VO = new Article_message_report_VO();

		
		article_message_report_VO.setMem_no(mem_no);
		article_message_report_VO.setArt_msg_no(art_msg_no);
		article_message_report_VO.setRpt_time(rpt_time);
		article_message_report_VO.setRpt_msg_content(rpt_msg_content);
		article_message_report_VO.setMng_no(mng_no);
		article_message_report_VO.setMsg_done_time(msg_done_time);
		article_message_report_VO.setMsg_states(msg_states);
		article_message_report_VO.setMsg_result(msg_result);
		article_message_report_VO.setMsg_note(msg_note);
		
		dao.insert(article_message_report_VO);

		return article_message_report_VO;
	}

	public Article_message_report_VO updateArticle_message_report(Integer art_msg_rpt,Integer mem_no, Integer art_msg_no,Timestamp rpt_time,
			String rpt_msg_content, Integer mng_no, Timestamp msg_done_time, Integer msg_states,
			Integer msg_result,String msg_note) {

		Article_message_report_VO article_message_report_VO = new Article_message_report_VO();

		article_message_report_VO.setArt_msg_rpt(art_msg_rpt);
		article_message_report_VO.setMem_no(mem_no);
		article_message_report_VO.setArt_msg_no(art_msg_no);
		article_message_report_VO.setRpt_time(rpt_time);
		article_message_report_VO.setRpt_msg_content(rpt_msg_content);
		article_message_report_VO.setMng_no(mng_no);
		article_message_report_VO.setMsg_done_time(msg_done_time);
		article_message_report_VO.setMsg_states(msg_states);
		article_message_report_VO.setMsg_result(msg_result);
		article_message_report_VO.setMsg_note(msg_note);
		dao.update(article_message_report_VO);

		return article_message_report_VO;
	}

	public void deleteArticle_message_report(Integer art_msg_rpt) {
		dao.delete(art_msg_rpt);
	}

	public Article_message_report_VO getOneArticle_message_report(Integer art_msg_rpt) {
		return dao.findByPrimaryKey(art_msg_rpt);
	}

	public List<Article_message_report_VO> getAll() {
		return dao.getAll();
	}
}