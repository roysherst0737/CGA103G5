package com.manager.model;

import java.io.IOException;
import java.util.List;

public class Manager_Service {

	private Manager_DAO_interface dao;

	public Manager_Service() {
		dao = new Manager_DAO();
	}

	public Manager_VO addManager(String mng_account, String mng_password, String mng_name,
			String mng_phone, byte[] mng_pic, Integer mng_status) {

		Manager_VO manager_VO = new Manager_VO();

		manager_VO.setMng_account(mng_account);
		manager_VO.setMng_password(mng_password);
		manager_VO.setMng_name(mng_name);
		manager_VO.setMng_phone(mng_phone);
		manager_VO.setMng_pic(mng_pic);
		manager_VO.setMng_status(mng_status);
		dao.insert(manager_VO);

		return manager_VO;
	}

	public Manager_VO updateManager(Integer mng_no, String mng_account, String mng_password,
			String mng_name, String mng_phone, byte[] mng_pic, Integer mng_status) {

		Manager_VO manager_VO = new Manager_VO();

		manager_VO.setMng_no(mng_no);
		manager_VO.setMng_account(mng_account);
		manager_VO.setMng_password(mng_password);
		manager_VO.setMng_name(mng_name);
		manager_VO.setMng_phone(mng_phone);
		manager_VO.setMng_pic(mng_pic);
		manager_VO.setMng_status(mng_status);
		dao.update(manager_VO);

		return manager_VO;
	}

	public void deleteManager(Integer mng_no) {
		dao.delete(mng_no);
	}

	public Manager_VO getOneManager(Integer mng_no) {
		return dao.findByPrimaryKey(mng_no);
	}

	public List<Manager_VO> getAllManager() {
		return dao.getAllManager();
	}
}
