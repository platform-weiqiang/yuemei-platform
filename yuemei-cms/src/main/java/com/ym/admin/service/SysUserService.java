package com.ym.admin.service;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysUser;

public interface SysUserService {

	List<SysUser> selectByList();

	List<Department> selectDepartmentByTree();

	List<Dictionary> slectByDictionaryList();

	void addDictionary(Dictionary dictionary);

	void addSysUser(SysUser user);

	Dictionary getDictionaryById(String id);

	void deleteDictionaryById(Integer[] id);


}
