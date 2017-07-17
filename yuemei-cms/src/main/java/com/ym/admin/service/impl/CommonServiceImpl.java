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
	public SysMenu addZtreeNode(SysMenu sysMenu,Integer type) {
		SysMenu menu=new SysMenu();
		menu.setId(UUIDUtil.uuid());
		menu.setParent_id(sysMenu.getId());
		menu.setName("新菜单");
		menu.setNum(sysMenu.getNum()+1);
		menu.setIsmenu(1);
		menu.setTips("新菜单");
		menu.setIsopen(1);
		menu.setCreate_date(new Date());
		if (type==1) {
			menu.setLevels(sysMenu.getLevels());
			
		}
		return null;
	}
}
