package com.imooc.service;

import java.util.List;

import com.imooc.Dao.MessageDao;
import com.imooc.bean.Message;

/*
 * �б���ص���Ϣ���
 */
public class ListService {

	public List<Message>  queryMessageList(String command,String description){
		MessageDao messageDao=new MessageDao();
		try {
			return messageDao.queryMessageList(command, description);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
