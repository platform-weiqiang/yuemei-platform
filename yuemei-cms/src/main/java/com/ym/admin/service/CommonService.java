package com.ym.admin.service;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;

public interface CommonService {

	List<Department> selectCompanyList(String id);

	List<Dictionary> selectEducationList();

}
