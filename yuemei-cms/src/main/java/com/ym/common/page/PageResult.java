package com.ym.common.page;

import java.util.List;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

public class PageResult {

	public static String result(List<?> list){
		PageInfo<?> pageInfo=new PageInfo<>(list);
		PageVO pageResult=new PageVO();
		pageResult.setData(list);
		pageResult.setTotal(pageInfo.getTotal());
		return JSON.toJSON(pageResult).toString();
	}
}
