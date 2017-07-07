package com.ym.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
