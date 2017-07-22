package com.ym.admin.service;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysMenu;

public interface CommonService {

	List<Department> selectCompanyList(String id);

	List<Dictionary> selectEducationList();

	List<SysMenu> selectMenuList();

	SysMenu addZtreeNode(SysMenu sysMenu, Integer type);

	SysMenu selectSysMenuById(String id);

}
