package com.imooc.service;

import com.imooc.Dao.MessageDao;
import com.imooc.bean.Message;

public class AddService {
/*
 * �������
 */
	public void add(Message message){
		MessageDao messageDao=new MessageDao();
		if(message!=null){
			System .out.println("���ݴ�������"+message.getCommand()+message.getDescription());
		messageDao.add(message);
		}
	}
}
