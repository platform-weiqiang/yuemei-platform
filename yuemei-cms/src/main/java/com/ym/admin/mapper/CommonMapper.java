package com.ym.admin.mapper;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysMenu;

public interface CommonMapper {

	List<Department> selectCompanyList(String id);

	List<Dictionary> selectEducationList();

	List<SysMenu> selectMenuList();

}
