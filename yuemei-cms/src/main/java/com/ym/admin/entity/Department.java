package com.ym.admin.entity;

import java.io.Serializable;

/**
 * 部门实体类
 * @author Sven
 *
 */
public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer parent_id;//父级id
	private String code;//编码
	private String dept_name;//部门名称
	private Integer num;//排序
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParent_id() {
		return parent_id;
	}
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDept_name() {
		return dept_name;
	}
	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
