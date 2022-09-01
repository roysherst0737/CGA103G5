package com.manager_auth.model;

import java.util.List;
import java.util.Map;

import com.manager.model.Manager_VO;

public class Manager_auth_Service {

	private Manager_auth_DAO_interface dao;

	public Manager_auth_Service() {
		dao = new Manager_auth_DAO();
	}

	public Manager_auth_VO addManager_auth(Integer mng_no, Integer mng_authfunc_no) {

		Manager_auth_VO manager_auth_VO = new Manager_auth_VO();

		manager_auth_VO.setMng_no(mng_no);
		manager_auth_VO.setMng_authfunc_no(mng_authfunc_no);
		dao.insert(manager_auth_VO);

		return manager_auth_VO;
	}

	public Manager_auth_VO updateManager(Integer mng_no, Integer mng_authfunc_no) {

		Manager_auth_VO manager_auth_VO = new Manager_auth_VO();

		manager_auth_VO.setMng_no(mng_no);
		manager_auth_VO.setMng_authfunc_no(mng_authfunc_no);
		dao.update(manager_auth_VO);

		return manager_auth_VO;
	}

	public void deleteManager_auth(Integer mng_no, Integer mng_authfunc_no) {
		
		Manager_auth_VO manager_auth_VO = new Manager_auth_VO();

		manager_auth_VO.setMng_no(mng_no);
		manager_auth_VO.setMng_authfunc_no(mng_authfunc_no);
		
		dao.delete(mng_no, mng_authfunc_no);
	}

	public Manager_auth_VO getOneManager_auth(Integer mng_no, Integer mng_authfunc_no) {
		return dao.findByPrimaryKey(mng_no, mng_authfunc_no);
	}

	public List<Manager_auth_VO> getAllManager_auth(Integer mng_no) {
		return dao.getAllManager_auth(mng_no);
	}
	public List<Manager_auth_VO> getAllManager_auth(Map<String, String[]> map) {
		return dao.getAllManager_auth(map);
	}
}
