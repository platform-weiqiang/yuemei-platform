package com.yuemei.api.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuemei.api.admin.entity.BeautifulPictures;
import com.yuemei.api.admin.service.BeautifulPicturesService;

@Controller
public class BeautifulPicturesController {
	
	@Autowired
	private BeautifulPicturesService beautifulPicturesService;
	
	
	@RequestMapping("/pic")
	@ResponseBody
	public PageInfo<BeautifulPictures> index(@RequestParam(required = true, defaultValue = "1") Integer pageNum){
		PageHelper.startPage(pageNum, 9);// 默认从第一页开始，每页五条
		List<BeautifulPictures> list=beautifulPicturesService.queryList();
		PageInfo<BeautifulPictures> pageUser = new PageInfo<BeautifulPictures>(list);// 将users对象绑定到pageInfo
		return pageUser;
	}
	
	@RequestMapping("/pic2")
	public String login(@RequestParam(required = true, defaultValue = "1") Integer pageNum,ModelMap map){
		PageHelper.startPage(pageNum, 9);// 默认从第一页开始，每页五条
		List<BeautifulPictures> list=beautifulPicturesService.queryList();
		PageInfo<BeautifulPictures> pageUser = new PageInfo<BeautifulPictures>(list);// 将users对象绑定到pageInfo
		map.addAttribute("pic", JSON.toJSON(pageUser));
		return "index";
	}

}
