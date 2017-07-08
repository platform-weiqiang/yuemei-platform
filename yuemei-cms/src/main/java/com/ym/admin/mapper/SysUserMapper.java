package com.ym.admin.mapper;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.SysUser;

public interface SysUserMapper {

	List<SysUser> selectByList();

	List<Department> selectDepartmentByTree();

}
