package com.yuemei.api.admin.service;

import java.util.List;
import java.util.Map;

import com.yuemei.api.admin.entity.SysUser;

public interface SysUserService {

	List<SysUser> selectByMap(Map<String, Object> map);

	void updateById(SysUser user);

}
