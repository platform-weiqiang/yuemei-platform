package com.ym.admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.ym.admin.entity.SysUser;
import com.ym.admin.service.SysUserService;

@Controller
public class AdminController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/user/slectByUser")
	public String selectByList(SysUser sysUser,ModelMap map){
		PageHelper.startPage(1,3);// 默认从第一页开始，每页五条
		List<SysUser> list=sysUserService.selectByList();
		//PageInfo<SysUser> pageUser = new PageInfo<SysUser>(list);// 将users对象绑定到pageInfo
		map.addAttribute("user", JSON.toJSON(list));
		return "user/user_list";
	}
}
