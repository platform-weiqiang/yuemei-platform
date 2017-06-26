package com.yuemei.api.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuemei.api.admin.entity.SysPermissionInit;
import com.yuemei.api.admin.mapper.SysPermissionInitMapper;
import com.yuemei.api.admin.service.SysPermissionInitService;

@Service
public class SysPermissionInitServiceImpl implements SysPermissionInitService{

	@Autowired
	private SysPermissionInitMapper sysPermissionInitMapper;
	
	@Override
	public List<SysPermissionInit> selectAll() {
		return sysPermissionInitMapper.selectAll();
	}

}
