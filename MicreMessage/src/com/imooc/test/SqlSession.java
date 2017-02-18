package com.imooc.test;

import java.lang.reflect.Proxy;

public class SqlSession {
	@SuppressWarnings("unchecked")
	public <T> T getMapper(Class<T> type) {
		System.out.println("通过接口的Class从代理工厂Map取出对应的代理工�?");
		System.out.println("通过代理工厂实例化一个代理类");
		System.out.println("用这个代理类生成�?个代理实例返回出�?");
		return (T) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new MapperProxy());
	}
}
