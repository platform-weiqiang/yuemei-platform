package com.ym.admin.controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.entity.SysUser;
import com.ym.admin.service.SysUserService;
import com.ym.common.page.PageResult;

@RestController
public class AdminController {

	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 用户列表
	 * @param sysUser
	 * @param pageResult
	 * @return
	 */
	@RequestMapping(value="/user/slectByUser",method = RequestMethod.POST)
	public String selectByList(SysUser sysUser,PageResult pageResult){
		if (StringUtils.isNoneBlank(sysUser.getSortField()) && StringUtils.isNotBlank(sysUser.getSortOrder())) {
			PageHelper.orderBy(sysUser.getSortField()+" "+sysUser.getSortOrder());
		}else{
			PageHelper.orderBy("create_time desc");
		}
		PageHelper.startPage(sysUser.getPageIndex()+1,sysUser.getPageSize());
		List<SysUser> list=sysUserService.selectByList();
		return PageResult.result(list);
	}
	
	/**
	 * 部门列表
	 * @return
	 */
	@RequestMapping(value="/department/selectDepartmentByTree",method = RequestMethod.POST)
	public String selectDepartmentByTree(){
		List<Department> list=sysUserService.selectDepartmentByTree();
		return JSON.toJSON(list).toString();
	}
	
	/**
	 * 数据字段
	 * @param sysUser
	 * @param pageResult
	 * @return
	 */
	@RequestMapping(value="/dictionary/slectByDictionary",method = RequestMethod.POST)
	public String slectByDictionary(Dictionary dictionary,PageResult pageResult){
		if (StringUtils.isNoneBlank(dictionary.getSortField()) && StringUtils.isNotBlank(dictionary.getSortOrder())) {
			PageHelper.orderBy(dictionary.getSortField()+" "+dictionary.getSortOrder());
		}else{
			PageHelper.orderBy("create_date asc");
		}
		PageHelper.startPage(dictionary.getPageIndex()+1,dictionary.getPageSize());
		List<Dictionary> list=sysUserService.slectByDictionaryList();
		return PageResult.result(list);
	}
	
	/**
	 * 
	 * @param dictionary
	 * @param pageResult
	 * @return
	 */
	@RequestMapping(value="/dictionary/add",method = RequestMethod.POST)
	public String addDictionary(String data){
		Dictionary dictionary=JSONObject.parseObject(data,Dictionary.class);
		sysUserService.addDictionary(dictionary);
		return "ok";
	}
}
