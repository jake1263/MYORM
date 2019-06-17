package com.irish.service;

import java.lang.reflect.Proxy;


public class SqlSession {

	// 获取getMapper
	@SuppressWarnings("unchecked")
	public static <T> T getMapper(Class<T> clz)
			throws IllegalArgumentException, InstantiationException, IllegalAccessException {
		return (T) Proxy.newProxyInstance(clz.getClassLoader(), new Class[] { clz },
				new MyInvocationHandlerMbatis(clz));
	}

}
