package com.imooc.db;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {

	public SqlSession getSqlSession() throws IOException{
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader=Resources.getResourceAsReader("Configuration.xml");
		//ͨ��������Ϣ����һ��sqlSessionFactory
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//ͨ��sqlSessionFactory��һ�����ݿ�Ự
		SqlSession session=sessionFactory.openSession();
		return session;
	}
}
