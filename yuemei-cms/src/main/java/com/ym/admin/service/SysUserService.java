package com.ym.admin.service;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.SysUser;

public interface SysUserService {

	List<SysUser> selectByList();

	List<Department> selectDepartmentByTree();


}
