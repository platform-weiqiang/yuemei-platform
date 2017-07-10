package com.ym.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ym.admin.service.CommonService;

@Controller
public class CommonController {

	@Autowired
	private CommonService commonService;
}
