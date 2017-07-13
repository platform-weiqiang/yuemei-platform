package com.ym.admin.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSON;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
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
}
