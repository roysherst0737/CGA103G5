package com.act_sign_up.model;

import java.util.List;
import java.util.Set;

public interface Act_sign_up_DAO_interface {

	public void insert(Act_sign_up_VO act_sign_up_VO);

	public void update(Act_sign_up_VO act_sign_up_VO);

	public void delete(Integer sign_up_no);

	public Act_sign_up_VO findByPrimaryKey(Integer sign_up_no);

	public List<Act_sign_up_VO> getAll();
	
	public Set<Integer> getAct_sign_up(Integer mem_no);
	
	public List<Act_sign_up_VO> getMy_act_sign_up(Integer mem_no);
	
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
