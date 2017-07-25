package com.ym.admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysMenu;
import com.ym.admin.service.CommonService;

/**
 * 公共的接口查询
 * @author 11601
 */
@RestController
public class CommonController {

	@Autowired
	private CommonService commonService;
	
	/**
	 * 公司/部门/职位的三级联动
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/selectCompany/list",method = RequestMethod.GET)
	public String selectCompanyList(@RequestParam(value="id",defaultValue="1",required=false)String id){
		List<Department> list=commonService.selectCompanyList(id);
		return JSON.toJSONString(list);
	}
	
	/**
	 * 查询学历列表
	 */
	@RequestMapping(value="/selectEducation/list",method = RequestMethod.GET)
	public String selectEducation(){
		List<Dictionary> list=commonService.selectEducationList();
		return JSON.toJSONString(list);
	}
	
	/**
	 * 系统的菜单管理
	 */
	@RequestMapping(value="/selectMenu/Ztree",method=RequestMethod.POST)
	public String selectMenuZtree(){
		List<SysMenu> list=commonService.selectMenuList();
		return JSON.toJSONString(list);
	}

	/**
	 * 添加树的节点
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/sysMenu/addTreeNode",method=RequestMethod.POST)
	public void addMenuZtree(String data){
		SysMenu sysMenu=JSONObject.parseObject(data,SysMenu.class);
		commonService.addZtreeNode(sysMenu);
	}
	
	/**
	 * 根据id查询树的节点数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/sysMenu/selectById",method=RequestMethod.GET)
	public String selectSysMenuById(String id){
		SysMenu menu=commonService.selectSysMenuById(id);
		return JSON.toJSONString(menu);
	}

	/**
	 * 根据所选的树的节点id删除相关的节点
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/sysMenu/deleteTreeById",method = RequestMethod.GET)
	public String sysMenu(String id){
		commonService.deleteTreeById(id);
		return "ok";
	}
	
}
   