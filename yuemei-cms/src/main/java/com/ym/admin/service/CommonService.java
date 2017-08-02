package com.ym.admin.service;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysMenu;
import com.ym.admin.entity.SysUser;

public interface CommonService {

	List<Department> selectCompanyList(String id);

	List<Dictionary> selectEducationList();

	List<SysMenu> selectMenuList();

	void addZtreeNode(SysMenu sysMenu);

	SysMenu selectSysMenuById(String id);

    void deleteTreeById(String id);
	
    List<SysUser> selectMenuByPrentIdList(String m_id);
}
