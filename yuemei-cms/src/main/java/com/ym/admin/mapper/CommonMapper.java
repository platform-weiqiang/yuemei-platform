package com.ym.admin.mapper;

import java.util.List;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysMenu;
import com.ym.admin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

public interface CommonMapper {

	List<Department> selectCompanyList(String id);

	List<Dictionary> selectEducationList();

	List<SysMenu> selectMenuList();

	void addSysMenu(SysMenu menu);

	SysMenu selectSysMenuById(String id);

	void updateSysMenu(SysMenu sysMenu);

    List<String> selectMenuListString(String id);

	void updateSysMenuStatus(String[] str);

	List<SysUser> selectMenuByPrentIdList(String m_id);
}
