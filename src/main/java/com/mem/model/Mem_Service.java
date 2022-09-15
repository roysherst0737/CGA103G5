package com.mem.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Mem_Service {

	private Mem_DAO_interface dao;

	public Mem_Service() {
		dao = new Mem_DAO();
	}

	public Mem_VO addMem(String mem_account,String mem_password,Integer mem_gender,String mem_last_name,
			String mem_first_name,String mem_nickname,String mem_tel_no,String mem_cel_no,String mem_email,
			String mem_id,Date mem_birth,String mem_addr,Integer mem_permission) {

		Mem_VO memVO = new Mem_VO();

		memVO.setMem_account(mem_account);
		memVO.setMem_password(mem_password);
		memVO.setMem_gender(mem_gender);
		memVO.setMem_last_name(mem_last_name);
		memVO.setMem_first_name(mem_first_name);
		memVO.setMem_nickname(mem_nickname);
		memVO.setMem_tel_no(mem_tel_no);
		memVO.setMem_cel_no(mem_cel_no);
		memVO.setMem_email(mem_email);
		memVO.setMem_id(mem_id);	
		memVO.setMem_birth(mem_birth);
		memVO.setMem_addr(mem_addr);
		memVO.setMem_permission(mem_permission);

		dao.insert(memVO);

		return memVO;
	}

	public Mem_VO updateMem(String mem_account,String mem_password,Integer mem_gender,String mem_last_name,
			String mem_first_name,String mem_nickname,String mem_tel_no,String mem_cel_no,String mem_email,
			String mem_id,Date mem_birth,String mem_addr,Integer mem_permission,Integer status,
			Timestamp mem_build_time,Integer mem_cert_status,Integer mem_no) {

		Mem_VO memVO = new Mem_VO();

		memVO.setMem_account(mem_account);
		memVO.setMem_password(mem_password);
		memVO.setMem_gender(mem_gender);
		memVO.setMem_last_name(mem_last_name);
		memVO.setMem_first_name(mem_first_name);
		memVO.setMem_nickname(mem_nickname);
		memVO.setMem_tel_no(mem_tel_no);
		memVO.setMem_cel_no(mem_cel_no);
		memVO.setMem_email(mem_email);
		memVO.setMem_id(mem_id);	
		memVO.setMem_birth(mem_birth);
		memVO.setMem_addr(mem_addr);
		memVO.setMem_permission(mem_permission);
		memVO.setStatus(status);
		memVO.setMem_build_time(mem_build_time);
		memVO.setMem_cert_status(mem_cert_status);
		memVO.setMem_no(mem_no);
		dao.update(memVO);

		return memVO;
	}

	public void deleteMem(Integer mem_no) {
		dao.delete(mem_no);
	}

	public Mem_VO getOneMem(Integer mem_no) {
		return dao.findByPrimaryKey(mem_no);
	}
	
	public Mem_VO getOneMem(String mem_account) {
		return dao.findByPrimaryKey(mem_account);
	}

	public List<Mem_VO> getAll() {
		return dao.getAll();
	}
	
	public Mem_VO loginMem(String mem_account,String mem_password) {
		return dao.login(mem_account, mem_password);
	}
}

