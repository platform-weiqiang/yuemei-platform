package com.ym.admin.entity;

import java.util.Date;
import com.alibaba.fastjson.annotation.JSONField;
import com.ym.common.page.PageVO;
import java.io.Serializable;

public class SysUser extends PageVO implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String nickname;
    private String name;
    private String email;
    private String tel;
    private String password;
    private int sex;
    private String area_id;
    private String city_id;
    private String rovince_id;
    @JSONField (format="yyyy-MM-dd")
    private Date birthday;
    private Integer education_id;
    private Integer department_id;
    private String address;
    private String head_img_url;
    private int status;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    private Date update_time;
    private String desc;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getArea_id() {
		return area_id;
	}
	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	public String getCity_id() {
		return city_id;
	}
	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}
	public String getRovince_id() {
		return rovince_id;
	}
	public void setRovince_id(String rovince_id) {
		this.rovince_id = rovince_id;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getEducation_id() {
		return education_id;
	}
	public void setEducation_id(Integer education_id) {
		this.education_id = education_id;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getHead_img_url() {
		return head_img_url;
	}
	public void setHead_img_url(String head_img_url) {
		this.head_img_url = head_img_url;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
}
