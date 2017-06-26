package com.yuemei.api.admin.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuemei.api.admin.entity.SysUser;
import com.yuemei.api.admin.mapper.SysUserServiceMapper;

@Service
public class SysUserServiceImpl implements com.yuemei.api.admin.service.SysUserService {

	@Autowired
	private SysUserServiceMapper sysUserServiceMapper;
	
	@Override
	public List<SysUser> selectByMap(Map<String, Object> map) {
		return sysUserServiceMapper.selectByMap(map);
	}

	@Override
	public void updateById(SysUser user) {
		
	}

}
