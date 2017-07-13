package com.ym.admin.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysUser;
import com.ym.admin.mapper.SysUserMapper;
import com.ym.admin.service.SysUserService;
import com.ym.common.utils.UUIDUtil;

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
		if (StringUtils.isNotBlank(dictionary.getId())) {
			sysUserMapper.updateDictionary(dictionary);
		}else{
			dictionary.setId(UUIDUtil.uuid());
			sysUserMapper.addDictionary(dictionary);
		}
	}

	@Override
	public void addSysUser(SysUser user) {
		if (StringUtils.isNotBlank(user.getId())) {
			sysUserMapper.updateSysUser(user);
		}else {
			user.setId(UUIDUtil.uuid());
			sysUserMapper.addSysUser(user);
		}
	}

	@Override
	public Dictionary getDictionaryById(String id) {
		return sysUserMapper.getDictionaryById(id);
	}

	@Override
	public void deleteDictionaryById(Integer[] id) {
		sysUserMapper.deleteDictionaryById(id);
	}
}
