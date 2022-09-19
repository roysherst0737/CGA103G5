package com.manager_authfunc.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.manager.model.Manager_VO;
import com.manager.model.Manager_Service;

public class Manager_authfunc_Service {

	private Manager_authfunc_DAO_interface dao;

	public Manager_authfunc_Service() {
		dao = new Manager_authfunc_DAO();
	}

	public Manager_authfunc_VO addManager_authfunc(String mng_authfunc_name) {

		Manager_authfunc_VO manager_authfunc_VO = new Manager_authfunc_VO();

		manager_authfunc_VO.setMng_authfunc_name(mng_authfunc_name);
		dao.insert(manager_authfunc_VO);

		return manager_authfunc_VO;
	}

	public Manager_authfunc_VO updateManager_authfunc(Integer mng_authfunc_no, String mng_authfunc_name) {

		Manager_authfunc_VO manager_authfunc_VO = new Manager_authfunc_VO();

		manager_authfunc_VO.setMng_authfunc_no(mng_authfunc_no);
		manager_authfunc_VO.setMng_authfunc_name(mng_authfunc_name);
		dao.update(manager_authfunc_VO);

		return manager_authfunc_VO;
	}

	public void deleteManager_authfunc(Integer mng_authfunc_no) {
		dao.delete(mng_authfunc_no);
	}

	public Manager_authfunc_VO getOneManager_authfunc(Integer mng_authfunc_no) {
		return dao.findByPrimaryKey(mng_authfunc_no);
	}

	public List<Manager_authfunc_VO> getAllManager_authfunc() {
		return dao.getAllManager_authfunc();
	}
	public List<Manager_authfunc_VO> getAllManager_authfunc(Map<String, String[]> map) {
		return dao.getAllManager_authfunc(map);
	}
	public Set<Manager_VO> getMngsByMng_authfunc_no(Integer mng_authfunc_no){
		return dao.getMngsByMng_authfunc_no(mng_authfunc_no);
	}
	public void insertWithMngs(Manager_authfunc_VO manager_authfunc_VO , List<Manager_VO> list) {
		return;
	}
}
