package com.act_pic.model;

import java.util.*;

public interface Act_pic_DAO_interface {

	public void insert(Act_pic_VO act_pic_VO);

	public void update(Act_pic_VO act_pic_VO);

	public void delete(Integer act_pic_no);

	public Act_pic_VO findByPrimaryKey(Integer act_pic_no);

	public List<Act_pic_VO> getAll();
	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
