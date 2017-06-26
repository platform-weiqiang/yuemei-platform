package com.yuemei.api.admin.mapper;

import java.util.List;
import java.util.Map;
import com.yuemei.api.admin.entity.SysUser;

public interface SysUserServiceMapper {

	List<SysUser> selectByMap(Map<String, Object> map);

}
