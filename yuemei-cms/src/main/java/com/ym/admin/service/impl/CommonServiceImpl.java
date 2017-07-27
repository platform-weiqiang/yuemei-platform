package com.ym.admin.service.impl;

import java.util.ArrayList;
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
		List<SysMenu> sysMenuList=commonMapper.selectMenuList();
		SysMenu sysMenu=selectSysMenuById(id);
		List<String> childList=treeMenuList(sysMenuList,sysMenu.getParent_id());
		for(String m:childList){
			System.out.println(m);
		}
	}


	public static List<String> treeMenuList(List<SysMenu> menuList, String pid){
		List<String> list=new ArrayList<>();
		for(SysMenu mu: menuList){
			//遍历出父id等于参数的id，add进子节点集合
			if(mu.getM_id().equals(pid)){
				//递归遍历下一级
				treeMenuList(menuList,mu.getM_id());
				list.add(mu.getM_id());
			}
		}
		return list;
	}
}
