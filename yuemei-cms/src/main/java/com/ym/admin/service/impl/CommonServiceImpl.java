package com.ym.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;
import com.ym.admin.mapper.CommonMapper;
import com.ym.admin.service.CommonService;

@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonMapper commonMapper;

	@Override
	public List<Department> selectCompanyList(Integer id) {
		return commonMapper.selectCompanyList(id);
	}

	@Override
	public List<Dictionary> selectEducationList() {
		return commonMapper.selectEducationList();
	}
}
