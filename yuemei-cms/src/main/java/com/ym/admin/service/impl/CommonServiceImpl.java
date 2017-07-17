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
		String id=UUIDUtil.uuid();
		SysMenu menu=new SysMenu();
		menu.setId(id);
		menu.setName("新菜单");
		menu.setNum(sysMenu.getNum()+1);
		menu.setIsmenu(1);
		menu.setTips("新菜单");
		menu.setIsopen(1);
		menu.setStatus(1);
		menu.setCreate_date(new Date());
		String[] code=sysMenu.getCode().split("-");
		String codeLength=String.valueOf(Integer.parseInt(code[code.length - 1])+1);
		String codeStr="";
		if (type==1) {
			for (int i = 0; i < code.length; i++) {
				if (i==0) {
					codeStr+="YM";
				}else{
					if (i==code.length-1) {
						codeStr+="-"+codeLength;
					}else{
						codeStr+="-"+code[i];
					}
				}
			}
			menu.setParent_id(sysMenu.getParent_id());
			menu.setCode(codeStr);
			menu.setLevels(sysMenu.getLevels());
		}else{
			for (int i = 0; i < code.length; i++) {
				if (i==0) {
					codeStr+="YM-";
				}else{
					if (i==code.length-1) {
						codeStr+="10000-10000";
					}else{
						codeStr+=code[i];
					}
				}
			}
			menu.setParent_id(sysMenu.getId());
			menu.setCode(codeStr);
			menu.setLevels(sysMenu.getLevels());
		}
		commonMapper.addSysMenu(menu);
		return commonMapper.selectSysMenuById(id);
	}
}
