package com.imooc.service;

import com.imooc.Dao.MessageDao;
import com.imooc.bean.Message;

public class AddService {
/*
 * 添加数据
 */
	public void add(Message message){
		MessageDao messageDao=new MessageDao();
		if(message!=null){
			System .out.println("数据传入正常"+message.getCommand()+message.getDescription());
		messageDao.add(message);
		}
	}
}
