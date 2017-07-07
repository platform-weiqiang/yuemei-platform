package com.ym.admin.controller;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.pagehelper.PageHelper;
import com.ym.admin.entity.SysUser;
import com.ym.admin.service.SysUserService;
import com.ym.common.page.PageResult;

@Controller
public class AdminController {

	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/user/slectByPage")
	public String selectUserPage(){
		return "/user/user_list";
	}
	
	@RequestMapping(value="/user/slectByUser",method = RequestMethod.POST)
	@ResponseBody
	public String selectByList(SysUser sysUser,PageResult pageResult){
		if (StringUtils.isNoneBlank(sysUser.getSortField()) && StringUtils.isNotBlank(sysUser.getSortOrder())) {
			PageHelper.orderBy(sysUser.getSortField()+" "+sysUser.getSortOrder());
		}
		PageHelper.startPage(sysUser.getPageIndex()+1,sysUser.getPageSize());
		List<SysUser> list=sysUserService.selectByList();
		return PageResult.result(list);
		
	}
}
