package com.yuemei.api.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class BeautifulPictures implements Serializable{
  
	private static final long serialVersionUID = 1L;
	private String id;
	private String title;
	private String url;
	private Integer pictureurlsNum;
	private Integer zan;
	private String biaoqian;
	private String keywords;
	private Date lastUpdateDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getPictureurlsNum() {
		return pictureurlsNum;
	}

	public void setPictureurlsNum(Integer pictureurlsNum) {
		this.pictureurlsNum = pictureurlsNum;
	}

	public Integer getZan() {
		return zan;
	}

	public void setZan(Integer zan) {
		this.zan = zan;
	}

	public String getBiaoqian() {
		return biaoqian;
	}

	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}
	
	@Override
	public String toString() {
		return "BeautifulPictures [id=" + id + ", title=" + title + ", url=" + url + ", pictureurlsNum="
				+ pictureurlsNum + ", zan=" + zan + ", biaoqian=" + biaoqian + ", keywords=" + keywords + "]";
	}

}
