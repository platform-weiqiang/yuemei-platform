package com.ym.admin.mapper;

import java.util.List;

import com.ym.admin.entity.Department;
import com.ym.admin.entity.Dictionary;

public interface CommonMapper {

	List<Department> selectCompanyList(Integer id);

	List<Dictionary> selectEducationList();

}
