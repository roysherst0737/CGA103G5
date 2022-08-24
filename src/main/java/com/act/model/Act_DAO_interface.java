package com.act.model;

import java.util.*;

public interface Act_DAO_interface {

	public void insert(Act_VO act_VO);

	public void update(Act_VO act_VO);

	public void delete(Integer act_no);

	public Act_VO findByPrimaryKey(Integer act_no);

	public List<Act_VO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
