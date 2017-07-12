package com.ym.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysUser;
import com.ym.admin.mapper.SysUserMapper;
import com.ym.admin.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Override
	public List<SysUser> selectByList() {
		return sysUserMapper.selectByList();
	}

	@Override
	public List<Department> selectDepartmentByTree() {
		return sysUserMapper.selectDepartmentByTree();
	}

	@Override
	public List<Dictionary> slectByDictionaryList() {
		return sysUserMapper.slectByDictionaryList();
	}

	@Override
	public void addDictionary(Dictionary dictionary) {
		if (dictionary.getId()==null) {
			sysUserMapper.addDictionary(dictionary);
		}else{
			sysUserMapper.updateDictionary(dictionary);
		}
	}

	@Override
	public void addSysUser(SysUser user) {
		if (user.getId()==null) {
			sysUserMapper.addSysUser(user);
		}else {
			sysUserMapper.updateSysUser(user);
		}
	}

	@Override
	public Dictionary getDictionaryById(Integer id) {
		return sysUserMapper.getDictionaryById(id);
	}

	@Override
	public void deleteDictionaryById(Integer[] id) {
		sysUserMapper.deleteDictionaryById(id);
	}
}
