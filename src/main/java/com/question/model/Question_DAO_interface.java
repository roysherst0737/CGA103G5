package com.question.model;

import java.util.List;

public interface Question_DAO_interface {

	public void insert(Question_VO question_VO);

	public void update(Question_VO question_VO);

	public void delete(Integer question_no);

	public Question_VO findByPrimaryKey(Integer question_no);

	public List<Question_VO> getAll();
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
