package com.ym.admin.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.ym.common.page.PageVO;

/**
 * 数据字典
 * @author Sven
 *
 */
public class Dictionary extends PageVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;//名称
	private String code;//编码
	private String date_desc;//描述
	private int status;//1,启用2停用
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	private Date create_date;//创建时间
	private Integer num;//排序
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getDate_desc() {
		return date_desc;
	}
	public void setDate_desc(String date_desc) {
		this.date_desc = date_desc;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
