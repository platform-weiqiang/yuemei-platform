package com.ym.common.utils;

import java.util.UUID;

/**
 * 项目中所有的id使用此方法
 */
public class UUIDUtil {
	
	//uuid使用加密生成唯一id
	public static String uuid(){
		Hashids hashids = new Hashids(UUID.randomUUID().toString(), 32,Hashids.DEFAULT_ALPHABET);
		return hashids.encode(1L);
	}
}
