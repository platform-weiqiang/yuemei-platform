package com.ym.admin.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主要用来跳转页面使用的Controller
 */
@Controller
public class PageController {
	
	//登陆页面
	@RequestMapping("/")
	public String login(){
		return "/login";
	}

	//首页
	@RequestMapping("/index")
	public String index(){
		return "index";
	}

	//查询用户列表
	@RequestMapping("/user/slectByPage")
	public String selectUserPage(){
		return "/user/user_list";
	}
	
	//添加用户列表
	@RequestMapping("/user/addUserPage")
	public String addUserPage(){
		return "/user/user_add";
	}
	
	//部门列表ZTree
	@RequestMapping("/department/slectByTree")
	public String slectByTree(){
		return "/common/department";
	}
	
	//数据字典列表
	@RequestMapping("/dictionary/slectByPage")
	public String slectByDictionaryPage(){
		return "/common/dictionary";
	}
	//添加数据字典
	@RequestMapping("/dictionary/addDictionaryPage")
	public String addDictionaryPage(){
		return "/common/dictionary_add";
	}
	//编辑数据字典
	@RequestMapping("/dictionary/editDictionaryPage")
	public String editDictionaryPage(){
		return "/common/dictionary_add";
	}
	
	//系统菜单
	@RequestMapping("/sys_menu/slectByTree")
	public String slectSysMenuByTree(){
		return "/menu/sys_menu";
	}
	
	//添加系统的菜单
	@RequestMapping("/sysMenu/addTree")
	public String addSysMenuByTree(){
		return "/menu/sys_menu_add";
	}	
}
