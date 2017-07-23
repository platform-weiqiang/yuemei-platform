package com.ym.admin.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysMenu;
import com.ym.admin.mapper.CommonMapper;
import com.ym.admin.service.CommonService;import com.ym.common.utils.UUIDUtil;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;

	@Override
	public List<Department> selectCompanyList(String id) {
		return commonMapper.selectCompanyList(id);
	}

	@Override
	public List<Dictionary> selectEducationList() {
		return commonMapper.selectEducationList();
	}

	@Override
	public List<SysMenu> selectMenuList() {
		return commonMapper.selectMenuList();
	}

	/**
	 * 添加属性菜单
	 */
	@Override
	public void addZtreeNode(SysMenu sysMenu) {
		SysMenu sysMenuNode=commonMapper.selectSysMenuById(sysMenu.getM_id());
		sysMenu.setM_id(UUIDUtil.uuid());
		sysMenu.setNum(sysMenuNode.getNum()+1);
		sysMenu.setIsmenu(1);
		sysMenu.setIsopen(1);
		sysMenu.setCreate_date(new Date());
		if (sysMenu.getNodeDataType()==1) {
			sysMenu.setParent_id(sysMenuNode.getParent_id());
			sysMenu.setLevels(sysMenuNode.getLevels());
		}else{
			sysMenu.setParent_id(sysMenuNode.getM_id());
			sysMenu.setLevels(sysMenuNode.getLevels()+1);
		}
		commonMapper.addSysMenu(sysMenu);
	}

	@Override
	public SysMenu selectSysMenuById(String id) {
		return commonMapper.selectSysMenuById(id);
	}
}
