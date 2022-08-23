package com.push_ads.model;

import java.util.List;

import oracle.sql.BLOB;



public class Push_Ads_Service {
	
	private Push_Ads_DAO_interface dao;

	public Push_Ads_Service() {
		dao = new Push_Ads_DAO();
	}

	public Push_Ads_VO addEmp(String ads_content,Integer prod_no,Integer act_no, 
	Integer pub_no,BLOB ads_pic,Integer weights) {

		Push_Ads_VO pushAdsVO = new Push_Ads_VO();

		pushAdsVO.setAds_content(ads_content);
		pushAdsVO.setProd_no(prod_no);
		pushAdsVO.setAct_no(act_no);
		pushAdsVO.setPub_no(pub_no);
		pushAdsVO.setAds_pic(ads_pic);
		pushAdsVO.setWeights(weights);

		dao.insert(pushAdsVO);

		return pushAdsVO;
	}

	public Push_Ads_VO updateEmp(String ads_content,Integer prod_no,Integer act_no, 
			Integer pub_no,BLOB ads_pic,Integer weights,Integer ads_no) {

		Push_Ads_VO pushAdsVO = new Push_Ads_VO();

		pushAdsVO.setAds_content(ads_content);
		pushAdsVO.setProd_no(prod_no);
		pushAdsVO.setAct_no(act_no);
		pushAdsVO.setPub_no(pub_no);
		pushAdsVO.setAds_pic(ads_pic);
		pushAdsVO.setWeights(weights);
		pushAdsVO.setAds_no(ads_no);
		dao.update(pushAdsVO);

		return pushAdsVO;
	}

	public void deleteEmp(Integer ads_no) {
		dao.delete(ads_no);
	}

	public Push_Ads_VO getOneEmp(Integer ads_no) {
		return dao.findByPrimaryKey(ads_no);
	}

	public List<Push_Ads_VO> getAll() {
		return dao.getAll();
	}
}