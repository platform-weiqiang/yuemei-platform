package com.ym.admin.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主要用来跳转页面使用的Controller
 */
@Controller
public class PageController {
	
	//首页
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	//用户列表
	@RequestMapping("/user/slectByPage")
	public String selectUserPage(){
		return "/user/user_list";
	}
	
	//用户列表
	@RequestMapping("/user/addUserPage")
	public String addUserPage(){
		return "/user/user_add";
	}
	
	//部门列表
	@RequestMapping("/department/slectByTree")
	public String slectByTree(){
		return "/common/department";
	}
}
