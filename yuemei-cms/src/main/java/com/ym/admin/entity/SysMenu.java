package com.ym.admin.entity;

import java.io.Serializable;
import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;

/**
 * 系统菜单的实体类
 * @author Sven
 *
 */
public class SysMenu implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String m_id;//id
	private String parent_id;//父级菜单的id
	private String name;//菜单名称
	private String icon;//菜单图标
	private String url;//url地址
	private int num;//菜单排序号
	private int levels;//菜单层级
	private int ismenu;//是否是菜单（1：是  0：不是）
	private String tips;//备注
	private int status;//菜单状态 :  1:启用   0:不启用
	private int isopen;//是否打开:1:打开0:不打开
	@JSONField (format="yyyy-MM-dd HH:mm:ss")
	private Date create_date;//创建时间
	
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public int getIsmenu() {
		return ismenu;
	}
	public void setIsmenu(int ismenu) {
		this.ismenu = ismenu;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIsopen() {
		return isopen;
	}
	public void setIsopen(int isopen) {
		this.isopen = isopen;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
}
