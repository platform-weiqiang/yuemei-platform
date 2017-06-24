package com.yuemei.api.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yuemei.api.admin.entity.BeautifulPictures;
import com.yuemei.api.admin.mapper.BeautifulPicturesMapper;
import com.yuemei.api.admin.service.BeautifulPicturesService;

@Service
public class BeautifulPicturesServiceImpl implements BeautifulPicturesService{

	@Autowired
	private BeautifulPicturesMapper beautifulPicturesMapper;
	
	@Override
	public List<BeautifulPictures> queryList() {
		return beautifulPicturesMapper.queryList();
	}

}
