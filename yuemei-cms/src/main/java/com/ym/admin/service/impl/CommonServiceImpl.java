package com.ym.admin.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		return commonMapper.selectMenuList(null);
	}

	/**
	 * 添加属性菜单
	 */
	@Override
	public void addZtreeNode(SysMenu sysMenu) {
		if (sysMenu.getNodeDataType()==1) {
			SysMenu sysMenuNode=commonMapper.selectSysMenuById(sysMenu.getM_id());
			sysMenu.setM_id(UUIDUtil.uuid());
			sysMenu.setNum(sysMenuNode.getNum()+1);
			sysMenu.setIsmenu(1);
			sysMenu.setIsopen(1);
			sysMenu.setCreate_date(new Date());
			sysMenu.setParent_id(sysMenuNode.getParent_id());
			sysMenu.setLevels(sysMenuNode.getLevels());
			commonMapper.addSysMenu(sysMenu);
		}else if (sysMenu.getNodeDataType()==2){
			SysMenu sysMenuNode=commonMapper.selectSysMenuById(sysMenu.getM_id());
			sysMenu.setM_id(UUIDUtil.uuid());
			sysMenu.setNum(sysMenuNode.getNum()+1);
			sysMenu.setIsmenu(1);
			sysMenu.setIsopen(1);
			sysMenu.setCreate_date(new Date());
			sysMenu.setParent_id(sysMenuNode.getM_id());
			sysMenu.setLevels(sysMenuNode.getLevels()+1);
			commonMapper.addSysMenu(sysMenu);
		}else {
			commonMapper.updateSysMenu(sysMenu);
		}
	}

	@Override
	public SysMenu selectSysMenuById(String id) {
		return commonMapper.selectSysMenuById(id);
	}

	@Override
	public void deleteTreeById(String id) {
		Map<Integer, List<String>> menu = new HashMap<>();
	    SysMenu sysMenu=commonMapper.selectSysMenuById(id);
	    if (null!=sysMenu){
			List<SysMenu> list=commonMapper.selectMenuList(sysMenu.getParent_id());
		}
	}

	public String selectSysMenuConter(String parentId){
		String str="";
		return "";
	}
}
